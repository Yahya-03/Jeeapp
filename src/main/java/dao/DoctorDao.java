package dao;

import model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    private Connection conn;
    public DoctorDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean registerDoctor(Doctor d) {
        boolean f = false;

        try {
            String sql = "insert into doctor(full_name,dob,qualification,specialist,email,mobno,password) " +
                          "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getFullName());
            ps.setString(2, d.getDob());
            ps.setString(3, d.getQualification());
            ps.setString(4, d.getSpecialist());
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getMobNo());
            ps.setString(7, d.getPassword());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    // recup list dr
    public List<Doctor> getAllDoctor() {
        List<Doctor> list = new ArrayList<Doctor>();
        Doctor d = null;
        try {

            String sql = "select * from doctor order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFullName(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecialist(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobNo(rs.getString(7));
                d.setPassword(rs.getString(8));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // recuper dr by id
    public Doctor getDoctorById(int id) {

        Doctor d = null;
        try {

            String sql = "select * from doctor where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFullName(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecialist(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobNo(rs.getString(7));
                d.setPassword(rs.getString(8));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
    // update doctor
    public boolean updateDoctor(Doctor d) {
        boolean f = false;

        try {
            String sql = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=?,password=? "
                    + "where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getFullName());
            ps.setString(2, d.getDob());
            ps.setString(3, d.getQualification());
            ps.setString(4, d.getSpecialist());
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getMobNo());
            ps.setString(7, d.getPassword());
            ps.setInt(8, d.getId());
            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    // delete dr
    public boolean deleteDoctor(int id) {
        boolean f = false;
        try {
            String sql = "delete from doctor where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    // login dr
    public Doctor login(String email, String psw) {
        Doctor d = null;
        try {

            String sql = "select * from doctor where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, psw);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFullName(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecialist(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobNo(rs.getString(7));
                d.setPassword(rs.getString(8));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;
    }
    // count km 3ndna mn dr
    public int countDoctor() {
        int i = 0;
        try {
            String sql = "select * from doctor";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    // km 3ndna mn mi3ad
    public int countAppointment() {
        int i = 0;
        try {
            String sql = "select * from appointment";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
    // km 3ndna mn user
    public int countUSer() {
        int i = 0;
        try {
            String sql = "select * from user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    // km 3ndna mn specialistes
    public int countSpecialist() {
        int i = 0;
        try {
            String sql = "select * from specialist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }


    // km 3ndna mn mi3ad 7assb dr
    public int countAppointmentByDocotrId(int did) {
        int i = 0;
        try {
            String sql = "select * from appointment where doctor_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, did);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
    // nchovou pwd l9adima
    public boolean checkOldPassword(int userid, String oldPassword) {
        boolean f = false;

        try {
            String sql = "select * from doctor where id=? and password=?";
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

    // badl pwd bwe7da jdida

    public boolean changePassword(int userid, String newPassword) {
        boolean f = false;

        try {
            String sql = "update doctor set password=? where id=?";
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

    // dr ibadl profilo
    public boolean editDoctorProfile(Doctor d) {
        boolean f = false;

        try {
            String sql = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getFullName());
            ps.setString(2, d.getDob());
            ps.setString(3, d.getQualification());
            ps.setString(4, d.getSpecialist());
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getMobNo());
            ps.setInt(7, d.getId());
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
