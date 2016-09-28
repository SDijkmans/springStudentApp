<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML>


<html>
<head>
<title>StudentApp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
	
<style>
	body {
	    background-color: lightblue;
	}
	.navbar .navbar-nav {
	    display: inline-block;
	    float: none;
	}
	
	.navbar-brand {
	    text-align: center;
	}
	
	body {
  padding-top: 1.5rem;
  padding-bottom: 1.5rem;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header,
.marketing,
.footer {
  padding-right: 1rem;
  padding-left: 1rem;
}

/* Custom page header */
.header {
  padding-bottom: 1rem;
  border-bottom: .05rem solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
  margin-top: 0;
  margin-bottom: 0;
  line-height: 3rem;
}

/* Custom page footer */
.footer {
  padding-top: 1.5rem;
  color: #777;
  border-top: .05rem solid #e5e5e5;
}

/* Customize container */
@media (min-width: 48em) {
  .container {
    max-width: 46rem;
  }
}
.container-narrow > hr {
  margin: 2rem 0;
}

/* Main marketing message and sign up button */
.jumbotron {
  text-align: center;
  border-bottom: .05rem solid #e5e5e5;
}
.jumbotron .btn {
  padding: .75rem 1.5rem;
  font-size: 1.5rem;
}

/* Supporting marketing content */
.marketing {
  margin: 3rem 0;
}
.marketing p + h4 {
  margin-top: 1.5rem;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 48em) {
  /* Remove the padding we set earlier */
  .header,
  .marketing,
  .footer {
    padding-right: 0;
    padding-left: 0;
  }
  /* Space out the masthead */
  .header {
    margin-bottom: 2rem;
  }
  /* Remove the bottom border on the jumbotron for visual effect */
  .jumbotron {
    border-bottom: 0;
  }
}
</style>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-top ">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Student App</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav justified">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
				</ul>
			</div>
		</nav>

		<div class="row jumbotron">
			<br> This is a list of students:
			<h2 class="display-3">${students}</h2>
		</div>

		<div align="left">
			<p align="left">Add new student</p>
			<form:form method='POST'
				action='${pageContext.request.contextPath}/student/addStudent.htm'
				modelAttribute="student">
				<div class=row>
					<div class="col-md-1">Name:</div>
					<form:input type='text' path='name' />
				</div>
				<div class=row>
					<div class="col-md-1">Age:</div>
					<form:input type='text' path='age' />
				</div>

				<div class="row">
					<input type='submit' value='Submit' />
				</div>
			</form:form>

			<a href="${pageContext.request.contextPath}/student/2">Click here
				to get student 2</a>



		</div>

	</div>
	<footer> StudentApp 2016 </footer>

</body>
</body>
</html>