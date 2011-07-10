package am.ik.admin.editor;

import java.beans.PropertyEditorSupport;

import am.ik.admin.util.IpAddressUtil;

public class IpAddressEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String hex = IpAddressUtil.ipToHex(text);
        setValue(hex);
    }

    @Override
    public String getAsText() {
        String hex = (String) getValue();
        return IpAddressUtil.hexToIp(hex);
    }
}
