<%-- 
    Document   : Weekly timetable
    Created on : May 26, 2022, 7:40:43 PM
    Author     : phung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/Home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <nav class="container" >
            <h1>Activities for</h1>

            <div class="table-responsive ">          
                <table class="table">
                    <thead>
                        <tr>
                            <th class="blue">
                                year <select class="selectt">
                                    <option>2021</option>
                                    <option>2022</option>
                                    <option>2023</option>
                                </select> <br>week<select class="selectt">
                                    <option value="1">03/01 To 09/01</option>
	<option value="2">10/01 To 16/01</option>
	<option value="3">17/01 To 23/01</option>
	<option value="4">24/01 To 30/01</option>
	<option value="5">31/01 To 06/02</option>
	<option value="6">07/02 To 13/02</option>
	<option value="7">14/02 To 20/02</option>
	<option value="8">21/02 To 27/02</option>
	<option value="9">28/02 To 06/03</option>
	<option value="10">07/03 To 13/03</option>
	<option value="11">14/03 To 20/03</option>
	<option value="12">21/03 To 27/03</option>
	<option value="13">28/03 To 03/04</option>
	<option value="14">04/04 To 10/04</option>
	<option value="15">11/04 To 17/04</option>
	<option value="16">18/04 To 24/04</option>
	<option value="17">25/04 To 01/05</option>
	<option value="18">02/05 To 08/05</option>
	<option value="19">09/05 To 15/05</option>
	<option value="20">16/05 To 22/05</option>
	<option selected="selected" value="21">23/05 To 29/05</option>
	<option value="22">30/05 To 05/06</option>
	<option value="23">06/06 To 12/06</option>
	<option value="24">13/06 To 19/06</option>
	<option value="25">20/06 To 26/06</option>
	<option value="26">27/06 To 03/07</option>
	<option value="27">04/07 To 10/07</option>
	<option value="28">11/07 To 17/07</option>
	<option value="29">18/07 To 24/07</option>
	<option value="30">25/07 To 31/07</option>
	<option value="31">01/08 To 07/08</option>
	<option value="32">08/08 To 14/08</option>
	<option value="33">15/08 To 21/08</option>
	<option value="34">22/08 To 28/08</option>
	<option value="35">29/08 To 04/09</option>
	<option value="36">05/09 To 11/09</option>
	<option value="37">12/09 To 18/09</option>
	<option value="38">19/09 To 25/09</option>
	<option value="39">26/09 To 02/10</option>
	<option value="40">03/10 To 09/10</option>
	<option value="41">10/10 To 16/10</option>
	<option value="42">17/10 To 23/10</option>
	<option value="43">24/10 To 30/10</option>
	<option value="44">31/10 To 06/11</option>
	<option value="45">07/11 To 13/11</option>
	<option value="46">14/11 To 20/11</option>
	<option value="47">21/11 To 27/11</option>
	<option value="48">28/11 To 04/12</option>
	<option value="49">05/12 To 11/12</option>
	<option value="50">12/12 To 18/12</option>
	<option value="51">19/12 To 25/12</option>
	<option value="52">26/12 To 01/01</option>

                                </select>
                            </th>
                            <th class="selec1">MOM</th>
                            <th class="selec1">TUE <br>12/12</th>
                            <th class="selec1">WED</th>
                            <th class="selec1">THU</th>
                            <th class="selec1">FRI</th>
                            <th class="selec1">SAT</th>
                            <th class="selec1">SUN</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Slot 1</td>
                            <td></td>
                            <td>PRJ301 <br>
                                at DE-C205<br>
                                (attended)</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>PRJ301 <br>
                                at DE-C205<br>
                                (attended)</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Slot 2</td>
                            <td></td>
                            <td></td>
                            <td>PRJ301 <br>
                                at DE-C205<br>
                                (attended)</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Slot 3</td>
                            <td>PRJ301 <br>
                                at DE-C205<br>
                                (attended)</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                       <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <nav class="container">
                
                <h3>More note / Chú thích thêm:</h3>
                <ul>
                    <li>(attended): AnhPVHE153711 had attended this activity / Phùng Việt Anh đã tham gia hoạt động này</li>
                    <li>(absent): AnhPVHE153711 had NOT attended this activity / Phùng Việt Anh đã vắng mặt buổi nà</li>
                    <li>(-): no data was given / chưa có dữ liệu</li>
                </ul>
            </nav>


    </nav>
</body>
</html>
