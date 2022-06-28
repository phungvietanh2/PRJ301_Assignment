<%-- 
    Document   : manage
    Created on : Jun 28, 2022, 11:35:09 AM
    Author     : Ngo Tung Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/grid_control.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="manage" method="POST">
            <table border="1px">
                <tr>
                    <td></td>
                   
                <tr/>
                <c:forEach items="${requestScope.Students}" var="s">
                    <tr>
                        <td>${s.rollnumber}</td>
                        <c:forEach items="${requestScope.Assignments}" var="a">
                            <td>
                                <input name="score${s.rollnumber}_${a.aid}" class="short_textfield" type="text"
                                       <c:forEach items="${requestScope.d}" var="e">   
                                        <c:if test="${e.student.rollnumber eq s.rollnumber and e.assignments.aid eq a.aid}">
                                               value=" ${e.asmarkk}"
                                           </c:if>
                                         
                                         
                                       </c:forEach>
                                       />
                               
                            </td> 
                            </c:forEach>
                    <tr/>  
                </c:forEach>
            </table>
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
