<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Points/PointsEndGame.js" type="text/javascript"></script>
	<div id="pts_body">
		<div id="pts_bg_end_ofGame">
			<div id="pts_player1_score">
				<label>${langPack['Pts_score']} ${ptsGame.board.serverScore}</label>
			</div>
			<div id="pts_player2_score">
				<label>${langPack['Pts_score']} ${ptsGame.board.clientScore}</label>
			</div>
			<div id="pts_player_label_1">
				<img class="pts_player_div_elements"
					src="images/Points/server_point-2.png">
				<label class="pts_player_div_elements">${ptsGame.server.name}</label>
			</div>
			<div id="pts_player_label_2">
				<img class="pts_player_div_elements"
					src="images/Points/client_point-1.png">
				<label class="pts_player_div_elements">${ptsGame.client.name}</label>
			</div>
			<div id="pts_label_win_loose">
				<label>${langPack['Pts_winner']}</label>
			</div>
			<div id="winner_gif">
				<img src="images/Points/winner.png">
			</div>
			
			<div class="homeButton" onclick=goToMainMenu()></div>
			<div class="pts_backButton" onClick=goToPointsMenu()></div>
		</div>
	</div>
</div>