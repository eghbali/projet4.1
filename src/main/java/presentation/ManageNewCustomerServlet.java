package presentation;

import dataaccess.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logic.NewCustomerlogic.manageNewCustomer;

public class ManageNewCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer(request.getParameter("national_code"), request.getParameter("first_name"), request.getParameter("last_name"),
                request.getParameter("father_name"), request.getParameter("birth_date"));
        String message = manageNewCustomer(customer);
        request.setAttribute("message", message);
        request.getRequestDispatcher("alert.jsp").forward(request, response);
    }
}
