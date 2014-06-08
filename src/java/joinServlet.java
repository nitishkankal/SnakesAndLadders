/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nitish
 */
public class joinServlet extends HttpServlet {

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
        out = response.getWriter();
        //get the variables entered in the form
        String uname = request.getParameter("uname");
        String boardname = request.getParameter("boardname");
        String password = request.getParameter("password");
        String color=request.getParameter("die");
        int count=0;
        int max_player=0;
        int status=0;
        int order;

        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get a Connection to the database
            connection = DriverManager.getConnection
            (connectionURL, "root", "12345"); 
            //Add the data into the database

           Statement statement = (Statement) connection.createStatement();
           //out.println("hello");

            rs = statement.executeQuery("SELECT * from user_details where username='" + uname + "'");  // 



    if(rs.next())
    {
        HttpSession s=request.getSession(true);
        String user3;
        user3 = (String)s.getAttribute("Name");
         s.setAttribute("board", boardname);
         System.out.println("in join serv bname= after session");
            
            
            
        if(user3==null)
        {
        out.println("<!DOCTYPE html>");  // HTML 5
        out.println("<html><head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<style>body{background-image:url('images/1.png');}");
        out.println("a{text-decoration:underline;size:'30px';color:orange;}");
        out.println("a:hover{color:blue;}");
        out.println("</style>");
        
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
        "<link rel=\"stylesheet\" type=\"text/css\" href=\"css1.css\" />\n" +
        "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" /><title> Successful </title></head>");
        out.println("<body>");
        out.println("<h1><center><font >You should login first </font></center></h1>");  
        // Set a hyperlink image to refresh this page
        out.println("<a href='Login.jsp'>Login</a><br><br>");
        // out.println("<a href='join.jsp'>Join Game </a>");
         out.println("</body></html>");
               //return;
            }
        
            else
            {
                

                String sql1="select max_player,count from game_details where game_name='"+boardname+"'";
                System.out.println("in joiservlet after sql q 2 ==>"+sql1);
                ResultSet rs2;
                Statement st1=connection.createStatement();
                rs2=st1.executeQuery(sql1);
                System.out.println("join servlet -count for given game--"+count);
                System.out.println("jo servlet -maxplayer"+max_player);
           
                    // int max=rs2.getInt(1);
               while(rs2.next())
               {
                   out.println("hello4");
                   max_player=rs2.getInt(1);
                   count=rs2.getInt(2);
                   System.out.println("count"+count);

               }

               if(count>=max_player)
               {
                   //response.sendRedirect("joingame.jsp");
                   
                    out.println("<!DOCTYPE html>");  // HTML 5
                    out.println("<html><head>");
                    out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
                    out.println("<style>body{background-image:url('images/1.png');}");
                    out.println("a{text-decoration:underline;size:'30px';color:orange;}");
                    out.println("a:hover{color:blue;}");
                    out.println("</style>");
                    
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"css1.css\" />\n" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" /><title> Successful </title></head>");
                    out.println("<body>");
                    out.println("<h1><center>This Game already Full...Join other game </center></h1>");  
                    // Set a hyperlink image to refresh this page
                    out.println("<a href='joingame.jsp'>[Go to join other Game]</a><br><br>");
                    out.println("</body></html>");
               }
               else
               {
                   count=count+1;
                   order=count;
                   System.out.println("count join java==> "+count);
                   System.out.println("maxplayer join java ==>"+max_player);
                   String sql2="update game_details set count=? where game_name=?";
                   PreparedStatement pst1 = connection.prepareStatement(sql2);
                   
                   pst1.setInt(1,count);
                   pst1.setString(2,boardname);
                   int numRowsChanged1 = pst1.executeUpdate();
                   pst1.close();
                   
                    //out.println("hello");
                    String sql =  "insert into player_details values (?,?,?,?,?,?,?)";
                    PreparedStatement pst = 
                    connection.prepareStatement(sql);
                    pst.setString(1, uname);
                    pst.setString(2, boardname);
                    pst.setString(3, color);
                    pst.setInt(4,0 );
                    pst.setInt(5,0);
                    pst.setInt(6,status);
                    pst.setInt(7,order);
                    int numRowsChanged = pst.executeUpdate();
                    pst.close();
                   response.sendRedirect("Gameboard.jsp");

               }

            }
    }     
  else
  {
      out.println("<!DOCTYPE html>");  // HTML 5
       out.println("<html><head>");
       out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
       out.println("<style>body{background-image:url('images/1.png');}");
       out.println("a{text-decoration:none;size:'30';color:white;}");
       out.println("a:hover{color:blue;}");
       out.println("</style>");
       out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
        "<link rel=\"stylesheet\" type=\"text/css\" href=\"css1.css\" />\n" +
        "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" /><title> UnSuccessful </title></head>");
       out.println("<body>");
       out.println("<h1><center><font >Wrong username please enter again</font></center></h1>");  
       // Set a hyperlink image to refresh this page
       out.println("<a href='Login.jsp'>Login</a><br><br>");
      // out.println("<a href='join.jsp'>Join Game </a>");
       out.println("</body></html>");
  }
 }

  catch(ClassNotFoundException e)
  {
    
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
      
        
    }//end of function

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
