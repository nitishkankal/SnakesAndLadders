<!DOCTYPE html>
<html lang="en">
    <head>


        <link rel="stylesheet" type="text/css" href="css/style.css" />
		

		<style type="text/css">
                    @import url(http://fonts.googleapis.com/css?family=Lato:300,400,700);
		html { height: 100%; }

					body {
						font-family: 'Lato', Calibri, Arial, sans-serif;
						background: #ddd url('images/bg.jpg') repeat top left;
						font-weight: 300;
						font-size: 15px;
						color: #333;
						-webkit-font-smoothing: antialiased;
						overflow-y: scroll;
						overflow-x: hidden;
					}

					a {
						color: #555;
						text-decoration: none;
					}

					.container {
						width: 100%;
						position: relative;
					}

					.clr {
						clear: both;
						padding: 0;
						height: 0;
						margin: 0;
					}

					.main {
						width: 90%;
						margin: 0 auto;
						position: relative;
					}

					.container > header {
						margin: 10px;
						padding: 20px 10px 10px 10px;
						position: relative;
						display: block;
						text-shadow: 1px 1px 1px rgba(0,0,0,0.2);
						text-align: center;
					}

					.container > header h1 {
						font-size: 40px;
						line-height: 38px;
						margin: 0;
						position: relative;
						font-weight: 300;
						color: #666;
						text-shadow: 0 1px 1px rgba(255,255,255,0.6);
					}

					.container > header h2 {
						font-size: 14px;
						font-weight: 300;
						margin: 0;
						padding: 15px 0 5px 0;
						color: #666;
						font-family: Cambria, Georgia, serif;
						font-style: italic;
						text-shadow: 0 1px 1px rgba(255,255,255,0.6);
					}
                                        .container > header h3 {
						font-size: 24px;
						font-weight: 300;
						margin: 0;
						padding: 15px 0 5px 0;
						color: #666;
						font-family: Cambria, Georgia, serif;
						font-style: italic;
						text-shadow: 0 1px 1px rgba(255,255,255,0.6);
					}
		</style>
	
    </head>
    <body>
        <div class="container">
		
			
			
			<header>
			
				<h1><strong>Snakes</strong> & <strong>Ladders</strong></h1>
                                <h3><strong>Login Form</strong></h3>
				
						
			</header>
			
			<section class="main">
				<form class="form-3" action="loginservlet">
				    <p class="clearfix">
				        <label for="login">Username</label>
				        <input type="text" name="Username" id="login" value="" placeholder="Username">
				    </p>
				    <p class="clearfix">
				        <label for="password">Password</label>
				        <input type="password" name="Password" id="password" value="" placeholder="Password"> 
				    </p>
				    <p class="clearfix">
				        <input type="checkbox" name="remember" id="remember">
				        <label for="remember">Remember me</label>
				    </p>
				    <p class="clearfix">
				        <input type="submit" name="submit" value="Sign in">
				    </p>    
                                     <p class="forgot">Forgot your password? <a href="forgetpassword.jsp">Click here to reset it.</a></p>
				</form>
                              
			</section>
			
        </div>
    </body>
</html>