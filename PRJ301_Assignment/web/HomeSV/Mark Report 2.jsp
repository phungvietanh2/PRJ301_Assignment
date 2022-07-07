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
        <jsp:include page="../Login/menu.jsp"></jsp:include>
            <nav class="container">
                <h1>View attendance for ${sessionScope.account.displayname} (${sessionScope.account.students}) </h1>
            <h5 style="text-align: center ; font-size: 2rem ; line-height: 50px" > 
                ... then see report
            </h5>
            <did class="container" >
                <div class="table-responsive ">          
                    <table class="table table-bordered">

                        <thead>

                        <th class="selec1">GRADE ITEM</th>
                        <th class="selec1">WEIGHT</th>  
                        <th class="selec1">VALUE</th>
                        <th class="selec1">Total</th> 
                        </thead>
                        <tbody >
                            <c:forEach items="${requestScope.asstudent}" var="c">
                                <tr>
                                    <td>${c.aname}</td>
                                    <td>${c.aweight}%</td>
                                    <td>
                                        <input readonly="true" name="${c.aid}" class="hight" type="text"
                                               <c:forEach items="${requestScope.assidstudent}" var="ca">   
                                                   <c:if test="${ca.assignments.aid eq c.aid}">
                                                       value="${ca.asmarkk}"
                                                   </c:if>
                                               </c:forEach>
                                               />
                                    </td>

                                    <td> <input readonly="true" name="${c.aid}" class="hight" type="text"
                                                <c:forEach items="${requestScope.assidstudent}" var="ca">                       
                                                    <c:if test="${ca.assignments.aid eq c.aid}">
                                                        value="${ca.total}"
                                                    </c:if>
                                                </c:forEach>
                                                /></td>


                                </tr> 
                            </c:forEach> 
                                <tr> 
                                    <th rowspan="2">COURSE TOTAL</th>
                        <c:forEach items="${requestScope.average}" var="b">   
                        <td>Average</td>
                        <td colspan="3">${b.average}</td>
                        
                        <c:set value="${b.average}" var="av"></c:set>
                          </tr>
                          <tr>
                           <td>STATUS</td> 
                               <c:forEach items="${requestScope.as}" var="avc">   
                                <c:if test="${avc.status == 1}">
                                    <td colspan="3"><h4 style="color: green">PASSED</h4></td>
                                </c:if>
                                <c:if test="${avc.status == 0}">
                                    <td colspan="3"><h4 style="color: red">NOT PASSED</h4></td>
                                </c:if>
                            </c:forEach> 
                          </tr>
                            
                               
                           
                        </c:forEach>
                              
                    </table>
                </div>
            </did>
        </nav>
        <jsp:include page="../Login/footer.jsp"></jsp:include>
    </body>
</html>
