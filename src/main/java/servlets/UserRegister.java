package servlets;

import dao.UserDao;
import db.DbConn;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
              String fullname=req.getParameter("fullname");
              String email=req.getParameter("email");
              String password=req.getParameter("password");

            User u=new User(fullname,email,password);

            UserDao ud=new UserDao(DbConn.getConn());

            HttpSession session=req.getSession();

           boolean f = ud.register(u);

           if(f){
               session.setAttribute("sucMsg","inscription réussie ");
               resp.sendRedirect("signup.jsp");
           } else {
               session.setAttribute("errorMsg","Quelque chose ne va pas sur le serveur ");
               resp.sendRedirect("signup.jsp");
           }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
