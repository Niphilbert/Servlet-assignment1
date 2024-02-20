import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="RequestServlet",urlPatterns = {"/request"})
@MultipartConfig
public class Request extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admission.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting username and email from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phonenumber");
        String nationality = request.getParameter("nationality");
        int age = Integer.parseInt(request.getParameter("age"));

        // Getting files from request
        Part filePart1 = request.getPart("file1");
        Part filePart2 = request.getPart("file2");

        // Get the real path of the web application
        String appPath = request.getServletContext().getRealPath("/");
        String uploadPath = appPath + File.separator + "uploads"; // Directory within the web application

        // Create the directory if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Process file 1
        String fileName1 = Paths.get(filePart1.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent1 = filePart1.getInputStream();
        File file1 = new File(uploadDir, fileName1);
        try (InputStream input = fileContent1; OutputStream output = new FileOutputStream(file1)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle errors here
        }

        // Process file 2
        String fileName2 = Paths.get(filePart2.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent2 = filePart2.getInputStream();
        File file2 = new File(uploadDir, fileName2);
        try (InputStream input = fileContent2; OutputStream output = new FileOutputStream(file2)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle errors here
        }

        sentEmail(email);
        
        // Set attributes to pass to the JSP
        request.setAttribute("studentName", name);
        request.setAttribute("studentEmail", email);
        request.setAttribute("studentPhoneNumber", phoneNumber);
        request.setAttribute("studentNationality", nationality);
        request.setAttribute("studentAge", age);
        request.setAttribute("file1", fileName1);
        request.setAttribute("file2", fileName2);
    
        RequestDispatcher dispatcher = request.getRequestDispatcher("/details.jsp");
        dispatcher.forward(request, response);
    }

    public void sentEmail(String email){
        // Email configuration
        String host = "smtp.gmail.com"; // E.g., smtp.gmail.com
        String port = "587"; // E.g., 587 for TLS, 465 for SSL
        String senderEmail = "nphilbert152@gmail.com";
        String password = "ovow rtin quxt twmq";

        // Set properties for SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Admission Confirmation");

            String emailContent = "Your admission has been sent successfully. Thank you for your application.\n\n"
                    + "Best regards,\n"
                    + "Your School Name";
            message.setText(emailContent);

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}