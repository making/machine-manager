package am.ik.admin.serializer;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import am.ik.admin.serializer.HtmlEncodeSerializer;

public class HtmlEncodeSerializerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSerializeStringJsonGeneratorSerializerProvider()
            throws Exception {
        HtmlEncodeSerializer serializer = new HtmlEncodeSerializer();
        MockJsonGenerator jgen = new MockJsonGenerator();
        StringWriter sw = new StringWriter();
        jgen.setWriter(new PrintWriter(sw));
        serializer.serialize("<a>hoge</a>", jgen, null);
        assertEquals("&lt;a&gt;hoge&lt;/a&gt;", sw.toString());
    }

}
