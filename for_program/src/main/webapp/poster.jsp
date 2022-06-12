<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="category.jsp" />

	<div class="col-md-9"> 
		<div class="article">
		
			<div class="tt_article_useless_p_margin contents_style">
				<p style="line-height: 1.8;">
					<br>
				</p>
				<p style="line-height: 1.8;">
					<br>
				</p>
				<p style="line-height: 1.8;">
					<b><span style="font-size: 18pt;">&nbsp;TEMPTEMPTEMPTEMPTEMPTEMP</span></b>
				</p>
				<p style="line-height: 1.8;">
					<br>
				</p>
				<p style="line-height: 1.8;">
					<span style="font-size: 14pt;">&nbsp;JSP에는 현재의 JSP 파일에다 다른
						파일(JSP, HTML)을 포함시켜 사용을 할 수 있다.</span><span style="font-size: 14pt;">&nbsp;보통
						많이 사용되는 경우는 header나 footer 그리고 상태바 등을 나타낼 때 주로 사용을 하고 있다.&nbsp;</span><span
						style="font-size: 14pt; line-height: 1.5;">나 또한 로그인 정보, 메뉴
						정보를 나타낼 때, 사용을 한다.</span>
				</p>
				<p style="line-height: 1.8;">
					<br>
				</p>
				<div class="txc-textbox"
					style="border: 3px double rgb(203, 203, 203); padding: 10px; background-color: rgb(255, 255, 255); line-height: 1.8;">
					<p>
						<span style="font-size: 12pt;"><b><span
								style="color: rgb(152, 0, 0); font-size: 14pt;">◆
									include에는 2가지 방식이 존재</span></b></span>
					</p>
					<p>
						<br>
					</p>
					<p>
						<b><span style="font-size: 12pt;">&nbsp;1. include
								directive(지시어)</span></b>
					</p>
					<p>
						<b><span style="font-size: 12pt;">&nbsp;2. include
								action(액션)</span></b>
					</p>
					<p>
						<br>
					</p>
					<p>
						<span style="font-size: 12pt;">&nbsp;이 두 가지의 </span><b><span
							style="font-size: 12pt;">공통점</span></b><span style="font-size: 12pt;">은
							동일하게 파일을 불러와서 사용을 하는 점이고,&nbsp;</span><span
							style="font-size: 9pt; line-height: 1.5;"><b><span
								style="font-size: 12pt;">차이점</span></b><span
							style="font-size: 12pt;">으로는 지시어는 해당 소스를 포함시킨 후에 컴파일을 하지만
								액션은 실행시점에서 해당 파일을 수행하여&nbsp;</span></span><span
							style="font-size: 12pt; line-height: 1.5;">결과를 포함시킨다.</span>
					</p>
				</div>
				<p style="line-height: 1.8;">
					<br>
				</p>
				<div class="txc-textbox"
					style="border: 3px double rgb(203, 203, 203); padding: 10px; background-color: rgb(255, 255, 255); line-height: 1.8;">
					<p>
						<span style="font-size: 11pt;"><b><span
								style="font-size: 14pt; color: rgb(152, 0, 0);">◆ include
									지시어 사용 방법</span></b></span><br>
					</p>
					<p>
						<br>
					</p>
					<p>
						<b><span style="font-size: 12pt;">&lt;%@ include
								file="/WEB-INF/views/include/header.jsp" %&gt;</span></b>
					</p>
					<p>
						<b><span style="font-size: 12pt;">--- 현재 파일 ---</span></b>
					</p>
					<p>
						<b><span style="font-size: 12pt;">&lt;%@ include
								file="/WEB-INF/views/include/footer.jsp" %&gt;</span></b>
					</p>
					<p>
						<br>
					</p>
					<p>
						<span style="font-size: 12pt;">가져올 파일의 경로를 넣어 다른 파일을 가져와 현재
							파일에 뿌려준다.</span>
					</p>
				</div>
				<p style="line-height: 1.8;">
					<br>
				</p>
				<div class="txc-textbox"
					style="border: 3px double rgb(203, 203, 203); padding: 10px; background-color: rgb(255, 255, 255); line-height: 1.8;">
					<p>
						<span style="font-size: 9pt; line-height: 1.5;"><b><span
								style="font-size: 14pt; color: rgb(152, 0, 0);">◆ include
									액션 사용 방법</span></b></span>
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
							style="font-size: 11pt; color: rgb(0, 0, 0);">2016/05/13 -
								[JSP] 전화번호(휴대폰번호) 유효성 검사 방법 !</span></a>
					</p>
					<p>
						<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
							href="http://sesok808.tistory.com/400" target="_blank"><span
							style="font-size: 11pt; color: rgb(0, 0, 0);">2016/05/13 -
								[JSP] 비밀번호(패스워드) 유효성 검사 방법은?</span></a>
					</p>
					<p>
						<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
							href="http://sesok808.tistory.com/360" target="_blank"><span
							style="font-size: 11pt; color: rgb(0, 0, 0);">2015/07/09 -
								[JSP] taglib 디렉티브 사용법</span></a>
					</p>
					<p>
						<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
							href="http://sesok808.tistory.com/329" target="_blank"><span
							style="font-size: 11pt; color: rgb(0, 0, 0);">2015/07/02 -
								[JSP] 에러 페이지 처리방법 (web.xml)</span></a>
					</p>
					<p>
						<span style="font-size: 11pt; color: rgb(0, 0, 0);">&nbsp;</span><a
							href="http://sesok808.tistory.com/328" target="_blank"><span
							style="font-size: 11pt; color: rgb(0, 0, 0);">2015/07/02 -
								[JSP] HTTP 에러코드 정리 모음</span></a>
					</p>
				</div>
				<p style="line-height: 1.8;">
					<br>
				</p>
				<p style="line-height: 1.8;">
					<b><span style="font-size: 14pt;"><span
							style="color: rgb(255, 0, 0); font-size: 14pt;">↓ 공감&nbsp;</span><span
							style="font-size: 14pt;">을 눌러주시면 블로거에게 큰 힘이 됩니다 !</span></span></b>
				</p>
				<p></p>
				<div class="container_postbtn #post_button_group">
					<div class="postbtn_like">

						<script>
							window.ReactionButtonType = 'reaction';
							window.ReactionApiUrl = '//sesok808.tistory.com/reaction';
							window.ReactionReqBody = {
								entryId : 331
							}
						</script>
						<div class="wrap_btn" id="reaction-331">
							<button class="btn_post uoc-icon">
								<div class="uoc-icon">
									<span class="ico_postbtn ico_like">좋아요</span><span
										class="txt_like uoc-count">20</span>
								</div>
							</button>
						</div>
						<script
							src="https://t1.daumcdn.net/tistory_admin/assets/blog/tistory-f35782317ecb44302da86ded84203e84780e1123/blogs/script/reaction/reaction-button-container.min.js?_version_=tistory-f35782317ecb44302da86ded84203e84780e1123"></script>
						<div class="wrap_btn wrap_btn_share">
							<button type="button" class="btn_post sns_btn btn_share"
								data-thumbnail-url="https://t1.daumcdn.net/tistory_admin/static/images/openGraph/opengraph.png"
								data-title="[JSP] JSP에서 include 사용하는 방법 (file, page)"
								data-description="&nbsp;JSP에서 Include 사용방법은 ? &nbsp;JSP에는 현재의 JSP 파일에다 다른 파일(JSP, HTML)을 포함시켜 사용을 할 수 있다.&nbsp;보통 많이 사용되는 경우는 header나 footer 그리고 상태바 등을 나타낼 때 주로 사용을 하.."
								data-profile-image="https://tistory4.daumcdn.net/tistory/1656045/attach/5e4feddd78754e47a96f155d8ca8c563"
								data-profile-name="SkyBaby"
								data-pc-url="https://sesok808.tistory.com/331"
								data-relative-pc-url="/331" data-blog-title="살아가는 그 이유">
								<span class="ico_postbtn ico_share">공유하기</span>
							</button>
						</div>
						<div class="wrap_btn wrap_btn_etc" data-entry-id="331"
							data-entry-visibility="public" data-category-visibility="public">
							<button type="button" class="btn_post btn_etc2">
								<span class="ico_postbtn ico_etc">글 요소</span>
							</button>
						</div>
					</div>
					<button type="button"
						class="btn_menu_toolbar btn_subscription  #subscribe"
						data-blog-id="1656045" data-url="https://sesok808.tistory.com/331"
						data-device="web_pc">
						<em class="txt_state">구독하기</em> <strong class="txt_tool_id">살아가는
							그 이유</strong> <span class="img_common_tistory ico_check_type1"></span>
					</button>
					<div class="postbtn_ccl" data-ccl-type="3">
						<a href="https://creativecommons.org/licenses/by/4.0/deed.ko"
							target="_blank" class="link_ccl" rel="license"> <span
							class="bundle_ccl"> <span class="ico_postbtn ico_ccl1">저작자표시</span>
						</span>
						</a>
					</div>
					<!--
<rdf:RDF xmlns="http://web.resource.org/cc/" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
    <Work rdf:about="">
        <license rdf:resource="http://creativecommons.org/licenses/by-fr/2.0/kr/" />
    </Work>
    <License rdf:about="http://creativecommons.org/licenses/by-fr/">
        <permits rdf:resource="http://web.resource.org/cc/Reproduction"/>
        <permits rdf:resource="http://web.resource.org/cc/Distribution"/>
        <requires rdf:resource="http://web.resource.org/cc/Notice"/>
        <requires rdf:resource="http://web.resource.org/cc/Attribution"/>
                <permits rdf:resource="http://web.resource.org/cc/DerivativeWorks"/>
                    </License>
</rdf:RDF>
-->
				</div>
				<div class="another_category another_category_color_gray">
					<h4>
						'<a href="/category/공부%20이야기">공부 이야기</a>&nbsp;&gt;&nbsp;<a
							href="/category/공부%20이야기/코드%20저장소">코드 저장소</a>' 카테고리의 다른 글
					</h4>
					<table>
						<tbody>
							<tr>
								<th><a href="/333?category=569069">[JSP] 숫자 변환 포맷 (3자리
										마다 콤마 찍기)</a>&nbsp;&nbsp;<span>(0)</span></th>
								<td>2015.07.02</td>
							</tr>
							<tr>
								<th><a href="/332?category=569069">[Spring] 한글이 깨질 시
										처리방법은 ?</a>&nbsp;&nbsp;<span>(0)</span></th>
								<td>2015.07.02</td>
							</tr>
							<tr>
								<th><a href="/331?category=569069" class="current">[JSP]
										JSP에서 include 사용하는 방법 (file, page)</a>&nbsp;&nbsp;<span>(0)</span>
								</th>
								<td>2015.07.02</td>
							</tr>
							<tr>
								<th><a href="/329?category=569069">[JSP] 에러 페이지 처리방법
										(web.xml)</a>&nbsp;&nbsp;<span>(0)</span></th>
								<td>2015.07.02</td>
							</tr>
							<tr>
								<th><a href="/328?category=569069">[JSP] HTTP 에러코드 정리
										모음</a>&nbsp;&nbsp;<span>(0)</span></th>
								<td>2015.07.02</td>
							</tr>
							<tr>
								<th><a href="/327?category=569069">[JSP] 웹에서 Session
										사용하기</a>&nbsp;&nbsp;<span>(0)</span></th>
								<td>2015.07.02</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div>
				<script async=""
					src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
				<ins class="adsbygoogle" style="display: block"
					data-ad-format="autorelaxed"
					data-ad-client="ca-pub-2427753694915716" data-ad-slot="3935245278"
					data-adsbygoogle-status="done">
					<iframe id="aswift_3"
						style="height: 1px !important; max-height: 1px !important; max-width: 1px !important; width: 1px !important;"></iframe>
					<iframe id="google_ads_iframe_3"
						style="height: 1px !important; max-height: 1px !important; max-width: 1px !important; width: 1px !important;"></iframe>
				</ins>
				<script>
					(adsbygoogle = window.adsbygoogle || []).push({});
				</script>
			</div>
			<!--<tenping class="adsbytenping" style="width: 100%; margin: 0px auto; display: block; max-width: 768px;" tenping-ad-client="JqB0bPl%2fh1jfYZkM5NvYdkYiokZ82RW4GeiA1LmlCZee52JTsOdTS63CjSQUr96W" tenping-ad-display-type="67%2be3LHzHbblsB9oLrOpWQ%3d%3d"></tenping><script async src='//ads.tenping.kr/scripts/adsbytenping.min.js' ></script>-->
		</div>
	</div>






	</div>
	</div>
</body>
</html>