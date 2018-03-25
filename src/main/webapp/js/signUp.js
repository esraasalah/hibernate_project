/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    
//   var password = document.getElementById("password")
//  , confirm_password = document.getElementById("confirm_password");
//
//function validatePassword(){
//  if(password.value != confirm_password.value) {
//    confirm_password.setCustomValidity("Passwords Don't Match");
//  } else {
//    confirm_password.setCustomValidity('');
//  }
//}
//
//password.onchange = validatePassword;
//confirm_password.onkeyup = validatePassword;


//$(document).ready(function(){
//    $("#register").click(function(){
//        var fname=$("#fname").val();
//        var lname=$("#lname").val();
//        var email=$("#email").val();
//        var password=$("#password").val();
//        var birthDate=$("#birthDate").val();
//        var Address=$("#Address").val();
//        var job=$("#job").val();
//        var creditLimit=$("#creditLimit").val();
//        
//        
//        
//        
//        var JsonMessage={"fname":fname,"lname":lname,"email":email,"password":password,"birthDate":birthDate,"Address":Address
//            ,"job":job,"creditLimit":creditLimit};
//        
//        $.ajax({
//            
//            url:"SignUp" ,
//            dataType: 'json',
//            data:JsonMessage,
//            success:function (response){
//                if(response==true){
//                    window.location="login.html";
//                }else{
//                    $('#emailexist').html("The Email is Already exist");
//                }
//                
//            }
//            
//        });
//    });
//});

$(document).ready(function(){
    $("#email").focusout(function(){
       
        var email=$("#email").val();
        
        var JsonMessage={"email":email};
        
        $.ajax({
            method:'GET',
            url:"SignUp" ,
            dataType: 'json',
            data:JsonMessage,
            success:function (response){
                if(response==true){
                    $("#register").prop('disabled', false);
                    $('#emailexist').html("");
                    
                }else{
                    $('#emailexist').html("The Email is Already exist");
                    $("#register").prop('disabled', true);
                }
                
            }
            
        });
    });
});

     var fname=$("#fname");
        var lname=$("#lname");
        var email=$("#email");
        var password=$("#password");
        var birthDate=$("#birthDate");
        var Address=$("#Address");
        var job=$("#job");
        var creditLimit=$("#creditLimit").val();
    
function checkForm(form)
{
    $('#emailexist').html("");
    $('#lnametext').html("");
    $('#fnametext').html("");
    $('#passtext').html("");
    $('#passconf').html("");
    $('#bdatetext').html("");
    $('#addresstext').html("");
    $('#jobtext').html("");
    $('#credtext').html("");
    if (fname.val() === "") {
       $('#fnametext').html("first name cannot be empty");
        //form.username.focus();
        return false;
    }
    
     if (lname.val() === "") {
        $('#lnametext').html("last name cannot be empty");
        //form.username.focus();
        return false;
    }
    
     if (email.val() === "") {
        $('#emailexist').html("email cannot be empty");
        //form.username.focus();
        return false;
    }
    
    


    if (password.val()!== "" ) {
        if (password.val().length < 6) {
           $('#passtext').html("pass length should be more tha 6 character"); 
            //form.pwd1.focus();
            return false;
        }
        
        re = /[0-9]/;
        if (!re.test(password.val())) {
            $('#passtext').html("password must contain at least one number (0-9)!");
            //form.pass.focus();
            return false;
        }
        re = /[a-z]/;
        if (!re.test(password.val())) {
            $('#passtext').html("password must contain at least one character (a-z)!");
            //form.pass.focus();
            return false;
        }


    } else {
        $('#passtext').html("pass cannot be empty ");
        //form.pass.focus();
        return false;
    }
    
   
          if (Address.val() === "") {
        $('#addresstext').html("address cannot be blank!");
        //form.username.focus();
        return false;
    }
    
     if (job.val() === "") {
        $('#jobtext').html("job cannot be blank!");
        //form.username.focus();
        return false;
    }
    
    if (creditLimit.val() === "") {
        $('#credtext').html("credit cannot be blank!");
        //form.username.focus();
        return false;
    }
    
     
    
       if (birthDate.val() === "") {
        $('#bdatetext').html("job cannot be blank!");
        //form.username.focus();
        return false;
    }
    
    

    
    return true;
}


