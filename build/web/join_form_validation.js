function validation()
        {
            var x = document.joinGameForm.uname.value;
            var y = document.joinGameForm.boardname.value;
            var p = document.joinGameForm.password.value;
             var ss="";

            if(x===null || x==="")
                {
                   // alert("Enter a valid user name ");
                   ss=ss+"user name; \n ";
                    //return false;                    
                }             
		
               
                if( y === "-1" )
                {
                     ss=ss+" Board Name; \n ";
                      
                }
                
		   if(p.length<5 || p.length>10)
                {
                   // alert("Enter a valid Password");
                    //return false;
                    ss=ss+" Password; \n ";
                }
		   	   
			
                 
                 if (ss!=="")
                {
                    
                        alert(ss);
                        return false;
                }
        
}