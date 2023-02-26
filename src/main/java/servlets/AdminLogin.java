package servlets;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try{
             // recup des para
             String email=req.getParameter("email");
             String password=req.getParameter("password");

             HttpSession session=req.getSession();

             if("admin@gmail.com".equals(email)&&"admin".equals(password))
             {
                 session.setAttribute("adminObj",new User());
                 resp.sendRedirect("admin/index.jsp");
             } else {
                 session.setAttribute("errorMsg","invalid email & password");
                 resp.sendRedirect("admin_login.jsp");
             }
         }catch (Exception e){
             e.printStackTrace();
         }
    }
}
