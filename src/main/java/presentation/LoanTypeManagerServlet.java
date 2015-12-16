package presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

import static logic.LoanTypeLogic.saveLoanType;

/**
 * Created by DotinSchool2 on 12/8/2015.
 */
public class LoanTypeManagerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loanName = req.getParameter("Loan Name");
        int interestRate = Integer.parseInt(req.getParameter("Interest Rate").replaceAll(" ", ""));
        String conditions = req.getParameter("output");
        if (saveLoanType(loanName, interestRate, conditions)) {
            req.setAttribute("message", "new loan Type added");
            req.getRequestDispatcher("alert.jsp").forward(req, resp);
        }
    }

}
