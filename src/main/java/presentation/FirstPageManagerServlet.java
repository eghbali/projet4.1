package presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FirstPageManagerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(req.getParameter("customer")+"hello!");
        if (req.getParameter("type").equals("customer")) {
            resp.sendRedirect("new-customer-form.jsp");
        } else if (req.getParameter("type").equals("loan type")) {
            resp.sendRedirect("new-loantype-form.jsp");
        } else if (req.getParameter("type").equals("loan profile")) {
            resp.sendRedirect("new-loanprofile-form.jsp");
        }
    }
}
