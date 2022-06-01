<%-- 
    Document   : View attendance
    Created on : Jun 1, 2022, 11:06:40 AM
    Author     : phung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container">
            <h1>View attendance for Phùng Việt Anh (AnhPVHE153711)</h1>
            <div class="row">
                <div class="col-sm-7">
                    <h3>
                        Select a campus/program, term, course ...
                    </h3>
                </div>
                <div class="col-sm-5">
                    <h3 >... then see report</h3>
                </div>
            </div>         
        </div>
        <nav class="container">
            <div class="row">
                <div class="col-sm-4">
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
                                    <td>Summer2021</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Summer2022</td>
                                    <td class="weekly"><li><a>Summer2022</a></li>
                            <li><a>Summer2022</a></li></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-sm-8">  
                    <div class="table-responsive ">          
                        <table class="table">
                            <thead>
                                <tr>                     
                                    <th class="selec1">NO</th>
                                    <th class="selec1">SLOT </th>      
                                    <th class="selec1">ROOM </th> 
                                    <th class="selec1">LECTURER </th> 
                                    <th class="selec1">GROUP<br> NAME </th>
                                    <th class="selec1">ATTEDANCE <br> STATUS</th> 
                                    <th class="selec1">LECTURER'S <br> COMMENT</th> 
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                    <td>4</td>
                                    <td>5</td>
                                    <td>6</td>
                                    <td>7</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                    <td>4</td>
                                    <td>5</td>
                                    <td>6</td>
                                    <td>7</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </nav>
         <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
