<%-- 
    Document   : BookingAppointment
    Created on : May 27, 2024, 6:29:21 PM
    Author     : SyazKhwarzm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment</title>
        <link rel="stylesheet" href="NavHeadFoot.css"/>
        <script src="bookingAppointment.js" defer></script>
        <style>
            #selectPetSection,#selectDr,#selectService,#selectDate {
                display: none; /* Initially hide the select pet section */
            }
        </style>


    </head>
    <body>
      


        <div class="layout">
  <header>
            <jsp:include page="header.jsp"/>
        </header>
            <jsp:include page="ClientNavi.jsp"/>
            <main>


                <div class="selectAppointment">
                    <form action="SaveAppointment" method="post">

                        <label for="clientId">ClientId : </label>
                        <input type="text" id="clientId" name="clientId" placeholder="Enter client ID">

                        <a href="viewBookings" id="nextPetLink">Next</a>

                        <br>
                        <div id="selectPetSection">
                            <label>Select Pet:</label>
                            <select class="petlist" id="petId" name="petId">


                            </select>
                            <a href="viewStaffSchedule" id="nextDr">Next</a>

                        </div>

                        <div id="selectDr">
                            <label>Choose Dr.:</label>
                            <select class="drList" id="staffId" name="staffId">

                            </select>
                            <a href="viewDatebyDr" id="nextAppt">Next</a>


                        </div>


                        <div id="selectDate">
                            <label>Choose Date and Time:</label>
                            <select class="apptList" id="scheduleId" name="scheduleId">

                            </select>  
                           
                            <a href="viewServices" id="nextService" >Next</a>
                        </div>



                        <div id="selectService">
                            <label>Service :</label>
                            <select class="servList" id="servId" name="servId">

                            </select>



                            <button  type="submit" value="submit">Submit</button> 
                        </div>

                    </form>                       

                </div>




            </main>
            
            <footer>
            <jsp:include page="footer.jsp"/>
        </footer>

        </div>


          
    </body>
</html>

 