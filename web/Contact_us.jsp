<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="css1.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>Contact_Me</title>

</head>
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
					<li><a onclick="window.location.href='join_session_exist';" accesskey="6" title="">Join Game</a></li>   
					<li class="active"><a href="Contact_us.jsp" accesskey="7" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
  </div>


<div>    <section class="main" style="margin:0 auto; padding: 10px ">
            <div style="margin:0 auto;text-align: left; ">
                
             <h1>Contact Us!!!</h1>   
              <table id="content" style="margin: 0 auto;  border-spacing: 10px;"  >

                <tr>  
                    <td>
                        <div >
                            <h2> Contact Information</h2>
                        </div>
                        <p>
                            Thank you for your interest in Snake _and_ Ladders , do you find Snake _and_ Ladders.com interesting
                            and Different? Or want to leave a feedback?
                        </p>
                      </td>
                  </tr>
                    <tr>
                        <td>
                        <h3 >Send your feedback</h3>
                        <div >
                            <p>International Institute of Information Technology<br/>
                             Gachibowli, Hyderabad 500 032<br/>
                             Andhra Pradesh, INDIA<br/>
                             Phone : +91-40-6653 1000<br/>
                             Fax : +91-40-6653 1413<br/><br/>
                              <span >91-44-4245-4444</span>
                            </p>
                        </div>
                        </td>
                    </tr>

                    <tr>
                        <td>
                        <h3>
                            Support services</h3>
                        <div >
                            <p >
                               <a href="mailto:support@Snake_and_Ladders.com">support@Snake _and_ Ladders.com</a>
                               <span>+91-9790905588</span></p>
                            <p>(9:30am to 8:30pm on all days)</p>
                        </div>
                         </td>
                    </tr>

                     <tr>
                        <td>
                        <h3>
                            Career opportunities</h3>
                        <div >
                            <p ><a href="mailto:jobs@Snake_and_Ladders.com">jobs@Snake _and_ Ladders.com</a></p>
                        </div>
                         </td>
                    </tr>

                    <tr>
                        <td>
                        <h3>
                            Game owners / Game organisers want to sell the Game</h3>
                        <div >
                            <p >
                               <a href="mailto:sell@Snake_and_Ladders.com">sell@Snake _and_ Ladders.com</a>
                                or +91-9790909911

                            </p>
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <h3>To advertise in the site</h3>
                        <p><a href="mailto:advertise@Snake_and_Ladders.com">advertise@Snake _and_ Ladders.com</a>
                                91-44-4245-4444 
                        </p>
                       
                         </td>
                    </tr>


              </table>
            </div>
        </section>
</div>
      <br/>
<br/>
<img id="footer" src="images/bg-footer.jpg" width="2000" height="241">       

</body>
</html>