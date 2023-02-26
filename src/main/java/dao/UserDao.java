package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean register(User u) {
        boolean f = false;

        try {
            String sql = "insert into user(fullname,email,password) values(?,?,?) ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getFullname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    // methode login user

    public User login(String em,String pw){

        User u=null;
        try {
           String sql="select * from user where email=? and password=?";
           PreparedStatement ps=conn.prepareStatement(sql);
           ps.setString(1,em);
           ps.setString(2,pw);


            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                u=new User();
                u.setId(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    return u;
    }

    // verifictaion pwd l9adima
    public boolean checkOldPassword(int userid, String oldPassword) {
        boolean f = false;

        try {
            String sql = "select * from user where id=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setString(2, oldPassword);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    // dir pwd jdida
    public boolean changePassword(int userid, String newPassword) {
        boolean f = false;

        try {
            String sql = "update user set password=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userid);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

}
