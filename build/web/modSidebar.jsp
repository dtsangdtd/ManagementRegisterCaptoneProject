<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">  
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="moderator.jsp">
<!--        <div class="sidebar-brand-text mx-3">Moderator</div>-->
    <img src="img/2021-FPTU-Eng.png" width="120px"/>
    </a>
    <hr class="sidebar-divider my-0">
    <li class="nav-item active">
        <a class="nav-link" href="moderator.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>
    <hr class="sidebar-divider">

    <li class="nav-item ">
        <a class="nav-link" href="modStudentList.jsp">
            <i class="fas fa-fw fa-folder"></i>
            <span>Students</span>
        </a>
    </li>

    <li class="nav-item ">
        <a class="nav-link" href="modGroup.jsp">
            <i class="fas fa-fw fa-folder"></i>
            <span>Student Groups</span>
        </a>
    </li>

    <li class="nav-item ">
        <a class="nav-link" href="modTopic.jsp">
            <i class="fas fa-fw fa-folder"></i>
            <span>Capstone Topics</span>
        </a>
    </li>

    <li class="nav-item ">
        <a class="nav-link" href="modSupList.jsp">
            <i class="fas fa-fw fa-folder"></i>
            <span>Supervisors</span>
        </a>
    </li>

    <li class="nav-item ">
        <a class="nav-link" href="modRequest.jsp">
            <i class="fas fa-fw fa-folder"></i>
            <span>Request</span>
        </a>
    </li>


    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
<!-- End of Sidebar -->

<!-- Content Wrapper -->
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
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
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
