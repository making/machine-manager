package am.ik.admin.bean;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(noClassnameStored = true)
public class Config {
    private static final String DEFAULT_THEME = "cupertino";

    @Id
    private ObjectId id;

    private String hostsHeader;

    private String theme = DEFAULT_THEME;

    public Config() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getHostsHeader() {
        return hostsHeader;
    }

    public void setHostsHeader(String hostsHeader) {
        this.hostsHeader = hostsHeader;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Config [id=" + id + ", hostsHeader=" + hostsHeader + ", theme="
                + theme + "]";
    }
}
