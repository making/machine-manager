package am.ik.admin.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import am.ik.admin.bean.Config;
import am.ik.admin.service.ConfigService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);

    @Inject
    protected ConfigService configService;

    @Resource
    private Map<String, String> themeCodeList;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Welcome home!");
        Config config = configService.getConfig();
        model.addAttribute(config);
        model.addAttribute("themeCodeList", themeCodeList);
        return "home";
    }

}
