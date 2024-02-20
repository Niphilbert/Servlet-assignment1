import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ConvertServlet",urlPatterns = {"/convert"})
public class Convert extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/numberConvert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));
        String action = request.getParameter("type");

        String convertedNumber = null;
        if(action.equals("binary")) {
            convertedNumber = Integer.toBinaryString(number);
        } else if(action.equals("hexa")) {
            convertedNumber = Integer.toHexString(number);
        } else {
            convertedNumber = Integer.toOctalString(number);
        }

        request.setAttribute("action", action);
        request.setAttribute("newNumber", convertedNumber);
        request.setAttribute("number", number);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/numberConvert.jsp");
        dispatcher.forward(request, response);
    }
    
}