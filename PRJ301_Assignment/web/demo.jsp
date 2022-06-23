<%-- 
    Document   : demo
    Created on : Jun 21, 2022, 7:56:09 PM
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
        <table  class="table table-bordered">
            <thead>
                <tr>

                    <td>Tên Lớp</td>
                    <td>Mã Sinh Viên </td>
                    <td>Tên Sinh Viên</td>       
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.IOT102s}" var="e">
                    <tr> 

                        <td style="margin-left: 10rem"> ${e.activelearning } </td>
                        
                       
                       
                            id${e.exercise1 *e.activelearning }
                    </tr>   
                   
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
