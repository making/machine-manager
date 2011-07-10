package am.ik.admin.service.impl;

import javax.inject.Inject;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import am.ik.admin.bean.Config;
import am.ik.admin.service.ConfigService;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.UpdateResults;

@Service
public class ConfigServiceImpl implements ConfigService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ConfigServiceImpl.class);

    @Inject
    private Datastore ds;

    @Override
    public Config getConfig() {
        Config config = ds.find(Config.class).get();
        if (config == null) {
            config = new Config();
            config.setHostsHeader("##\n# Host Database\n##\n\n127.0.0.1\tlocalhost");
        }
        LOGGER.debug("config {}", config);
        return config;
    }

    @Override
    public ObjectId updateConfig(Config config) {
        LOGGER.debug("config {}", config);
        UpdateResults<Config> result = ds.updateFirst(
                ds.createQuery(Config.class), config, true);
        return (ObjectId) result.getNewId();
    }

}
