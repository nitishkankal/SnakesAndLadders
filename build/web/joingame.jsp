<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css1.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>Join Game</title>
 <script type="text/javascript" src="join_form_validation.js"></script>
 
 <script src="jquery-1.9.1.js"> </script>
<script type="text/javascript">
	$(function() {
		// set opacity to nill on page load
		//$("ul#menu span").css("opacity","0");
		// on mouse over
		//$("ul#menu span").hover(function () {
			// animate opacity to full
		//	$(this).stop().animate({
		//		opacity: 1
		//	}, 'slow');
		//},
		// on mouse out
		//function () {
			// animate opacity to nill
		//	$(this).stop().animate({
		//		opacity: 0
		//	}, 'slow');
		//});
                //alert("in joingame call getcolor 1");
              $("#bname").on('change',function(){
                
                $.post(
                        "getcolors",
                        {bnamee:$("#bname option:selected").text()},
                        
                        function(data){
                            if($('#die1')){
                                        $('#die').html("");
                                        
                                }
                                $("#die").html(data);
                                //alert("in joingame call getcolor");
                        });
		});
	});
        
        
	</script>
</head>

<body>
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
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="menu">
				<ul>
					<li ><a href="homepage.jsp" accesskey="1" title="">Home</a></li>
                                        <li><a href="Login.jsp" accesskey="2" title="">LogIn</a></li>
					<li><a href="Registration.jsp" accesskey="3" title="">Register</a></li>
					<li><a href="instructions.jsp" accesskey="4" title="">Instructions</a></li>
					<li><a onclick="window.location.href='new_session_exist';" accesskey="5" title="">Create Game</a></li> 
					<li class="active"><a onclick="window.location.href='join_session_exist';" accesskey="6" title="">Join Game</a></li>   
					<li><a href="Contact_us.jsp" accesskey="7" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
  </div>

<section class="main" style="margin:0 auto; ">
<div style="margin:0 auto;text-align: left; ">
<h1>Joining game and play!!!</h1>


<form name="joinGameForm" action="joinServlet" method="post" onsubmit="return validation();">
    
<table  id="content" style="margin: 0 auto;  border-spacing: 10px;" >
    
      <tr >
          <td colspan="2" >
            <h2>Enter details to join already created game:</h2>
            </td>
       </tr>
       
        <tr>
            <td >User Name:</td>
           <td><input name="uname" required  placeholder="Enter a valid User Name" type="text" autofocus value="" size="40"></td>
        </tr>
		  
          <tr>
             <td>Board Name:</td>
             <td>
                 <select name="boardname"  id="bname">
                     <option value="-1" selected disabled> Select Game</option>
                     <%
                         try
                         {
                             System.out.println("in joingame die color");
                             
                             String dbURL="jdbc:mysql://localhost:3306/snakes_and_ladders";
                             String user="root";
                             String pwd="12345";
                             String driver="com.mysql.jdbc.Driver";
                             Class.forName(driver);
                             Connection con=DriverManager.getConnection(dbURL,user,pwd);
                             String query="select game_name from game_details";
                             ResultSet rs2=null;
                             String bn=null;
                             Statement stmt =con.createStatement();
                             rs2=stmt.executeQuery(query);
                             while(rs2.next())
                                 {
                                     bn=rs2.getString("game_name");%>	
                                     <option value="<%=bn%>"><%=bn%></option>
                                     <%
                                     System.out.println(bn);
                                 }
                          }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                                     %>              
                 </select>
           
             
             </td>
          </tr>
                    
          <tr>
              <td >Password:</td>
              <td >
              <input name="password" type="password" required pattern="[a-zA-Z0-9_-]{5,10}"  autofocus value="" size="40"/></td>
          </tr>
		    
	      <tr>
              <td >Die Color:</td>
			<td id="die"></td> 
	       </tr>
             <tr>
                 <td style="border:0"><input class="button" type="Reset"  ></td>
               <td  style="border:0"><input type="Submit" class="button" value="Submit"/></td>
              </tr>                    
                    
       
  </table>

</form>

</div>
</section>
<br/>
<br/>
<img id="footer" src="images/bg-footer.jpg" width="2000" height="241">
</body>
</html>