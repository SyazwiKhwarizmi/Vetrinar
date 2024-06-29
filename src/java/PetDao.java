
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class PetDao {

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

    public static List<Pet> getAllPet() {
        List<Pet> list = new ArrayList<>();

        try {
            Connection con = PetDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from pet");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pet e = new Pet();
                e.setPetId(rs.getInt(1));
                e.setPetName(rs.getString(2));
                e.setPetType(rs.getString(3));
                e.setSex(rs.getString(4));
                e.setClientId(rs.getInt(5));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static List<Pet> getPetByClientId(int clientId) {

        List<Pet> list = new ArrayList<>();

        try {
            Connection con = PetDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from pet where ClientId=?");
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pet e = new Pet();
                e.setPetId(rs.getInt(1));
                e.setPetName(rs.getString(2));
                e.setAge(rs.getInt(3));
                e.setPetType(rs.getString(4));
                e.setSex(rs.getString(5));
                e.setClientId(rs.getInt(6));
                list.add(e);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public static List<Pet> getPetByClientIds() {

        List<Pet> list = new ArrayList<>();

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from pet where ClientId =1");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pet e = new Pet();
                e.setPetId(rs.getInt(1));
                e.setPetName(rs.getString(2));
                e.setAge(rs.getInt(3));
                e.setPetType(rs.getString(4));
                e.setSex(rs.getString(5));
                e.setClientId(rs.getInt(6));
                list.add(e);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
