var count = 0;
function addstudent()
{
    count++;
    var
     content = "<div id=\"emp_container" + count + "\" class=\"emp_container\">";
    
    content += "<label for=\"fname\">ID</label><input type=\"text\" name=\"Srollnumbers" + count + "\"/> <br/>";
    content += " <label for=\"fname\"> Name </label><input type=\"text\" name=\"Sname" + count + "\"><br/>";
    content += "<label for=\"fname\">Gender</label><br/> <input class=\"Gender1\" checked=\"checked\"type=\"radio\"name=\"Sgender" + count + "\"/> Male ";
    content += "<input class=\"Gender1\" checked=\"checked\"type=\"radio\"name=\"Sgender" + count + "\"/> Female <br/>";
    content += "<label for=\"fname\">Dob</label><br><input type=\"date\" name=\"Sdob" + count + "\"/> <br/>";
    content += "<label for=\"fname\">Gmail </label><input type=\"text\"  name=\"Sgmail" + count + "\"/><br/>";
    content += "<label for=\"fname\">TERM</label><br><input type=\"text\" name=\"Sstart" + count + "\" /> <br/>";
    content += "<label for=\"fname\">K</label><br><input type=\"number\" name=\"Sk" + count + "\"/> <br/>";

    content += "<input  style=\"margin-top: 20px;border-radius:  10px ;width: 10rem; height: 5rem;\" type=\"button\" onclick=\"removeEmp(" + count + ")\" value=\"Remove\"/>";
    content += "<input type=\"hidden\" name=\"index\" value=\"" + count + "\"/> <br/>";
    content += "</div>";
    var container = document.getElementById("container");
    container.innerHTML += content;
}

function removeEmp(index)
{
    var container = document.getElementById("container");
    var emp_container = document.getElementById("emp_container" + index);
    container.removeChild(emp_container);
}
            