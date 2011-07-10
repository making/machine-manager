package am.ik.admin.bean;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(noClassnameStored = true)
public class Config {
    @Id
    private ObjectId id;

    private String hostsHeader;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Config [");
        if (id != null) {
            builder.append("id=");
            builder.append(id);
            builder.append(", ");
        }
        if (hostsHeader != null) {
            builder.append("hostsHeader=");
            builder.append(hostsHeader);
        }
        builder.append("]");
        return builder.toString();
    }
}
