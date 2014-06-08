<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="refresh" content="3">
  <TITLE> Create Game-Board </TITLE>
 <link rel="stylesheet" type="text/css" href="css/boardstyle.css" />
<script src="jquery-1.9.1.js"></script>
<script src="jquery-ui.js"></script>
 
 <script>
/*
//preload the six images first
var face0=new Image();
face0.src="d1.gif";
var face1=new Image();
face1.src="d2.gif";
var face2=new Image();
face2.src="d3.gif";
var face3=new Image();
face3.src="d4.gif";
var face4=new Image();
face4.src="d5.gif";
var face5=new Image();
face5.src="d6.gif";

function throwdice()
{
//create a random integer between 0 and 5
var randomdice=Math.round(Math.random()*5);
document.images["mydice"].src=eval("face"+randomdice+".src");
}
*/

$(document).ready(function(){
    //alert("jquery in gameboard");
                        $("#rolling").on('click',function(){
                            
                           var num=Math.round(Math.random()*5)+1;
                           $("#mydice").attr('src',"images/"+"dice/"+num+".JPG");
                           //alert("You got score:-"+num);
                           
                           //alert($("#bname").val());
                         
                           $.post("gameboardServlet",{curr:num},function(data){
                                     $("#scores").remove();
                               $("#id1").after(data);                          
                           });
                           return false;
                           
                        });
                    });
                    
                             
</script>

<script type="text/JavaScript">
<!--
function AutoRefresh( t ) {
	setTimeout("location.reload(true);", t);
        
}
//   -->

function Mark(x,color)
{
//alert(x);
//alert(color);

document.getElementById(x).innerHTML="<img src=images//dice//"+color+".jpg>"
}
</script>
    
<Style type="text/css">
    /* #logout{position:absolute;top:100px;right:200px;}
        img.Blue{position:absolute;right:700px;top:200px;}
        img.Red{position:absolute;right:680px;top:200px;}
        img.Black{position:absolute;right:660px;top:200px;}
        img.Green{position:absolute;right:640px;top:200px;}
        */
</Style>


</head>

<body >
       <%
         HttpSession s=request.getSession();
         String name=(String)s.getAttribute("Name");
         if(name!=null)
         {
     %>
     <div id ="logoutright" class="logout">
            <h4 style="color:red"> Welcome Mr. <%=name%></h4>
            <form method="post" action="logout">
            <input type="submit" value="logout" name="logout">
            </form>
     </div> 
            <%}%>
 <div id="headimage"></div>
 
    <div id="wrapper" >
    <div class='topleftconcave'></div>
    <div class='botleftconcave'></div>
    <div class='toprightconcave'></div>
    <div class='botrighttconcave'></div>
        <div id="header-wrapper" >
            <div id="header" class="container">
                    <div id="menu">
                            <ul>
                                    <li ><a href="homepage.jsp" accesskey="1" title="">Home</a></li>
                                    <li><a href="Login.jsp" accesskey="2" title="">LogIn</a></li>
                                    <li><a href="Registration.jsp" accesskey="3" title="">Register</a></li>
                                     <li><a href="instructions.jsp" accesskey="4" title="">Instructions</a></li>
                                    <li class="active"><a href="Gameboard.jsp" accesskey="8" title="">Game Board</a></li>
                                   <li ><a href="NewGame.jsp" accesskey="5" title="">Create Game</a></li> 
                                    <li><a href="Contact_us.jsp" accesskey="7" title="">Contact Us</a></li>

                            </ul>
                    </div>
		</div>
	</div>
  </div>    
<h1 style=" vertical-align: central">Board Game</h1>

<table style=" margin-left: 50px">
<tr>
    
<td rowspan="2" style="width: 70%; border: 0px" >

  <table id="boardtable" background="images/Snakes_Ladders_board80.jpg" width="744px" height="547px">

                <tr>
               <td width="49px" height="44px" id="100">100</td>
               <td width="49px" height="44px" id="99">1</td>
               <td width="49px" height="44px" id="98">1</td>
               <td width="49px" height="44px" id="97">1</td>
               <td width="49px" height="44px" id="96">1</td>
               <td width="49px" height="44px" id="95">1</td>
               <td width="49px" height="44px" id="94">1</td>
               <td width="49px" height="44px" id="93">1</td>
               <td width="49px" height="44px" id="92">1</td>
               <td width="49px" height="44px" id="91">1</td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="81">81</td>
               <td width="49px" height="44px" id="82">1</td>
               <td width="49px" height="44px" id="83">1</td>
               <td width="49px" height="44px" id="84">1</td>
               <td width="49px" height="44px" id="85">1</td>
               <td width="49px" height="44px" id="86">1</td>
               <td width="49px" height="44px" id="87">1</td>
               <td width="49px" height="44px" id="88">1</td>
               <td width="49px" height="44px" id="89">1</td>
               <td width="49px" height="44px" id="90">1</td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="80">80</td>
               <td width="49px" height="44px" id="79">1</td>
               <td width="49px" height="44px" id="78">1</td>
               <td width="49px" height="44px" id="77">1</td>
               <td width="49px" height="44px" id="76">1</td>
               <td width="49px" height="44px" id="75">1</td>
               <td width="49px" height="44px" id="74">1</td>
               <td width="49px" height="44px" id="73">1</td>
               <td width="49px" height="44px" id="72">1</td>
               <td width="49px" height="44px" id="71">1</td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="61">61</td>
               <td width="49px" height="44px" id="62">62</td>
               <td width="49px" height="44px" id="63">1</td>
               <td width="49px" height="44px" id="64">1</td>
               <td width="49px" height="44px" id="65">1</td>
               <td width="49px" height="44px" id="66">1</td>
               <td width="49px" height="44px" id="67">1</td>
               <td width="49px" height="44px" id="68">1</td>
               <td width="49px" height="44px" id="69">1</td>
               <td width="49px" height="44px" id="70">1</td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="60"></td>
               <td width="49px" height="44px" id="59"></td>
               <td width="49px" height="44px" id="58"></td>
               <td width="49px" height="44px" id="57"></td>
               <td width="49px" height="44px" id="56"></td>
               <td width="49px" height="44px" id="55"></td>
               <td width="49px" height="44px" id="54"></td>
               <td width="49px" height="44px" id="53"></td>
               <td width="49px" height="44px" id="52"></td>
               <td width="49px" height="44px" id="51"></td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="41"></td>
               <td width="49px" height="44px" id="42"></td>
               <td width="49px" height="44px" id="43"></td>
               <td width="49px" height="44px" id="44"></td>
               <td width="49px" height="44px" id="45"></td>
               <td width="49px" height="44px" id="46"></td>
               <td width="49px" height="44px" id="47"></td>
               <td width="49px" height="44px" id="48"></td>
               <td width="49px" height="44px" id="49"></td>
               <td width="49px" height="44px" id="50"></td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="40"></td>
               <td width="49px" height="44px" id="39"></td>
               <td width="49px" height="44px" id="38"></td>
               <td width="49px" height="44px" id="37"></td>
               <td width="49px" height="44px" id="36"></td>
               <td width="49px" height="44px" id="35"></td>
               <td width="49px" height="44px" id="34"></td>
               <td width="49px" height="44px" id="33"></td>
               <td width="49px" height="44px" id="32"></td>
               <td width="49px" height="44px" id="31"></td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="21"></td>
               <td width="49px" height="44px" id="22"></td>
               <td width="49px" height="44px" id="23"></td>
               <td width="49px" height="44px" id="24"></td>
               <td width="49px" height="44px" id="25"></td>
               <td width="49px" height="44px" id="26"></td>
               <td width="49px" height="44px" id="27"></td>
               <td width="49px" height="44px" id="28"></td>
               <td width="49px" height="44px" id="29"></td>
               <td width="49px" height="44px" id="30"></td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="20"></td>
               <td width="49px" height="44px" id="19"></td>
               <td width="49px" height="44px" id="18"></td>
               <td width="49px" height="44px" id="17"></td>
               <td width="49px" height="44px" id="16"></td>
               <td width="49px" height="44px" id="15"></td>
               <td width="49px" height="44px" id="14"></td>
               <td width="49px" height="44px" id="13"></td>
               <td width="49px" height="44px" id="12"></td>
               <td width="49px" height="44px" id="11"></td>
               </tr>

               <tr>
               <td width="49px" height="44px" id="1"></td>
               <td width="49px" height="44px" id="2"></td>
               <td width="49px" height="44px" id="3"></td>
               <td width="49px" height="44px" id="4"></td>
               <td width="49px" height="44px" id="5"></td>
               <td width="49px" height="44px" id="6"></td>
               <td width="49px" height="44px" id="7"></td>
               <td width="49px" height="44px" id="8"></td>
               <td width="49px" height="44px" id="9"></td>
               <td width="49px" height="44px" id="10"></td>
               </tr>
       </table>

</td>

<td style="padding-top:20px; border: 0px;">
    
    <%
                int cur=1;
                String p=null;
                String c=null;
                String curr="";
                int prev;
                int status=0;
                int curPlayerStatus=0;
                
            try{
                HttpSession s3=request.getSession(true);
                String bname=(String)s3.getAttribute("board");
                   
                String color=(String)s3.getAttribute("die");
              
               
 %> <h2> Welcome to <%=bname%> Board</h2>
 <label id="id1"></label>
         <%             Connection con=null;
            String dbURL = "jdbc:mysql://localhost:3306/snakes_and_ladders";
            String user = "root";
            String pwd = "12345";
            String driver = "com.mysql.jdbc.Driver";            
            Class.forName(driver);
            con = DriverManager.getConnection(dbURL, user, pwd);
            String query="select player_name,player_color,current_pos,prev_pos,status from player_details where game_name='"+bname+"'";
            System.out.println(query);
            ResultSet rs2;
            
            Statement stmt = con.createStatement();
            rs2=stmt.executeQuery(query);%>
            
            <table id="scores" >     
            <tr>
            <td><label >Player</label></td>
            <td><label >Name</label></td>
            <td><label >Color</label></td>

            <td><label >prev_position</label></td>
            <td><label >curr_position</label></td>
            </tr>

            <%int i=1;
            
             while(rs2.next())
                {
                p=rs2.getString(1);
                c=rs2.getString(2);
                cur=rs2.getInt(3);
                curr=cur+"";
                prev=rs2.getInt(4);
                System.out.println("currr--"+curr);
                System.out.println("color--"+c);
                 if(name.equals(rs2.getString(1)))
                curPlayerStatus=rs2.getInt(5);
            %>
    
                
                
             	
            <tr>
            <td><label >Player <%=i%></label></td>
            <td><label ><%=p%></label></td>
            <td><label ><%=c%></label></td>
            <td><label ><%=prev%></label></td>
            <td><label ><%=curr%></label></td>

            </tr>
          
            <script>
                Mark('<%=curr%>','<%=c%>');
            </script> 
          
           
            <% 
                           i++; 
                       }

              }

             catch(Exception e)
             {
                   e.printStackTrace();
             }
            
%>

   </table>  <!--here ends internal table for showing details          -->             
                

  <div>
      <br>
      <br>
      <div style=" margin-left: 80px">
      <form method="post" action="">
          <% System.out.println("### curent player status-"+curPlayerStatus);
            if(curPlayerStatus==1)
          {
         
          %>
          <input type="submit" value="RollDice" id="rolling" >
          <%
          }
          else
          {
          System.out.println("### curent player status-"+curPlayerStatus);
          %>  
          <input type="submit" value="RollDice" id="rolling" disabled >
          <%
          }
          %>
          
      </form>
      </div>
      <br>
      <br>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <img src="images/dice/red.jpg" alt="red" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <img src="images/dice/green.jpg" alt="Green" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <img src="images/dice/blue.jpg" alt="Blue" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <img src="images/dice/black.jpg" alt="Black" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <img src="images/dice/yellow.jpg" alt="Yellow" >&nbsp;&nbsp;
              
  </div>   
      
</td>
	
	</tr>
	
	<tr>
	<td style="padding-top:20px; padding-left:20px;  ">
	<div>
	<img src="images/dice/1.JPG"  name="mydice" id="mydice"  />
	</div>
	</td>
	</tr>

</table>
<br/>
<br/>
<img id="footer"  src="images/bg-footer.jpg" width="2000"  />
 </body>
</html>
