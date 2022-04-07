<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<script src="https://kit.fontawesome.com/e136359f35.js" crossorigin="anonymous"></script>
<title>User Management</title>
<link rel="icon" href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1" type="image/x-icon">
<script src="${pageContext.request.contextPath}/views/admin/js/script.js" defer></script>
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<c:url var="url" value="/user"></c:url>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="hero is-fullheight">
		<div class="columns is-centered mt-4">
			<div class="column is-6">
				<div class="box">
					<!-- tab header -->
					<div class="tabs is-boxed">
						<ul>
							<li class="is-active" data-target="user-edition"><a> <span class="icon is-small"><i
										class="fas fa-user-alt"></i></span> <span>USER EDITION</span>
							</a></li>
							<li data-target="user-list"><a> <span class="icon is-small"><i class="fas fa-list"></i></span> <span>USER
										LIST</span>
							</a></li>
						</ul>
					</div>

					<!-- tab content -->
					<div class="px-2" id="tab-content">
						<!-- user edition tab -->
						<div id="user-edition">
							<form action="${url}/index" method="post">
								<div class="field is-horizontal">
									<div class="field-body">
										<div class="field">
											<div class="control">
												<label for="" class="label">Username</label> <input type="text" class="input" value="${form.userId}"
													name="userId">
											</div>
										</div>
										<div class="field">
											<div class="control">
												<label for="" class="label">Password</label> <input type="password" class="input" value="${form.password}"
													name="password">
											</div>
										</div>
									</div>
								</div>
								<div class="field is-horizontal">
									<div class="field-body">
										<div class="field">
											<div class="control">
												<label for="" class="label">Email</label> <input type="email" class="input" value="${form.email}"
													name="email">
											</div>
										</div>
										<div class="field">
											<div class="control">
												<label for="" class="label">Fullname</label> <input type="text" class="input" value="${form.fullname}"
													name="fullname">
											</div>
										</div>
									</div>
								</div>
								<hr>
								<div class="field is-grouped is-grouped-right">
									<div class="control">
										<button formaction="${url}/update" class="button
											is-light" type="submit" name="update" >Update</button>
									</div>
									<div class="control">
										<button formaction="${url}/delete" class="button
											is-light" type="submit" name="delete" >Delete</button>
									</div>
								</div>
								<div class="field">
									<p>${message}</p>
								</div>
								<div class="field">
									<p>${error}</p>
								</div>
							</form>
						</div>

						<!-- user list tab -->
						<div id="user-list" class="is-hidden">
							<form action="" method="post">
								<table class="table is-bordered is-hoverable is-fullwidth">
									<thead>
										<th>Username</th>
										<th>Password</th>
										<th>Fullname</th>
										<th>Email</th>
										<th>Is Admin</th>
										<th></th>
									</thead>
									<tbody>
										<c:forEach var="user" items="${users}">
											<tr>
												<td>${user.userId}</td>
												<td>${user.password}</td>
												<td>${user.fullname}</td>
												<td>${user.email}</td>
												<td>${user.admin}</td>
												<td><a href="${url}/edit/${user.userId}">Edit</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="field is-grouped is-grouped-centered">
									<div class="control">
										<button class="button" type="button">
											<span class="icon"> <i class="fas fa-angle-double-left"></i>
											</span>
										</button>
									</div>
									<div class="control">
										<button class="button" type="button">
											<span class="icon"> <i class="fas fa-chevron-left"></i>
											</span>
										</button>
									</div>
									<div class="control">
										<button class="button" type="button">
											<span class="icon"> <i class="fas fa-chevron-right"></i>
											</span>
										</button>
									</div>
									<div class="control">
										<button class="button" type="button">
											<span class="icon"> <i class="fas fa-angle-double-right"></i>
											</span>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>