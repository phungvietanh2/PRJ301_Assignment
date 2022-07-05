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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        <link href="css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="css/search2.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <!------------------------------------------------------------------------------------------------------------------------>
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
                        Hello ${sessionScope.account.user } 
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
                                    <li class="active"><a href="Admin"><span class="glyphicon "></span>Home</a></li>
                                    <li><a href="AdminInsertStudent"><span class="glyphicon "></span> INSERT STUDENT</a></li>
                                    <li><a href="AdminInsertMarkController"><span class="glyphicon "></span> INSERT MARK</a></li>
                                    <li><a href="login.jsp"><span class="glyphicon  glyphicon-log-out"></span> Log out</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>  		
            </div>

            <!--start code-->
            <div class="col-md-10 content">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Search  
                    </div>
                    <form action="Search" method="GET" >
                        <div class="wrap">
                            <div class="search">
                                <input name="searchsstudent" type="text" class="searchTerm" placeholder="What are you looking for?">
                                <button type="submit" class="searchButton">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <br><!-- comment -->
                    <form>
                        <div class="panel-body">
                            <div class="container"><h1>Student</h1> </div> 
                            <table  class="table table-bordered">
                                <thead>
                                    <tr>
                                        <td>RollNumber</td>
                                        <td>Name</td>
                                        <td>Gender</td>
                                        <td>Dob</td>  
                                        <td>Gmail</td>
                                        <td>Start</td>                         
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.students}" var="e">
                                        <tr>                                     
                                            <td>${e.sid}</td>
                                            <td>${e.sname}</td>
                                            <td>${e.sgender}</td>
                                            <td>${e.sdob}</td>
                                            <td>${e.sgmail}</td>
                                            <td>${e.start}</td>
                                        </tr>   
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </form>

                   
                    

                </div>
            </div>
    </body>
</html>
