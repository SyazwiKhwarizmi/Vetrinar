
import java.sql.*;
import java.util.*;

/**
 *
 * @author SyazKhwarzm
 */
public class AppointmentDao {
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

    public static int saveAppointment(Appointment e) {
        int status = 0;

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into appointment(PetId,ScheduleId,ServiceId)values (?,?,?)");
             PreparedStatement my =con.prepareStatement("update schedule set status = 'Booked' where scheduleId=?");
            ps.setInt(1, e.getPetId());
            ps.setInt(2, e.getScheduleId());
            ps.setString(3, e.getServiceId());
            my.setInt(1, e.getScheduleId());
            ps.executeUpdate();
            status=my.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;

    }

    public static int updateAppointment(Appointment e) {
        int status = 0;

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("update appointment set username=?,password=?,roles=? where id=?");

            ps.setInt(1, e.getApptId());
            ps.setInt(2, e.getPetId());
            ps.setInt(3, e.getScheduleId());
            ps.setInt(4, e.getScheduleId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;

    }

    public static int deleteAppointment(int id) {
        int status = 0;

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from appointment where ApptId=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Appointment getAppointmentById(int id) {
        Appointment e = new Appointment();

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from appointment where ApptId=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e.setApptId(rs.getInt(1));
                e.setPetId(rs.getInt(2));
                e.setScheduleId(rs.getInt(3));
                e.setServiceId(rs.getString(4));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public static List<Appointment> getAllAppointment() {
        List<Appointment> list = new ArrayList<>();

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select a.ApptId,a.PetId,p.PetName,a.ScheduleId,s.Date,s.Time,st.StaffName as StaffName,a.ServiceId,serv.servType from appointment a "
                    + "join schedule s on a.ScheduleId = s.ScheduleId "
                    + "join staff st on s.StaffId = st.StaffId "
                    + "join pet p on a.PetId=p.PetId "
                    + "join service serv on a.ServiceId=serv.ServiceId");
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Appointment e = new Appointment();
                e.setApptId(rs.getInt(1));
                e.setPetId(rs.getInt(2));
                e.setPetName(rs.getString(3));
                e.setScheduleId(rs.getInt(4));
                e.setDate(rs.getString(5));
                e.setTime(rs.getString(6));
                e.setStaffName(rs.getString(7));
                e.setServiceId(rs.getString(8));
                e.setServtype(rs.getString(9));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
public static List<Pet> getPetByClientId() {

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

public static Appointment getAllFromAppointmentById(int id){
    
    Appointment e = new Appointment();
    try{
        
        Connection con = AppointmentDao.getConnection();
          PreparedStatement ps = con.prepareStatement("select a.ApptId,p.ClientId,a.PetId,p.PetName,a.ScheduleId,s.Date,s.Time,s.StaffId,st.StaffName as StaffName,a.ServiceId,serv.servType,serv.servFee from appointment a join schedule s on a.ScheduleId = s.ScheduleId join staff st on s.StaffId = st.StaffId join pet p on a.PetId=p.PetId join service serv on a.ServiceId=serv.ServiceId where a.apptId=?");
          ps.setInt(1, id);
          ResultSet rs = ps.executeQuery();
          
          if (rs.next()) {
               e.setApptId(rs.getInt(1));
                e.setClientId(rs.getInt(2));
                e.setPetId(rs.getInt(3));
                e.setPetName(rs.getString(4));
                e.setScheduleId(rs.getInt(5));
                e.setDate(rs.getString(6));
                e.setTime(rs.getString(7));
                e.setStaffId(rs.getString(8));
                e.setStaffName(rs.getString(9));
                e.setServiceId(rs.getString(10));
                e.setServtype(rs.getString(11));
                e.setServFee(rs.getDouble(12));
              
          }
        
         con.close();
    } catch (Exception ex) {
            ex.printStackTrace();
        }
    return e;
    
}

}
    

    
    

