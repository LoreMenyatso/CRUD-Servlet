
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*,com.awd.project.model.*" %>
      

<!DOCTYPE html>
<html lang="en">
<head>
  <title>FDC</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	
	
	<!-- nav links -->
	
	   <c:url var="tempLink1" value="ControllerServlet">
                         <c:param name="command" value="listAdvisors"/>
                         <c:param name="UndergraduateId" value="${tempAdvisor.id}"/>
                         </c:url>
                         
       <c:url var="tempLink2" value="ControllerServlet">
                         <c:param name="command" value="listGraduates"/>
                         <c:param name="GraduateId" value="${tempGraduate.id}"/>
                         </c:url> 
                         
       <c:url var="tempLink3" value="ControllerServlet">
                         <c:param name="command" value="listProfessionals"/>
                         <c:param name="ProfessionalId" value="${tempProfessional.id}"/>
                         </c:url>               
                         
	   <c:url var="tempLink4" value="ControllerServlet">
                         <c:param name="command" value="listUndergraduates"/>
                         <c:param name="UndergraduateId" value="${tempUndergraduate.id}"/>
                         </c:url>
                         
      <c:url var="tempLink5" value="ControllerServlet">
                         <c:param name="command" value="listCompanys"/>
                         <c:param name="CompanyId" value="${tempCompany.id}"/>
                         </c:url>
      
      <c:url var="tempLink10" value="ControllerServlet">
                         <c:param name="command" value="listExperts"/>
                         <c:param name="ExpertId" value="${tempExpert.id}"/>
                         </c:url>                                  									
	
	<header>
	
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Francistown DC</a>
    </div>
    <ul class="nav navbar-nav">
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Personnel <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${tempLink1}">business advisors</a></li>
           <li><a href="${tempLink10}">experts</a></li>
          <li><a href="${tempLink2}">graduates</a></li>
          <li><a href="${tempLink3}">field professionals</a></li>
          <li><a href="${tempLink4}">undergraduates</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Corporations/Startups<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${tempLink5}">companies</a></li>
          <li><a href="#">startups</a></li>
        </ul>
      </li>
      
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
	</header>
	<br>
	
	</body>
	
	
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>Francistown Digital City</h1>      
    <p>We bring the first ever real time web directory packed with every innovative initiative in the city of the north.</p>
  </div>
</div>

	<center><div class="spinner-grow spinner-grow-sm text-primary"></div></center>
		<br>
<ul class="list-group">
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Companies
    <span class="badge badge-primary badge-pill">10+</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Professionals
    <span class="badge badge-primary badge-pill">7</span>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    Tech. Startups
    <span class="badge badge-primary badge-pill">5</span>
  </li>
</ul>
	
	
</html>