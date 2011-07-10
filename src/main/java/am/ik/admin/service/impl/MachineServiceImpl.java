package am.ik.admin.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import am.ik.admin.bean.Machine;
import am.ik.admin.service.MachineService;
import am.ik.admin.util.IpAddressUtil;
import am.ik.support.jqgrid.JqGridRequest;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateResults;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.mongodb.WriteResult;

@Service
public class MachineServiceImpl implements MachineService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(MachineServiceImpl.class);

    @Inject
    private Datastore ds;

    @Override
    public List<Machine> listAllMachines(JqGridRequest req) {
        Query<Machine> q = ds.find(Machine.class);

        if ("desc".equals(req.getSord())) {
            q = q.order("-" + req.getSidx());
        } else {
            q = q.order(req.getSidx());
        }
        q.offset(req.getRows() * (req.getPage() - 1));
        q.limit(req.getRows());
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("query {}", ToStringBuilder.reflectionToString(q));
        }
        return q.asList();
    }

    @Override
    public void update(Machine machine) {
        LOGGER.debug("update {}", machine);
        Query<Machine> q = ds.find(Machine.class).filter("id", machine.getId());
        UpdateResults<Machine> result = ds.updateFirst(q, machine, false);
        LOGGER.debug("result {}", result.getUpdatedCount());
    }

    @Override
    public void insert(Machine machine) {
        machine.setId(null);
        LOGGER.debug("insert {}", machine);
        Key<Machine> key = ds.save(machine);
        LOGGER.debug("result {}", key);
    }

    @Override
    public void delete(ObjectId id) {
        LOGGER.debug("delete {}", id);
        Query<Machine> q = ds.find(Machine.class).filter("id", id);
        WriteResult result = ds.delete(q);
        LOGGER.debug("result {}", result);
    }

    @Override
    public long getTotalSize(JqGridRequest req) {
        return ds.find(Machine.class).countAll();
    }

    @Override
    public Multimap<String, String> getIpHostMap() {
        List<Machine> machines = ds.find(Machine.class).order("ip")
                .retrievedFields(true, "ip", "hostName").asList();
        Multimap<String, String> map = LinkedListMultimap
                .<String, String> create();
        for (Machine m : machines) {
            map.put(IpAddressUtil.hexToIp(m.getIp()), m.getHostName());
        }
        LOGGER.debug("map {}", map);
        return map;
    }

}
