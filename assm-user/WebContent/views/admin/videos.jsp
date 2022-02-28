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
<title>Video Management</title>
<link rel="icon"
	href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1"
	type="image/x-icon">
<script
	src="${pageContext.request.contextPath}/views/admin/js/script.js" defer></script>
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<c:url var="url" value="/video"></c:url>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="hero is-fullheight">
		<div class="columns is-centered mt-4">
			<div class="column is-6">
				<div class="box">
					<!-- tab header -->
					<div class="tabs is-boxed">
						<ul>
							<li class="is-active" data-target="video-edition"><a> <span
									class="icon is-small"><i class="fas fa-photo-video"></i></span>
									<span>VIDEO EDITION</span>
							</a></li>
							<li data-target="video-list"><a> <span
									class="icon is-small"><i class="fas fa-list"></i></span> <span>VIDEO
										LIST</span>
							</a></li>
						</ul>
					</div>

					<!-- tab content -->
					<div class="px-2" id="tab-content">
						<!-- video edition tab -->
						<div id="video-edition">
							<form action="${url}/index" method="post">
								<div class="columns">
									<div
										class="column mt-5 is-5 is-flex is-align-items-center is-flex-direction-column">
										<figure class="image">
											<img
												src="${empty form.poster ? 'https://previews.123rf.com/images/kaymosk/kaymosk1804/kaymosk180400006/100130939-error-404-p%C3%A1gina-no-encontrada-error-con-efecto-de-falla-en-la-pantalla-ilustraci%C3%B3n-vectorial-para-s.jpg':form.poster}"
												alt="" width="256" height="256" name="poster">
										</figure>
									</div>
									<div class="column">
										<div class="field">
											<label class="label">Video ID</label>
											<div class="control">
												<input class="input" type="text" value="${form.videoId}"
													name="videoId">
											</div>
										</div>
										<div class="field">
											<label class="label">Video Title</label>
											<div class="control">
												<input class="input" type="text" value="${form.title}"
													name="title">
											</div>
										</div>
										<div class="field">
											<label class="label">View Count</label>
											<div class="control">
												<input class="input" type="number" value="${form.views}"
													name="views">
											</div>
										</div>
										<div class="field">
											<div class="control">
												<label class="radio"> <input type="radio"
													name="active" ${form.active?"checked":""}> Active
												</label> <label class="radio"> <input type="radio"
													name="active" ${!form.active?"checked":""}>
													In-active
												</label>
											</div>
										</div>
									</div>
								</div>
								<div class="field">
									<label class="label">Description</label>
									<div class="control">
										<textarea class="textarea" name="description">${form.description}</textarea>
									</div>
								</div>
								<hr>
								<div class="field is-grouped is-grouped-right">
									<div class="control">
										<button formaction="${url}/create" class="button is-light">Create</button>
									</div>
									<div class="control">
										<button formaction="${url}/update" class="button is-light">Update</button>
									</div>
									<div class="control">
										<button formaction="${url}/delete" class="button is-light ">Delete</button>
									</div>
									<div class="control">
										<button formaction="${url}/reset" class="button is-light ">Reset</button>
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

						<!-- video list tab -->
						<div id="video-list" class="is-hidden">
							<form action="" method="post">
								<table class="table is-bordered is-hoverable is-fullwidth">
									<thead>
										<th>Youtube ID</th>
										<th>Video Title</th>
										<th>View Count</th>
										<th>Status</th>
										<th></th>
									</thead>
									<tbody>
										<c:forEach var="video" items="${videos}">
											<tr>
												<td>${video.videoId}</td>
												<td>${video.title}</td>
												<td>${video.views}</td>
												<td>${video.active? 'Active':'Deactive'}</td>
												<td><a href="${url}/edit/${video.videoId}">Edit</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="field is-grouped is-grouped-centered">
									<div class="control">
										<button class="button" type="button">
											<span class="icon"> <i
												class="fas fa-angle-double-left"></i>
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
											<span class="icon"> <i
												class="fas fa-angle-double-right"></i>
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