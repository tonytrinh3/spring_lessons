<html>
	<body>
		<h1> Spring REST Demo</h1>
		
		<hr>
		<!-- you can do test/hello. if you want /test/hello then you have to add pageContext request to work -->
		<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/api/students">Get All Students</a>
		
	</body>
	
	
</html>