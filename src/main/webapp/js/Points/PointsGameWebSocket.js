var userType;
var gameId;
var socket = new WebSocket("ws://localhost:8082");
var waitForClient = true;
var lock = false;
var board;
var x_length = 20;
var y_length = 19;
//

$(document).ready(function(){

    userType = $('#pts_game_table').attr('userType');
    gameId = $('#pts_game_table').attr('gameId');
    $('#pts_player2_img').css('visibility', 'hidden');
    
    $(".pts_point").mouseover(function(){
    
    	if(!lock) {
	        var x = parseX(this.id);
	        var y = parseY(this.id);
	        if (board[y][x] == 0) {
	            $('#' + this.id).css('background-image', "url(\'images/Points/point_hover_true.png\')");
	        }
	        if (board[y][x] == -1) {
	            $('#' + this.id).css('background-image', "url(\'images/Points/point_hover_false.png\')");
	        }
    	}
    });
    
    $(".pts_point").mouseout(function(){
    	if(!lock) {
	        var x = parseX(this.id);
	        var y = parseY(this.id);
	        if (board[y][x] == 0 || board[y][x] == -1) {
	            $('#' + this.id).css('background-image', "url(\'images/Points/square.png\')");
	        }
    	}
    });
    
    board = createMatrix();
    
    
    if (userType == "client") 
        lock = true;
    
    socket.onopen = function(){
    
        console.log("open socket");
        
        var userInfo = {
            "type": "userInfo",
            "userType": userType,
            "gameId": gameId
        };
        socket.send(JSON.stringify(userInfo));
        
        var initialize = {
            "type": "initialize",
            "userType": userType,
            "gameId": gameId
        };
        socket.send(JSON.stringify(initialize));
        
    };
    
});



socket.onmessage = function(event){

    console.log(event.data);
    
    var msg = JSON.parse(event.data);
    
    switch (msg.type) {
    
        case "clientConnect":
            $('#pts_player_label_1 > label').text(msg.serverName);
            $('#pts_player_label_2 > label').text(msg.clientName);
            $('#pts_player2_img').css('visibility', 'visible');
            waitForClient = false;
            break;
            
        case "serverConnect":
            $('#player_label_1 > label').text(msg.serverName);
            break;
            
        case "lastChanges":
            if (msg.userType == "server") {
                $('#' + msg.coords + ' > img').attr('src', getRandomPoint("client"));
                lock = msg.serverLock;
                var x = parseX(msg.coords);
                var y = parseY(msg.coords);
                board[y][x] = 1;
            }
            else 
                if (msg.userType == "client") {
                    $('#' + msg.coords + ' > img').attr('src', getRandomPoint("server"));
                    lock = msg.clientLock;
                    var x = parseX(msg.coords);
                    var y = parseY(msg.coords);
                    board[y][x] = 2;
                }
            
            break;
            
        case "initialize":
            
            var matrix = createMatrix();
            matrix = msg.matrix;
            
            if (userType == "server") {
                lock = msg.serverLock;
            }
            else 
                if (userType == "client") {
                    lock = msg.clientLock;
                }
            
            for (var i = 0; i < y_length; i++) {
            
                for (var j = 0; j < x_length; j++) {
                    if (matrix[i][j] == -11 || matrix[i][j] == 11 || matrix[i][j] == 10) 
                        board[i][j] = 1;
                    else 
                        if (matrix[i][j] == -12 || matrix[i][j] == 22 || matrix[i][j] == 20) 
                            board[i][j] = 2;
                        else 
                            board[i][j] = matrix[i][j];
                }
            }
            $('#pts_player_label_1 > label').text(msg.serverName);
            $('#pts_player_label_2 > label').text(msg.clientName);
            $('#pts_player1_score > label').text("score : " + msg.serverScore);
            $('#pts_player2_score > label').text("score : " + msg.clientScore);
            
            if ($('#pts_player_label_2 > label').text() != "") {
            
                $('#pts_player2_img').css('visibility', 'visible');
                waitForClient = false;
            }
            
            putPoints();
            
            paintContour(msg.contoursServer, contourBoard, "server");
            paintContour(msg.contoursClient, contourBoard, "client");
            break;
            
        case "countur":
            console.log(msg);
            
            var usType = msg.userType;
            
            var contourBoard = createMatrix();
            contourBoard = msg.matrix;
            
            var contourCoords = createMatrix();
            contourCoords = msg.lastCounturs;
            initializeBoard(contourBoard);
            
            $('#pts_player1_score > label').text("score : " + msg.serverScore);
            $('#pts_player2_score > label').text("score : " + msg.clientScore);
            
            
            paintContour(contourCoords, contourBoard, usType);
            
            break;
    }
    
};


function initializeBoard(matrix){
    for (var i = 0; i < matrix.length; i++) {
    
        for (var j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 11 || matrix[i][j] == -11) 
                board[i][j] = 1;
            else 
                if (matrix[i][j] == 22 || matrix[i][j] == -12) 
                    board[i][j] = 2;
                else 
                    board[i][j] = matrix[i][j];
        }
    }
    console.log("BOARD!!!!!!!!!!!!!!!!!" + board);
}

function putPoints(){
    for (var i = 0; i < y_length; i++) {
        for (var j = 0; j < x_length; j++) {
            if (board[i][j] == 1) {
                $('#X' + j + 'Y' + i + ' > img').attr('src', getRandomPoint("server"));
            }
            else 
                if (board[i][j] == 2) {
                    $('#X' + j + 'Y' + i + ' > img').attr('src', getRandomPoint("client"));
                }
        }
    }
    
}

function createMatrix(){
    var board = new Array();
    for (var i = 0; i < y_length; i++) {
        board[i] = new Array();
        for (var j = 0; j < x_length; j++) {
            board[i][j] = 0;
        }
    }
    return board;
}

function putPoint(td_point){

    if (lock == true) {
        alert("not your move");
        return;
    }
    console.log(waitForClient);
    if (waitForClient == true) {
    
        alert("wait for client");
        
    }
    else {
    
        var x = parseX(td_point.id);
        var y = parseY(td_point.id);
        console.log(board[y][x]);

        if (board[y][x] == 0) {
            if (userType == "server") {
                $('#' + td_point.id + ' > img').attr('src', getRandomPoint(userType));
                board[y][x] = 1;
            }
            else {
                $('#' + td_point.id + ' > img').attr('src', getRandomPoint(userType));
                board[y][x] = 2;
            }
            
			if (!isEndOfGame()) {
				var coords = {
					"type": "lastChanges",
					"userType": userType,
					"gameId": gameId,
					"coords": td_point.id
				};
				var sendCoords = JSON.stringify(coords);
				socket.send(sendCoords);
				lock = true;
			} else {
				
				goTo('PointsEndGame.html');
			}
            
        }
        else 
            alert("there is already a point there");
        
    }
}

function isEndOfGame() {
	
	for (var i = 0; i < y_length; i++) {
		for (var j = 0; j < x_length; j++) {
			if (board[i][j] == 0)
				return false;
		}
	}
	
	return true;
}

function getRandomPoint(usType){

    var random = Math.floor((Math.random() * 4) + 1);
    
    if (usType === "server") {
    
        return ('images/Points/server_point-' + random + '.png');
    }
    else {
    
        return ('images/Points/client_point-' + random + '.png');
    }
}

function parseX(strPoint){

    var indexY = strPoint.indexOf('Y');
    return strPoint.substring(1, indexY);
}

function parseY(strPoint){

    var indexY = strPoint.indexOf('Y');
    return strPoint.substring(indexY + 1);
}

function paintContour(contoursCoords, pointsBoard, usType){

    var contourCoords = createMatrix();
    contourCoords = contoursCoords;
    
    var c = document.getElementById("pts_canvas");
    var ctx = c.getContext("2d");
    
    ctx.lineWidth = 8;
    
    
    if (usType === "server") {
        ctx.strokeStyle = '#2f2d33';
        ctx.fillStyle = '#676767';
    }
    else {
        ctx.strokeStyle = '#3904ba';
        ctx.fillStyle = '#686fd2';
    }
    
    for (var j = 0; j < contourCoords.length; j++) {
        ctx.beginPath();
        var coord = new Array();
        coord[0] = -1;
        coord[1] = -1;
        
        for (var i = 0; i < contourCoords[j].length; i = i + 2) {
        
            if (coord[0] != -1) {
            
                ctx.lineTo(contourCoords[j][i + 1] * 21.6 + 13, contourCoords[j][i] * 26.35 + 16);
                
                
            }
            else {
                coord[0] = contourCoords[j][i] * 26.35 + 16;
                coord[1] = contourCoords[j][i + 1] * 21.6 + 13;
                ctx.moveTo(coord[1], coord[0]);
            }
            
        }
        ctx.lineTo(coord[1], coord[0]);
        ctx.closePath();
        ctx.stroke();
        ctx.fill();
    }
    
    
    //		ctx.m1oveTo(coord[1], coord[0]);
    //		ctx.lineTo(contourCoords[j][1] * 20 + 8, contourCoords[j][0] * 20 + 8);
    //		ctx.stroke();
    //        for (var i = 0; i < x_length-1; i ++) {
    //        	console.log(i);
    //        	if (i%2 == 0) {
    //        		ctx.strokeStyle = 'yellow';
    //        	} else {
    //        		ctx.strokeStyle = 'blue';
    //        	}
    //        	 ctx.beginPath();
    //        ctx.moveTo( i*21.6+12,500);
    //        ctx.lineTo( (i+1)*21.6+12,500);
    //        ctx.closePath();
    //        ctx.stroke();
    //        
    //    }
}

//
// var first_y = contourCoords[j][0];
// var first_x = contourCoords[j][1];
//
// markNeighborCoords(pointsBoard, first_y, first_x, first_y - 1, first_x - 1,
// pointMarked, ctx);
// markNeighborCoords(pointsBoard, first_y, first_x, first_y - 1, first_x,
// pointMarked, ctx);
// markNeighborCoords(pointsBoard, first_y, first_x, first_y - 1, first_x + 1,
// pointMarked, ctx);
// markNeighborCoords(pointsBoard, first_y, first_x, first_y, first_x + 1,
// pointMarked, ctx);
// markNeighborCoords(pointsBoard, first_y, first_x, first_y + 1, first_x + 1,
// pointMarked, ctx);
// markNeighborCoords(pointsBoard, first_y, first_x, first_y + 1, first_x,
// pointMarked, ctx);
// markNeighborCoords(pointsBoard, first_y, first_x, first_y + 1, first_x - 1,
// pointMarked, ctx);
// markNeighborCoords(pointsBoard, first_y, first_x, first_y, first_x - 1,
// pointMarked, ctx);
// }
// }
//
// function markNeighborCoords(board, first_y, first_x, neighbor_y, neighbor_x,
// pointMarked, ctx) {
//
// if (board[neighbor_y][neighbor_x] == pointMarked) {
//
// ctx.moveTo(first_x * 20 + 8, first_y * 20 + 8);
// ctx.lineTo(neighbor_x * 20 + 8, neighbor_y * 20 + 8);
// ctx.stroke();
// }
// }
// function waitForFirstMove() {
// changes = setInterval(getChanges, 1000);
// }
//
// function waitForClient() {
// $.get("WaitingForClient.html", function(response) {
// if (response == '') {
// $('#player_label_2 > label').text("WAITING");
// } else {
// $('#player_label_2 > label').text(response);
// clearInterval(waitingForClient);
// }
// });
// }
//
// function check() {
// $.get("PointCheck.html", function(lastChanges) {
//
// });
// }
// function put(td_point) {
//
// $.post("PointPut.html", {
// point_xy : td_point.id
// }, function(response) {
// if (response == 'server') {
// $('#' + td_point.id + ' > img').attr('src',
// 'images/Points/point1.png');
// } else {
// $('#' + td_point.id + ' > img').attr('src',
// 'images/Points/point2.png');
// }
// });
// console.log("waiting for changes");
// changes = setInterval(getChanges, 1000);
//
// }
//
// function getChanges() {
//
// $.get("PointsGetChanges.html", function(lastChanges) {
// if (lastChanges.coordsOfChanges != 'none') {
//
// if (lastChanges.userThatChanged == 'server') {
//
// $('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
// 'images/Points/point1.png');
//
// } else {
//
// $('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
// 'images/Points/point2.png');
//
// }
// clearInterval(changes);
// }
//
// });
//
// }
//
// function putPoint(td_point) {
//
// $.get("PointCheckMove.html", function(boolMove) {
// if (boolMove == false) {
// alert("not your move");
// } else {
// put(td_point);
// }
// });
//
// }