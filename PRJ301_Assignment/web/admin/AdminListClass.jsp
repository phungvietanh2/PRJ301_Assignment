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
                        <h3>List Class/ 
                            <a style="color: black;font-size: 20p" href="Admin">Back</a> 
                            <span class="material-icons">
                                keyboard_return
                            </span></h3>
                    </div>
                    <form action="AdminListClass" method="POST">
                        <div class="panel-body">
                            <div class="container"><h1>Class</h1> </div> 
                            <select style="border-radius: 10px ; height: 4rem;
                                    text-align: center; "  name="id">
                                <c:forEach items="${requestScope.classs}" var="c">
                                    <option <c:if test="${param.id == c.cid}" >selected="selected" </c:if>  value="${c.cid}" >
                                        ${c.cid}
                                    </option>
                                </c:forEach>
                            </select>
                            <br>
                            <input style="border-radius: 10px ;
                                   height: 4rem;
                                   width: 10rem;
                                   font-size: 20px;
                                   margin-top: 15px;
                                   margin-left: 0px;" type="submit" value="Search" /> 
                        </div>
                    </form>
                    <c:if test="${requestScope.IOT102s !=null }">
                        <table  class="table table-bordered">
                            <thead>
                                    <tr>
                                    <td>RollNumber</td>
                                    <td>Activelearning <br>(10%)</td>
                                    <td>Exercise 1<br> (5%)</td> 
                                    <td>Exercise 2 <br>(5%)</td>  
                                    <td>Presentation <br>(10%)</td> 
                                    <td>Project<br>(30%)</td> 
                                    <td>FinalExam<br>(40%)</td>  
                                    <td>FinalExamResit<br>(40%)</td>
                                    <td>AVERAGE STATUS</td>
                                    <td>STATUS</td>
                                </tr>
                             
                            </thead>
                            <tbody>
                               
                                <c:forEach items="${requestScope.IOT102s}" var="e">
                                    <tr> 
                                        <td>${e.students.rollnumber}</td>
                                        <td>${e.activelearning }</td>
                                        <td>${e.exercise1}</td>
                                        <td>${e.exercise2}</td>
                                        <td>${e.presentation}</td>
                                        <td>${e.project}</td>
                                        <td>${e.finalExam}</td>
                                        <td>                         
                                            ${e.finalExamResit != 0 ? e.finalExamResit :'' }
                                        </td>
                                        <!--AVERAGE STATUS-->
                                        <c:set var="sum1" value="
                                               ${((e.activelearning*0.1) + (e.exercise1*0.05 + e.exercise2*0.05)
                                                 +e.presentation*0.1 + e.project*0.4 +e.finalExam*0.4)}">

                                        </c:set>
                                        <c:set var="sum2" value="
                                               ${((e.activelearning*0.1) + (e.exercise1*0.05 + e.exercise2*0.05)
                                                 +e.presentation*0.1 + e.project*0.3 +e.finalExamResit*0.4)}">
                                        </c:set>
                                        <td>
                                            <c:if test="${e.finalExam != 0 && e.finalExamResit ==0}">
                                                ${Math.round(sum1*100)/100}
                                            </c:if>
                                            <c:if test="${e.finalExam != 0 && e.finalExamResit !=0}">
                                                ${Math.round(sum2*100)/100}
                                            </c:if>
                                        </td>
                                        <!--STATUS-->
                                        <td>
                                            <!--sum-->
                                            <c:if test="${e.finalExam >=4 && e.finalExamResit ==0}">
                                                <c:if test="${Math.round(sum1*100)/100 >= 5}">
                                                    <h4 style="color: lime"> passed</h4>
                                                </c:if>
                                                <c:if test="${Math.round(sum1*100)/100 < 5}">
                                                    <h4 style="color: red">Not passed</h4>
                                                </c:if>
                                            </c:if>
                                            <!------------------------------------------------------------------------------------------------------------------------------------------------->
                                            <!-- check -->
                                            <c:if test="${e.finalExam <4 && e.finalExamResit ==0||
                                                          e.finalExam <4 && e.finalExamResit <4||
                                                          e.finalExam >=4 && e.finalExamResit <4||
                                                          e.activelearning == 0 || 
                                                          e.exercise1 == 0 ||  e.exercise2 == 0 || e.presentation==0 || e.project==0
                                                  }">
                                                <h4 style="color: red">Not passed</h4>
                                            </c:if>
                                            <!------------------------------------------------------------------------------------------------------------------------------------------------->
                                            <!--check pass--> 
                                            <c:if test="${e.finalExam != 0 && e.finalExamResit >=4 || e.finalExam == 0 && e.finalExamResit !=0 }">

                                                <c:if test="${Math.round(sum2*100)/100  >=5}">
                                                    <h4 style="color: lime"> passed</h4>
                                                </c:if>
                                                <c:if test="${Math.round(sum2*100)/100  <5}">
                                                    <h4 style="color: red">Not passed</h4>
                                                </c:if>
                                            </c:if>


                                        </td>

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