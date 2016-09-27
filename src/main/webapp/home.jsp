<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE HTML>
<html>
<head><title>Welcome to my application</title></head>
<body>
<div align="center">
		<br>
		This is a list of students: <h1>${students}</h1>
</div>

<div align="left">
	Add new student
	<form:form method='POST' action='${pageContext.request.contextPath}/student/addStudent.htm' modelAttribute="student">
		Name: <form:input type='text' path='name' />
		Age : <form:input type='text' path='age' />
		<input type='submit' value='Submit' />
	</form:form>
</div>
</body>
</body>
</html>