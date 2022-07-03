<%-- 
    Document   : menu
    Created on : May 26, 2022, 7:47:07 PM
    Author     : phung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-sm-10">
                        <img class="logoimg" src="img/logofpt.png">
                    </div>
                    <div class="col-sm-2 name1">
                      <c:if test="${sessionScope.account == null}">
                            <a style="font-size: 25px ; display: flex ;margin-top: 10px ;text-decoration: none" href="login.jsp">Login</a>
                       </c:if>                 
                        <c:if test="${sessionScope.account != null}">
                            <div style="font-size: 25px ; display: flex ;">
                              
                             <p>   ${sessionScope.account.displayname} </p> 
                             <p><a style="margin-top: 10px ;text-decoration: none" href="Home">Home</a></p>
                             <a style="margin-top: 10px ;text-decoration: none" href="Logout">Logout</a>
                            </div>       
                        </c:if>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
