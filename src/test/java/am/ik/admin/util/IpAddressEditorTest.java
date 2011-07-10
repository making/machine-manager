package am.ik.admin.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import am.ik.admin.editor.IpAddressEditor;

public class IpAddressEditorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSetAsText01() throws Exception {
        IpAddressEditor editor = new IpAddressEditor();
        editor.setAsText("255.255.255.255");
        assertEquals("ffffffff", editor.getValue());
    }

    @Test
    public void testSetAsText02() throws Exception {
        IpAddressEditor editor = new IpAddressEditor();
        editor.setAsText("1.1.1.1");
        assertEquals("01010101", editor.getValue());
    }

    @Test
    public void testGetAsText01() throws Exception {
        IpAddressEditor editor = new IpAddressEditor();
        editor.setAsText("255.255.255.255");
        assertEquals("255.255.255.255", editor.getAsText());
    }

    @Test
    public void testGetAsText02() throws Exception {
        IpAddressEditor editor = new IpAddressEditor();
        editor.setAsText("1.1.1.1");
        assertEquals("1.1.1.1", editor.getAsText());
    }
}
