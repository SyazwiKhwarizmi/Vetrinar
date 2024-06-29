<%-- 
    Document   : HomePage
    Created on : May 27, 2024, 6:03:52 PM
    Author     : SyazKhwarzm
--%>

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
                <p>Assalamualaikum test</p>
            </main>
            <footer>
                <jsp:include page="footer.jsp"/>
            </footer>  
        </div>
    </body>


</html>
