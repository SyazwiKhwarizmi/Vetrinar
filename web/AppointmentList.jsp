<%-- 
    Document   : AppointmentList
    Created on : May 27, 2024, 6:06:58 PM
    Author     : SyazKhwarzm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="NavHeadFoot.css"/>
        <link rel="stylesheet" type="text/css" href="ViewAppointment.css"/>
        <title>Appointment</title>
<!--<script type="text/javascript">
    window.onload = function(){
        // Redirect to servlet page after a certain time
        setTimeout(function() {
            window.location.href = "ViewAppointment";
        }, 2500); // 5000 milliseconds = 5 seconds
    };
    </script>-->


    <body>
        
       

        <div class="layout">
 <header>
            <jsp:include page="header.jsp"/>
        </header>
            <jsp:include page="Navigation.jsp"/>
            <main>


                <table border='1'>
                    <tr>
                        <th>Appointment ID</th>
                        <th>Pet Name</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Doctor</th>
                        <th>Service</th>
                    </tr>
                    <c:forEach var="item" items="${listAppointment}">
                        <tr>
                            <td>${item.apptId}  </td>
                            <td>${item.petName}</td>
                            <td>${item.date}</td>
                            <td>${item.time}</td>
                            <td>${item.staffName}</td>
                            <td>${item.servtype}</td>
                            <td><a href="EditAppointment?ApptId=${item.apptId}">edit</a></td>
                            <td><a href="DeleteAppointment?ApptId=${item.apptId}">delete</a></td></tr>
                        </c:forEach>
                </table>
                <a href="bookingAppointment" class="add"><button>Add Appointment</button></a>
            </main>
   <footer>
            <jsp:include page="footer.jsp"/>
        </footer> 
        </div>


     
    </body>


</html>
