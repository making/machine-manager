package am.ik.admin.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import am.ik.admin.bean.Config;
import am.ik.admin.service.ConfigService;
import am.ik.admin.service.MachineService;

import com.google.common.collect.Multimap;

@Controller
public class DownloadController {
    @Inject
    protected MachineService machineService;
    @Inject
    protected ConfigService configService;

    @RequestMapping("/download")
    public String downloadHosts(Model model) {
        Multimap<String, String> map = machineService.getIpHostMap();
        Config config = configService.getConfig();
        model.addAttribute("ipHostMap", map);
        model.addAttribute("header", config.getHostsHeader());
        return "hostsDownloadView";
    }
}
