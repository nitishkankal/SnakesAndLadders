<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css1.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>Create New game Page</title>

 <script type="text/javascript" src="create_form_validation.js"></script>
        
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
					<li class="active"><a onclick="window.location.href='new_session_exist';" accesskey="5" title="">Create Game</a></li> 
					<li ><a onclick="window.location.href='join_session_exist';" accesskey="6" title="">Join Game</a></li>   
					<li><a href="Contact_us.jsp" accesskey="7" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
  </div>
<section class="main" style="margin:0 auto; ">	
    <div style="margin:0 auto;text-align:  left; ">
	<h1>Create New Game!!!</h1>
	
	<form name="newGameForm" action="creategameServlet" onsubmit="return validation();">
	 <input type="hidden" name="expid" value="%% EXPID %%" />
		<table  id="content"  style="margin: 0 auto;  padding: 10px; border-spacing: 10px;">

		   <tr >
                    <td colspan="2" >
                      <h2>Enter details to create New game:</h2>
                      </td>
                 </tr>
			<tr>
				<td >UserName:<br/></td>
				<td><input required autofocus placeholder="Enter a valid User Name" type="text" size="25"  maxlength="25" value="" name="uname"></td>
			</tr>
		  
		   
			<tr>
				<td style="width: 50%;">Password:<br/></td>
				<td><input required pattern="[a-zA-Z0-9_-]{5,10}"  autofocus placeholder="Enter a valid password must be alphanumeric in 5-10 chars" type="password" size="25" maxlength="25" value="" name="password"></td>
			</tr>
			
			<tr>
				<td style="width: 50%;">Board Name :<br/></td>
				<td><input required placeholder="Enter a valid Game Board Name " autofocus type="text" size="25" maxlength="25" name="boardname"></td>
			</tr>
		  
		  
			<tr>
				<td style="width: 50%;" valign="middle">Select no of players:</td>
                                <td><select name="noplayer" >
					  <option name="-1"  value="-1" selected="selected" >---Select---</option>
					  
					  <option name="02" value="2">2</option>
					  <option name="03" value="3">3</option>
					  <option name="04" value="4">4</option>

					</select></td>
			</tr>
		  
		    <tr>
						<td>Die Color:</td>
						<td>
                                                    <input type="radio"  required="required" name="die" value="red">Red<br/>
						&nbsp;&nbsp;<input type="radio"  name="die" value="blue">Blue<br/>
						&nbsp;&nbsp;<input type="radio"  name="die" value="green">Green<br/>
						&nbsp;&nbsp;<input type="radio"  name="die" value="black">Black<br/>
						&nbsp;&nbsp;<input type="radio"  name="die" value="yellow">yellow<br/>
							
						</td>
			</tr>
			
			<tr >
				<td  style="border:0"><input class="button" type="Reset" ></td>
				<td  style="border:0"><input class="button" type="submit" value="Submit"></td>
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