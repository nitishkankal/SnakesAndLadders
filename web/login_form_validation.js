/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function validation()
        {

				           
	    var x = document.newGameForm.Username.value;
            var p = document.newGameForm.Password.value;
	
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
		   
                
        if (ss!=="")
                {
                    
                        alert(ss);
                        return false;
                }
        
       }
