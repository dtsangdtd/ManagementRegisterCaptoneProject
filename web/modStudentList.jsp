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

        <title>Moderator Student List</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
        <!-- Custom styles for this template -->
        <!-- Custom styles for this page -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

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
                        <form
                            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                       aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                        <ul class="navbar-nav ml-auto">
                            <%@include file="noti.jsp" %>
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
                            <h1 class="h3 mb-0 text-gray-800">Student</h1>
                            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                    class="fas fa-upload fa-sm text-white-50"></i> Import Excel</a>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <div class="card shadow mb-4">
                                    <div class="card-body">
                                        <div class="table-responsive" >
                                            <div class="col-12">
                                                <div class="row">
                                                    <div class="col-9">
                                                        <div class="dropdown mb-4">
                                                            <button class="btn btn-info dropdown-toggle" type="button"
                                                                    id="dropdownMenuButton1" data-toggle="dropdown" aria-haspopup="true"
                                                                    aria-expanded="false">
                                                                Semester
                                                            </button>
                                                            <div class="dropdown-menu animated--fade-in"
                                                                 aria-labelledby="dropdownMenuButton1">
                                                                <a class="dropdown-item" href="#">Fall 2021</a>
                                                                <a class="dropdown-item" href="#">Spring 2021</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <table class="table-sm" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>No</th>
                                                        <th>Name</th>
                                                        <th>Phone</th>

                                                        <th>Gmail</th>
                                                        <th style="width: 160px">Status
                                                            <div class="dropdown">
                                                                <i class="fas fa-filter "></i>
                                                                <div class="dropdown-content">
                                                                    <input type="checkbox" id="scales" name="full"
                                                                           checked>
                                                                    <label for="full">full</label>
                                                                    <input type="checkbox" id="scales" name="Not Full"
                                                                           checked>
                                                                    <label for="notFull">not full</label>
                                                                </div>
                                                            </div>
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <c:forEach var="stu" varStatus="counter" items="${LIST_STUDENT}">
                                                    <tbody>
                                                        <tr>
                                                            <td>${counter.count}</td>
                                                            <td>${stu.username}</td>
                                                            <td>${stu.phone}</td>
                                                            <td>
                                                                <a href="" class="copy-click"
                                                                   data-tooltip-text="Click To Copy" 
                                                                   data-tooltip-text-copied="✔ Copied">
                                                                    ${stu.gmail}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </c:forEach>
                                            </table>

                                        </div>  
                                    </div>
                                </div>
                            </div>
                            <div class="col-2"> 
                                <a href="#" class="btn btn-info btn-icon-split">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-sync-alt"></i>
                                    </span>
                                    <span class="text">Random</span>
                                </a>
                                <div class="mt-2"></div>
                                <a href="#" class="btn btn-info btn-icon-split">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-bell"></i>
                                    </span>
                                    <span class="text">Noti</span>
                                </a>
                                 <div class="mt-2"></div>
                                <a href="#" class="btn btn-success btn-icon-split">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-check"></i>
                                    </span>
                                    <span class="text">Accept</span>
                                </a>

                            </div>
                            <div class="col-4">
                                <div class="stu-tab-gr">
                                    <!-- Earnings (Monthly) Card Example -->
                                    <div class="">
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
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                    </div>
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
            .copy-click {
                position: relative;
                padding-bottom: 2px;
                text-decoration: none;
                cursor: copy;
                color: #484848;
                /*                border-bottom: 1px dashed #767676;*/
                transition: background-color calc(var(--duration) * 2) var(--ease);
            }

            .copy-click:after {
                content: attr(data-tooltip-text);
                position: absolute;
                bottom: calc(100% + 6px);
                left: 50%;
                padding: 8px 16px;
                white-space: nowrap;
                background-color: white;
                border-radius: 4px;
                box-shadow: 0 0 0 -12px rgba(0, 0, 0, 0);
                pointer-events: none;
                -webkit-backface-visibility: hidden;
                backface-visibility: hidden;
                opacity: 0;
                -webkit-transform: translate(-50%, 12px);
                transform: translate(-50%, 12px);
                transition: box-shadow calc(var(--duration) / 1.5) var(--bounce), opacity calc(var(--duration) / 1.5) var(--bounce), -webkit-transform calc(var(--duration) / 1.5) var(--bounce);
                transition: box-shadow calc(var(--duration) / 1.5) var(--bounce), opacity calc(var(--duration) / 1.5) var(--bounce), transform calc(var(--duration) / 1.5) var(--bounce);
                transition: box-shadow calc(var(--duration) / 1.5) var(--bounce), opacity calc(var(--duration) / 1.5) var(--bounce), transform calc(var(--duration) / 1.5) var(--bounce), -webkit-transform calc(var(--duration) / 1.5) var(--bounce);
            }

            .copy-click.is-hovered:after {
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                opacity: 1;
                -webkit-transform: translate(-50%, 0);
                transform: translate(-50%, 0);
                transition-timing-function: var(--ease);
            }

            /*            .copy-click.is-copied {
                            background-color: yellow;
                        }*/

            .copy-click.is-copied:after {
                content: attr(data-tooltip-text-copied);
            }
        </style>
        <script>
            const links = document.querySelectorAll('.copy-click');
            const cls = {
                copied: 'is-copied',
                hover: 'is-hovered'};


            const copyToClipboard = str => {
                const el = document.createElement('input');
                str.dataset.copyString ? el.value = str.dataset.copyString : el.value = str.text;
                el.setAttribute('readonly', '');
                el.style.position = 'absolute';
                el.style.opacity = 0;
                document.body.appendChild(el);
                el.select();
                document.execCommand('copy');
                document.body.removeChild(el);
            };

            const clickInteraction = e => {
                e.preventDefault();
                copyToClipboard(e.target);
                e.target.classList.add(cls.copied);
                setTimeout(() => e.target.classList.remove(cls.copied), 1000);
                setTimeout(() => e.target.classList.remove(cls.hover), 700);
            };

            Array.from(links).forEach(link => {
                link.addEventListener('click', e => clickInteraction(e));
                link.addEventListener('keypress', e => {
                    if (e.keyCode === 13)
                        clickInteraction(e);
                });
                link.addEventListener('mouseover', e => e.target.classList.add(cls.hover));
                link.addEventListener('mouseleave', e => {
                    if (!e.target.classList.contains(cls.copied)) {
                        e.target.classList.remove(cls.hover);
                    }
                });
            });
        </script>
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
