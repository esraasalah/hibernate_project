<%-- 
    Document   : add_product
    Created on : Mar 2, 2018, 5:33:12 PM
    Author     : toshiba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/javascript_admin.js"></script>
        
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="admin.html">Admin Page</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="admin.html"><!--<a class="nav-link" href="tables.html">-->
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">View Users</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link" href="manage_product.html"><!--<a class="nav-link" href="tables.html">-->
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Manage Product</span>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Add Product</li>
      </ol>
	   <!-- Add your Code here -->
           <form action="AddProduct" method="post" enctype="multipart/form-data">
           <div class="form-group">
            <div class="form-row">
           <div class="col-md-6">
                <label for="productname">Product Name</label>
                <input class="form-control" id="productname" type="text" aria-describedby="nameHelp" name="productname" placeholder="Enter Product Name" required>
                <span id='productnametext'></span>
           </div><br>
           
           <div class="col-md-6">
                <label for="productimage">Product Image</label>
                <input class="form-control" id="productimage" type="file" accept="image/*" aria-describedby="nameHelp" name="productimage" placeholder="Choose Product Image" required>
                <span id='productimagetext'></span>
           </div><br>
           
           </div>
            </div>
           
           <div class="col-md-6">
                <label for="productdescription">Product description</label>
                <textarea rows="4" cols="50" maxlength="500" name="productdescription" required></textarea>
                <span id='productdessctext'></span>
           </div><br>
           
           <div class="form-group">
            <div class="form-row">
           <div class="col-md-6">
                <label for="productquan">Product Quantity</label>
                <input class="form-control" id="productquan" type="number" min="1" aria-describedby="nameHelp" name="productquan" placeholder="Enter Product Name" required>
                <span id='productdessctext'></span>
           </div><br>
           
           <div class="col-md-6">
                <label for="productprice">Product Price</label>
                <input class="form-control" id="productprice" type="number" min="1" aria-describedby="nameHelp" name="productprice" placeholder="Enter Product price" required>
                <span id='productdessctext'></span>
           </div><br>
            </div></div>
           <input type="submit" class="btn btn-primary active btn-lg pull-right" value="Add" id="register"  >
    </form>
     
<!--     <input type="file" name="pic" accept="image/*">
     
     <textarea rows="4" cols="50" maxlength="500"></textarea>-->
    </div>
        
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="Logout">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>
  </div>
</body>

</html>

