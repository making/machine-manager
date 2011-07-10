package am.ik.admin.serializer;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import am.ik.admin.util.IpAddressUtil;

public class IpAddressSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeString(IpAddressUtil.hexToIp(value));
    }

}
