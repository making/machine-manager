package am.ik.admin.service;

import java.util.List;

import org.bson.types.ObjectId;

import am.ik.admin.bean.Machine;
import am.ik.support.jqgrid.JqGridRequest;

import com.google.common.collect.Multimap;

public interface MachineService {
    List<Machine> listAllMachines(JqGridRequest req);

    long getTotalSize(JqGridRequest req);

    void insert(Machine machine);

    void update(Machine machine);

    void delete(ObjectId id);

    Multimap<String, String> getIpHostMap();
}
