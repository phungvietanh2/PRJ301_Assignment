<%-- 
    Document   : demo
    Created on : Jun 27, 2022, 1:54:31 AM
    Author     : phung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h2>Bordered Table</h2>
            <p>The .table-bordered class adds borders on all sides of the table and the cells:</p>            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <c:forEach items="${requestScope.Assignment}" var="c">
                            <th>${c.aname}</th>
                </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    
                        <c:forEach items="${requestScope.Students}" var="a">
                            <tr> 
                              <td>${a.rollnumber}</td> 
                                 <c:forEach items="${requestScope.AssignmentIDSTUDENT}" var="ca">
                                     <td>${ca.mark}</td>
                                         </c:forEach>
                            </tr>
                        </c:forEach>
                           
                    
                </tbody>
            </table>
        </div>
    </body>
</html>
