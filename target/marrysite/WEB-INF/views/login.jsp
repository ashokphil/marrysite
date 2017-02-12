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
<title>Login</title>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

</head>
<body>
            
    <div align="center">
    <c:url value="/j_spring_security_check" var="loginUrl" />
        <form:form action="${loginUrl}" method="POST" modelAttribute="login" >
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Please Login</h2></td>
                </tr>
                
                <tr>
                    <td>Login:</td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Login" /></td>
                </tr>

            </table>
        </form:form>   
        ${success}
    </div>
</body>
</html>