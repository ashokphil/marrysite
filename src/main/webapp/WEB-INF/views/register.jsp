<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		//reset type=date inputs to text
		$( document ).bind( "mobileinit", function(){
			$.mobile.page.prototype.options.degradeInputs.date = true;
		});	
	</script>
	<script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>	
	<script src="jQuery.ui.datepicker.js"></script>
	<script src="jquery.ui.datepicker.mobile.js"></script>
<script src="js/registration.js"></script>
</head>
<body background="resources/bg.jpg">
    <div align="center">
        <form:form name="registration" action="registersuccess" method="GET"  modelAttribute="userForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>New User Registration</h2></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" />
                    </td>
                    <td><form:errors path="email" />
                    </td>
                </tr>
                <tr>
                    <td>Login Name:</td>
                    <td><form:input path="loginname" onchange="post()"/></td>
                    <td><form:errors path="loginname" />
                    <mark></mark>
                    </td>
                    
                </tr>
                
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                    <td><form:errors path="password" />
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><form:input path="name" /></td>
                    <td><form:errors path="name" />
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><form:input path="gender" /></td>
                    <td><form:errors path="gender" />
                    </td>
                </tr>
                <tr>
                    <td>date of birth</td>
                    <td><form:input path="dob" name="date" id="date" type="date"/></td>
                    
                    <td><form:errors path="dob" />
                    </td>
                </tr>
                 <tr>
                    <td>religion</td>
                    <td><form:input path="religion" /></td>
                    <td><form:errors path="religion" />
                    </td>
                </tr>
                  <tr>
                    <td>Caste</td>
                    <td><form:input path="caste" /></td>
                    <td><form:errors path="caste" />
                    </td>
                </tr>
                  <tr>
                    <td>Country</td>
                    <td><form:input path="country" /></td>
                    <td><form:errors path="country" />
                    </td>
                </tr>
                 <tr>
                    <td>Location</td>
                    <td><form:input path="location" /></td>
                    <td><form:errors path="location" />
                    </td>
                </tr>
                <tr>
                    <td>Mobile number</td>
                    <td><form:input path="mobileno" /></td>
                    <td><form:errors path="mobileno" />
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><button type="submit" >Register New</button></td>
                </tr>
            </table>
        </form:form>
        ${success}
    </div>
</body>
<script>
    function post() { 
    	alert('test');
    	 //var form = new FormData(document.getElementById('idUploadLogoForm'));
    	 var name = $('#loginname').val();
    	 alert(name);
    	 $.ajax({
    	  url: "check-user?username="+name,
    	  processData: false,
    	  contentType: false,
    	  type: 'GET',
    	  success: function (response) {
    		  alert('success');
    		  alert(response);
    	      //var data = jQuery.parseJSON(response);
    	     // alert(data);
    	      $("mark").html(response);   
    	  },
    	  error: function (jqXHR) {
    	   //Error handling
    	  }
    	 });
    }

    </script>
     
</html>