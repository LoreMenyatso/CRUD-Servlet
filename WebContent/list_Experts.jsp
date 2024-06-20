

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*,com.awd.project.model.*" %>
    
    
    
<!DOCTYPE html>
<html>
<html lang="en">
<head>
   <title>FDC</title>      
	 <meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
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


		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			 <h3>IT Experts</h3>

  <blockquote class="blockquote">
    <p3>A directory of all the registered IT Experts.</p3>
    <footer class="blockquote-footer">2020</footer>
  </blockquote>
			
			<div class="container text-left">
			
			  <div class="row">
			  
			<!-- buttons that search and add  -->
			
					<div class="col">
   	    				<input type="button" value="Add Expert" onclick="window.location.href='add-expert-form.jsp'; return false;"
   	   					class="btn btn-primary" />
   	    				</div>
         
         <!-- search field and button -->
         
					<div class="col">
	 			 	  	<form action="ControllerServlet" method="get">
	   			  		 <input type="hidden" name="command" value="searchExperts"/>
	   			  		 <input  type="text" name="theSearchName" required="required"/>
	   			  		 <input type="submit" value="Search" class="btn btn-outline-info" title="Case sensitive search keys" data-toggle="popover" data-trigger="focus" data-content="please make sure your search keys match the item(s) intended to be searched"/>      
	   			   		</form>
	   			   </div>
	   			   

	   				</div>   
	   	</div>
	
   		<br>
   			   
               <table class="table table-hover">
    				<thead>
        			  <tr>
             		     <th>First name</th>
              		   	 <th>Last name</th>
               			 <th>Qualifications</th>
               			 <th>Expertise</th>
               			 <th>Email</th>
               			 <th>more</th>
                	</tr>
                </thead>
                <tbody>
                <tr>
                
                     <c:forEach var="tempCompany" items="${EXPERT_LIST}">         
                      
                         <c:url var="tempLink" value="ControllerServlet">
                         <c:param name="command" value="loadCompanys"/>
                         <c:param name="companyId" value="${tempCompany.id}"/>
                         </c:url>
                         
                         <c:url var="deletLink" value="ControllerServlet">
                         <c:param name="command" value="deleteCompanys"/>
                         <c:param name="companyId" value="${tempCompany.id}"/>
                         </c:url>
                         
                         <tr>
                                <td>${tempCompany.first_name}</td>
                                <td>${tempCompany.last_name}</td>
                                <td>${tempCompany.qualifications}</td>
                                <td>${tempCompany.expertise}</td>
                                
                                
                                <td>${tempCompany.email}</td>
                                
                                <td>
                                 <a class="btn btn-outline-success" href="index.jsp"onclick="if(!(confirm('Do you want to leave page?')))return false">info</a>
                                </td>
                         </tr>
                         </c:forEach>
                
                </tr>
                </tbody>
                </table>
                
                <br>
                
                
                <!-- Link to open other jsp pages  -->
                
                         <c:url var="tempLink1" value="ControllerServlet">
                         <c:param name="command" value="listUndergraduates"/>
                         <c:param name="UndergraduateId" value="${tempUndergraduate.id}"/>
                         </c:url>
            
                          <a href="${tempLink1}">>>></a>
             

             </div>
             
   <script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
</script>         



      </body>


</html> 