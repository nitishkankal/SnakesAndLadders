function validation()
        {
			
            var fname = document.registrationForm.firstname.value;
            var lname     = document.registrationForm.lastname.value;	
            var loginname = document.registrationForm.loginName.value;
            var p         = document.registrationForm.password.value;

            var cp        = document.registrationForm.confirmpassword.value;
            var email     = document.registrationForm.email.value;
            var aemail    = document.registrationForm.alternetemail.value;
            var gender     = document.registrationForm.gender.value;
			
            var day     = document.registrationForm.day.value;
            var month     = document.registrationForm.month.value;
            var year     = document.registrationForm.year.value;
            
            var country   = document.registrationForm.country.value;
            var address   = document.registrationForm.address.value;    
            var ph        = document.registrationForm.phoneno.value;
            var iChars = "!`@#$%^&*()+=-[]\\\';,./{}|\":<>?~_";
            var num ="1234567890";
            var ss="";
            var txtCaptcha=document.registrationForm.txtCaptcha.value;
                var txtInput=document.registrationForm.txtInput.value;
		
              if(fname === null || !(validfname(fname)))
                {
                    alert("Enter a valid user First name ");
                    return false;                    
                }  
                if(lname === null ||!(validfname(lname)))
                {
                    alert("Enter a valid user last name ");
                    return false;                    
                }  
                
		if(loginname==="" || iChars.indexOf(loginname.charAt(0)) !== -1 || num.indexOf(loginname.charAt(0)) !== -1)
                {
                    alert("Enter a valid Login Nam\n First character is not a numeric or special character");
                    return false;
                }
                
            	           
                if(!(validpassword(p)))
                {
                    alert("Enter a valid Password");
                    return false;
                }
              if(cp!==p )
                {
                    alert("Password does not match!!! \nPlease give correct password");
                    return false;
                }
              
               ss = ss + checkEmail(email,"Email");

                if (ss !=="")
                {
                        alert(ss);
                        return false;
                }
                ss = ss + checkEmail(aemail,"Alternet Email");

                if (ss !=="")
                {
                        alert(ss);
                        return false;
                }
              if( gender === "-1" )
				{
                    alert( "Please Select Your Gender" );
                    return false;
                  }
				  
                 if( month === "-1" )
                    {
                     alert( "Please Select Your day in Date of Birth" );
                     return false;
                    }
                if( day === "-1" )
                    {
                     alert( "Please Select Your day in Date of Birth" );
                    return false;
                    } 

                    if( year === "-1" )
                    {
                     alert( "Please Select Your day in Date of Birth" );
                        return false;
                    } 
                 if(!(isDate( day, month, year )))
                    {
                            alert("Please Select Valid date" );
                            return false;
                    }
                 
				 
                if(country === "-1" )
                       {
                    alert( "Please Select country" );
                    return false;
                       }  
                
                if(!(addressValid(address)))
                    {
                            return false;
                    } 
            if(!(phoneValid(ph)))
                    {

                            return false;
                    } 
                    if(!txtCaptcha.match(txtInput))
                    {
                    alert("Wrong Captcha"); 
                    document.registrationForm.txtInput.focus();
                     return false; 
                     
                }

		
	}
				
/* FUNCTION TO VALIDATE first name */
function validfname(fname)
{
        var pat=/[a-z]{5,20}/i;
	if(fname.match(pat)===fname)
	return true;
	else
	return false;
}
function validpassword(pwd)
{
        var pat=/[a-z0-9]{5,10}/i;
	if(pwd.match(pat)===pwd)
	return true;
	else
	return false;
}
/* Function to validate the Email */
function checkEmail(email,str)
{
    
	var cut, len;
	
	len = email.length;
	var tmp1 = email.substring ( email.lastIndexOf ( "." )+1 );
	var tmp2 = email.substring ( 0, email.indexOf ( "@" ) );
	var tmp3 = email.substring (email.indexOf ( "@" )+1 );
	var x;
	var tmp4 = email.substring ( ( x = email.indexOf ( '@' ) ) + 1, email.indexOf ( '.', x ) );
	var flag = false;
		
	if ((cut = email.indexOf ('@')) === -1 || email.indexOf ('.') === -1 || tmp3.indexOf('.') === -1 || tmp4.length === 0)
	{
		return str + " is not Valid\n";	
	}					
	else if (email.substring (++cut, len).indexOf ('@') !== -1)
	{
		return str + " shouldn't contain more than one @ Symbols \n";
	}
	// Checking for minimum two characters after "." and before "@"
	else if ( tmp1.length < 2  || tmp2.length < 2 )
	{
		return str + " is not Valid \n";
	}
	tmp2 = tmp2.toLowerCase();
	for (var i=0; i<tmp2.length; i++)
	{
		if ( (tmp2.charAt(i) >= 'a' && tmp2.charAt(i) <= 'z') || (tmp2.charAt(i) >= '0' && tmp2.charAt(i) <= '9') )
		{
			flag = true;
			break;
		}
	}
	if (flag === false)
	{
		return str + " is not Valid \n";
	}
	
	return "";
}
function phoneValid(phone)		//validate phone number
{
	if(phone!=="" && phone.length===10)
	{
		if(!isNaN(phone))
		{
			return true;	
		}	
		else
		{
			alert("Phone number is not valid!!");	
			
			return false;
		}
	}	
	else
	{
		alert("Phone number must be 10 digits");	
		return false;
	}
}

function addressValid(addresslane)		//validate address
{
	if(addresslane!=="" && addresslane.match(/^\S+$/))
	{
		return true;
	}	
	else
	{
		alert("Address field should not be empty");	
		return false;
	}
}
/* FUNCTION TO VALIDATE DATE */
function isDate(day,month,year)
{
	if ( ( day === 0 ) || ( year === 0 ) )
		return false;
	month = month.toLowerCase ();
	switch ( month ) 
	{
		case "january"	:if ( !( (day > 0) && (day <= 31) ) )
				return false;
				break;								
		case "february"	:if ( ( year % 4 === 0 ) && ( year % 100 !== 0 ) || ( year % 400 === 0 ) )
				{
				if ( !( day > 0 && day <= 29 ) )
				return false;
				}
				else
				if ( !( day > 0 && day <= 28 ) )
				return false;
				break;									
		case "march"	:if ( !( day > 0 && day <= 31 ) )
				return false;							
				break;								
		case "april"	:if ( !( day > 0 && day <= 30 ) )
				return false;
				break;
		case "may"	:if ( !( day > 0 && day <= 31 ) )
				return false;
				break;	
		case "june"	: if ( !( day > 0 && day <= 30 ) )
				return false;
				break;								
		case "july"	: if ( !( day > 0 && day <= 31 ) )
				return false;
				break;								
		case "august"	:if ( !( day > 0 && day <= 31 ) )
				return false;
				break;								
		case "september":if ( !( day > 0 && day <= 30 ) )
				return false;
				break;	
		case "october"	: if ( !( day > 0 && day <= 31 ) )
				return false;
				break;	
		case "november"	: if ( !( day > 0 && day <= 30 ) )
				return false;
				break;	
		case "december"	:if ( !( day > 0 && day <= 31 ) )
				return false;
				break;					
		default		:return false;										
	}
	return true;
}

/*************fUNCTION for ajax username validation******/


function checkUsername()
{
	//var xmlhttp;
        //alert("in check username");    
	var x= document.getElementById("loginName").value;
	//alert(x);
	
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.open("post","unamecheck?username="+escape(x),true);
	xmlhttp.send(null);
	
	
	
	xmlhttp.onreadystatechange=function()
	{
		
		
		if (xmlhttp.readyState===4 && xmlhttp.status===200)
		{	
			document.getElementById("unameid").innerHTML=xmlhttp.responseText;
			//alert(xmlhttp.responseText);
		}
	};

}