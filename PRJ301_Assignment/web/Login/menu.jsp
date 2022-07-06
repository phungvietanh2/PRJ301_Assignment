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
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <img class="logoimg" src="img/logofpt.png">
                    </div>

                    <div class="col-sm-6 name1">
                        <h2  style=" margin-right: 4rem">FPT University Academic Portal</h2>
                    </div>
                </div>
                <div style="height: 6rem;
                     font-size: 25px;
                     display: flex;
                     background: whitesmoke;
                     padding: 1rem;
                     width: 100%;">
                    <c:if test="${sessionScope.account == null}">
                        <a style="border-radius: 6px;background: #5cb85c ;color: #ffffff;text-decoration: none;padding-left: 10px;padding-right:  10px "  
                           href="Acount">Login</a>
                    </c:if>                 
                    <c:if test="${sessionScope.account != null}">
                        <div style="font-size: 20px ; display: flex; height:  3rem">
                            <p style="border-radius: 6px;background: #5cb85c ;color: #ffffff ;height:  3rem;">Hello ${sessionScope.account.displayname} </p> 
                            <p style="padding-left: 10px ;padding-right: 10px"> |</p>
                            <a style="border-radius: 6px;background: #5cb85c ;color: #ffffff;text-decoration: none ;padding-left: 10px ;padding-right:  10px " href="Home">Home</a>
                            <p style="padding-left: 10px ;padding-right: 10px"> |</p>
                            <a style="border-radius: 6px;background: #5cb85c ;color: #ffffff;text-decoration: none;padding-left: 10px;padding-right:  10px " href="Logout">Logout</a>
                        </div>       
                    </c:if>
                </div>
            </div>
        </header>
    </body>
</html>
