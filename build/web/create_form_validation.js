function validation()
        {

				           
	    var x = document.newGameForm.uname.value;
            var y = document.newGameForm.boardname.value;
            var p = document.newGameForm.password.value;
	
            var ss="";  
          
               if(x===null || x==="")
                {
                   // alert("Enter a valid user name ");
                    ss=ss+"user name;\n ";
                                        
                }             
              if(p.length<5 || p.length>10)
                {
                   // alert("Enter a valid Password");
                    ss=ss+" Last Name; \n ";
	
                }
		   if(y===null || y==="")
                {
                  //  alert("Enter a valid Game Board Name");
                  ss=ss+" Game Board Name; \n ";
                   
                }
                   
           if( document.newGameForm.noplayer.value === "-1" )
                {
                     // alert( "Please Select No of Players!" );
                     ss=ss+" No of Players; \n ";
                      
                }

			   
		var radios = document.newGameForm.die, i;
                var flag=null;
                 for (i=0; i<radios.length; i++)
                    {
                      if (radios[i].checked) 
                      {
                          flag=1;
                           break;
                      }

                     }
               
               if(flag===null)
                   {
                ss=ss+" Select Die Color;  ";
                   }		
	
        if (ss!=="")
                {
                    
                        alert(ss);
                        return false;
                }
        
       }