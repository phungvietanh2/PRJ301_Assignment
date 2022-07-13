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

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Updock&display=swap" rel="stylesheet">
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../Login/menu.jsp"></jsp:include>
            <br>
            <nav>
                <div class="container">
                    <div style="font-family: 'Nanum Gothic', sans-serif;
                         font-size: 25px">
                        <h3>Reports(Báo cáo)</h3>
                        <ul>
                            <li>
                                <a href="MarkReport?iduser=${sessionScope.account.user } " >
                                Mark Report (Báo cáo điểm)</a>
                        </li>
                        <li>
                            
                                    <a href="AcademicTranscript?iduser=${sessionScope.account.user} " >
                                                Academic Transcript (Báo cáo điểm)</a>
                               
                        </li>
                    </ul>
                </div>


            </div>

        </nav>
        <jsp:include page="../Login/footer.jsp" ></jsp:include>
    </body>
</html>
