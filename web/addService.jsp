<%-- 
    Document   : addService
    Created on : Jun 4, 2024, 1:28:31 AM
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


        <div class="layout">
            <header>
                <jsp:include page="header.jsp"/>
            </header>

            <jsp:include page="Navigation.jsp"/>
            <main>
                <form action="saveServlet" method="post">

                    <table>
                        <tr>
                            <th>Service Id</th>
                            <td><input type="text" name="serviceId" required></td>
                        </tr>

                        <tr>
                            <th>Service Type</th>
                            <td><input type="text" name="servType"></td>
                        </tr>

                        <tr>
                            <th>Service Fee</th>
                            <td><input type="text" name="servFee"</td>
                        </tr>
                    </table>
                    
                    <button type="Submit" value="Submit">Submit</button>
                </form>  




            </main>
            <footer>
                <jsp:include page="footer.jsp"/>
            </footer>  
        </div>


    </body>
</html>
