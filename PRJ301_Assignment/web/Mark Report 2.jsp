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
        <link href="css/mark.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <nav class="container">
                <h1>View attendance for ${sessionScope.account.displayname} (${sessionScope.account.students}) </h1>
            <h5 style="text-align: center ; font-size: 2rem ; line-height: 50px" > 
                Select a campus/program, term, course ...
            </h5>
            <did class="container" >
                <div class="table-responsive ">          
                    <table class="table table-bordered">
                        <thead>
                        <th class="selec1" ></th>
                            <c:forEach items="${requestScope.as}" var="c">
                            <th class="selec1">${c.aname} <br> ${c.aweight}%</th>
                            </c:forEach> 
                        <th class="selec1">AVERAGE</th>
                        <th class="selec1">STATUS</th>
                        </thead>
                        <tbody >

                            <tr > 
                                <td class="selec1">	VALUE	 <br>Total</td>
                                    <c:forEach items="${requestScope.as}" var="b">

                                    <td  >
                                        <input readonly="true" name="${b.aid}" class="hight" type="text"
                                               <c:forEach items="${requestScope.assstudent}" var="c">   
                                                   <c:if test="${c.assignments.aid eq b.aid}">
                                                       value="${c.asmarkk}"
                                                   </c:if>
                                               </c:forEach>
                                               />

                                        <input readonly="true" name="${b.aid}" class="hight" type="text"
                                               <c:forEach items="${requestScope.assstudent}" var="c">                       
                                                   <c:if test="${c.assignments.aid eq b.aid}">
                                                       value="(${c.asmarkk2})"
                                                   </c:if>
                                               </c:forEach>
                                               />
                                    </td> 
                                </c:forEach>   
                                <c:forEach items="${requestScope.assstudent2}" var="ca">   
                                    <td> ${ca.asmarkk1}</td>
                                    <c:set var="sum" value="${ca.asmarkk1}" ></c:set>
                                </c:forEach>

                                <td>
                                    <c:if test="${ sum<4}">
                                        <h4 style="color: red">NOT PASS</h4>
                                    </c:if>
                                    <c:if test="${sum >=4}">
                                        <h4 style="color: limegreen">PASS</h4>
                                    </c:if>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                </div>
            </did>
        </nav>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
