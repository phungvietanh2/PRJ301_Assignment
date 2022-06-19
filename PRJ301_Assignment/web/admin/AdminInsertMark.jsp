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
                        <h4>Inser Mark</h4>  
                    </div>

                    <form action="AdminInserMark" method="POST" class="a">
                        <label for="fname">Class</label><br>
                        <select style="border-radius: 54px;
                                width: 10rem;
                                height: 4rem;
                                text-align: center;" name="Mamh">
                            <c:forEach  items="${requestScope.subjectss}" var="d">
                                <option  
                                    <c:if  test="${param.Mamh eq d.mamh}">selected="selected"</c:if>
                                    value="${d.mamh}" >${d.mamh}
                                </option>
                            </c:forEach>
                        </select> 
                        <br>
                        <label for="fname">Student</label><br>
                        <select style="border-radius: 54px;
                                width: 10rem;
                                height: 4rem;
                                text-align: center;" name="MaSV">
                            <c:forEach  items="${requestScope.students}" var="s">
                                <option  
                                    <c:if  test="${param.MaSV eq s.masv }">selected="selected"</c:if>
                                    value="${s.masv}" >${s.masv}
                                </option>
                            </c:forEach>
                        </select> 
                        <br>
                        <label for="fname">Active learning</label>
                        <input type="number" name="Active">
<!--                        <label for="fname">Exercise 1</label>
                        <input type="number"  name="Exercise1">
                        <label for="fname">Exercise 2</label>
                        <input type="number"  name="Exercise2">
                        <label for="fname">Presentation</label>
                        <input type="number"  name="Presentation">
                        <label for="fname">Project</label>
                        <input type="number"  name="Project">
                        <label for="fname">Final Exam</label>
                        <input type="number"  name="FinalExam">
                        <label for="fname">Final Exam Resit</label>
                        <input type="number"  name="FinalExamResit">
                        <br/>-->
                        <input style="margin-top: 20px;border-radius:  10px ;width: 10rem; height: 5rem;" type="submit" value="Save" />

                    </form>


                </div>
            </div>

        </div>
    </body>
</html>
