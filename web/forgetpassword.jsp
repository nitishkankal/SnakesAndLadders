
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css1.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>Forget password</title>

</head>

<body>
    
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
					<li><a onclick="window.location.href='join_session_exist';" accesskey="6" title="">Join Game</a></li>   
					<li><a href="Contact_us.jsp" accesskey="7" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
  </div>
<section class="main" style="margin:0 auto; ">
<div style="margin:0 auto;text-align: left; ">
<h1>Forget Password???</h1>

<form>
<table id="content" style="margin: 0 auto;  border-spacing: 10px;">

     <tr >
          <td colspan="2" >
            <h2>Enter details to Retrieve Password:</h2>
            </td>
       </tr>
    
    <tr>
            <td >User Name:</td>
           <td><input name="uname" type="text" autofocus value="" size="40"></td>
        </tr>
  
   
    <tr>
        <td width="50%">Secret question:<br/></td>
        <td><textarea rows="2" cols="30" name='secque'></textarea></td>
    </tr>
  
    <tr>
        <td width="30%">Answer to Secret question:<br/></td>
        <td><textarea rows="2" cols="30" name="secans"></textarea></td>
    </tr>
     <tr>
                 <td style=" margin: 0 auto;border:0;"><input class="button" type="Reset"></td>
               <td style="border:0"><input type="Submit" class="button" value="Submit"/></td>
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