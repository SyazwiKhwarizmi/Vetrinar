<%-- 
    Document   : EditSchedule
    Created on : Jun 24, 2024, 3:09:25 PM
    Author     : SyazKhwarzm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Schedule</title>
    </head>
    <body>
        <form action="updateSchedule" method="post">

            <h1>Edit Schedule</h1>
            <input type="hidden" name="scheduleId" value="<c:out value="${schedule.scheduleId}"/>"
            <table>
                
                
                
                <tr>

                    <td>Date :</td>
                    <td><input type="date" name="date" value="<c:out value="${schedule.date}"/>"</td>
                </tr>
                <tr>
                    <td>Time    :</td>
                    <td><input type="time" name="time" value="<c:out value="${schedule.time}"/>"></td>                            
                </tr>

            </table>
                
                <button value="submit">Submit</button>



        </form>
   
</body>
</html>
