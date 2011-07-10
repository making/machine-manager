package am.ik.admin.web.controller;

import java.util.Map;

import javax.inject.Inject;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import am.ik.admin.bean.Config;
import am.ik.admin.service.ConfigService;
import am.ik.support.morphia.ObjectIdEditor;

import com.google.common.collect.Maps;

@Controller
@RequestMapping("/config")
public class ConfigController {
    @Inject
    protected ConfigService configService;

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(ObjectId.class, "id", new ObjectIdEditor());
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map<String, Object> update(Config config) {
        ObjectId id = configService.updateConfig(config);
        Map<String, Object> result = Maps.newHashMap();
        result.put("result", "success");
        result.put("id", id != null ? id : null);
        return result;
    }
}
