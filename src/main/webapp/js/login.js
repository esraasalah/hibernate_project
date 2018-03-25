/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//$(document).ready(function(){
//    $("#login").click(function(){
//       
//        var email=$("#email").val();
//        var password=$("#password").val();
//        var
//        
//        
//        
//        
//        var JsonMessage={"email":email,"password":password};
//        
////        $.ajax({
////            method:'POST',
////            url:"LogIn" ,
////            dataType: 'json',
////            data:JsonMessage,
////            success:function (response){
////                
////                
////            },error: function(r){
////                alert("err");
////       }
////            
////        });
//
//
//        loginButton.disabled = true;
//    $.post("/Login" , postObject , function (data) {
//
//        if(data === "success")
//            window.location.replace("customer-account.jsp");
//        else
//        {
//            errorLabel.innerHTML = "Email or Password Invalid";
//        }
//        loginButton.disabled = false;
//
//    });
//    });
//});


function loginValidation() {

    console.log("Here");
    var email=$("#email").val();
    var password=$("#password").val();
    var loginText = $("#loginText");
    var loginButton = $("#login");
    
    var postObject = {"email":email , "password":password};
    loginButton.disabled = true;
    $.post("LogIn" , postObject , function (data) {

        if(data === "user"){
         window.location.replace("index.jsp");  
         
            
        }else if(data === "admin"){
            window.location.replace("admin.html"); 
            
        }else
        {
            loginText.html("Email or Password Invalid") ;
        }
        loginButton.disabled = false;

    });

    return false;
}


