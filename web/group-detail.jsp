<%-- 
    Document   : group-detail
    Created on : Jan 17, 2022, 2:53:22 PM
    Author     : dtsang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group detail</title>
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <%@include file="bootstrap.jsp" %>
    </head>
    <body id="page-top">
    <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'MT'}">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
    <!-- Page Wrapper -->       
    <div id="wrapper">
        <%@include file="supSidebar.jsp" %>
        <!-- Begin Page Content -->
        <div class="container-fluid" style="height: 80vh">

            <!-- Page Heading -->
            <h1>Group Details</h1>
            <div class="card shadow mb-4">
                <h3 style="text-align: center" class="mt-5">Nhom vip pro 123</h3>
                <div class="card-body ">
                    <div class="col-12">
                        <div class="row" style="display: flex; align-items: center" >
                            <div class="col-3">
                                <div class="card shadow p-3 mb-5 bg-body rounded " >
                                    <img style="width: 250px; height: 250px ; border-radius: 50%; margin: 0 auto" src="./img/avatar.jpg" class="card-img-top" alt="..." >
                                    <div class="card-body">
                                        <h5 class="card-title">Mai hoc gioi</h5>
                                        <h6>Phone: </h6>
                                        <h6>Email: </h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="card shadow p-3 mb-5 bg-body rounded" >
                                    <img style="width: 250px; height: 250px ; border-radius: 50%; margin: 0 auto" src="./img/avatar.jpg" class="card-img-top" alt="..." >
                                    <div class="card-body">
                                        <h5 class="card-title">Mai Nha Giau</h5>
                                        <h6>Phone: </h6>
                                        <h6>Email: </h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="card shadow p-3 mb-5 bg-body rounded" >
                                    <img style="width: 250px; height: 250px ; border-radius: 50%; margin: 0 auto" src="./img/avatar.jpg" class="card-img-top" alt="..." >
                                    <div class="card-body">
                                        <h5 class="card-title">Mai De Thuong</h5>
                                        <h6>Phone: </h6>
                                        <h6>Email: </h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="card shadow p-3 mb-5 bg-body rounded" >
                                    <img style="width: 250px; height: 250px ; border-radius: 50%; margin: 0 auto" src="./img/avatar.jpg" class="card-img-top" alt="..." >
                                    <div class="card-body">
                                        <h5 class="card-title">Mai Xinh Gai</h5>
                                        <h6>Phone: </h6>
                                        <h6>Email: </h6>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div>
                            <h5 style="text-align: center">
                                Capstone Name
                            </h5>
                            <div style="text-align: center">
                                Tourism Smart Card
                            </div>
                        </div>
                        
                    </div>
                </div>

            </div>


        </div>

        <!-- End of Main Content -->

        <%@include file ="footer.jsp" %>

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<%@include file ="logout.jsp" %>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/chart-area-demo.js"></script>
<script src="js/demo/chart-pie-demo.js"></script>

</body>
</html>
