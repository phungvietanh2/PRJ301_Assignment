<%-- 
    Document   : Home
    Created on : May 26, 2022, 6:09:54 PM
    Author     : phung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <br>
        <nav>
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="table-responsive">          
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Login</th>
                                        <th>Full name</th>                                      
                                        <th>Email</th> 
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.listlogstudentt}" var="c">
                                      <tr>
                                          <td>${c.username}</td>
                                          <td>${c.fullname}</td>
                                          <td>${c.fullname} <td>
                                    </tr>
                                </c:forEach>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                
                <div class="col-sm-4">
                    <div><ul>
                            <li><a href="MarkReport">Mark Report (Báo cáo điểm)</a></li>
                    </ul></div>
                </div>
                    </div>
            </div>
        </div>
    </nav>
        <jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>
