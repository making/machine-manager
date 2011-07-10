package am.ik.admin.serializer;

import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class HtmlEncodeSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        if (value != null) {
            String text = StringEscapeUtils.escapeHtml(value);
            jgen.writeString(text);
        }
    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }

}
