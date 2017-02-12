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
<!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="css/agency.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


 
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>



</head>
<body background="resources/bg.jpg">
<div data-role="page" id="page" style="background-image: url('resources/bg.jpg'); background-attachment: fixed; background-repeat: no-repeat; background-size: 100% 100%;"
    data-theme="a">

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="search">Search for matches</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="logout">Logout</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="interests">Interests Received</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#team">Team</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
     <div>       
<form id="idUploadLogoForm" name="idUploadLogoForm" enctype="multipart/form-data">
 
    <div>
 <label>Profile Image:</label>
               
 <mark><img src="data:image/png;base64,${user.jsonLogo.image}"/></mark>
    </div>
 
  <div>
 <label for="idLogoFile">Choose your image:</label>
 <input id="idLogoFile" type="file" name="idLogoFile" value="idLogoFile"/>
  </div>   

<button id="idUploadLogoButton" onclick="test()">Upload Image</button>
</form>
</div>

    <div align="center">
        <form:form action="edit?${_csrf.parameterName}=${_csrf.token}" method="POST"  modelAttribute="user" >
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Profile Information</h2></td>
                </tr>
              
		        <tr><form:hidden path="id" value="${user.id}"/><form:hidden path="jsonLogo.image" value="${user.jsonLogo.image}"/>
                    <td>Email:</td>
                    <td><form:input path="email" value="${user.email}" /></td>
               
                    <td>Login Name:</td>
                    <td><form:password path="loginname" value="${user.loginname}"/> </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password" value="${user.password }" /></td>
                
                    <td>Name</td>
                    <td><form:input path="name" value="${user.name }" /></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><form:input path="gender" value="${user.gender }" /></td>
               
                    <td>date of birth</td>
                    <td><form:input path="dob" value="${user.dob }" /></td>
                </tr>
                <tr>
                    <td>religion</td>
                    <td><form:input path="religion" value="${user.religion}" /></td>
                
                    <td>Caste</td>
                    <td><form:input path="caste" value="${user.caste}" /></td>
                </tr>
                  <tr>
                    <td>Country</td>
                    <td><form:input path="country" value="${ user.country}" /></td>
                
                    <td>Location</td>
                    <td><form:input path="location" value="${user.location}" /></td>
               </tr>
                 <tr>
                    <td>Mobile number</td>
                    <td><form:input path="mobileno" value="${user.mobileno}" /></td>
                     
                    <td>About me</td>
                    <td><form:input path="userdetails.aboutme" value="${ user.userdetails.aboutme}" /></td>
                </tr>
                </table>
                
                <div data-role="collapsible">
                <table>              
                <tr>          
                
      <h1>Education details</h1>  </tr>  
      <tr> 
                
                   <td>Education</td>
                    <td><form:input path="userdetails.education.education" value="${ user.userdetails.education.education}" /></td>
                 <td>Education in Detail</td>
                  
                    <td><form:input path="userdetails.education.educationdetail" value="${ user.userdetails.education.educationdetail}" /></td>
                  
      </tr>   
      </table>    
    </div>
    <div data-role="collapsible">
                <table>              
                <tr>          
                
      <h1>Contact details</h1>  </tr>  
      <tr> 
                
                   <td>Contact name</td>
                    <td><form:input path="userdetails.contactdetails.contactname" value="${ user.userdetails.contactdetails.contactname}" /></td>
                 <td>Relationship</td>
                  
                    <td><form:input path="userdetails.contactdetails.relationship" value="${ user.userdetails.contactdetails.relationship}" /></td>
                  
      </tr>    
      <tr>
      <td>Number</td>
                  
                    <td><form:input path="userdetails.contactdetails.number" value="${ user.userdetails.contactdetails.number}" /></td>
                    <td>Profile Created by</td>
                  
                    <td><form:input path="userdetails.contactdetails.profilecreatedby" value="${ user.userdetails.contactdetails.profilecreatedby}" /></td>
      </tr>
         </table>
    </div>
    <div data-role="collapsible">
                <table>              
                <tr>          
                
      <h1>Career</h1>  </tr>  
      <tr> 
                
                   <td>Employed In</td>
                    <td><form:input path="userdetails.career.employedin" value="${ user.userdetails.career.employedin}" /></td>
                 <td>Income</td>
                  
                    <td><form:input path="userdetails.career.income" value="${ user.userdetails.career.income}" /></td>
                  
      </tr>    
      <tr>
      <td>Occupation</td>
                  
                    <td><form:input path="userdetails.career.occupation" value="${ user.userdetails.career.occupation}" /></td>
                    
      </tr>
      </table>
    </div>
    
     
     <table>
               <tr>
                
                    <td colspan="2" align="center"><input type="submit" value="save" /></td>
                </tr>
           
       
       </table> 
       </form:form>  
    </div>
    </div>   
    
       <script>
         function test() { 
    	alert('test');
    	 var form = new FormData(document.getElementById('idUploadLogoForm'));
    	 
    	 //console.log(filename);
    	 //alert(filename);
    	 $.ajax({
    	  url: "upload-logo?${_csrf.parameterName}=${_csrf.token}",
    	  data: form,
    	  dataType: 'text',
    	  processData: false,
    	  contentType: false,
    	  type: 'POST',
    	  success: function (response) {
    		  //alert('success');
    		 // alert(response);
    	      var data = jQuery.parseJSON(response);
    	      alert(data.image);
    	      $("mark").html('<img src="data:image/png;base64,'+data.image+'"/>');   
    	  },
    	  error: function (jqXHR) {
    	   //Error handling
    	  }
    	 });
    }
    </script>
       

</body>
</html>