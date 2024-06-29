<%-- 
    Document   : EditService
    Created on : Jun 24, 2024, 4:15:32 PM
    Author     : SyazKhwarzm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Service</title>
    </head>
    <body>
        <form action="updateService" method="post">

            <h1>Edit Schedule</h1>
            <input type="hidden" name="servId" value="<c:out value="${service.serviceId}"/>">
            <table>
                <tr>
                    <th>Service Type</th>
                    <td><input type="text" name="servType" value="<c:out value="${service.servType}"/>"></td>
                </tr>

                <tr>
                    <th>Service Fee</th>
                    <td><input type="text" name="servFee" value="<c:out value="${service.servFee}"/>"></td>
                </tr>
            </table>

            <button value="submit">Submit</button>



        </form>
    </body>
</html>
