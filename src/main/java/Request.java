import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Request extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admission.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phonenumber");
        String nationality = request.getParameter("nationality");
        int age = Integer.parseInt(request.getParameter("age"));
    
        request.setAttribute("studentName", name);
        request.setAttribute("studentEmail", email);
        request.setAttribute("studentPhoneNumber", phoneNumber);
        request.setAttribute("studentNationality", nationality);
        request.setAttribute("studentAge", age);
    
        RequestDispatcher dispatcher = request.getRequestDispatcher("/details.jsp");
        dispatcher.forward(request, response);
    }
    
    
}
