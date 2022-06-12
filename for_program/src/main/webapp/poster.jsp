<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/5547fa07a6.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.contour {
	border-right: 2px solid rgb(209, 209, 209);
	height: 100%;
	width: 100%;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="category.jsp" />

	<!-- poster-top -->
	<div class="col-md-9 mt-5">
		<nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">temp1</a></li>
				<li class="breadcrumb-item" aria-current="page">temp2</li>
			</ol>
		</nav>
		<div class="container">
			<div class="row">
				<div class="col-xl-5">
					<img src="resources/images/thumnail.png" class="img-fluid"
						alt="...">
				</div>
				<div class="col-xl-1">
					<div class="contour"></div>
				</div>
				<div class="col-xl-6">
					<label class="fs-4 mx-4">Kakao</label><br> <label
						class="fs-3 mx-4 fw-bold">맞춤형 광고 알고리즘 설계 가능합니다</label><br> <label
						class="mx-4">Java</label> <label class="">Mysql</label>
					<div class="mx-4">
						<span class="text-warning"> <i class="fa-solid fa-star"></i>
						</span> <span class="fw-bold">4.5</span>
					</div>
					<div class="justify-content-end">
						<div class="text-end">
							<span class="fw-bold mx-4 fs-3">100,000원</span>
						</div>
						<div class="text-center">
							<input type="button" class="btn btn-warning w-75 mx-4"
								value="구매하기">
						</div>
					</div>
				</div>
				<ul class="nav nav-pills nav-fill bg-light my-5 py-2">
					<li class="nav-item"><a class="nav-link text-black" href="#">서비스
							설명</a></li>
					<li class="nav-item"><a class="nav-link text-black" href="#">기술
							소개</a></li>
					<li class="nav-item"><a class="nav-link text-black" href="#">개발자
							소개</a></li>
					<li class="nav-item"><a class="nav-link text-black" href="#">리뷰
							121</a></li>
				</ul>
			</div>
		</div>
		<!-- poster-top end -->

		<!-- poster-main -->
		<div class="container m-1">
			<div class="row">
				<div class="col bg-primary">

					<div class="txc-textbox"
						style="border: 3px double rgb(203, 203, 203); padding: 10px; background-color: rgb(255, 255, 255); line-height: 1.8;">
						<p>
							<span style="font-size: 9pt; line-height: 1.5;"><b><span
									style="font-size: 14pt; color: rgb(152, 0, 0);">◆
										include 액션 사용 방법</span></b></span>
						</p>
						<p>
							<span style="font-size: 9pt; line-height: 1.5;"><br></span>
						</p>
						<p>
							<b><span style="font-size: 12pt;">&lt;jsp:include
									page="/WEB-INF/views/include/header.jsp"/&gt;</span></b>
						</p>
						<p>
							<b><span style="font-size: 12pt;">--- 현재 파일 ---</span></b>
						</p>
						<p></p>
						<p>
							<b><span style="font-size: 12pt;">&lt;jsp:include
									page="/WEB-INF/views/include/footer.jsp"/&gt;</span></b>
						</p>
					</div>
					<p style="line-height: 1.8;">
						<br>
					</p>
					<div class="txc-textbox"
						style="border: 3px double rgb(203, 203, 203); padding: 10px; background-color: rgb(255, 255, 255); line-height: 1.8;">
						<p>
							<b><span
								style="font-size: 14pt; line-height: 1.5; color: rgb(152, 0, 0);">◆
									include&nbsp;</span><span
								style="font-size: 14pt; color: rgb(152, 0, 0);">액션 일부 사용
									방법</span></b>
						</p>
						<p>
							<br>
						</p>
						<p>
							<b><span style="font-size: 12pt;">&lt;jsp:include
									page="/WEB-INF/views/include/footer.jsp"&gt;</span></b>
						</p>
						<p style="margin-left: 2em;">
							<b><span style="font-size: 12pt;">&lt;jsp:param
									name="email" value="sesok808@naver.com" /&gt;</span></b>
						</p>
						<p style="margin-left: 2em;">
							<b><span style="font-size: 12pt;">&lt;jsp:param
									name="tel" value="010-1234-5678" /&gt;</span></b>
						</p>
						<p>
							<b><span style="font-size: 12pt;">&lt;/jsp:include&gt;</span></b>
						</p>
					</div>
					<p style="line-height: 1.8;">
						<br>
					</p>
					<p style="line-height: 1.8;"></p>
					<div class="txc-textbox"
						style="border-style: dashed; border-width: 1px; border-color: rgb(193, 193, 193); background-color: rgb(238, 238, 238); padding: 10px; line-height: 1.8;">
						<p>
							<b><span style="color: rgb(255, 0, 0); font-size: 14pt;">관련글
									더 보기</span></b>
						</p>
						<p>
							<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
								href="http://sesok808.tistory.com/401" target="_blank"><span
								style="font-size: 11pt; color: rgb(0, 0, 0);">2016/05/13
									- [JSP] 전화번호(휴대폰번호) 유효성 검사 방법 !</span></a>
						</p>
						<p>
							<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
								href="http://sesok808.tistory.com/400" target="_blank"><span
								style="font-size: 11pt; color: rgb(0, 0, 0);">2016/05/13
									- [JSP] 비밀번호(패스워드) 유효성 검사 방법은?</span></a>
						</p>
						<p>
							<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
								href="http://sesok808.tistory.com/360" target="_blank"><span
								style="font-size: 11pt; color: rgb(0, 0, 0);">2015/07/09
									- [JSP] taglib 디렉티브 사용법</span></a>
						</p>
						<p>
							<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
								href="http://sesok808.tistory.com/329" target="_blank"><span
								style="font-size: 11pt; color: rgb(0, 0, 0);">2015/07/02
									- [JSP] 에러 페이지 처리방법 (web.xml)</span></a>
						</p>
						<p>
							<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
								href="http://sesok808.tistory.com/328" target="_blank"><span
								style="font-size: 11pt; color: rgb(0, 0, 0);">2015/07/02
									- [JSP] HTTP 에러코드 정리 모음</span></a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>

	<footer>footer</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>