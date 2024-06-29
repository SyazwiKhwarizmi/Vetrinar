<%-- 
    Document   : Service
    Created on : Jun 2, 2024, 12:43:08 PM
    Author     : SyazKhwarzm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="NavHeadFoot.css"/>
    </head>


    <body>


        <div class="layout">
            <header>
                <jsp:include page="header.jsp"/>
            </header>
            <jsp:include page="Navigation.jsp"/>
            <main>
                <table >
                    <tr>
                        <th>Service Id</th>
                        <th> Type</th>
                        <th> Fee</th>
                        <th>header</th>
                        <th>header</th>
                    </tr>

                    <c:forEach var="serv" items="${listService}" >

                        <tr>
                            <td>${serv.serviceId}</td>
                                <td>${serv.servType}</td>
                                <td>${serv.servFee}</td>
                            <td><a href="EditService?serviceId=${serv.serviceId}">edit</a></td>
                            <td><a href="DeleteService?serviceId=${serv.serviceId}">delete</a></td>
                        </tr>

                    </c:forEach>
                </table>
                <a href="addService.jsp">Add New Service</a>

            </main>

        </div>
    </body>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>    
</html>
