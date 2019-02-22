package vovik.java.webapp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Vovik
 * 2/17/2019
 */

public class ResumeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(){}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Writer w = response.getWriter();
        String name = request.getParameter("name");
        w.write("Test сервлет " + name);
        w.close();

    }
}
