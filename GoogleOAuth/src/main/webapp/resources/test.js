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

var uiConfig = {
	callbacks : {
		signInSuccessWithAuthResult : function(authResult, redirectUrl) {
			// User successfully signed in.
			// Return type determines whether we continue the redirect
			// automatically
			// or whether we leave that to developer to handle.
			return true;
		},
		uiShown : function() {
			// The widget is rendered.
			// Hide the loader.
			document.getElementById('loader').style.display = 'none';
		}
	},
	// Will use popup for IDP Providers sign-in flow instead of the default,
	// redirect.
	// signInFlow: 'popup',
	signInSuccessUrl : '/oauth',
	signInOptions : [
	// Leave the lines as is for the providers you want to offer your users.
	firebase.auth.GoogleAuthProvider.PROVIDER_ID,
	// firebase.auth.FacebookAuthProvider.PROVIDER_ID,
	// firebase.auth.TwitterAuthProvider.PROVIDER_ID,
	// firebase.auth.GithubAuthProvider.PROVIDER_ID,
	// firebase.auth.EmailAuthProvider.PROVIDER_ID,
	// firebase.auth.PhoneAuthProvider.PROVIDER_ID
	],
// Terms of service url.
// tosUrl: '<your-tos-url>',
// Privacy policy url.
// privacyPolicyUrl: '<your-privacy-policy-url>'
};
var ui = new firebaseui.auth.AuthUI(firebase.auth());
ui.start('#firebaseui-auth-container', uiConfig);