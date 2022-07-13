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
        <link href="css/mark.css" rel="stylesheet" type="text/css"/>
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

                    <!-----xin chao nguoi dang nhap ---->
                    <p class="navbar-brand">
                        Hello ${sessionScope.account.user } 
                        <img style="width: 58px;margin-top:-13px;" src="img/hello.png">
                    </p>
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
                                    <li><a href="AdminInsertStudent"><span class="glyphicon "></span> INSERT STUDENT</a></li>
                                    <li><a href="AdminInsertMarkController"><span class="glyphicon "></span> INSERT MARK</a></li>
                                    <li><a href="Search"><span class="glyphicon "></span> Search</a></li>
                                    <li><a href="Logout"><span class="glyphicon  glyphicon-log-out"></span> Log out</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>  		
            </div>
            <div class="col-md-10 content">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3>List Class/ 
                            <a style="color: black;font-size: 20p" href="Admin">Back</a> 
                            <span class="material-icons">
                                keyboard_return
                            </span></h3>
                    </div>
                    <did class="container" >
                        <div class="table-responsive ">          
                            <table class="table table-bordered">

                                <thead>

                                <th class="selec1">GRADE ITEM</th>
                                <th class="selec1">WEIGHT</th>  
                                <th class="selec1">VALUE</th>
                                <th class="selec1">Total</th> 
                                </thead>
                                <tbody >
                                    <c:forEach items="${requestScope.assignment}" var="c">
                                        <tr>
                                            <td>${c.aname}</td>
                                            <td>${c.aweight}%</td>
                                            <td>
                                                <input readonly="true" name="${c.aid}" class="hight" type="text"
                                                       <c:forEach items="${requestScope.assidstudent}" var="ca">   
                                                           <c:if test="${ca.assignments.aid eq c.aid}">
                                                               value="${ca.asmarkk}"
                                                           </c:if>
                                                       </c:forEach>
                                                       />
                                            </td>

                                            <td> <input readonly="true" name="${c.aid}" class="hight" type="text"
                                                        <c:forEach items="${requestScope.assidstudent}" var="ca">                       
                                                            <c:if test="${ca.assignments.aid eq c.aid}">
                                                                value="${ca.total}"
                                                            </c:if>
                                                        </c:forEach>
                                                        /></td>


                                        </tr> 
                                    </c:forEach> 
                                    <tr> 
                                        <th rowspan="2">COURSE TOTAL</th>
                                            <c:forEach items="${requestScope.average}" var="b">   
                                            <td>Average</td>
                                            <td colspan="3">${b.average}</td>

                                            <c:set value="${b.average}" var="av"></c:set>
                                            </tr>
                                            <tr>
                                                <td>STATUS</td> 
                                            <c:forEach items="${requestScope.as}" var="avc">   
                                                <c:if test="${avc.status == 1}">
                                                    <td colspan="3"><h4 style="color: green">PASSED</h4></td>
                                                </c:if>
                                                <c:if test="${avc.status == 0}">
                                                    <td colspan="3"><h4 style="color: red">NOT PASSED</h4></td>
                                                </c:if>
                                            </c:forEach> 
                                        </tr>



                                    </c:forEach>

                            </table>
                        </div>
                    </did>
                </div>
            </div>


    </body>
</html>