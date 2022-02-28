<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<title>Home</title>
<link rel="icon"
	href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1"
	type="image/x-icon">
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:url var="url" value="/detail"></c:url>
	<c:set value="page" var="Home"></c:set>
	<jsp:include page="header.jsp"></jsp:include>

	<main style="display: flex; min-height: 100vh; flex-direction: column;">
		<section class="section">
			<div class="container mt-6">
				<div class="columns is-multiline is-3">
					<c:forEach var="item" items="${videos}">
						<div class="column is-6-mobile is-3-desktop">
							<div class="block">
								<a href="${url}/${item.videoId}">
									<figure class="block image">
										<img
											src="${empty item.poster ? 'https://previews.123rf.com/images/kaymosk/kaymosk1804/kaymosk180400006/100130939-error-404-p%C3%A1gina-no-encontrada-error-con-efecto-de-falla-en-la-pantalla-ilustraci%C3%B3n-vectorial-para-s.jpg':item.poster}"
											alt="">
									</figure>
									<h1 class="block title is-5">${item.title}</h1>
								</a>
							</div>
							<div class="buttons is-fullwidth">
								<a href="LikeVideo?videoId=${item.videoId}"
									class="button is-info"> <span class="icon"> <i
										class="far fa-thumbs-up"></i>
								</span> <span>LIKE</span>
								</a> <a href="ShareVideo?videoId=${item.videoId}" class="button">
									<span class="icon"> <i class="fas fa-share-alt"></i>
								</span> <span>SHARE</span>
								</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		<section class="section">
			<div class="container">
				<div class="buttons is-centered">
					<button class="button">
						<span class="icon"> <i class="fas fa-angle-double-left"></i>
						</span>
					</button>
					<button class="button">
						<span class="icon"> <i class="fas fa-chevron-left"></i>
						</span>
					</button>
					<button class="button">
						<span class="icon"> <i class="fas fa-chevron-right"></i>
						</span>
					</button>
					<button class="button">
						<span class="icon"> <i class="fas fa-angle-double-right"></i>
						</span>
					</button>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>