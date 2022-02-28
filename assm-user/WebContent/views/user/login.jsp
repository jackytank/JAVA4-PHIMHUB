<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<script src="https://kit.fontawesome.com/e136359f35.js"
	crossorigin="anonymous"></script>
<title>Login</title>
<link rel="icon"
	href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1"
	type="image/x-icon">
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="header.jsp"></jsp:include>
	
	<main style="display: flex; min-height: 100vh;">
		<div class="container">
			<div class="columns is-centered mt-6">
				<div class="column is-4">
					<h1 class="block title has-text-centered">LOGIN</h1>
					<form action="Login" method="post" class="box" id="form-login">
						<div class="field">
							<p class="sub-title is-success">${message}</p>
						</div>
						<div class="field">
							<p class="sub-title is-dangerous">${error}</p>
						</div>
						<div class="field">
							<label for="" class="label">Username</label>
							<div class="control has-icons-left">
								<input type="text" class="input" name="userId"> <span
									class="icon is-small is-left"> <i class="fas fa-user"></i>
								</span>
							</div>
						</div>
						<div class="field">
							<label for="" class="label">Password</label>
							<div class="control has-icons-left">
								<input type="password" class="input" name="password"> <span
									class="icon is-small is-left"> <i class="fas fa-lock"></i>
								</span>
							</div>
						</div>
						<div class="field is-horizontal">
							<div class="control">
								<label class="checkbox"> <input type="checkbox"
									name="remember"> Remember me
								</label>
							</div>
						</div>
						<hr>
						<div class="field">
							<div class="control">
								<button class="button is-fullwidth is-primary" type="submit">Login</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>