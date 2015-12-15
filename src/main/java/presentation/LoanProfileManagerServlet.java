package presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dataaccess.LoanTypeCRUD.checkLoanConditions;
import static logic.LoanProfileManager.ManageLoan;
import static logic.LoanProfileManager.searchCustomer;
import static logic.LoanProfileManager.selectLoanType;

/**
 * Created by DotinSchool2 on 12/15/2015.
 */
public class LoanProfileManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId=req.getParameter("customer id");
        String name=searchCustomer(customerId);
        if(name.equals("")){
            req.setAttribute("message","no customer found");
            req.getRequestDispatcher("alert.jsp").forward(req,resp);
        }
        else{
            String result="<br> first name: <input type=\"text\" name=\"first name\" value=\""+name.split("\\+")[0]+"\" readonly><br>";
            result+="<br>last name: <input type=\"text\" name=\"last name\" value=\""+name.split("\\+")[1]+"\" readonly><br>";
            ArrayList loanTypes= selectLoanType();
            req.setAttribute("LoanList",loanTypes);
            req.setAttribute("message",result);
            req.getRequestDispatcher("new-loanprofile-form.jsp").forward(req,resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loan[]=req.getParameterValues("options");
        String message=ManageLoan(req.getParameter("customer id"), req.getParameter("Amount"), req.getParameter("Duration"), loan[0]);
        req.setAttribute("message",message);
        req.getRequestDispatcher("alert.jsp").forward(req,resp);

    }
}
