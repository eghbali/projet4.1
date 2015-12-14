package presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;

/**
 * Created by DotinSchool2 on 12/8/2015.
 */
public class LoanTypeManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String conditions=req.getParameter("output");
        System.out.println(conditions);
        String[] condition=conditions.split("\\+");
        for(int i=0;i<condition.length;i++){

        }

        System.out.println(condition.length);
        Writer out=resp.getWriter();
        out.write("loan type manager servlet----------------");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Object[] x= req.getParameterValues("grantConditions");
        System.out.println(x);
        Writer out=resp.getWriter();
        out.write("loan type manager servlet");
    }
}
