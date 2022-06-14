<%-- 
    Document   : AdminListClass
    Created on : Jun 14, 2022, 9:53:37 AM
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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
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
                    <p class="navbar-brand">
                        Hello ${sessionScope.accounts.user} 
                        <img style="width: 58px;margin-top:-13px;" src="img/hello.png">
                    </p>

                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
                    <form class="navbar-form navbar-left" method="GET" role="search">
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
                    <!-- uncomment code for absolute positioning tweek see top comment in css -->
                    <div class="absolute-wrapper"> </div>
                    <!-- Menu -->
                    <div class="side-menu">
                        <nav class="navbar navbar-default" role="navigation">
                            <!-- Main Menu -->
                            <div class="side-menu-container">
                                <ul class="nav navbar-nav">


                                    <li><a href="#"><span class="glyphicon "></span> Course</a></li>
                                    <li><a href="#"><span class="glyphicon "></span> Class</a></li>
                                    <li><a href="#"><span class="glyphicon "></span> Student</a></li>
                                    <li><a href="login.jsp"><span class="glyphicon  glyphicon-log-out"></span> Log out</a></li>

                                </ul>
                            </div><!-- /.navbar-collapse -->
                        </nav>

                    </div>
                </div>  		</div>
            <div class="col-md-10 content">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3>List Mark Report/ 
                            <a style="color: black;font-size: 20px" href="Admin">Back</a> 
                            <span class="material-icons">
                                keyboard_return
                            </span></h3>
                    </div>
                    <form action="AdminListMark" method="POST">
                        <div class="panel-body">
                            <div class="container"><h1>Mark Report </h1> </div> 
                            <select style="border-radius: 10px ; height: 4rem;
                                    text-align: center; "  name="id">
                                <c:forEach items="${requestScope.subjectss}" var="c">
                                    <option <c:if test="${param.id == c.id}" >selected="selected" </c:if>  value="${c.id}" >
                                     ${c.id}
                                    </option>
                                </c:forEach>
                            </select>
                            <br>
                            <input  style="border-radius: 10px ;
                                   height: 4rem;
                                   width: 10rem;
                                   font-size: 20px;
                                   margin-top: 15px;
                                   margin-left: 0px;"  type="submit" value="Search" /> 
                        </div>
                    </form>
                    
                    <c:if test="${requestScope.markss != null}">
                        <table  class="table table-bordered">
                            <thead>
                                <tr>
                                    <td>Mã Môn Học </td>
                                    <td>Mã Sinh Viên</td>
                                    <td>Tên Sinh Viên</td> 
                                    <td>Active learning</td>
                                    <td>Exercise 1</td>
                                    <td>Exercise 2</td>
                                    <td>Exercise 1</td>
                                    <td>Exercise 2</td>
                                    <td>Exercise 1</td>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.markss}" var="e">
                                    <tr> 
                                        <td>${e.subjectss.id}</td>
                                        <td><a href="#">FULL</a>${e.masv}</td>
                                        <td>${e.mark1}</td>
                                        <td>${e.mark21}</td>
                                        <td>${e.mark22}</td>
                                        <td>${e.mark3}</td>
                                        <td>${e.mark4}</td>
                                        <td>${e.mark5}</td>
                                        <td>${e.mark6}</td>
                                    </tr>   
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
                        
    </body>
</html>