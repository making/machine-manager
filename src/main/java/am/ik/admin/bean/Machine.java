package am.ik.admin.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import am.ik.admin.serializer.IpAddressSerializer;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(noClassnameStored = true)
public class Machine {
    @Id
    private ObjectId id;
    @NotNull
    @Pattern(regexp = "[0-9a-f]{8}")
    private String ip;
    @NotNull
    @Size(min = 1)
    private String hostName;
    private String os;
    private String cpu;
    private String memory;
    private String strage;
    private String user;
    private String password;
    private String comment;
    private boolean virtual;

    public Machine() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @JsonSerialize(using = IpAddressSerializer.class)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStrage() {
        return strage;
    }

    public void setStrage(String strage) {
        this.strage = strage;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Machine [");
        if (id != null) {
            builder.append("id=");
            builder.append(id);
            builder.append(", ");
        }
        if (ip != null) {
            builder.append("ip=");
            builder.append(ip);
            builder.append(", ");
        }
        if (hostName != null) {
            builder.append("hostName=");
            builder.append(hostName);
            builder.append(", ");
        }
        if (os != null) {
            builder.append("os=");
            builder.append(os);
            builder.append(", ");
        }
        if (cpu != null) {
            builder.append("cpu=");
            builder.append(cpu);
            builder.append(", ");
        }
        if (memory != null) {
            builder.append("memory=");
            builder.append(memory);
            builder.append(", ");
        }
        if (strage != null) {
            builder.append("strage=");
            builder.append(strage);
            builder.append(", ");
        }
        if (user != null) {
            builder.append("user=");
            builder.append(user);
            builder.append(", ");
        }
        if (password != null) {
            builder.append("password=");
            builder.append(password);
            builder.append(", ");
        }
        if (comment != null) {
            builder.append("comment=");
            builder.append(comment);
            builder.append(", ");
        }
        builder.append("virtual=");
        builder.append(virtual);
        builder.append("]");
        return builder.toString();
    }
}
