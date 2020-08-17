<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Styles -->
<link rel="stylesheet" href="https://uicdn.toast.com/tui-editor/latest/tui-editor.css"></link>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-editor/latest/tui-editor-contents.css"></link>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.css"></link>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/github.min.css"></link>
<!-- Scripts -->
<script src="https://uicdn.toast.com/tui-editor/latest/tui-editor-Editor-full.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", ()=>{
		var editor = new tui.Editor({
			el: document.querySelector("#editorSection"),
			initialEditType: "markdown",
			previewStyle: "vertical",
			height: "300px",
			hooks:{
				'addImageBlobHook':function(blob, callback){
					//console.log(blob, callback);
					//blob 업로드를 하고(axios 등)
					var frm = new FormData();
					frm.append("f", blob);
					//frm.append("이름", 값);
					axios({
						url:"",
						method:"post",
						data:frm
					});
					//callback("반환된 다운로드 주소");
				}
			}
		})
	}, false);
</script>
</head>
<body>
	<div>
		<div id="editorSection"></div>
		<button id="form-submit">OK</button>
	</div>
</body>
</html>