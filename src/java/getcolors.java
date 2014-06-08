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
import java.util.ArrayList;
import javax.servlet.*;
public class getcolors extends HttpServlet {

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
   // public class create extends HttpServlet{
  @Override
  public void init(ServletConfig config) throws ServletException{
  super.init(config);
  }
    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, 
  HttpServletResponse res) throws ServletException,
  IOException{
  String connectionURL = "jdbc:mysql://localhost:3306/snakes_and_ladders";
  Connection connection=null;
  ResultSet rs,rs1;
  res.setContentType("text/html");
  PrintWriter out = res.getWriter();
  //get the variables entered in the form
  String username3 = req.getParameter("uname");
   String boardname=req.getParameter("bnamee");
  String password = req.getParameter("password");
  String color=req.getParameter("die");
  
  int count=0;
  int max_player=0;

  //String player_no=req.getParameter("no_of_players");
 //String max_player="4";
  try {
  // Load the database driver
        Class.forName("com.mysql.jdbc.Driver");
        // Get a Connection to the database
        connection = DriverManager.getConnection
        (connectionURL, "root", "12345"); 
        //Add the data into the database

            Statement statement = (Statement) connection.createStatement();
            //out.println("hello");
           String [] colors={"red","blue","green","black","yellow"};
           ArrayList<String> al=new ArrayList<String>();
           System.out.println("select * from player_details where game_name='"+boardname+"'");
           rs=statement.executeQuery("select * from player_details where game_name='"+boardname+"'");
           String str="";

           str=str+"<select name=\"die\" id=\"die1\">";
           str=str+"<option name=\"Default\" value=\"Default\">Select Die Color</option>";
           while(rs.next()){
                  al.add(""+rs.getString(3));
           }
           System.out.println(al);
           ArrayList<String> co=new ArrayList<String>();
           for(int i=0;i<colors.length;i++){
                  if(!al.contains(colors[i])){
                          co.add(colors[i]);
                  }
           }
           for(int i=0;i<co.size();i++){
                  str=str+"<option value="+co.get(i)+" class=\"span-"+co.get(i)+"\" >"+co.get(i)+"</option>";
           }
           res.setContentType("text/html");
           out=res.getWriter();
           str=str+"</select>";
           out.println(""+str);
      }

  catch(ClassNotFoundException e)
  {
        e.printStackTrace();
     out.println("Couldn't load database driver: " + e.getMessage());
  }
  catch(SQLException e)
  {
         e.printStackTrace();
        out.println("SQLException caught: " 
  + e.getMessage());
  }
  catch (Exception e)
  {
        e.printStackTrace();
        out.println(e);
  }
  finally 
  {
  // Always close the database connection.
  try 
  {
  if (connection != null) connection.close();
  }
  catch (SQLException ignored)
  {
        ignored.printStackTrace();
        out.println(ignored);
  }
  }
  }
 }
