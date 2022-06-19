<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.fpp.dao.*"%>
<%@ page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<script src="https://kit.fontawesome.com/5547fa07a6.js"
	crossorigin="anonymous"></script>

<script>

	function toggleText(){

		var form = document.getElementById("reviewForm");
		var btn = document.getElementById("createReviewBtn");

		if(form.className === "d-block"){
			form.className = "d-none"
			btn.style.display = 'block';
		}
		else{
			form.className = "d-block"
			btn.style.display = 'none';
		}
	}
	
	function addreview() {
		var form = document.getElementById("reviewForm");
		if (confirm("리뷰 등록 하시겠습니까?")) {

			form.submit();
			alert("등록이 완료되었습니다.");
		}
	}
	
	function fillStart(){
		var star = document.getEmele
	}
</script>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./resources/css/root.css" rel="stylesheet">

</head>
<body>

	<!-- 헤더와 카테고리 추가-->
	<jsp:include page="header.jsp" />
	<jsp:include page="category.jsp" />

	<%
	String id;
	try {
		id = (String) pageContext.getSession().getAttribute("id");
	} catch (Exception e) {
		id = null;
	}
	%>

	<%@ include file="dbconn.jsp"%>
	<%
	float score = 0;
	float cnt = 0;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	//--------------------받은 페이지넘버 저장---------------------------
	String num_ = request.getParameter("id");
	int num = 1;
	if (num_ != null && !num_.equals(""))
		num = Integer.parseInt(num_);

	//----------------------------------별점평균 쿼리-----------------------------------------------------
	String sql3 = "SELECT sum(rScore) as sum , count(rScore) as cnt FROM reviewtbl where rPosterID = ? ";
	pstmt = conn.prepareStatement(sql3);
	pstmt.setInt(1, num);
	rs = pstmt.executeQuery();
	while (rs.next()) {
		cnt = rs.getFloat("cnt");
		if (cnt != 0) {
			score = rs.getFloat("sum") / cnt;
		}

	}
	String score_ = String.format("%.2f", score);
	//---------------------------------포스터에 해당하는 멤버, 포스터정보 쿼리-------------------------------------------------
	String sql = "SELECT * FROM posttbl as P " + "inner join membertbl as M " + "on P.pWriter = M.mID "
			+ "inner join skilltbl as S on S.sMemberID = M.mID where pid=?;";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, num);
	rs = pstmt.executeQuery();
	while (rs.next()) {
	%>

	<!-- poster-top -->
	<div class="col-md-9 mt-5">

		<nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="posters.jsp">전체리스트</a></li>
				<li class="breadcrumb-item active" aria-current="page"><%=rs.getString("pCategory")%></li>
			</ol>
		</nav>

		<div class="container ">
			<div class="row">
				<div class="col-xl-5">
					<!-- 이미지 제목필요 -->
					<img src="resources/images/thumnail.png" class="img-fluid w-100%"
						alt="...">
				</div>
				<div class="col-xl-1">
					<div class="contour"></div>
				</div>



				<div class="col-xl-6 d-flex flex-column justify-content-between">
					<div>
						<label class="fs-7"><%=rs.getString("pID")%></label><br> <label
							class="fs-5"><%=rs.getString("mCompany")%></label>
						<p>
							<label class="fs-3 fw-bold"><%=rs.getString("pTitle")%></label><br>
						</p>
						<label class=""><%=rs.getString("pCategory")%></label>
						<div class="">
							<span class="text-warning"> <i class="fa-solid fa-star"></i></span>
							<span class="fw-bold"> <%=score_%></span>
						</div>
					</div>
					<div>
						<div class="col-md-12 text-end mb-3">
							<span class="fw-bold mx-4 fs-3 text-end"><%=rs.getString("pPrice")%>원</span>
						</div>

						<div class="col-md-12 text-center">
							<a href="header.jsp"><input type="button"
								class="btn btn-warning w-75 mx-4" value="구매하기"></a>
						</div>
					</div>
				</div>
				<ul class="nav nav-pills nav-fill bg-light my-5 py-2">
					<li class="nav-item"><a class="nav-link text-black"
						href="#service">서비스 설명</a></li>
					<li class="nav-item"><a class="nav-link text-black"
						href="#skill">기술 소개</a></li>
					<li class="nav-item"><a class="nav-link text-black"
						href="#develop">개발자 소개</a></li>
					<li class="nav-item"><a class="nav-link text-black"
						href="#review">리뷰 <%=Math.round(cnt)%></a></li>
				</ul>
			</div>
		</div>
		<!-- poster-top end -->

		<!-- poster-main -->
		<div class="container m-1">
			<div class="row">
				<div class="col">
					<h3 class="fw-bold" id="service">서비스 설명</h3>
					<div class="serviceBox">
						<p><%=rs.getString("pText")%></p>
					</div>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<h3 class="fw-bold" id="skill">기술 소개</h3>
					<div class="skillBox">
						<%=rs.getString("pSkillText")%>
					</div>

					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<h3 class="fw-bold" id="develop">개발자 소개</h3>
					<div class="developerBox">
						<p><%=rs.getString("mCompany")%></p>
						<p><%=rs.getString("pWriter")%></p>
						<p><%=rs.getString("mTel")%></p>
						<p><%=rs.getString("mMail")%></p>
						<p><%=rs.getString("mText")%></p>




						<p><%=rs.getString("sSkill1")%></p>

						<%
						if (rs.getString("sSkill2") != null) {
						%>
						<p><%=rs.getString("sSkill2")%></p>
						<%
						}

						if (rs.getString("sSkill3") != null) {
						%>

						<p><%=rs.getString("sSkill3")%></p>
						<%
						}

						}
						%>
					</div>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<h3 class="fw-bold" id="review">리뷰</h3>
					<div class="reviewBox">
						<%
						String sql2 = "SELECT * FROM reviewtbl where rPosterID=?";
						pstmt = conn.prepareStatement(sql2);
						pstmt.setInt(1, num);
						rs = pstmt.executeQuery();
						while (rs.next()) {
						%>
						<span class="text-warning"> <i class="fa-solid fa-star"></i></span>
							<span class="fw-bold"><%=rs.getFloat("rScore")%></span>
							<span class="fw-bold"><%=rs.getString("rWriter")%></span>
						<p class="mt-2"><%=rs.getString("rText")%></p>
						<hr>
						<%
						}
						pstmt.close();
						conn.close();
						%>
						<!-- 로그인된 아이디, 별점, 리뷰텍스트 ,,, 기본설정은 hidden 누르면 보이게... 스크룰 맨아래로 -->
						<form id="reviewForm" action="review_process.jsp"
							class="d-none">
							<div class="row d-flex ">
								<div class="col-md-4">
									<span class="fw-bold"><%=id%></span>
									<fieldset class="mx-3">
									<div style="cursor:default" oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
										  <input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
								        <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
								        <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
								        <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
								        <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
								        </div>
									</fieldset>
								</div>
							</div>
							<div class="row">
								<textarea class="form-control mt-3" placeholder="리뷰를 입력해주세요"
									id="addReviewText" name="addReviewText" rows="5"></textarea>
							</div>
							<input type="button" class="btn btn-primary mt-3" value="등록 완료"
								onclick="addreview()">
							<input type="button" class="btn btn-outline-primary mt-3" value="취소"
								onclick="toggleText()">
							<textarea class="d-none"
									id="pid" name="pid" rows="1"><%=num %></textarea>
						</form>
						<% if(id == null){ %>
							<p class="mt-3">로그인 시 리뷰를 남길 수 있습니다.</p>
						<%}else{ %>
							
						<input type="button" id="createReviewBtn"
							class="btn btn-primary mt-3" value="리뷰 등록"
							onclick="toggleText()">
						<%} %>



					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>

	<footer>footer</footer>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>