<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css1.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>Home Page</title>

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
					<li class="active"><a href="homepage.jsp" accesskey="1" title="">Home</a></li>
                                        <li><a href="Login.jsp" accesskey="2" title="">LogIn</a></li>
					<li><a href="Registration.jsp" accesskey="3" title="">Register</a></li>
					<li><a href="instructions.jsp" accesskey="4" title="">Instructions</a></li>
					<li><a onclick="window.location.href='new_session_exist';" accesskey="5" title="">Create Game</a></li> 
					<li ><a onclick="window.location.href='join_session_exist';" accesskey="6" title="">Join Game</a></li>   
					<li><a href="Contact_us.jsp" accesskey="7" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
  </div>

    
<!--<a href="http://twitter.com/" target="_blank"><img src="images/main-logo.png"/></a>
<a href="https://www.facebook.com/" target="_blank"><img src="images/facebook.png"/></a>-->

<table  style="border: 0px; box-shadow: none; ">
	<tr>
            <td height="394" align="center" valign="middle" style="border: 0px; padding: 0px 0px 0px 0px"> 
                <span style="font-family: papyrus; font-size: 14px; color: #990000">
                    <span style="width: 100%;">
                        <img border="0" align="Right" src="images/img1.jpg" width="210" height="176">
                        </span></span></td>
            <td style="border: 0px; ">
                <p style="font-family: papyrus; font-size: 16px; color: #990000">
                Snakes and Ladders is an ancient Indian board game regarded today as a worldwide classic. It is played between two or more players on a gameboard having numbered,gridded squares.A number of "ladders" and "snakes" are pictured on the board, each connecting two specific board squares. The object of the game is to navigate one's game piece from the start to the finish, helped or hindered by ladders and snakes, respectively. The historic version had root in morality lessons, where a player's progression up the board represented a life journey complicated by virtues and vices. The game is a simple race contest lacking a skill component, and is popular with young children. </p>
            </td>
        </tr>
	</table>

<br/>
<div style="alignment-adjust: central; margin-left: 30%">
<a onclick="window.location.href='join_session_exist';"><img src="images/logo1.png"  width="463" height="207"/></a>
</div>
<img id="footer" src="images/bg-footer.jpg" width="2000" height="241">

</body>
</html>