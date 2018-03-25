/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//setInterval(ajaxCallToPopulateTable, 3000); //300000 MS == 5 minutes
$(function(){
   ajaxCallToPopulateTableProducts();
});

function ajaxCallToPopulateTableProducts() {
    $.post("GetProductsToAdmin",{},ajaxCallBack_products,"json");
}

function ajaxCallBack_products(responseTxt,statusTxt,xhr){
    if(statusTxt=='success'){
        //alert(responseTxt.msg+" , "+responseTxt.username);
        if(responseTxt.yes == "yes"){
             window.location.replace("login.html");
        }else{
            var output = '<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">'+
              '<thead>'
                +'<tr>'
                  +'<th>Image</th>'
                  +'<th>Product</th>'
                  +'<th>Description</th>'
                  +'<th>Quanitity</th>'
                  +'<th>Price</th>'
                  +'<th>Category</th>'
                  +'<th>Manage</th>'
                +'</tr>'
              +'</thead>'
              +'<tfoot>'
                +'<tr>'
                  +'<th>Image</th>'
                  +'<th>Product</th>'
                  +'<th>Description</th>'
                  +'<th>Quanitity</th>'
                  +'<th>Price</th>'
                  +'<th>Category</th>'
          +'<th>Manage</th>'
                +'</tr>'
              +'</tfoot>'
              +'<tbody>';
      
        var tr='';
        
        for(var i in responseTxt){
            
            var res_id = responseTxt[i].id;
            var res_name = responseTxt[i].name;
            var res_description = responseTxt[i].description;
            var res_quanitity = responseTxt[i].quantity;
            var res_price = responseTxt[i].salary;
            var res_image = responseTxt[i].image;
            var res_category = responseTxt[i].category;
            var res_category_name;
            
            if(res_category == 1){
                res_category_name = 'Men';
            }else if(res_category == 2){
                res_category_name = 'Women';
            }else if(res_category == 3){
                res_category_name = 'Accessories';
            }else{
                res_category_name = '';
            }
            
            //var product = {res_id:res_id, res_name:res_name, res_description:res_description
            //, res_quanitity:res_quanitity, res_price:res_price, res_image:res_image, res_category:res_category};
            
            //var product = new Product(res_id,res_name,res_description,res_quanitity,res_price,res_image,res_category);
            
            tr += '<tr>';
                tr += '<td><img src="'+res_image+'" alt="'+res_name+'" width="100" height="120" id="img_'+res_id+'"></td>';
                tr += '<td id="name_'+res_id+'">'+res_name+'</td>';
                tr += '<td id="desc_'+res_id+'">'+res_description+'</td>';
                tr += '<td id="quantity_'+res_id+'">'+res_quanitity+'</td>';
                tr += '<td id="price_'+res_id+'">'+res_price+'</td>';
                tr += '<td id="category_'+res_id+'">'+res_category_name+'</td>';
                tr += '<td><a class="btn btn-primary" href="#" onclick="edit_product('+res_id+')">Edit</a>'
                +'&nbsp&nbsp<a class="btn btn-primary" href="#" onclick="delete_product('+res_id+')">Delete</a>'
                +'</td>';
            tr +='</tr>';
        }
            
        output += tr+'</tbody>'
                +'</table>';
        
        $("#products").html(output);
        }   
    }else
        alert("Error:"+xhr.status+":"+xhr.statusTxt);
}

function Product(res_id,res_name,res_description,res_quanitity,res_price,res_image,res_category){
    this.res_id = res_id;
    this.res_name = res_name;
    this.res_description = res_description;
    this.res_quanitity = res_quanitity;
    this.res_price = res_price;
    this.res_image = res_image;
    this.res_category = res_category;
}

function edit_product(product_id){
    var name = $('#name_'+product_id).text(); 
    var img = $('#img_'+product_id).attr('src');
    var desc = $('#desc_'+product_id).text(); 
    var quantity = $('#quantity_'+product_id).text();
    var price = $('#price_'+product_id).text();
    var category = $('#category_'+product_id).text();
    
    window.location.href = "edit_product.jsp?id="+product_id+"&name="+name+"&desc="+desc+"&quantity="+quantity+"&price="+price+"&category="+category+"&img="+img;
    //ajaxCallToEditProduct();
}

function ajaxCallToEditProduct() {
    //$.post("EditProduct",{},,"json");
}

function delete_product(product_id){
    var postObject = {"id":product_id };
    
    $.post("DeleteProduct" , postObject , function (data) {

        if(data==="1"){
            window.location.replace("manage_product.html");
        }else{
            
        }
    });
}

