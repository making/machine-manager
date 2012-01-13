package am.ik.admin.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import am.ik.admin.bean.Machine;
import am.ik.admin.editor.IpAddressEditor;
import am.ik.admin.service.MachineService;
import am.ik.admin.util.IpAddressUtil;
import am.ik.support.jqgrid.JqGridRequest;
import am.ik.support.jqgrid.JqGridResponse;
import am.ik.support.jqgrid.JqGridResponseBuilder;
import am.ik.support.morphia.ObjectIdEditor;

@Controller
@RequestMapping("/machine")
public class MachineController {
    private static final Logger logger = LoggerFactory
            .getLogger(MachineController.class);

    @Inject
    private MachineService machineService;

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(ObjectId.class, "id", new ObjectIdEditor());
        binder.registerCustomEditor(String.class, "ip", new IpAddressEditor());
    }

    @RequestMapping("/list")
    @ResponseBody
    public JqGridResponse<Machine> list(JqGridRequest req,
            @RequestParam("_search") boolean isSearch) {
        logger.debug("request={}, isSearch={}", req, isSearch);

        List<Machine> machines = machineService.listAllMachines(req);
        logger.debug("machines={}", machines);
        int records = (int) machineService.getTotalSize(req);
        logger.debug("records={} rows={} page={}",
                new Object[] { records, req.getRows(), req.getPage() });
        int total = (int) Math.ceil((double) records / req.getRows());

        return new JqGridResponseBuilder<Machine>().page(req.getPage())
                .total(total).records(records).addAll(machines).build();
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(@Valid Machine machine) {
        logger.debug("update machine={}", machine);
        machineService.update(machine);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public void insert(@Valid Machine machine) {
        logger.debug("insert machine={}", machine);

        if (machine.getId() != null) {
            update(machine);
            return;
        }
        machineService.insert(machine);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(Machine machine) {
        logger.debug("delete machine={}", machine);
        machineService.delete(machine.getId());
    }

    @RequestMapping("/ping/{ip}")
    @ResponseBody
    public boolean ping(@PathVariable String ip) {
        logger.debug("ping {}", ip);
        boolean ret = IpAddressUtil.ping(ip);
        return ret;
    }
}
