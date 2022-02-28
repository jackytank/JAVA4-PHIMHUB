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
<title>Report</title>
<link rel="icon"
	href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1"
	type="image/x-icon">
<script
	src="${pageContext.request.contextPath}/views/admin/js/script.js" defer></script>
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="header.jsp"></jsp:include>

	<section class="hero is-fullheight">
		<div class="columns is-centered mt-4">
			<div class="column is-6">
				<div class="box">
					<!-- tab header -->
					<div class="tabs is-boxed">
						<ul>
							<li class="is-active" data-target="favorite"><a> <span
									class="icon is-small"><i class="fas fa-photo-video"></i></span>
									<span>Favorite</span>
							</a></li>
							<li data-target="favorite-user"><a> <span
									class="icon is-small"><i class="fas fa-list"></i></span> <span>Favorite
										Users</span>
							</a></li>
							<li data-target="shared-friend"><a> <span
									class="icon is-small"><i class="fas fa-list"></i></span> <span>Shared
										Friends</span>
							</a></li>
						</ul>
					</div>

					<!-- tab content -->
					<div class="px-2" id="tab-content">
						<!-- favorite tab -->
						<div id="favorite">
							<table class="table is-bordered is-hoverable is-fullwidth">
								<thead>
									<tr>
										<th>Video Title</th>
										<th>Favorite Count</th>
										<th>Latest Date</th>
										<th>Oldest Date</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${favList}">
										<tr>
											<td>${item.videoTitle}</td>
											<td>${item.favoriteCount}</td>
											<td>${item.newestDate}</td>
											<td>${item.oldestDate}</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>

						<!-- favorite user tab -->
						<div id="favorite-user" class="is-hidden">
							<form action="Report" method="post">
								<div class="field is-horizontal">
									<div class="field-label is-normal">
										<label class="label">Video Title</label>
									</div>
									<div class="field-body">
										<div class="field">
											<div class="control">
												<div class="select is-fullwidth">
													<select name="videoUserId">
														<c:forEach var="item" items="${videoList}">
															<option value="${item.videoId}"
																${item.videoId == videoUserId? "selected":""}>
																${item.title}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="field">
									<table class="table is-bordered is-hoverable is-fullwidth">
										<thead>
											<tr>
												<th>Username</th>
												<th>Fullname</th>
												<th>Email</th>
												<th>Favorite Date</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${favUserList}">
												<tr>
													<td>${item.userId}</td>
													<td>${item.fullname}</td>
													<td>${item.email}</td>
													<td>${item.likeDate}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</form>
						</div>

						<!-- shared friend tab -->
						<div id="shared-friend" class="is-hidden">
							<form action="Report" method="post">
								<div class="field is-horizontal">
									<div class="field-label is-normal">
										<label class="label">Video Title</label>
									</div>
									<div class="field-body">
										<div class="field">
											<div class="control">
												<div class="select is-fullwidth">
													<select name="videoShareId">
														<c:forEach var="item" items="${videoShareList}">
															<option value="${item.videoId}"
																${item.videoId == videoShareId? "selected":""}>
																${item.title}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="field">
									<table class="table is-bordered is-hoverable is-fullwidth">
										<thead>
											<tr>
												<th>Sender Name</th>
												<th>Sender Email</th>
												<th>Receiver Email</th>
												<th>Sent Date</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="c" items="${shareReportsList}">
												<tr>
													<td>${c.userId}</td>
													<td>${c.senderEmail}</td>
													<td>${c.receiveEmail}</td>
													<td>${c.sendDate}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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