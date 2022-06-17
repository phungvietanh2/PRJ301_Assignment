<%-- 
    Document   : a
    Created on : Jun 16, 2022, 2:51:34 PM
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
        <nav class="container">
            <h1>View attendance for</h1>
            <h5  style="text-align: center ; font-size: 2rem ; line-height: 50px" > 
                Select a campus/program, term, course ...
            </h5>
            ${requestScope.subjectss.id}
                



        </nav>
    </body>
</html>
