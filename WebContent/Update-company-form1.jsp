

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
  <h3>Update IT Companies Form</h3>
  	<p>Please fill out every field.</p>
  	
  	<form action="ControllerServlet" method="GET"  class="needs-validation" novalidate>
  	<input type="hidden" name="command" value="updateCompanys"/>
  	<input type="hidden" name="companyId" value="${THE_COMPANY.id}"/>
  	
  	<div class="form-group">
		<label>Company name:</label>
		<input type="text" class="form-control" placeholder="Enter firstname" name="firstName" 
		value= "${THE_COMPANY.first_name}" required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">Please fill out this field.</div>
	</div>
	<div class="form-group">
		<label>Status:</label>
		<input type="text" class="form-control" placeholder="Enter status" name="status" 
		value= "${THE_COMPANY.status}" required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">Please fill out this field.</div>
	</div>
	<div class="form-group">
		<label>Activities:</label>
		<input type="text" class="form-control" placeholder="Enter activities" name="activities" 
		value= "${THE_COMPANY.activities}" required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">Please fill out this field.</div>
	</div>
	<div class="form-group">
		<label>profile:</label>
		<input type="text" class="form-control" placeholder="Enter profile" name="profile" 
		value= "${THE_COMPANY.profile}" required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">Please fill out this field.</div>
	</div>
	<div class="form-group">
		<label>Employees:</label>
		<input type="text" class="form-control" placeholder="Enter employee" name="employers" 
		value= "${THE_COMPANY.employers}" required>
		<div class="valid-feedback">Valid.</div>
		<div class="invalid-feedback">Please fill out this field.</div>
	</div>
	<div class="form-group">
		<label>Email:</label>
		<input type="email" class="form-control" placeholder="Enter email" name="email" 
		value= "${THE_COMPANY.email}" required>
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

   <input type="submit" class="btn btn-primary" value="Save">
   
   <a class="btn btn-warning" href="ControllerServlet">Cancel</a>
   
 </form>
 
	
	
	 
 
</div>



</body>
</html>
	
	
	