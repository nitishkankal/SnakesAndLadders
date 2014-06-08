

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css1.css" />
        <link rel="stylesheet" type="text/css" href="css/main.css" />
        
	<title>Snakes and ladder game</title>
	

      </head>
<body>
    
    <div align="center">
            <img alt="Snakes n Ladders" src="./images/heading1.png"/>

        </div>
    	<%
		HttpSession s=request.getSession();
		
			String test=(String)s.getAttribute("pos");
                        String name=(String)s.getAttribute("Name");
			
		
	%>

<div id ="logoutright" class="logout">
            <h3 style="color:red"> Welcome Mr. <%=name%></h3>
            <form method="post" action="logout">
            <input type="submit" value="logout" name="logout">
            </form>
     </div>   
            
<%String boardname=""; %>

 <SCRIPT>

var fc1=new Image();
fc1.src="images/oneD.png";

var fc2=new Image();
fc2.src="images/twoD.png";

var fc3=new Image();
fc3.src="images/threeD.png";

var fc4=new Image();
fc4.src="images/fourD.png";

var fc5=new Image();
fc5.src="images/fiveD.png";

var fc6=new Image();
fc6.src="images/sixD.png";


</SCRIPT>
	
 
<%

boardname=(String)s.getAttribute("boardname");
%>
<table border="3" align="centre" width="950">	
	<tr>
	<td><table border="3" align="centre" width="300"><th colspan="3">Information</th>
	<tr>
	<th>Player Name</th>
	<th>Die Color</th>
	<th>Position</th>
	</tr>
	
	 <%! int i=0;String col=""; %>
	 <%
	 java.sql.Connection  con = null;
         final String url = "jdbc:mysql://localhost:3306/";
	 final String dbName = "snakes_and_ladders";
         final String driver = "com.mysql.jdbc.Driver";
	 
	 // Informs the driver to use server a side-cursor, 
	 // which permits more than one active statement 
	 // on a connection.
	  
	String na="";
	   try
	     {
	          Class.forName(driver).newInstance(); 
	          con = java.sql.DriverManager.getConnection(url+dbName,"root","12345");
	          if(con!=null)
	          { 
	         	 System.out.println("Connection Successful!");
	         	 Statement st=con.createStatement();
	         	 ResultSet rs=st.executeQuery("select * from player_details where game_name='"+boardname+"'");
	         	 while(rs.next())
	         	 {
	         		 i=rs.getInt("current_position");
	         		 col=rs.getString("player_color");
	         		 if(i==100)
	         		 {
	         			 na=rs.getString("player_name");
	         		 }
	         		 out.println("<tr><td>"+rs.getString("player_name")+"</td><td>"+rs.getString("player_color")+"</td><td>"+rs.getInt("current_position")+"</td></tr>");	         		 
	         	 }
	         	 test="";
	         	 s.setAttribute("pos",test);
	          }      
	     }
	     catch(Exception e)
	     {
	          e.printStackTrace();
	          System.out.println("Error Trace in getConnection() : " + e.getMessage());
	     }	 	
		%>
		</table>
</td></tr>
	</table>
<div><% out.println("<h1>Winner is "+na);%></div>


<script type="text/javascript">
    play();
</script>
</body>
</html>
