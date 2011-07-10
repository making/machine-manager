package am.ik.admin.mapper;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import am.ik.admin.serializer.HtmlEncodeSerializer;
import am.ik.support.morphia.jackson.ObjectIdSerializer;

public class HtmlEncodableObjectMapper extends ObjectMapper {
    public HtmlEncodableObjectMapper() {
        SimpleModule module = new SimpleModule("HTML Encode Serializer",
                new Version(1, 0, 0, "FINAL"));
        module.addSerializer(new HtmlEncodeSerializer());
        module.addSerializer(new ObjectIdSerializer());
        registerModule(module);
    }
}
