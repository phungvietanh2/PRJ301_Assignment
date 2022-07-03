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
    <a href="Home.jsp"></a>
    <title>JSP Page</title>
</head>
<body>
    <jsp:include page="menu.jsp"></jsp:include>
        <nav class="container">
            <h1>View attendance for ${sessionScope.account.user } </h1>
        <h5 style="text-align: center ; font-size: 2rem ; line-height: 50px" > 
            Select a campus/program, term, course ...
        </h5>
        <did class="container" >
            <did class="row">
                <div class="table-responsive ">          
                        <table class="table">
                            <thead>
                                <tr>                     
                                    <th class="selec1">GRADE ITEM</th>
                                    <th class="selec1">WEIGHT </th>
                                    <th class="selec1">VALUE </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <c:forEach items="${requestScope.assstudent}" var="ass">
                                        <td>${ass.assignments.aname}</td>
                                    </c:forEach> 
                                        <c:forEach items="${requestScope.as}" var="c">
                                        <td>${c.aname}</td>
                                    </c:forEach> 
                                </tr>
                            </tbody>
                        </table>
                </div>

            </did>
        </did>
    </nav>
</body>
</html>
