package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class BookingAppointment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Appointment</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"NavHeadFoot.css\"/>\n");
      out.write("        <script src=\"bookingAppointment.js\" defer></script>\n");
      out.write("        <style>\n");
      out.write("            #selectPetSection,#selectDr,#selectService,#selectDate {\n");
      out.write("                display: none; /* Initially hide the select pet section */\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"layout\">\n");
      out.write("  <header>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        </header>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ClientNavi.jsp", out, false);
      out.write("\n");
      out.write("            <main>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"selectAppointment\">\n");
      out.write("                    <form action=\"SaveAppointment\" method=\"post\">\n");
      out.write("\n");
      out.write("                        <label for=\"clientId\">ClientId : </label>\n");
      out.write("                        <input type=\"text\" id=\"clientId\" name=\"clientId\" placeholder=\"Enter client ID\">\n");
      out.write("\n");
      out.write("                        <a href=\"viewBookings\" id=\"nextPetLink\">Next</a>\n");
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <div id=\"selectPetSection\">\n");
      out.write("                            <label>Select Pet:</label>\n");
      out.write("                            <select class=\"petlist\" id=\"petId\" name=\"petId\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <a href=\"viewStaffSchedule\" id=\"nextDr\">Next</a>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div id=\"selectDr\">\n");
      out.write("                            <label>Choose Dr.:</label>\n");
      out.write("                            <select class=\"drList\" id=\"staffId\" name=\"staffId\">\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <a href=\"viewDatebyDr\" id=\"nextAppt\">Next</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div id=\"selectDate\">\n");
      out.write("                            <label>Choose Date and Time:</label>\n");
      out.write("                            <select class=\"apptList\" id=\"scheduleId\" name=\"scheduleId\">\n");
      out.write("\n");
      out.write("                            </select>  \n");
      out.write("                           \n");
      out.write("                            <a href=\"viewServices\" id=\"nextService\" >Next</a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div id=\"selectService\">\n");
      out.write("                            <label>Service :</label>\n");
      out.write("                            <select class=\"servList\" id=\"servId\" name=\"servId\">\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <button  type=\"submit\" value=\"submit\">Submit</button> \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </form>                       \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </main>\n");
      out.write("            \n");
      out.write("            <footer>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("          \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write(" ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
