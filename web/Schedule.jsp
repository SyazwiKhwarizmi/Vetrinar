<%-- 
    Document   : Schedule
    Created on : May 27, 2024, 8:13:36 PM
    Author     : SyazKhwarzm
--%>
<%@taglib  uri='http://java.sun.com/jsp/jstl/core' prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="NavHeadFoot.css"/>
         <link rel="stylesheet" href="Schedule.css"/>
    </head>


    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>

        <div class="layout">

            <jsp:include page="Navigation.jsp"/>
            <main>
                <h1>Schedule</h1>
                <div class="hh">

                    <form action="addSchedule" method="post">
                        <table>
                            <tr>
                                <td>Staff Id:</td>
                                <td><select id="staffId" name="staffId">
                                        <c:forEach var="item" items="${listDoctor}">
                                            <option value="${item.staffId}">${item.staffId}-${item.name}</option>
                                        </c:forEach>
                                      
                                            
                                    </select>
                                    
                                </td>
                                
                            </tr>
                            
                            <tr>
                                <td>Date :</td>
                                <td><input type="date" name="date"</td>
                            </tr>
                            <tr>
                                <td>Time    :</td>
                                <td><input type="time" name="time"></td>                            
                            </tr>
                        </table>
                        <button type="submit" value="submit">Submit</button>
                    </form>
                </div>
                <a href="viewSchedule">View Schedule</a>
            </main>

        </div>
    </body>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>  
</html>
