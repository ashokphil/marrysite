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
<title>Profile Info</title>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/registration.js"></script>
<script type="text/javascript">
function doAjaxPost() { 
	alert('test');
	 var form = new FormData(document.getElementById('idUploadLogoForm'));
	 $.ajax({
	  url: "upload-logo?${_csrf.parameterName}=${_csrf.token}",
	  data: form,
	  dataType: 'text',
	  processData: false,
	  contentType: false,
	  type: 'POST',
	  success: function (response) {
		  alert('success');
		  alert(response);
	      var data = jQuery.parseJSON(response);
	      alert(data);
	      $('#idImagePlaceHolder').html('<img src="data:image/png;base64,' + data.image + '"/>');   
	  },
	  error: function (jqXHR) {
	   //Error handling
	  }
	 });
}

</script>
</head>
<body>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="search">Search for matches</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#registration">Registration</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#team">Team</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
<a href="express">Express Interest</a>
<form id="idUploadLogoForm" enctype="multipart/form-data">
 
    <div>
 <label>Profile Image:</label>                
 <div id="idImagePlaceHolder"></div>
    </div>
 
    <div>
 <label for="idLogoFile">Choose your image:</label>
 <input id="idLogoFile" type="file" name="logo"/>
    </div>   

</form>

<button id="idUploadLogoButton" onclick="doAjaxPost()">Upload Image</button>
    <div align="center">
        <form:form action="edit?${_csrf.parameterName}=${_csrf.token}" method="POST"  modelAttribute="user" >
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Profile Information</h2></td>
                </tr>
              
		        <tr><form:hidden path="id" value="${viewuser.id}"/>
                    <td>Email:</td>
                    <td><form:input path="email" value="${viewuser.email}" /></td>
               
                    <td>Login Name:</td>
                    <td><form:password path="loginname" value="${viewuser.loginname}"/> </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password" value="${viewuser.password }" /></td>
                
                    <td>Name</td>
                    <td><form:input path="name" value="${viewuser.name }" /></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><form:input path="gender" value="${viewuser.gender }" /></td>
               
                    <td>date of birth</td>
                    <td><form:input path="dob" value="${viewuser.dob }" /></td>
                </tr>
                <tr>
                    <td>religion</td>
                    <td><form:input path="religion" value="${viewuser.religion}" /></td>
                
                    <td>Caste</td>
                    <td><form:input path="caste" value="${viewuser.caste}" /></td>
                </tr>
                  <tr>
                    <td>Country</td>
                    <td><form:input path="country" value="${viewuser.country}" /></td>
                
                    <td>Location</td>
                    <td><form:input path="location" value="${viewuser.location}" /></td>
               </tr>
                 <tr>
                    <td>Mobile number</td>
                    <td><form:input path="mobileno" value="${viewuser.mobileno}" /></td>
                     
                    <td>About me</td>
                    <td><form:input path="userdetails.aboutme" value="${viewuser.userdetails.aboutme}" /></td>
                </tr>
                </table>
                
                <div data-role="collapsible">
                <table>              
                <tr>          
                
      <h1>Education details</h1>  </tr>  
      <tr> 
                
                   <td>Education</td>
                    <td><form:input path="userdetails.education.education" value="${viewuser.userdetails.education.education}" /></td>
                 <td>Education in Detail</td>
                  
                    <td><form:input path="userdetails.education.educationdetail" value="${viewuser.userdetails.education.educationdetail}" /></td>
                  
      </tr>   
      </table>    
    </div>
    <div data-role="collapsible">
                <table>              
                <tr>          
                
      <h1>Contact details</h1>  </tr>  
      <tr> 
                
                   <td>Contact name</td>
                    <td><form:input path="userdetails.contactdetails.contactname" value="${viewuser.userdetails.contactdetails.contactname}" /></td>
                 <td>Relationship</td>
                  
                    <td><form:input path="userdetails.contactdetails.relationship" value="${viewuser.userdetails.contactdetails.relationship}" /></td>
                  
      </tr>    
      <tr>
      <td>Number</td>
                  
                    <td><form:input path="userdetails.contactdetails.number" value="${viewuser.userdetails.contactdetails.number}" /></td>
                    <td>Profile Created by</td>
                  
                    <td><form:input path="userdetails.contactdetails.profilecreatedby" value="${viewuser.userdetails.contactdetails.profilecreatedby}" /></td>
      </tr>
         </table>
    </div>
    <div data-role="collapsible">
                <table>              
                <tr>          
                
      <h1>Career</h1>  </tr>  
      <tr> 
                
                   <td>Employed In</td>
                    <td><form:input path="userdetails.career.employedin" value="${viewuser.userdetails.career.employedin}" /></td>
                 <td>Income</td>
                  
                    <td><form:input path="userdetails.career.income" value="${viewuser.userdetails.career.income}" /></td>
                  
      </tr>    
      <tr>
      <td>Occupation</td>
                  
                    <td><form:input path="userdetails.career.occupation" value="${ viewuser.userdetails.career.occupation}" /></td>
                    
      </tr>
         </table>
    </div>
               </tr>
               <tr>
                
                    <td colspan="2" align="center"><input type="submit" value="save" /></td>
                </tr>
            </table>
        </form:form>
        
        
    </div>
</body>
</html>