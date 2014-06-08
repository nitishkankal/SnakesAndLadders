/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.*;


/**
 *
 * @author Nitish
 */
public class creategameServlet extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String connectionURL = "jdbc:mysql://localhost:3306/snakes_and_ladders";
        Connection connection=null;
        ResultSet rs,rs1;
        
        response.setContentType("text/html");

        //get the variables entered in the form
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        String boardname=request.getParameter("boardname");
        String max_player=request.getParameter("noplayer");
        
        String color=request.getParameter("die");
        int player_no=1;
        int order=player_no;
        int status=1;
        try {
        // Load the database driver
        Class.forName("com.mysql.jdbc.Driver");
        // Get a Connection to the database
        connection = DriverManager.getConnection
        (connectionURL, "root", "12345"); 
        //Add the data into the database

       Statement statement = (Statement) connection.createStatement();

       rs = statement.executeQuery("SELECT * from user_details where username='" + username + "'");  // 
       

        if(rs.next())
        {
            
         HttpSession s3=request.getSession(true);
         String user1=(String)s3.getAttribute("Name");
         s3.setAttribute("board", boardname);
         out.println("hello");
                
         out.println(username);
         if(user1==null){
         out.println("<!DOCTYPE html>");  // HTML 5
         out.println("<html><head>");
         out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css1.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" />");
         
         
         out.println("</style>");
         out.println("<title> Successful </title></head>");
         out.println("<body> <div id=\"headimage\"></div>");
         out.println("<h1><center>You should login first </center></h1>"); 
         // Set a hyperlink image to refresh this page
         out.println("<a href='Login.jsp'>Login</a><br><br>");
         out.println("<img src=\"images/1.png\">");
         out.println("</body></html>");
              }
              
    if(user1!=null && !user1.equals(username))
       {
         out.println("user not one as logged in");
         out.println("<!DOCTYPE html>");  // HTML 5
         out.println("<html><head>");
         out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css1.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" />");
         
        
         out.println("<title> Successful </title></head>");
         out.println("<body> <div id=\"headimage\"></div>");
         out.println("<h1>You should login first </h1>");  
         // Set a hyperlink image to refresh this page
         out.println("<a href='Login.jsp'>Login</a><br><br>");
         out.println("<img src=\"images/1.png\">");
        // out.println("<a href='join.jsp'>Join Game </a>");
         out.println("</body></html>");
                   return;
                }

        ///out.println("user is authinticated as given");
      
        
        Statement statement1 = (Statement) connection.createStatement();
        rs1=statement1.executeQuery("SELECT * from game_details where game_name='" + boardname + "'");

    if(rs1.next())
    {
         
         out.println("<!DOCTYPE html>");  // HTML 5
         out.println("<html><head>");
         out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css1.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" />");
          out.println("<title> Successful </title></head>");
         out.println("<body> <div id=\"headimage\"></div>");
         out.println("<h1>Board name already exists please choose a different boardname</h1>");  // Prints "Hello, world!"
         // Set a hyperlink image to refresh this page
         out.println("<a href='NewGame.jsp'> To create New Game</a><br><br>");
         out.println("<img src=\"images/1.png\">");
        
         out.println("</body></html>");
            // RequestDispatcher rd1 =  req.getRequestDispatcher("create.jsp");
             // rd1.forward(req, res); 

        }


       else
       {
        out.println("hello");
        String sql =  "insert into game_details values (?,?,?,?,?,?)";
        String sql1="insert into player_details values (?,?,?,?,?,?,?)";
        PreparedStatement pst = 
        connection.prepareStatement(sql);
        pst.setString(1, boardname);
        pst.setString(2, password);
        pst.setInt(3,Integer.parseInt(max_player));
        pst.setString(4, username);
        pst.setInt(5, player_no);
        pst.setString(6,color);
        int numRowsChanged = pst.executeUpdate();
        out.println("hello");
        pst.close();
         
        PreparedStatement pst1 = 
        connection.prepareStatement(sql1);
        pst1.setString(1, username);
        pst1.setString(2, boardname);
        pst1.setString(3, color);
        pst1.setInt(4, 0);
        pst1.setInt(5, 0);
        pst1.setInt(6, status);
        pst1.setInt(7, order);
 
        int numRowsChanged1 = pst1.executeUpdate();
        pst1.close();
        
        response.sendRedirect("Gameboard.jsp");

       }
}
  else{
   // out.println("<script>alert('Login fail.')</script>");
      //      request.setAttribute("errorMessage", "Invalid username or password"); 
    //RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
    //rd.forward(request, response);
    
         out.println("<!DOCTYPE html>");  // HTML 5
         out.println("<html><head>");
         out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css1.css\" />\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" />");
         out.println("<title> Successful </title></head>");
         out.println("<body> <div id=\"headimage\"></div>");
        
         out.println("<h1>Wrong username please enter again</h1>");  
         
         out.println("<a href='Login.jsp'>Login</a><br><br>");
         out.println("<img src=\"images/1.png\">");
        
         out.println("</body></html>");
                 
}
 
  }
  catch(ClassNotFoundException e){
    
  out.println("Couldn't load database driver: " 
  + e.getMessage());
  }
  catch(SQLException e){
  out.println("SQLException caught: " 
  + e.getMessage());
  }
  catch (Exception e){
  out.println(e);
  }
  finally {
  // Always close the database connection.
  try {
  if (connection != null) connection.close();
  }
  catch (SQLException ignored){
  out.println(ignored);
  }
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
