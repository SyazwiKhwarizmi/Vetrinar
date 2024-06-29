<%-- 
    Document   : testing
    Created on : May 31, 2024, 10:04:30 AM
    Author     : SyazKhwarzm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <
        <%
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            out.print(date);
            out.print(time);
            %>
            
            
    </body>
</html>
