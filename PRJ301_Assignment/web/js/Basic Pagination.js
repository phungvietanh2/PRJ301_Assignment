/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/gulpfile.js to edit this template
 */
function removeEmp(id)
            {
                var result = confirm("are you sure?");
                if (result)
                {
                    window.location.href = "DelectController?id=" + id;
                }
            }
function render(id, pageindex, totalpage,gap)
{
   var container = document.getElementById(id);
   var content = "";
   if(pageindex > gap+1)
    content += "<a  href='AdminListStudent?page=1'>First</a>";
   
   for(var i = pageindex - gap ; i<pageindex;i++)
   {
       if(i>0)
       content += "<a href='AdminListStudent?page="+i+"' >Previous</a>";
   }
   
   content += "<span>"+pageindex+"</span>";
   
   for(var i = pageindex +1 ; i<=pageindex+gap;i++)
   {
       if(i<=totalpage)
       content += "<a href='AdminListStudent?page="+i+"'>Next</a>";
   }
   
   if(pageindex < totalpage - gap)
    content += "<a href='AdminListStudent?page="+totalpage+"'>Last</a>";
   container.innerHTML = content;
}
