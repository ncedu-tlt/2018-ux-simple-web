package ru.ncedu.simpleweb.servlets.offices;

import org.json.JSONObject;
import ru.ncedu.simpleweb.repositories.OfficesRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet(name = "officeRemove", urlPatterns = {"/offices/remove"})
public class OfficesRemoveServlet extends HttpServlet {

    private static final String OFFICE_ID_PARAM = "officeId";

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        String officeIdStr=req.getParameter(OFFICE_ID_PARAM);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        if (officeIdStr==null || officeIdStr.isEmpty()){
            try (PrintWriter out = resp.getWriter()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("isSuccess", false);
                out.print(jsonObject.toString());
            }
            return;
        }

        long officeId = Long.parseLong(req.getParameter(OFFICE_ID_PARAM));
        boolean success = OfficesRepository.getInstance().removeById(officeId);
        try (PrintWriter out = resp.getWriter()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("isSuccess", success);

            out.print(jsonObject.toString());
        }
    }

}
