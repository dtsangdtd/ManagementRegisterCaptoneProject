<%-- 
    Document   : modStudentList
    Created on : Jan 16, 2022, 12:56:11 PM
    Author     : mac
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Tables</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">
            <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'AD'}">
                <c:redirect url="login.jsp"></c:redirect>
            </c:if>

            <%@include file="modSidebar.jsp" %>     

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Student</h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-upload fa-sm text-white-50"></i> Import Excel</a>
                </div>

                <div class="card shadow mb-4">
                    <div class="card-body">
                        <div class="table-responsive">
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-9"></div>
                                    <div class="col-3">
                                        <div class="mb-3">
                                            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="search">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-bordered" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Name</th>
                                        <th>Major</th>
                                        <th>Phone</th>
                                        <th>GroupID</th>
                                        <th>Gmail</th>
                                        <th>Photo</th>
                                    </tr>
                                </thead>
                                <c:forEach var="stu" varStatus="counter" items="${LIST_STUDENT}">
                                <tbody>
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${stu.username}</td>
                                        <td>SE</td>
                                        <td>${stu.phone}</td>
                                        <td>${stu.groupID}</td>
                                        <td>${stu.gmail}</td>
                                        <td>${stu.photoUrl}</td>
                                    </tr>
                                </tbody>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>                   

                <div>
                    <a href="#" class="btn btn-light btn-icon-split">
                        <span class="icon text-gray-600">
                            <i class="fas fa-arrow-right"></i>
                        </span>
                        <span class="text">Randomize Student Group</span>
                    </a>
                </div>

                <div class="row stu-tab-gr">

                    <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-primary shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                            Group 1</div>
                                        <div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">Nguyen Hieu Kien</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">Nguyen Hong Mai</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">Nguyen Tho Thai Bao</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">Pham Khai</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">Duong Thanh Sang</div>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <a href="#" class="btn btn-success btn-circle">
                                            <i class="fas fa-check"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- /.container-fluid -->

        </div>

        <!-- End of Main Content -->

        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<%@include file="logout.jsp" %>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>

</body>

</html>
