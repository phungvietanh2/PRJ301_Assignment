<%-- 
    Document   : Mark Report
    Created on : May 26, 2022, 8:46:41 PM
    Author     : phung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Updock&display=swap" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../Login/menu.jsp"></jsp:include>
            <nav class="container">
                <h1>
                    Grade report for transcipt ${sessionScope.account.user }(${sessionScope.account.students}) </h1>
            <did class="container" >
                <div style="font-family: 'Nanum Gothic', sans-serif;font-size: 25px" class="table-responsive ">          
                    <table class="table">
                        <thead>
                            <tr>            
                                <th class="selec1">NO</th>
                                <th class="selec1">TERM</th>
                                <th class="selec1">SEMESTER</th>
                                <th class="selec1">SUBJECT CODE</th>                           
                                <th class="selec1">SUBJECT NAME </th>
                                <th class="selec1">CREDIT</th>
                                   
                                <th class="selec1">STATUS</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.courses}" var="c"> 
                                <tr>
                                    <td>
                                        ${c.no}
                                    </td>
                                    <td>${c.termm}</td>
                                    <td>
                                        ${c.terms.tname}
                                    </td>
                                    <td>
                                        ${c.suid}                         
                                    </td>
                                    <td>${c.suname}</td>
                                    <td>${c.credit  }</td>

                                    <c:if test="${c.status == 1}">
                                        <td><h4 style="color: green">PASSED</h4></td>
                                    </c:if>
                                       
                                    <c:if test="${c.status == 0}">
                                        <td><h4 style="color: red">NOT PASSED</h4></td>
                                    </c:if>


                                </tr> 
                            </c:forEach> 
                        </tbody>
                    </table>

                </div>

            </did>
        </nav>
        <jsp:include page="../Login/footer.jsp"></jsp:include>
    </body>
</html>
