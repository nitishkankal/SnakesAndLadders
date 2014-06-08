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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nitish
 */
public class gameboardServlet extends HttpServlet {

    /**
     * Processes reqs for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param req servlet req
     * @param res servlet res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
	System.out.println("Noww in gameboard");	 
  String connectionURL = "jdbc:mysql://localhost:3306/snakes_and_ladders";
  Connection connection=null;
  ResultSet rs,rs7,rs8;
    int prev=0;
    int main_prev;
    String p=null;
    String c=null;
    int curr=0;
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    //get the variables entered in the form
    HttpSession s=req.getSession();

    Enumeration e1=s.getAttributeNames();

     while(e1.hasMoreElements())
      {
           String s1=e1.nextElement().toString();
            String s2;
              s2 = s.getAttribute(s1).toString();
            System.out.println(s1+"---------->"+s2);
            System.out.println("<BR>");
      }
       String boardname= s.getAttribute("board").toString();
        String player_name=s.getAttribute("Name").toString();
        System.out.println("boardnneame in gameboard"+boardname);
      
    try
      {
    // Load the database driver
    Class.forName("com.mysql.jdbc.Driver");
    // Get a Connection to the database
    connection = DriverManager.getConnection
    (connectionURL, "root", "12345"); 
    //Add the data into the database
 
    Statement statement = (Statement) connection.createStatement();

    String final_curr=req.getParameter("curr");

    System.out.println("curr pos in gb--random variable...s1...."+final_curr);
    int current=Integer.parseInt(final_curr);
    System.out.println("SELECT current_pos from player_details where player_name='" + player_name + "'"); 
    rs = statement.executeQuery("SELECT current_pos from player_details where player_name='" + player_name + "'"); 
 
     System.out.println("after rs query select....."+boardname);

    if(rs.next())
    {
         prev=rs.getInt(1);
         main_prev=prev;

 
        System.out.println("retrieved value....."+prev);
        System.out.println("previous current....."+current);
        current=current+prev;
       if (current==5)
        {
            current=27;
            System.out.println("current"+current);
        }
        else if(current==12)
                {
                    current=33;
                    System.out.println("current"+current);
                }

        else if(current==17)
        {
            current=43;
            System.out.println("current"+current);
        }
        else if(current==28)
        {
            current=9;
            System.out.println("current"+current);
        }
        else if(current==31)
        {
            current=69;
            System.out.println("current"+current);
        }
        else if(current==36)
        {
            current=3;
            System.out.println("current"+current);
        }
        else if(current==40)
        {
            current=78;
            System.out.println("current"+current);
        }
        else if(current==46)
        {
            current=74;
            System.out.println("current"+current);
        }
        else if(current==53)
        {
            current=11;
            System.out.println("current"+current);
        }
        else if(current==56)
        {
            current=98;
            System.out.println("current"+current);
        }
        else if(current==63)
        {
            current=20;
            System.out.println("current"+current);
        }
        else if(current==71)
        {
            current=92;
            System.out.println("current"+current);
        }
        else if(current==76)
        {
            current=6;
            System.out.println("current"+current);
        }
        else if(current==96)
        {
            current=47;
            System.out.println("current"+current);
        }
        else if(current==99)
        {
            current=60;
            System.out.println("current"+current);
        }

        else if(current>100)
        {
            current=prev;
            return;
        }
        else if(current==100)
        {
            res.sendRedirect("announcewinner.jsp");
        }
        
        System.out.println("current update"+current);
        System.out.println("update player_details set current_pos="+current+" where player_name='"+player_name+"'");
        String sql2="update player_details set current_pos="+current+" where player_name='"+player_name+"';";
        System.out.println(sql2);
        Statement pst1 = connection.createStatement();
        HttpSession l=req.getSession();
        l.setAttribute("current", current);
       
        pst1.executeUpdate(sql2);
        
        //System.out.println("update player_details set prev_pos="+main_prev+" where player_name='"+player_name+"'");
        String sql3="update player_details set prev_pos="+main_prev+" where player_name='"+player_name+"';";
        System.out.println(sql3);
        Statement pst2 = connection.createStatement();
         pst2.executeUpdate(sql3);
          
         
  
  // res.sendRedirect("board.jsp");
    }
    else
        {
                System.out.println("resultset of select is null"); 
        }
     HttpSession boardname1=req.getSession(true);
     String bname=(String)boardname1.getAttribute("board");
     
     
   System.out.println("**for button enable and disable*****");
     int c1;
     rs7=statement.executeQuery("select count from game_details where game_name='"+bname+"'");
     if(rs7.next());
        {
            c1=rs7.getInt(1);
            System.out.println("count---->"+c1);
        }

        int order;
        //System.out.println("select orderp from player_details where player_name='"+player_name+"' and game_name='"+bname+"'");
        rs8=statement.executeQuery("select orderp from player_details where player_name='"+player_name+"' and game_name='"+bname+"'");
        System.out.println("select orderp from player_details where player_name='"+player_name+"' and game_name='"+bname+"'");
        if(rs8.next());
        {
            order=rs8.getInt(1);
            System.out.println(order);
        }

        if(order <c1)
        {
           System.out.println("order1"+order);
           statement.executeUpdate("update player_details set status=0 where player_name='"+player_name+"' and game_name='"+bname+"' and orderp='"+order+"'");
            order=order+1;
            statement.executeUpdate("update player_details set status=1 where orderp="+order+" and game_name='"+bname+"'");

                    
        }
        else
        {
            System.out.println("inside update"+order);
            statement.executeUpdate("update player_details set status=0 where player_name='"+player_name+"' and game_name='"+bname+"' and orderp='"+order+"'"); 
            order=1;
            statement.executeUpdate("update player_details set status=1 where orderp="+order+" and game_name='"+bname+"'");


        }
  
  
     String query="select player_name,player_color,current_pos,prev_pos from player_details where game_name='"+bname+"'";
     ResultSet rs22;
            
     Statement statement5 = connection.createStatement();
     rs22=statement5.executeQuery(query);
     out.println("<table id=\"scores\">");
     out.println("<tr>");
     out.println("<td><label style=\"color:white;\">Player</label></td>");
     out.println("<td><label style=\"color:white;\">Name</label></td>");
     out.println("<td><label style=\"color:white;\">Color</label></td>");
     out.println("<td><label style=\"color:white;\">prev_position</label></td>");
     out.println("<td><label style=\"color:white;\">cur_position</label></td></tr>");

             
   
int i=1;
  while(rs22.next())
            {
     p=rs22.getString(1);
     c=rs22.getString(2);
      curr=Integer.parseInt(rs22.getString(3));
   
 // while(rs22.next())
            
    // p=rs22.getString(1);
    // c=rs22.getString(2);
     // curr=Integer.parseInt(rs22.getString(3));
        
         out.println("<tr id=\"<%= p%>\">");
         out.println("<td><label style=\"color:white;\">Player "+i+"</label></td>");
         out.println("<td><label style=\"color:white;\">"+p+"</label></td>");
         out.println("<td><label style=\"color:white;\">"+c+"</label></td>");
         out.println("<td><label style=\"color:white;\">previous</label></td>");
         out.println("<td><label style=\"color:white;\">"+curr+"</label></td>");
         out.println("</tr>");
         
      

   
         i++;
            }
    
 //res.sendRedirect("Gameboard.jsp");
    }

  catch (Exception e)
  {
  
  e.printStackTrace();
  }
  finally 
      {
  // Always close the database connection.
  try {
  if (connection != null) {
          connection.close();
      }
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
     * @param req servlet req
     * @param res servlet res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param req servlet req
     * @param res servlet res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
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
