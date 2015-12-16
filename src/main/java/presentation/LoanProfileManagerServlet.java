package presentation;

import dataaccess.entity.LoanProfile;
import dataaccess.entity.LoanType;
import logic.LoanProfileLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by DotinSchool2 on 12/15/2015.
 */
public class LoanProfileManagerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customer id");
        String customerName = LoanProfileLogic.searchCustomer(customerId);
        if (customerName.equals("")) {
            req.setAttribute("message", "no customer found");
            req.getRequestDispatcher("alert.jsp").forward(req, resp);
        } else {
            List<LoanType> loanTypes = LoanProfileLogic.selectAllLoanTypes();
            req.setAttribute("firstname", customerName.split("\\+")[0]);
            req.setAttribute("lastname", customerName.split("\\+")[1]);
            req.setAttribute("LoanList", loanTypes);
            req.getRequestDispatcher("new-loanprofile-form.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loanId = req.getParameter("options");
        LoanProfile loanProfile = new LoanProfile(Long.parseLong(req.getParameter("customer id")), Integer.parseInt(loanId), Integer.parseInt(req.getParameter("Amount")),
                Integer.parseInt(req.getParameter("Duration")));
        String message = LoanProfileLogic.insertLoanToDatabase(loanProfile);
        req.setAttribute("message", message);
        req.getRequestDispatcher("alert.jsp").forward(req, resp);
    }
}
