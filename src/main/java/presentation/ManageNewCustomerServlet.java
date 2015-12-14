package presentation;

import logic.NewCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.NewCustomerManager.manageNewCustomer;

/**
 * Created by DotinSchool2 on 12/1/2015.
 */
public class ManageNewCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewCustomer newCustomer = new NewCustomer(request.getParameter("national_code"), request.getParameter("first_name"), request.getParameter("last_name"),
                request.getParameter("father_name"), request.getParameter("birth_date"));
        String message = manageNewCustomer(newCustomer);
        System.out.println(message);
        request.setAttribute("message", message);
        request.getRequestDispatcher("alert.jsp").forward(request, response);
    }
}
