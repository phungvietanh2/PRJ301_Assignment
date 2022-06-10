<%-- 
    Document   : View attendance
    Created on : Jun 1, 2022, 11:06:40 AM
    Author     : phung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <div class="container">
                <h1>View attendance for Phùng Việt Anh (AnhPVHE153711)</h1>
                <div class="row">
                    <div class="col-sm-7">
                        <h3>
                            Select a campus/program, term, course ...
                        </h3>
                    </div>
                    <div class="col-sm-5">
                        <h3 >... then see report</h3>
                    </div>
                </div>         
            </div>
            <nav  class="container">
                <div class="row">
                    <div  class="col-sm-4">
                        
                            <div  class="table-responsive ">          
                            <table class="table">
                                <thead>
                                    <tr>                     
                                        <th class="selec1">COURSE </th>                            
                                    </tr>
                                </thead>
                                <tbody >


                                <c:forEach items="${requestScope.courses}" var="c">
                                    <tr>
                                        <td>
                                            <a href="Account?id=${c.id}">${c.name}</a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                       
                </div>
                    <form action="Account" method="POST">
                <div class="col-sm-8">  
                    <div class="table-responsive ">          
                        <table class="table">
                            <thead>
                                <tr>                     

                                    <th class="selec1">SLOT </th>      
                                    <th class="selec1">ROOM </th> 

                                    <th class="selec1">GROUP<br> NAME </th>
                                    <th class="selec1">ATTEDANCE <br> STATUS</th> 
                                    <th class="selec1">LECTURER'S <br> COMMENT</th> 
                                </tr>
                            </thead>
                           
                            <tbody>
                            
                                 <c:forEach items="${requestScope.test}" var="c">
                                    <tr>
                                        <td> ${c.slot}</td>
                                        <td>${c.room}</td>
                                        <td>${c.name}</td>
                                        <td>${c.attendencee}</td>
                                        <td>${c.notee}</td>
                                    </tr> 
                                </c:forEach>
                            
                            </tbody>
                            
                        </table>
                    </div>
                </div>
                        </form>
            </div>
        </nav>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
