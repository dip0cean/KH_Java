<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.min.js" integrity="sha512-VZ6m0F78+yo3sbu48gElK4irv2dzPoep8oo9LEjxviigcnnnNvnTOJRSrIhuFk68FMLOpiNz+T77nNY89rnWDg==" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Firebase App (the core Firebase SDK) is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/6.2.0/firebase-app.js"></script>

<!-- Add Firebase products that you want to use -->
<script src="https://www.gstatic.com/firebasejs/6.2.0/firebase-auth.js"></script>
<script src="https://www.gstatic.com/firebasejs/6.2.0/firebase-firestore.js"></script>
<script>
	// Your web app's Firebase configuration
	var firebaseConfig = {
		apiKey : "AIzaSyD_SXWgHkEe9FSR2k6T5HT_V-IPSFgcqX0",
		authDomain : "d0-project.firebaseapp.com",
		databaseURL : "https://d0-project.firebaseio.com",
		projectId : "d0-project",
		storageBucket : "d0-project.appspot.com",
		messagingSenderId : "684872143927",
		appId : "1:684872143927:web:eb18bd47cbfd7a8fbbdbb2",
		measurementId : "G-63NPBL99Q9"
	};
	// Initialize Firebase
	firebase.initializeApp(firebaseConfig);
	firebase.analytics();
</script>

<script src="https://cdn.firebase.com/libs/firebaseui/3.5.2/firebaseui.js"></script>
<link type="text/css" rel="stylesheet" href="https://cdn.firebase.com/libs/firebaseui/3.5.2/firebaseui.css" />
<script>
	var uiConfig = {
		callbacks : {
			signInSuccessWithAuthResult : function(authResult, redirectUrl) {
				// User successfully signed in.
				// Return type determines whether we continue the redirect automatically
				// or whether we leave that to developer to handle.
				return true;
			},
			uiShown : function() {
				// The widget is rendered.
				// Hide the loader.
				document.getElementById('loader').style.display = 'none';
			}
		},
		// Will use popup for IDP Providers sign-in flow instead of the default, redirect.
		//   signInFlow: 'popup', 
		signInSuccessUrl : '/oauth',
		signInOptions : [
		// Leave the lines as is for the providers you want to offer your users.
		firebase.auth.GoogleAuthProvider.PROVIDER_ID,
		//    firebase.auth.FacebookAuthProvider.PROVIDER_ID,
		//    firebase.auth.TwitterAuthProvider.PROVIDER_ID,
		//    firebase.auth.GithubAuthProvider.PROVIDER_ID,
		//    firebase.auth.EmailAuthProvider.PROVIDER_ID,
		//   firebase.auth.PhoneAuthProvider.PROVIDER_ID
		],
	// Terms of service url.
	//   tosUrl: '<your-tos-url>',
	// Privacy policy url.
	//   privacyPolicyUrl: '<your-privacy-policy-url>'
	};
	var ui = new firebaseui.auth.AuthUI(firebase.auth());
	ui.start('#firebaseui-auth-container', uiConfig);
</script>
<script>
// 참고 사이트
// > http://blog.naver.com/PostView.nhn?blogId=wj8606&logNo=221206395970

	// 구글 로그인
	function login() {
		
		//인증서비스 제공업체설정
		var provider = new firebase.auth.GoogleAuthProvider();
		
		//로그인창 호출
		firebase.auth().signInWithPopup(provider);
		
		//공식API 활용 예제
		firebase.auth().signInWithPopup(provider).then(function(result) {

			console.log(result.user.email)
			
			var loginEmail = result.user.email;
			
			axios({
				url:"${pageContext.request.contextPath}/ajax/getList?email=" + loginEmail,
				method:"get"
				}).then(function (resp) {
					console.log(resp)
					if(!resp.data.email) {
						// 소셜 로그인 > 로그아웃 
						this.logout();
						
						// 회원가입 페이지로 이동 
						window.location.href = "join?email=" + loginEmail;
						}
					
					})
			  
		  var token = result.credential.accessToken;
		  var user = result.user;

		}).catch(function(error) {
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  var email = error.email;
		  var credential = error.credential;
		});	
	}
	
	// 로그아웃
	function logout() {
		firebase.auth().signOut().then(function() {
			  // Sign-out successful.
			  console.log("로그아웃 성공")
		}).catch(function(error) {
			  // An error happened.
		});
	}
	
	// 정보 가지고 오기
	firebase.auth().onAuthStateChanged(function(user) {
		  if (user) {
		    // User is signed in.
		    console.log(user.displayName)
		    console.log(user.email)
		    var id = document.querySelector("#your_id");
		    id.textContent = user.email;
		    
		    var nick = document.querySelector("#your_nick");
		    nick.textContent = user.displayName;
		  } else {
		    // No user is signed in.
		    console.log(user)
		    var id = document.querySelector("#your_id");
		    id.textContent = "";
		    var nick = document.querySelector("#your_nick");
		    nick.textContent = "";
		  }
	});
</script>

</head>
<body>
	<div id="firebaseui-auth-container"></div>
	<div id="loader"></div>
	
	<button onclick="login();">로그인 창 띄우기</button>
	<br><br>
	<button onclick="logout();">로그아웃</button>
	
	<div id="your_id"></div>
	<div id="your_nick"></div>
	<hr>
	${not empty getList }
	<h2>이메일</h2>
	<c:forEach var="email" items="${getList }">
		<h4>${email.email }</h4>
	</c:forEach>
	
</body>
</html>