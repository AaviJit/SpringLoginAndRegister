<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Member</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<sf:form class="form-horizontal" modelAttribute="member"
			action="${pageContext.request.contextPath}/updateMember">
			<fieldset>

				<!-- Form Name -->
				<legend>Update Info</legend>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Name</label>
					<div class="col-md-4">

						<!-- 	<sf:hidden path="userName"></sf:hidden>  
						
						
						
						
						 -->
						 
						<sf:input id="textinput" name="textinput" type="hidden" path="id"
							placeholder="id" class="form-control input-md"></sf:input>



						<sf:input id="textinput" name="textinput" type="hidden"
							path="userName" placeholder="userName"
							class="form-control input-md"></sf:input>

						<sf:input id="textinput" name="textinput" type="text" path="name"
							placeholder="name" class="form-control input-md"></sf:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Mobile
						No</label>
					<div class="col-md-4">
						<sf:input id="textinput" name="textinput" type="text"
							path="mobile" placeholder="mobile number"
							class="form-control input-md"></sf:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Address</label>
					<div class="col-md-4">
						<sf:input id="textinput" name="textinput" type="text"
							path="address" placeholder="address"
							class="form-control input-md"></sf:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Password</label>
					<div class="col-md-4">
						<sf:input id="textinput" name="textinput" type="text"
							path="password" placeholder="password"
							class="form-control input-md"></sf:input>

					</div>
				</div>


				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="update"></label>
					<div class="col-md-4">
						<button id="update" name="update" class="btn btn-primary">Update</button>
					</div>
				</div>


			</fieldset>
		</sf:form>
	</div>

</body>
</html>