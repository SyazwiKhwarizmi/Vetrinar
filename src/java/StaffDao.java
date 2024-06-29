
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SyazKhwarzm
 */
public class StaffDao {
    
    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinar", "root", "admin");
        } catch (Exception e) {
            System.out.println(e);

        }
        return con;
    }
    
    
        public static List<Staff> getAllStaffDoctor() {
        List<Staff> list = new ArrayList<>();

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from staff where StaffId like 'D%'");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff e = new Staff();
                e.setStaffId(rs.getString(1));
                e.setName(rs.getString(2));
                e.setSPhoneNumber(rs.getString(3));
                e.setPassword(rs.getString(4));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
