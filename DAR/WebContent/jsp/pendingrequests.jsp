<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<div class="maincontainer" id="maincontainer">

	<div class="panel panel-default" style="">
		<div class="panel-heading">
			<h3>
				<p class='capital'>Requêtes Reçues</p>
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
