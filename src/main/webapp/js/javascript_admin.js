/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//setInterval(ajaxCallToPopulateTable, 3000); //300000 MS == 5 minutes
$(function(){
   ajaxCallToPopulateTableUsers();
});

function ajaxCallToPopulateTableUsers() {
    $.post("GetUsersToAdmin",{},ajaxCallBack_users,"json");
}

function ajaxCallBack_users(responseTxt,statusTxt,xhr){
    if(statusTxt=='success'){
        //alert(responseTxt.msg+" , "+responseTxt.username);
        if(responseTxt.yes == "yes"){
             window.location.replace("login.html");
        }else{
            var output = '<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">'+
              '<thead>'
                +'<tr>'
                  +'<th>Name</th>'
                  +'<th>Birth Date</th>'
                  +'<th>Email</th>'
                  +'<th>Job</th>'
                  +'<th>Criedit Limit</th>'
                  +'<th>Address</th>'
                +'</tr>'
              +'</thead>'
              +'<tfoot>'
                +'<tr>'
                  +'<th>Name</th>'
                  +'<th>Birth Date</th>'
                  +'<th>Email</th>'
                  +'<th>Job</th>'
                  +'<th>Criedit Limit</th>'
                  +'<th>Address</th>'
                +'</tr>'
              +'</tfoot>'
              +'<tbody>';
      
        var tr='';
        
        for(var i in responseTxt){
            
            var res_id = responseTxt[i].id;
            var res_name = responseTxt[i].name;
            var res_date = responseTxt[i].date;
            var res_email = responseTxt[i].email;
            var res_password = responseTxt[i].password;
            var res_job = responseTxt[i].job;
            var res_cridet = responseTxt[i].cridet;
            var res_address = responseTxt[i].address;
            var res_admin = responseTxt[i].admin;
            
            tr += '<tr>';
                tr += '<td>'+res_name+'</td>';
                tr += '<td>'+res_date+'</td>';
                tr += '<td>'+res_email+'</td>';
                tr += '<td>'+res_job+'</td>';
                tr += '<td>'+res_cridet+'</td>';
                tr += '<td>'+res_address+'</td>';
            tr +='</tr>';
        }
            
        output += tr+'</tbody>'
                +'</table>';
        
        $("#users").html(output);
        }
        
    }else
        alert("Error:"+xhr.status+":"+xhr.statusTxt);
}

