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
        <%@include file="bootstrap.jsp" %>
    </head>

    <body id="page-top">
        <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <!-- Page Wrapper -->
        <div id="wrapper">
            

            <%@include file="modSidebar.jsp" %>  
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.LOGIN_USER.username} (${sessionScope.LOGIN_USER.userID})</span>
                                    <img class="img-profile rounded-circle"
                                         src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Supervisor</h1>
                            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                    class="fas fa-upload fa-sm text-white-50"></i> Import Excel</a>
                        </div>

                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <div class="col-12">
                                        <div class="row">
                                            <div class="col-9">
                                                <div class="dropdown">
                                                    <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
                                                        Semester
                                                    </button>
                                                    <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="dropdownMenuButton2">
                                                        <li><a class="dropdown-item active" href="#">Fall 2021</a></li>
                                                        <li><a class="dropdown-item" href="#">Spring 2021</a></li>
                                                        <li><a class="dropdown-item" href="#">Spring 2021</a></li>
                                                        <li><a class="dropdown-item" href="#">Spring 2021</a></li>

                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-3">
                                                <div class="mb-3">
                                                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="search">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <table class="table table-sm" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>Name</th>
                                                <th>Major</th>
                                                <th>Phone</th>
                                                <th style="width: 160px">Groups 
                                                    <div class="dropdown">
                                                        <i class="fas fa-filter "></i>
                                                        <div class="dropdown-content">
                                                            <input type="checkbox" id="scales" name="full"
                                                                   checked>
                                                            <label for="full">full</label>
                                                            <input type="checkbox" id="scales" name="notFull"
                                                                   checked>
                                                            <label for="notFull">not full</label>
                                                        </div>
                                                    </div>
                                                </th>
                                                <th>Gmail</th>
                                                <th>photoUrl</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="sup" varStatus="counter" items="${LIST_SUPERVISOR}">
                                            <tbody>
                                                <tr>
                                                    <td>${counter.count}</td>
                                                    <td>${sup.username}</td>
                                                    <td>SE</td>
                                                    <td>${sup.phone}</td>
                                                    <td>${sup.groupID}</td>
                                                    <td>${sup.gmail}</td>
                                                    <td>${sup.photoUrl}</td>
                                                </tr>
                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <table class="table-sm" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Name</th>
                                        <th>Major</th>
                                        <th>Phone</th>
                                        <th style="width: 160px">Groups 
                                            <div class="dropdown">
                                                <i class="fas fa-filter "></i>
                                                <div class="dropdown-content">
                                                    <input type="checkbox" id="scales" name="full"
                                                           checked>
                                                    <label for="full">full</label>
                                                    <input type="checkbox" id="scales" name="notFull"
                                                           checked>
                                                    <label for="notFull">not full</label>
                                                </div>
                                            </div>
                                        </th>
                                        <th>Gmail</th>
                                        <th>photoUrl</th>
                                    </tr>
                                </thead>
                                <c:forEach var="sup" varStatus="counter" items="${LIST_SUPERVISOR}">
                                    <tbody>
                                        <tr>
                                            <td>${counter.count}</td>
                                            <td>${sup.username}</td>
                                            <td>SE</td>
                                            <td>${sup.phone}</td>
                                            <td>${sup.groupID}</td>
                                            <td>${sup.gmail}</td>
                                            <td>${sup.photoUrl}</td>
                                        </tr>
                                    </tbody>
                                </c:forEach>
                            </table>

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
        <style>
            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding: 12px 16px;
                z-index: 1;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }
        </style>
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
