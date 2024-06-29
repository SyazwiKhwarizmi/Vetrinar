
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SyazKhwarzm
 */
public class ScheduleDao {

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

    public static int save(Schedule e) {

        int status = 0;

        try {
            Connection con = ScheduleDao.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into schedule(StaffId,date,time)values (?,?,?)");
            ps.setString(1, e.getStaffId());
            ps.setString(2, e.getDate());
            ps.setString(3, e.getTime());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;

    }

    public static List<Schedule> getAllSchedule() {
        List<Schedule> list = new ArrayList<Schedule>();

        try {
            Connection con = ScheduleDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from schedule");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule e = new Schedule();
                e.setScheduleId(rs.getInt(1));
                e.setStaffId(rs.getString(2));
                e.setDate(rs.getString(3));
                e.setTime(rs.getString(4));
                e.setStatus(rs.getString(5));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static int deleteSchedule(int id) {
        int status = 0;

        try {
            Connection con = AppointmentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from schedule where scheduleId=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static List<Schedule> getDrSchedulebyDate(String date) {
        List<Schedule> list = new ArrayList<>();

        try {
            Connection con = ScheduleDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select s.StaffId,d.StaffName from schedule s "
                    + "join staff d on d.StaffId = s.StaffId where  s.date=?");
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule e = new Schedule();
                e.setStaffId(rs.getString(1));
                e.setStaffName(rs.getString(2));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Schedule> getScheduleIdbyDrId(String staffId) {
        List<Schedule> list = new ArrayList<>();

        try {
            Connection con = ScheduleDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select scheduleId,date,time from schedule where StaffId=? and status='Available' ");
            ps.setString(1, staffId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule e = new Schedule();
                e.setScheduleId(rs.getInt(1));
                e.setDate(rs.getString(2));
                e.setTime(rs.getString(3));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Schedule getScheduleIdbyScheduleId(int scheduleId) {
        Schedule e = new Schedule();

        try {
            Connection con = ScheduleDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select scheduleId,date,time from schedule where scheduleId=?");
            ps.setInt(1, scheduleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                e.setScheduleId(rs.getInt(1));
                e.setDate(rs.getString(2));
                e.setTime(rs.getString(3));

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static int updateSchedule(Schedule e) {
        int status = 0;
        try {
            Connection con = ScheduleDao.getConnection();
            PreparedStatement ps = con.prepareStatement("update schedule set date=?,time=?  where scheduleId=?");
            ps.setString(1, e.getDate());
            ps.setString(2, e.getTime());
            ps.setInt(3, e.getScheduleId());

            status = ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
