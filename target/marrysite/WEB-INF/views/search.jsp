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
                        <a class="page-scroll" href="loginaction">Home</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="search">Search for matches</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="logout">Logout</a>
                    </li>
                    
                    <li>
                        <a class="page-scroll" href="#team">Team</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>


  <div data-role="header">
    <h1>Search For Matches</h1>
  </div>
  
  <div data-role="main" class="ui-content">
    <form action="searchaction?page=0" method="get">
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
            
            <table border="1" align="right">
      <tr>
        <td valign="top">
          <h5>Pages</h5>

          <c:forEach var="i" begin="0" end="${pageno}">
          <a href="searchaction?page=${i}&gender=${gender}&religion=${religion}">  <c:out value="${i}" /></a>

          </c:forEach>
        </td>
        </tr>
        </table>
            
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
      <c:forEach items="${userList}" var="user">
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
</div> 

</body>
</html>
