
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
public class ServiceDao {
    
    
     
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
    
    
    public static int save(Service e){
        int status =0;
        
        try{
            Connection con =ServiceDao.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into service values (?,?,?)");
            ps.setString(1, e.getServiceId());
            ps.setString(2, e.getServType());
            ps.setDouble(3, e.getServFee());
            
            status = ps.executeUpdate();
            
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return status;
        
    }
    
    public static int updateService(Service e){
        int status =0;
        
        try{
            Connection con = ServiceDao.getConnection();
            PreparedStatement ps=con.prepareStatement("update service set servType=?,servFee=? where ServiceId=?");
            
            
            ps.setString(1, e.getServType());
            ps.setDouble(2, e.getServFee());
            ps.setString(3, e.getServiceId());
        
            
            status=ps.executeUpdate();
            
            con.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return status;
        
    }

       
    public static int deleteService(String id){
        int status=0;
        
        try{
            Connection con = ServiceDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from service where ServiceId=?");
            ps.setString(1, id);
            status = ps.executeUpdate();
            
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return status;
    }
    
    public static Service getServiceById(String id){
        Service e = new Service();
        
        try{
            Connection con=ServiceDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from service where ServiceId=?");
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
               e.setServiceId(rs.getString(1));
                e.setServType(rs.getString(2));
                e.setServFee(rs.getDouble(3));
            }
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return e;
    }
        
    
    
    public static List<Service> getAllServices(){
        List<Service> list = new ArrayList<>();
        
        try{
            Connection con = ServiceDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from service");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Service e = new Service();
                e.setServiceId(rs.getString(1));
                e.setServType(rs.getString(2));
                e.setServFee(rs.getDouble(3));
               
                list.add(e);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
}
