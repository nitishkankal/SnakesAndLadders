<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>

<html>
    <head>
   <link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css1.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
     <title>Instructions</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
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
					<li class="active"><a href="instructions.jsp" accesskey="4" title="">Instructions</a></li>
					<li><a onclick="window.location.href='new_session_exist';" accesskey="5" title="">Create Game</a></li> 
					<li ><a onclick="window.location.href='join_session_exist';" accesskey="6" title="">Join Game</a></li>   
					<li><a href="Contact_us.jsp" accesskey="7" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
  </div>

<section class="main" style="margin:0 auto; ">
<div style="margin:0 auto;text-align: left; ">
    <h1>Instructions!!!</h1>   
 
 <table id="content" style="margin: 0 auto;  border-spacing: 10px;"  >
 <tr>  
     <td>
          <h2 >Rules</h2>  
     </td>
 </tr>
 <tr><td>
       <img src="images/instruction.jpg" width="550" height="250">  
     </td>
 </tr>
       
    
     
  <tr><td>
          <ol>   
        <li>The game starts on a first come first serve basis <br/></li>
        <li>If the die rolled is six, the player will get another chance to roll the die. <br/></li>
        <li>There could be only one winner. Once a player wins (reaches the 100th mark), the game is over.<br/></li>
        <li>The first player creates the game and pass phrase.<br/></li>
        <li>Others joining the game should know the <br/></li>
        <li>pass phrase to join the game. <br/></li>
    </ol>
     </td>
 </tr>
     
   
  <tr><td>
          <h3>Tips</h3>  
    <ol>   
        <li>It’s very easy to play the game. Follow the instructions given below before you play the game.  <br/></li>
        <li>Create the game. <br/></li>
        <li>Ask your friends to join the game created by you.<br/></li>
        <li>Play the game.<br/></li>
     </ol>
     </td>
 </tr>
    
  <tr><td>
     <h3>Notes</h3>  
    <ol>   
        <li>Maximum of four players can play the game  <br/></li>
        <li>There are four colors (each one for a player to differentiate from others) to choose from.  <br/></li>
    </ol>
     </td>
 </tr>
  
 
 </table>
 
  </div>  

</section>
    <br/>
<br/>
<img id="footer" src="images/bg-footer.jpg" width="2000" height="241">
</body>
</html>        
       
  
