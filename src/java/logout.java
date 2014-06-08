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
import javax.servlet.*;
import javax.servlet.http.*;


public class logout extends HttpServlet{
  @Override
  public void init(ServletConfig config) throws ServletException{
  super.init(config);
  }
  /**Process the HTTP Get request*/
  @Override
  public void doPost(HttpServletRequest req, 
  HttpServletResponse res) throws ServletException,
  IOException{
 
 String connectionURL = "jdbc:mysql://localhost:3306/snakes_and_ladders";
  Connection connection=null;
  ResultSet rs;
  res.setContentType("text/html");
  PrintWriter out = res.getWriter();
  
 
HttpSession s=req.getSession();
String name=(String)s.getAttribute("Name");
String board=(String)s.getAttribute("board");
  try {
  // Load the database driver
  Class.forName("com.mysql.jdbc.Driver");
  // Get a Connection to the database
  connection = DriverManager.getConnection
  (connectionURL, "root", "12345"); 
  //Add the data into the database
 
 Statement statement = (Statement) connection.createStatement();
 
 
 
 rs = statement.executeQuery("SELECT player_name from  game_details where player_name='" + name + "' ");  // 

 if(rs.next())
 {
     String sql="delete from game_details where player_name='"+name+"'";
     
  PreparedStatement pst = 
  connection.prepareStatement(sql);
  pst.executeUpdate();
  
   String sql1="delete from player_details where player_name='"+name+"'";
     
  PreparedStatement pst1 = 
  connection.prepareStatement(sql1);
  pst1.executeUpdate();
  s.invalidate();
  res.sendRedirect("index.jsp");
     
 }
 else
 {
  String sql1="delete from player_details where player_name='"+name+"'";
     
  PreparedStatement pst1 = 
  connection.prepareStatement(sql1);
  pst1.executeUpdate();
  
  String sql2="update game_details set count=count-1 where game_name='"+board+"'";
  PreparedStatement pst2 = 
  connection.prepareStatement(sql2);
  pst2.executeUpdate();
  s.invalidate();
   res.sendRedirect("index.jsp");
   
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
            throws ServletException, IOException
{
        doPost(request, response);
}
    }