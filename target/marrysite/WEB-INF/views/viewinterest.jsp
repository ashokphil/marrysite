<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="pageone">
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
                        <a class="page-scroll" href="#team">Team</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            
    <table data-role="table" class="ui-responsive">
      <thead>
        <tr>
          <th>Profile Picture</th>
          <th>Name</th>
          <th>Religion</th>
          <th>Occupation</th>
          <th>Income</th>
          <th>View Profile</th>
          </tr>
      </thead>
      <tbody>
      <c:forEach items="${viewinterest}" var="user">
        <tr>
        <td><img height="75" width="75" src="data:image/png;base64,${user.jsonLogo.image}"> </td>
          <td><c:out value="${user.name}"/></td>
          <td><c:out value="${user.religion}" /></td>
          <td><c:out value="${user.userdetails.career.occupation}"/></td>
          <td><c:out value="${user.userdetails.career.income}"/></td>
          <td><a href="viewall?loginname=${user.loginname}"/>view all</a></td>
        </tr>
         </c:forEach>
              </tbody>
    </table>
  </div>

  <div data-role="footer">
    <h1>Footer Text</h1>
  </div>


</body>
</html>
