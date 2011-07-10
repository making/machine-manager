package am.ik.admin.web.view;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;

public class HostsDownloadView extends AbstractView {

    @SuppressWarnings("unchecked")
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Multimap<String, String> map = (Multimap<String, String>) model
                .get("ipHostMap");
        String header = (String) model.get("header");
        PrintWriter writer = response.getWriter();
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition",
                "attachment; filename=\"hosts\"");
        writer.println(header);
        for (Map.Entry<String, Collection<String>> e : map.asMap().entrySet()) {
            writer.printf("%s\t%s%n", e.getKey(),
                    Joiner.on(" ").join(e.getValue()));
        }
        writer.flush();
    }
}
