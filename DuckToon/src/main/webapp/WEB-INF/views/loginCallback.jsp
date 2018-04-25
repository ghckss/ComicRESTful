<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jmnaverloginPop.html</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"></script>
</head>
<body>
 <div data-role="page" id="pOne">
  <div data-role="header" id="pHead">
   <h1>WELCOME</h1>
   <h1>${accessToken}</h1>
   <h1>${state}</h1>
  </div>
  <div data-role="main" class="ui-content">
   <p>WELCOME MAIN - NAVER LOGIN</p>
   <!-- 네이버아이디로로그인 버튼 노출 영역 -->
   <div id="naver_id_login" style="display: none;"></div>
   <!-- //네이버아이디로로그인 버튼 노출 영역 -->
   <!-- 네이버아디디로로그인 초기화 Script -->
   <script type="text/javascript">
    var naver_id_login = new naver_id_login("HwWScsxnTIVBsgrr5nXv",
      "http://203.247.240.40:8080/callback");
    var state = naver_id_login.getUniqState();
    naver_id_login.setButton("white", 2, 40);
    naver_id_login.setDomain("http://localhost:3000");
    naver_id_login.setState(state);
    naver_id_login.setPopup();
    naver_id_login.init_naver_id_login();
   </script>
   <!-- // 네이버아이디로로그인 초기화 Script -->
   <!-- 네이버아디디로로그인 Callback페이지 처리 Script -->
   
   <script type="text/javascript">
    // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
    
    naver_id_login.get_naver_userprofile("naverSignInCallback()");
    // 네이버 사용자 프로필 조회
    function naverSignInCallback() {
     // naver_id_login.getProfileData('프로필항목명');
      alert(naver_id_login.getProfileData('email'));
      alert(naver_id_login.getProfileData('nickname'));

      window.close();
      
     // 로그인 처리
     $(opener.document).find("#naver_id_login").hide();
     $(opener.document).find("#naver_id_logout").show();
     
     // 창닫기 및 로그인입력
    // $(opener.document).find("#dvLogin").empty();
    // $(opener.document).find("#dvLogin").append(naver_id_login.getProfileData('email') + "님 로그인("+ naver_id_login.getProfileData('nickname') +","+ naver_id_login.getAccessToken() +")");
     
     //window.close();
    }
   </script>
  </div>
 </div>
</body>
</html>

3000-> 3000callback(흰창 + ajax(access,state)) -> rest(acces,state){프로필 조회를해 + db + 다시넘겨} 

