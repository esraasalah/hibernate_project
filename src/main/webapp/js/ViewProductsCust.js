/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
    ajaxCallAllProducts();
});

function ajaxCallAllProducts(){
    $.post("ViewCustProducts",{},ajaxCallBack,"json");
}

function ajaxCallBack(responseTxt,statusTxt,xhr){
    if(statusTxt == 'success'){
        var result = '';
        for(var i in responseTxt){
            result += '<div class="product-item">'
            + '<div class="product product_filter">'
            + '<div class="product_image">'
            + '<p hidden name"productId"  style="display: inline;">' + responseTxt[i].id + '</p>'
            + '<img width="100" height="200" src="'+responseTxt[i].image+'" alt="">'
            + '</div>'
            + '<div class="favorite"></div>'
            + '<div class="product_info">'
            + '<h6 class="product_name"><a href="single.html">' + responseTxt[i].name + '</a></h6>'
            + '<div class="product_price">' + responseTxt[i].salary + ' LE</div>'
            + '</div>'
            + '</div>'
            + '<div id = "div'+responseTxt[i].id+'" class="red_button add_to_cart_button" onclick="refreshCart('+responseTxt[i].id+')"  value="'+responseTxt[i].id+'" >add to cart</div>'
            + '</div>';
        }
        
        $("#productView").html(result);
    }else{
        alert("Error:"+xhr.status+":"+xhr.statusTxt);
    }
}

//Favorit Function
//$(document).ready(function () {
//    $("favorite").click(function () {
//        $("favorite").addClass("active");
//    });
//});

 $(document).ready(function () {

    //this will attach the class to every target 
    $(document).on('click', function (event) {
        $target = $(event.target);
        if($target.hasClass('favorite')){
            if($target.hasClass('active')){
                $target.removeClass('active');
            }else{
                $target.addClass('active');
            }
        }
    });
});
