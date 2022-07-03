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

            <div class="table-responsive ">          
                <table class="table">
                    <thead>
                        <tr>                     
                            <th class="selec1">TERM</th>
                            <th class="selec1">COURSE </th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> 
                                <c:forEach items="${requestScope.Terms}" var="c">
                        <li>
                            <a href="MarkReport?id=${c.tid}&iduser=${sessionScope.account.user}" 
                               > 
                                ${c.tname}</a>
                        </li>
                    </c:forEach> 

                    </td>
                    <td class="weekly">  
                        <c:forEach items="${requestScope.classs}" var="a">
                        <li> <a href="MarkReport2Controller?ssid=${a.cid}&iduser=${sessionScope.account.user}&sssid=${a.subjectss.suid} " >
                                ${a.subjectss.suid}(${a.cid} , ${a.clstart} ,${a.clend})</a></li>
                            </c:forEach>  

                    </td>
                    </tr>  
                    </tbody>
                </table>

            </div>

        </did>
    </nav>
</body>
</html>
