<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<li>Amis|requetes </li>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--  Scripts  -->
<!-- JQuery  -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<!-- Bootstrap  -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- JQuery Validate  -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="/DAR/assets/js/friendsandrequest.js"></script>

<!-- Fin  Scripts  -->

<!-- Styles  -->
<!-- bootstrap  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- fontAwsome  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<!-- style du footer  -->
<link rel="stylesheet" href="/DAR/assets/css/pageFooter.css">
<!-- style du header  -->
<link rel="stylesheet" href="/DAR/assets/css/header.css">
<link rel="stylesheet" href="/DAR/assets/css/main.css">

<!-- Fin Styles  -->
<title>Requêtes Reçus</title>
</head>
<body>
<jsp:include page="header.jsp" />

	<div class="maincontainer" id="maincontainer">

		<div class="panel panel-default" style="">
			<div class="panel-heading">
				<h3>
					<p class='capital'>Requêtes Reçus</p>
				</h3>
			</div>
			<div class="panel-body">
				<div id='page'>
					<div class='layer-center'>
						<div id='notifier'></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			retrieveRequestsFunc();

		});
	</script>
	<jsp:include page="footer.jsp"/>
</body>
</html>