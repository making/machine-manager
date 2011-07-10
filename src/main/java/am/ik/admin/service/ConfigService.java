package am.ik.admin.service;

import org.bson.types.ObjectId;

import am.ik.admin.bean.Config;

public interface ConfigService {
    Config getConfig();

    ObjectId updateConfig(Config config);
}
