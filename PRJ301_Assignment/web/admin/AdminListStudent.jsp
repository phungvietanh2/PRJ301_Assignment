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
        <script src="js/Basic Pagination.js" type="text/javascript"></script>
        <link href="css/Pagination.css" rel="stylesheet" type="text/css"/>
        <link href="css/search.css" rel="stylesheet" type="text/css"/>
        <script src="js/search.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <nav  class="navbar navbar-default navbar-static-top">
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
                            <a style="color: black;font-size: 20p;" href="Admin">Back</a> 
                            <span class="material-icons">
                                keyboard_return
                            </span></h3>
                    </div>
                    <div class="panel-body">
                        <div class="container"><h1>Student</h1> </div> 
                        <table  class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="selec1">TERM</th>
                                    <th class="selec1">COURSE </th>
                                    <th class="selec1">GROUP</th>                                   
                                </tr>
                            </thead>
                            <tbody >
                                <tr>
                                    <td >

                                        <table class="table table-bordered">
                                            <c:forEach items="${requestScope.Terms}" var="c">
                                                <tr>
                                                    <td>
                                                        <a href="AdminListStudent?idterms=${c.tname}"> 
                                                            ${c.tname}</a>
                                                    </td>
                                                </tr>  
                                            </c:forEach> 
                                        </table>
                                    </td>

                                    <td> 
                                        <table  class="table table-bordered">
                                            <c:forEach items="${requestScope.course}" var="a">                
                                                <tr>
                                                    <td>
                                                        <a href="AdminListStudent?idcourse=${a.suid}&idterms=${a.terms.tname}"> 
                                                            ${a.suname}</a>
                                                    </td>
                                                </tr>               
                                            </c:forEach> 
                                        </table>
                                    </td>
                                    <td> 
                                        <table  class="table table-bordered">
                                            <c:forEach items="${requestScope.classs}" var="b">                
                                                <tr>
                                                    <td>
                                                        <a href="AdminListStudent?idcourse=${b.subjectss.suid}&idterms=${b.terms.tname}&idclass=${b.cid}"> 
                                                            ${b.cname}</a>
                                                    </td>
                                                </tr>               
                                            </c:forEach> 
                                        </table>
                                    </td>
                                </tr> 

                            </tbody>
                        </table>

                        <!--                        <div id="bot_pagger" class="Pagination"> 
                                                </div>-->

                        <c:if  test="${requestScope.students != null}">
                            <table  class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th class="selec1">NO</th>
                                        <th class="selec1">MEMBER</th>
                                        <th class="selec1">CODE </th>
                                        <th class="selec1">NAME</th>                                   
                                    </tr>
                                </thead>
                                <tbody >
                                    <c:forEach items="${requestScope.students}" var="s">
                                        <tr>
                                            <td>
                                                ${s.no}
                                            </td>
                                           
                                            <td>
                                                ${s.sname}${s.sid}
                                                <br>
                                                <a href="Viewgrade?idstudent=${s.sid}&idclass=${s.classss.cid}&idcourse=${s.subjectss.suid}">View Mark</a>
                                            </td>
                                            <td>
                                                ${s.sid}
                                            </td>
                                            <td>
                                                ${s.sname}
                                            </td>
                                        </tr> 
                                    </c:forEach> 




                                </tbody>
                            </table>
                        </c:if>
                    </div>


                </div>

            </div>


        </div>
        <!--        <script>
                    render("bot_pagger",${requestScope.pageindex},${requestScope.totalpage}, 1);
                </script>-->

    </body>
</html>