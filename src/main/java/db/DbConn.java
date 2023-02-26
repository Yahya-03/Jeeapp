package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {

    private static Connection conn;

    public static Connection getConn(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Ok");
            String url="jdbc:mysql://localhost:3306/dbhopital";
            String user="root";
            String pwd="";
            // def var on va utiliser pour cree statments
            // doit spercifier l'url , login , pwd ala meth getcon de objt DriverManager
             conn = DriverManager.getConnection(url,user,pwd);
            System.out.println("Connxion bien etablie");
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}
