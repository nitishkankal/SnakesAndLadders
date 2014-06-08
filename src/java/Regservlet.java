/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nitish
 */
public class Regservlet extends HttpServlet {

/**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException 
    {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fname=request.getParameter("firstname");
        String lname=request.getParameter("lastname");
        String username=request.getParameter("loginName");
        String pwd=request.getParameter("password");
        String email=request.getParameter("email");
        String alt_email=request.getParameter("alternetemail");
        String sex=request.getParameter("gender");
        
        String dobm=request.getParameter("month");
        String dobd=request.getParameter("day");
        String doby=request.getParameter("year");
        
        String country =request.getParameter("country");
        String address =request.getParameter("address");
        String phone =request.getParameter("phoneno");
        String secque=request.getParameter("secque");
        String secans=request.getParameter("secans");
        
        String dob=doby+"-"+dobm+"-"+dobd;
        Connection connection = null;
        Statement stmt=null;
       System.out.println("in servlet registeration");
            /* TODO output your page here. You may use following sample code. */
        try 
        {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance ();
            } catch (InstantiationException ex) {
                Logger.getLogger(Regservlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Regservlet.class.getName()).log(Level.SEVERE, null, ex);
            }
	 
            System.out.println("in servlet registeration");
             
             connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_and_ladders","root","12345");
                stmt=(Statement) connection.createStatement();
                String que="insert into user_details values('"+fname+"', '"+lname+"', '"+username+"', '"+pwd+"', '"+email+"', '"+alt_email+"', '"+sex+"', '"+dob+"', '"+country+"', '"+address+"', '"+phone+"', '"+secque+"', '"+secans+"')";
                stmt.executeUpdate(que);
                //ResultSet rs = stmt.executeQuery(query);
                
	} 
        catch (SQLException e) 
        {
		System.out.println("Connection Failed! Check output console"+e);
		return;
	}
 
	if (connection!= null) 
        {
		System.out.println("databse connection succussfully");
	} 
        else
        {
		System.out.println("Failed to make connection!");
	}
        
        try 
        {
            /* TODO output your page here. You may use following sample code. */
            HttpSession s;
            s = request.getSession(true);
            s.setAttribute("Name", username);
            s.setAttribute("password", pwd);
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registration</title>");   
            out.println("<link rel='stylesheet' type='text/css' href='main.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Data registerd succesfully"  + "</h1>");
            out.println("<a href='NewGame.jsp'> Start a New Game </a>");
            out.println("<br><a href='joingame.jsp'> Join Existing Game </a>");
            out.println("</body>");
            out.println("</html>");
            
        } 
        finally 
        {            
            out.close();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Regservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Regservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Regservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Regservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
