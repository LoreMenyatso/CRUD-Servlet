

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

<div class="container">
  <h3>Add Business Advisors Form</h3>
  	<p>Please fill out every field.</p>
  	
	<form action="ControllerServlet" method="GET" class="needs-validation" >
	<input type="hidden" name="command" value="addAdvisors"/>
	
    <div class="form-group">
		<label for="first_name">First name:</label>
		<input type="text" class="form-control" id="firstName" placeholder="Enter firstname" name="firstName" required="required">
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">Please fill out this field.</div>
	</div>
	<div class="form-group">
		<label for="last_name">Last Name:</label>
		<input type="text" class="form-control" id="lastName" placeholder="Enter lastname" name="lastName" required="required">
		<div class="valid-feedback">Valid.</div>
   	    <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
		<label for="email">Email:</label>
		<input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required="required">
		<div class="valid-feedback">Valid.</div>
   	    <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group form-check">
        <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember" required> I agree to that I have provided authentic details.
        <div class="valid-feedback">Valid.</div>
        
        <div class="invalid-feedback">Check this check-box to continue.</div>
      </label>
      </div>
      
   <input type="hidden" name="command" value="Add">
   
   <input type="submit" class="btn btn-primary" value="Save">
   
     <a class="btn btn-warning" href="ControllerServlet">Cancel</a>
     
 </form>
</div>



</body>
</html>

