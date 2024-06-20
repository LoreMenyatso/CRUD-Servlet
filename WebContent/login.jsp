
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*,com.awd.project.model.*" %>
      

<!DOCTYPE html>
<html lang="en">
<head>
  <title>FDC</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css'>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>



</head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css">
<div class="bg-info">
    <!-- Container containing all contents -->
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                <!-- White Container -->
                <div class="container bg-white rounded mt-2 mb-2 px-0">
                    <!-- Main Heading -->
                    <div class="row justify-content-center align-items-center pt-3">
                        <h1><strong>Login</strong></h1>
                    </div>
                    <div class="pt-3 pb-3">
                        <form class="form-horizontal">
                            <!-- User Name Input -->
                            <div class="form-group row justify-content-center px-3">
                                <div class="col-9 px-0"> <input type="text" placeholder="&#xf007; &nbsp; user name" class="form-control border-info placeicon"  required="required" > </div>
                            </div> <!-- Password Input -->
                            <div class="form-group row justify-content-center px-3">
                                <div class="col-9 px-0"> <input type="password" placeholder="&#xf084; &nbsp; &#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;" class="form-control border-info placeicon"  required="required" > </div>
                            </div> <!-- CheckBox Remember Me-->
                            <div class="form-group row justify-content-center px-3">
                                <div class="col-9">
                                    <div class="row">
                                        <div class="col-6 px-0">
                                            <div class="custom-control custom-checkbox mb-3"> <input id="customCheck1" type="checkbox" class="custom-control-input checkbox-muted"> <label for="customCheck1" class="custom-control-label text-muted">Remember Me</label> </div>
                                        </div> <!-- Forgot Password Link -->
                                       
                                    </div>
                                </div>
                            </div> <!-- Log in Button -->
                            <div class="form-group row justify-content-center" >
                                <div class="col-3 px-3"> <input type="submit" value="Log in"  onclick="window.location.href='index.jsp'; return false;" class="btn btn-block btn-info"> </div>
                            </div>
                        </form>
                    </div> <!-- Alternative Login -->
                    <div class="mx-0 px-0 bg-light">
                        <div class="pt-4">
                            <div class="row justify-content-center pt-3">
                                <h3><strong>Login</strong></h3>
                            </div>
                            <div class="row justify-content-center">
                                <h5>To gain administrative privileges</h5>
                            </div> <!-- Social Media Login buttons -->
                            
                        </div> <!-- Horizontal Line -->
                        <div class="px-4 pt-5">
                            <hr>
                        </div> <!-- Register Now -->
                        <div class="pt-2">
                            <div class="row justify-content-center">
                                <h5>Don't have an Account?<span><a href="indexGuest.jsp" class="text-success"> enter browse only mode</a></span></h5>
                            </div>
                            <div class="row justify-content-center align-items-center pt-4 pb-5">
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<body>
