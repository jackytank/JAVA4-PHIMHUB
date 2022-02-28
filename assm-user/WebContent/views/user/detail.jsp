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
<title>${empty video.title ? 'Detail':video.title}</title>
<link rel="icon"
	href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1"
	type="image/x-icon">
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="header.jsp"></jsp:include>
	<c:url var="url" value="/detail"></c:url>

	<main>
		<div class="hero is-fullheight">
			<section class="section mt-5">
				<div class="columns is-centered">
					<div class="column is-four-fifths">
						<form action="" method="post">
							<div class="field">
								<figure>
									<iframe style="width: 100%;" height="550"
										src="${video.videoId}" title="YouTube video player"
										frameborder="0"
										allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
										allowfullscreen></iframe>
								</figure>
							</div>
							<div class="field">
								<h4 class="title is-5">${video.title}</h4>
							</div>
							<div class="field">
								<div class="columns">
									<div class="column">
										<div class="block">
											<p>Views: ${video.views}</p>
										</div>
									</div>
									<div class="column">
										<div class="field is-grouped is-grouped-right">
											<div class="buttons is-fullwidth">
												<a href="LikeVideo?videoId=${item.videoId}"
													class="button is-info"> <span class="icon"> <i
														class="far fa-thumbs-up"></i>
												</span> <span>LIKE</span>
												</a> <a href="ShareVideo?videoId=${video.videoId}"
													class="button"> <span class="icon"> <i
														class="fas fa-share-alt"></i>
												</span> <span>SHARE</span>
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<hr>
							<div class="field">
								<h5 class="sub-title">${video.description}</h5>
							</div>
						</form>
					</div>
					<div class="column is-2">
						<c:forEach var="item" items="${videos}">
							<div class="block is-flex is-flex-direction-row">
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
						</c:forEach>
					</div>
				</div>
			</section>
		</div>
	</main>

	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>