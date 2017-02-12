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
<title>Search Page</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #FF0000}
</style>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script src="js/registration.js"></script>
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
            <form action="searchaction" method="get">
            <table><tr>
            
            <td>
            Bride</td><td><input type="checkbox" id="female" name="gender" value="female"></td>
            <td>Groom</td><td><input type="checkbox" id="male" name="gender" value="male">
           </td>
            </tr>
            <tr>
            <td>
            Age from</td><td> <input type="text" id="fromage" name="fromage"></td>
            <td>Age To</td> <td><input type="text" id="toage" name="toage"></td>
            
            </tr>
            
            <tr>
            <td>
            Religion
            </td>
            <td>
            <select name="religion">
  <option value="christian">Christian</option>
  <option value="hindu">Hindu</option>
  <option value="muslim">Muslim</option>
  <option value="sikh" selected>Sikh</option>
</select>
            </td>
            </tr>
            
            <tr>
            <td>
            <input type="submit" value="search">Search
            </td>
            </tr>
           
            </table>
            </form>
            
    <div>        
<table data-role="table" class="ui-responsive">
      <c:forEach items="${userList}" var="user">
      
     
        <tr><td> Name :</td><td><c:out value="${user.name}" /></td></tr>
        <tr><td>Religion</td><td><c:out value="${user.religion}" /></td></tr>
        <tr><td>Occupation</td><td><c:out value="${user.userdetails.career.occupation}" /></td></tr>
        <tr><td>Income</td><td><c:out value="${user.userdetails.career.income}" /></td></tr>
      
       
      </c:forEach>
      </table>
            </div>
            </body>