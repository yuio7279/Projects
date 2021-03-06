<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://kit.fontawesome.com/5547fa07a6.js"
	crossorigin="anonymous"></script>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="./resources/css/carousel.css">
	
<style>
.contour {
	border-right: 3px solid rgb(209, 209, 209);
	height: 100%;
	width: 55%;
}
    .icon {
      font-size: 24px;
    }

    .cardImage {
      background-size: cover;
    }
</style>
</head>
<body>
	
	<jsp:include page="header.jsp" />
	<div class="container">
			<form method="post" class="mt-5" action="<%= request.getContextPath()%>/LoginAction.jsp">
		<div class="row">
			    <h3 class="mb-3" style="text-align: center;">로그인 화면</h3>
			    <div class="col-md-4 mx-auto">
					<label for="name">아이디</label>
					<input type="text" class="form-control mb-3" id="mID" placeholder="아이디" maxlength = "20" name ="mID" required>
				</div>
		</div>
		<div class="row">
				<div class="col-md-4 mx-auto">
					<label for="name">비밀번호</label>
					<input type="password" class="form-control" id="mPW" placeholder="비밀번호" maxlength = "20" name="mPW" required>
					<input type="submit" class="btn btn-primary btn-block mt-3 text-center" value="로그인">
			    </div>
		</div>
			    
			</form>
	</div>
	   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
      crossorigin="anonymous"></script>
</body>
</html>