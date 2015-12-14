package presentation;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;

import static logic.LoanTypeManager.saveLoanType;

/**
 * Created by DotinSchool2 on 12/8/2015.
 */
public class LoanTypeManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loanName=req.getParameter("Loan Name");
        int interestRate=Integer.parseInt(req.getParameter("Interest Rate").replaceAll(" ", ""));
        String conditions=req.getParameter("output");
        if(saveLoanType(loanName,interestRate,conditions))
        {
            req.setAttribute("message", "new loan Type added");
            req.getRequestDispatcher("alert.jsp").forward(req, resp);
        }
        Writer out=resp.getWriter();
        out.write("loan type manager servlet----------------");
    }

}
