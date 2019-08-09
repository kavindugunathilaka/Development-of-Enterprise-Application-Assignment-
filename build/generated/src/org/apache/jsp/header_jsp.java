package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/header-css.css\">\n");
      out.write("        <script src=\"Script/indexScript.js\" charset=\"utf-8\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      <header>\n");
      out.write("        <div class=\"nav-bar\">\n");
      out.write("              <a href=\"index.jsp\" class=\"nav-content\">\n");
      out.write("                Home\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                About\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                Services\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                Blog\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                Contact\n");
      out.write("              </a>\n");
      out.write("            ");

                // clean session
                HttpSession userSession = request.getSession(false);
//                userSession.invalidate();

            if (userSession.getAttribute("username") != null){
//                String name = (String)userSession.getAttribute("username");
                out.print(""
                        + "<a href='LogoutServlet' class='nav-content-left'>"
                        + "Logout"
                        + "</a>"
                        + "<text class='nav-content-left'>"+userSession.getAttribute("username")+"</text>"
                        + "");
            }
            else{
                String block = "document.getElementById(id01).style.display='block'";
                
                out.print("<a href='Signup-tourist.jsp' class='nav-content-left'>"
                        + "Signup as Tourist"
                        + "</a>"
                        + "<a href='Signup-business.jsp' class='nav-content-left'>"
                        + "Signup as Business"
                        + "</a>"
                        + "<a href='login.jsp' class='nav-content-left'>"
                        + "Login"
                        + "</a>" );
            }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--          <a href=\"#\" class=\"nav-content-left\">\n");
      out.write("                Login\n");
      out.write("              </a>\n");
      out.write("              <a href=\" \" class=\"nav-content-left\">\n");
      out.write("                Signup\n");
      out.write("              </a>\n");
      out.write("        -->\n");
      out.write("        </div>\n");
      out.write(" <!--       <div class=\"login-panel\" id=\"id01\">\n");
      out.write("            <div class=\"login-panel-content\"><center>\n");
      out.write("                <a href=\"Signup-tourist.jsp\">\n");
      out.write("                    <button type=\"submit\" name=\"tourist-login-btn\" class=\"login-panel-btn\">Login as Tourist</button>\n");
      out.write("                </a>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <a href=\"Signup-business.jsp\">\n");
      out.write("                    <button type=\"button\" name=\"business-login-btn\" class=\"login-panel-btn\">Login as Business</button>\n");
      out.write("                </a>\n");
      out.write("            </center></div>\n");
      out.write("        </div>\n");
      out.write("      </header>\n");
      out.write("-->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
