<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/root.css">
    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/category.css">
    <link rel="stylesheet" href="resources/css/poster.css">
</head>
<body>
<!-- 아직 부트스트랩 적용 전임 ㅡㅡ -->


<!-- 이건 헤더 컨테이너 복붙하시믄 될듯?? 몰루? -->
    <div class="header">
        <div class="header_nav">
            <a href="#">
            	<div class="header_logo">temp</div>	<!-- 임시임 로고 이미지 넣어야함 -->
            	</a>
            <div class="header_nav_project">
                <a href="#">프로젝트 등록</a>
                <a href="#">프로젝트 입력</a>
            </div>
        </div>
        <div class="header_member">
            <button class="header_login">로그인</button>
            <button class="header_gaip">회원가입</button>
        </div>
    </div>
<!-- 요기까지 -->


    <!-- 카테고리 컨테이너  -->
     <div class="c_container">
        <div class="category">
            <h2 class="msg">카테고리</h2>
            <hr class="category_border"></hr>
            <ul class="listBox">
                <li><a href="#">프론트엔드</a></li>
                <li><a href="#">백엔드</a></li>
                <li><a href="#">웹 풀스텍</a></li>
                <li><a href="#">안드로이드</a></li>
                <li><a href="#">IOS</a></li>
                <li><a href="#">하이브리드앱</a></li>
                <li><a href="#">게임 클라이언트</a></li>
                <li><a href="#">게임 서버</a></li>
                <li><a href="#">DBA</a></li>
                <li><a href="#">데이터엔지니어</a></li>
                <li><a href="#">머신러닝</a></li>
                <li><a href="#">인공지능</a></li>
                <li><a href="#">시스템소프트웨어</a></li>
                <li><a href="#">devOPs</a></li>
                <li><a href="#">사물인터넷(IoT)</a></li>
                <li><a href="#">인터넷보안</a></li>
                <li><a href="#">응용프로그램</a></li>
                <li><a href="#">QA</a></li>
                <li><a href="#">VR / AR / 3D</a></li>
            </ul>
        </div>
    </div>
<!-- 요기까지 -->


<!-- 이건 내꼬임 -->
    <div class="post_container">
        <span class="post_cate">temp > temp</span>
        <div class="post_container_top">
            <div class="img_box">
                <img src="#" alt="img_temp">
            </div>
            <hr class="post_border_col"><!--구분선-->
            <div class="top_titleBox">
                <span>Kakao</span>
                <span>맞춤형 광고 알고리즘 설계 가능합니다</span>
                <div class="title_stack">Java MySQL</div>
                <div>
                    <img src="#">
                    <span>4.5</span>
                </div>
                <div>
                    <span>100,000원</span>
                </div>
                <input type="button" value="구매하기">
            </div>
        </div>
        <ul class="post_navBox">
            <!-- 클릭하면 스크룰 바이되게끔 -->
            <li>서비스 설명</li>
            <li>기술 소개</li>
            <li>개발자 소개</li>
            <li>리뷰</li>   <!--갯수 동적으로-->
        </ul>
        <div class="post_main">

        </div>
    </div>
</body>
</html>