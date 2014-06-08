/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Scanner;
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
public class loginservlet extends HttpServlet {
    private ResultSet rs;
    private Connection con;
    private Statement st;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
     
        String name=null,password=null;
        String givenname=request.getParameter("Username");
        String givenpwd=request.getParameter("Password");
        Scanner sc =new Scanner(System.in);
         
      try
        {

        Class.forName("com.mysql.jdbc.Driver").newInstance ();

         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/snakes_and_ladders","root","12345");
        st=con.createStatement() ;
        
                //st.executeUpdate(sql);
        out.println(givenname);
         rs=st.executeQuery("SELECT username,pwd from user_details where username='"+ givenname+"'");
         
         
         while(rs.next())
         {
             out.println("______________________________________");
             out.println("username: "+rs.getString(1));
             out.println("password: "+rs.getString(2));
             name=rs.getString(1);
             password=rs.getString(2);
           	
          }
         out.println("after"+password+givenpwd);
         if(password!=null && password.equals(givenpwd))
         {
                  out.println("You valid user");
                  System.out.println("<script>alert('Login Successful.')</script>");
                  
                  HttpSession s;
                  s = request.getSession(true);
                  s.setAttribute("Name", name);
                  s.setAttribute("password", password);
                  Enumeration e =s.getAttributeNames();
                  
                  response.sendRedirect("NewGame.jsp");
                //RequestDispatcher rd =  req.getRequestDispatcher("create.jsp");
                //rd.forward(req, res);
                  
               }
         else
         {
             response.sendRedirect("Login.jsp");
            // out.println("<script>alert('Login fail.')</script>");
            //req.setAttribute("errorMessage", "Invalid username or password"); 
            //RequestDispatcher rd =  req.getRequestDispatcher("login.jsp");
            //rd.forward(req, res);

          }
 
    }   catch (ClassNotFoundException ex) {  
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
        }  
           catch (Exception ex) {
            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
