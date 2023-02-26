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

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recup des para
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        HttpSession session=req.getSession();
       //recup conn bd
        UserDao usd=new UserDao(DbConn.getConn());
        // recup login
        User user= usd.login(email,password);

        if(user!=null)
        {
            session.setAttribute("userObj",user);
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("errorMsg","invalid email & password");
            resp.sendRedirect("user_login.jsp");
        }
    }
}
