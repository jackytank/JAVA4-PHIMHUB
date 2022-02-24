<%@ page
        pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">

<head>
    <title> ${page.title }</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <base href="//"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>

<body>
<main class="container-fluid">
    <nav class="row">
        <nav class="navbar navbar-expand-sm navbar-light bg-light col">
            <a class="navbar-brand" href="Admin/VideosManagement"
               style="color: mediumturquoise; font-weight: bold;font-family: cursive;">Administration</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                    data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <!-- <li class="nav-item active">
                        <a class="nav-link" href="Admin/VideosManagement">Home <span class="sr-only">(current)</span></a>
                    </li> -->
                    <li class="nav-item">
                        <a class="nav-link" href="Admin/VideosManagement">
                            <i class="fa fa-info" aria-hidden="true"></i> Video
                        </a>
                    </li>

                    <div class="nav-item">
                        <a href="UsersManagementServlet" class="nav-link">
                            <i class="fa fa-id-card" aria-hidden="true"></i> Users
                        </a>
                    </div>
                    <div class="nav-item">
                        <a href="ReportManagementServlet" class="nav-link">
                            <i class="fa fa-comments" aria-hidden="true"></i> Reports
                        </a>
                    </div>
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" href="#" id="dropdownId"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
                            class="fa fa-user" aria-hidden="true"></i> My Account</a>
                        <div class="dropdown-menu" aria-labelledby="dropdownId">
                            <c:if test="${! isLogin }">
                                <a class="dropdown-item text-success" href="LoginServlet">Login</a> <a
                                    class="dropdown-item" href="ForgotPasswordServlet">Forgot Password</a> <a
                                    class="dropdown-item" href="Registration">Registration</a>
                            </c:if>
                            <c:if test="${isLogin }">
                                <a class="dropdown-item text-danger" href="LogoffServlet">Log Out</a>
                                <a class="dropdown-item" href="ChangepasswordServlet">Change Password</a>
                                <a class="dropdown-item" href="EditprofileServlet">Edit Profile</a>
                            </c:if>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </nav>
    <section class="row">
        <jsp:include page="${page.contentUrl }"></jsp:include>
    </section>

    <footer class="row"></footer>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<c:if test="${not empty page.scriptUrl }">
    <jsp:include page="${page.scripUrl }"></jsp:include>
</c:if>
<script>
    $('#myTab a').on('click', function (event) {
        event.preventDefault()
        $(this).tab('show')
    })
</script>

</body>

</html>