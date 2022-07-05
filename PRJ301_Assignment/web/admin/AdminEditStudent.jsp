<%-- 
    Document   : admin
    Created on : Jun 1, 2022, 11:41:36 AM
    Author     : phung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminInser.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle navbar-toggle-sidebar collapsed">
                        MENU
                    </button>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <!-----xin chao nguoi dang nhap ---->
                    <p class="navbar-brand">
                        Hello ${sessionScope.accounts.user} 
                        <img style="width: 58px;margin-top:-13px;" src="img/hello.png">
                    </p>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
                    <form class="navbar-form navbar-left" method="GET" action="Search" role="search">
                        <div class="form-group">
                            <input type="text" name="q" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                    </form>

                </div>
            </div>
        </nav>  		
        <div class="container-fluid main-container">
            <div class="col-md-2 sidebar">
                <div class="row">
                    <div class="absolute-wrapper"> </div>
                    <!-- Menu -->
                    <div class="side-menu">
                        <nav class="navbar navbar-default" role="navigation">
                            <!-- Main Menu -->
                            <div class="side-menu-container">
                                <ul class="nav navbar-nav">
                                    <li><a href="Admin"><span class="glyphicon "></span>Home</a></li>
                                    <li class="active" ><a href="AdminInsertStudent"><span class="glyphicon  "></span> INSERT STUDENT</a></li>
                                    <li><a href="#"><span class="glyphicon "></span> Class</a></li>
                                    <li><a href="#"><span class="glyphicon "></span> Student</a></li>
                                    <li><a href="login.jsp"><span class="glyphicon  glyphicon-log-out"></span> Log out</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>  	
            </div>

            <div class="col-md-10 content">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>UPDATE STUDENT</h4>  
                    </div>

                    <form action="AdminEditStudent" method="POST" class="a">
                        <label for="fname">ID : ${requestScope.student.sid}</label>
                        <input type="hidden" name="Sid"  value="${requestScope.student.sid}"/> <br/>

                        <label for="fname"> Name </label>
                        <input type="text" name="Sname" value="${requestScope.student.sname}">

                        <label for="fname">Gender</label><br>   
                        <input <c:if test="${requestScope.student.sgender}">checked="checked"</c:if>
                                                                            class="Gender1" checked="checked"type="radio"name="Sgender"value="male"/> Male
                            <input <c:if test="${!requestScope.student.sgender}">checked="checked"</c:if>
                                                                                 class="Gender1" checked="checked"type="radio"name="Sgender"value="male"/> Female <br>
                     
                            <label for="fname">Dob</label><br>
                            <input type="date" name="Sdob"  value="${requestScope.student.sdob}"/> <br/>

                        <label for="fname">Gmail </label>
                        <input type="text"  name="Sgmail" value="${requestScope.student.sgmail}" />

                        <label for="fname">TERM</label><br>
                        <input type="text" name="Sstart"  value="${requestScope.student.start}"/> <br/>

                        

                        <input style="margin-top: 20px;border-radius:  10px ;width: 10rem; height: 5rem;" type="submit" value="Save" />

                    </form>


                </div>
            </div>

        </div>
    </body>
</html>
