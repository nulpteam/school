/**
 * 
 */
package epam.ph.sg.models.infection;




/**
 * @author roman
 *
 */
public class InfGameBoard {


	public static int[][] changeBoard(int[][] board, InfClientMessage message,int fmX,int fmY) {

		if (message.getMoveType().equals("server")){
			if (message.getNullcoord()==3){
				board[message.getXcoord()][message.getYcoord()] = 1;
				board[fmX][fmY] = 0;
				board = infectEnemies(board, message);
				return board;
			}else{
				board[message.getXcoord()][message.getYcoord()] = 1;
				board[fmX][fmY] = 1;
				board = infectEnemies(board, message);
			}
		}
		if (message.getMoveType().equals("client")){
			if (message.getNullcoord()==3){
				board[message.getXcoord()][message.getYcoord()] = 2;
				board[fmX][fmY] = 0;
				board = infectEnemies(board, message);
				return board;
			}else{
				board[message.getXcoord()][message.getYcoord()] = 2;
				board[fmX][fmY] = 2;
				board = infectEnemies(board, message);
			}
		}
		return board;
	}

	public static InfClientMessage validateFirstMove(int[][] board, InfClientMessage message){

		if ( message.getMoveType().equals("server") ){
			if ( board[message.getXcoord()][message.getYcoord()] == 1 ){
				message.setType("rightFirstMove");
				board = lightFields(board, message);
				message.setBoard(board);
			}
			else{
				System.out.println("You CANT DO IT");
				message.setType("wrongFirstMove");
			}
		}

		if ( message.getMoveType().equals("client") ){
			if ( board[message.getXcoord()][message.getYcoord()] == 2 ){
				message.setType("rightFirstMove");
				board = lightFields(board, message);
				message.setBoard(board);
			}
			else{
				System.out.println("You CANT DO IT");
				message.setType("wrongFirstMove");
			}
		}

		return message;
	}
	public static InfClientMessage validateSecondMove(int[][] board,InfClientMessage message,int fmX,int fmY,String id){
		board = cleandLightFields(board, message);
		
		if ((message.getXcoord() == fmX ) & (message.getYcoord() == fmY)){
			message.setType("cancelFirstMove");
			message.setBoard(board);
			return message;
		}

		if ( message.getMoveType().equals("server") ){
			if ( board[message.getXcoord()][message.getYcoord()] == 0){
				if ( isFieldNearBy5x5(message, fmX, fmY) ){
					if ( isFieldNearBy5x5(message, fmX, fmY) == true & isFieldNearBy3x3(message, fmX, fmY) == false ){
						message.setNullcoord(3);
						message.setType("rightSecondMove");
						changeBoard(board, message, fmX, fmY);
						message.setBoard(board);
						message.setServerScore(countServerScore(board));
						message.setClientScore(countClientScore(board));
						if ( isNoEmptyFieldsLeft(board) || isNoServerChipsLeft(board) || isNoClientChipsLeft(board) ){
							if ( countServerScore(board) > countClientScore(board)  ){
								message.setType("serverWin");
							}else{
								message.setType("clientWin");
							}
							InfGameMap.deleteGame(id);
						}
						return message;
					}
					message.setType("rightSecondMove");
					changeBoard(board, message,fmX,fmY);
					message.setBoard(board);
					message.setServerScore(countServerScore(board));
					message.setClientScore(countClientScore(board));
					if (isNoEmptyFieldsLeft(board) || isNoServerChipsLeft(board) || isNoClientChipsLeft(board)){
						if ( countServerScore(board) > countClientScore(board) ){
							message.setType("serverWin");
						}else{
							message.setType("clientWin");
						}
						InfGameMap.deleteGame(id);
					}
				}
				else{
					message.setType("wrongSecondMove");
				}
			}
			else{
				message.setType("wrongSecondMove");
			}
		}
		if ( message.getMoveType().equals("client") ){
			if ( board[message.getXcoord()][message.getYcoord()] == 0){
				if ( isFieldNearBy5x5(message, fmX, fmY) ){
					if ( isFieldNearBy5x5(message, fmX, fmY) == true & isFieldNearBy3x3(message, fmX, fmY) == false ){
						message.setNullcoord(3);
						message.setType("rightSecondMove");
						changeBoard(board, message, fmX, fmY);
						message.setBoard(board);
						message.setServerScore(countServerScore(board));
						message.setClientScore(countClientScore(board));
						if (isNoEmptyFieldsLeft(board) || isNoServerChipsLeft(board) || isNoClientChipsLeft(board)){
							if ( countServerScore(board) > countClientScore(board) ){
								message.setType("serverWin");
							}else{
								message.setType("clientWin");
							}
							InfGameMap.deleteGame(id);
						}
						return message;
					}
					message.setType("rightSecondMove");
					changeBoard(board, message, fmX, fmY);
					message.setBoard(board);
					message.setServerScore(countServerScore(board));
					message.setClientScore(countClientScore(board));
					if (isNoEmptyFieldsLeft(board) || isNoServerChipsLeft(board) || isNoClientChipsLeft(board)){
						if ( countServerScore(board) > countClientScore(board) ){
							message.setType("serverWin");
						}else{
							message.setType("clientWin");
						}
						InfGameMap.deleteGame(id);
					}

				}
				else{
					message.setType("wrongSecondMove");
				}
			}else{
				message.setType("wrongSecondMove");
			}
		}
		return message;
	}

	private static boolean isFieldNearBy3x3(InfClientMessage message,int fmX,int fmY){
		int fmXcoord = fmX;
		int fmYcoord = fmY;

		System.out.println("fX:"+fmXcoord+"fY:"+fmYcoord);

		int curXcoord = message.getXcoord();
		int curYcoord = message.getYcoord();
		System.out.println("cX:"+curXcoord+"cY:"+curYcoord);

		if ( (curXcoord == fmXcoord ||  curXcoord == fmXcoord-1 || curXcoord == fmXcoord+1) &
				(curYcoord == fmYcoord ||  curYcoord == fmYcoord-1 || curYcoord == fmYcoord+1)){
			return true;
		}
		else{
			return false;
		}
	}

	private static boolean isFieldNearBy5x5(InfClientMessage message,int fmX,int fmY){
		int fmXcoord = fmX;
		int fmYcoord = fmY;

		System.out.println("fX:"+fmXcoord+"fY:"+fmYcoord);

		int curXcoord = message.getXcoord();
		int curYcoord = message.getYcoord();
		System.out.println("cX:"+curXcoord+"cY:"+curYcoord);

		if ( (curXcoord == fmXcoord ||  curXcoord == fmXcoord-2 || curXcoord == fmXcoord+2 ||  curXcoord == fmXcoord-1 || curXcoord == fmXcoord+1) &
				(curYcoord == fmYcoord ||  curYcoord == fmYcoord-2 || curYcoord == fmYcoord+2 ||  curYcoord == fmYcoord-1 || curYcoord == fmYcoord+1)){
			return true;
		}
		else{
			return false;
		}
	}

	private static int[][] infectEnemies(int[][] board,InfClientMessage message){

		int xcoord = message.getXcoord();
		int ycoord = message.getYcoord();
		if (message.getMoveType().equals("server")){

			for ( int i = 0 ; i <= 6; i++){
				for (int j = 0; j <=6 ; j++){
					if ( ((i >= xcoord-1)&(i<=xcoord+1)) & ((j >= ycoord-1)&(j<=ycoord+1)) ){
						if (board[i][j] == 2){
							board[i][j] = 1;
						}

					}
				}
			}	

		}
		if (message.getMoveType().equals("client")){
			for ( int i = 0 ; i <= 6; i++){
				for (int j = 0; j <=6 ; j++){
					if ( ((i >= xcoord-1)&(i<=xcoord+1)) & ((j >= ycoord-1)&(j<=ycoord+1)) ){
						if (board[i][j] == 1){
							board[i][j] = 2;
						}

					}
				}
			}
		}
		return board;
	}

	private static int countServerScore(int[][] board){
		int score=0;
		for ( int i = 0 ; i <= 6; i++){
			for (int j = 0; j <=6 ; j++){
				if (board[i][j] == 1){
					score++;
				}

			}
		}
		return score;
	}

	private static int countClientScore(int[][] board){
		int score=0;
		for ( int i = 0 ; i <= 6; i++){
			for (int j = 0; j <=6 ; j++){
				if (board[i][j] == 2){
					score++;
				}

			}
		}
		return score;
	}

	private static boolean isNoEmptyFieldsLeft(int[][] board){
		int score=0;
		for ( int i = 0 ; i <= 6; i++){
			for (int j = 0; j <=6 ; j++){
				if (board[i][j] == 0){
					score++;
				}

			}
		}

		if ( score == 0){
			return true;
		}else{
			return false;
		}

	}

	private static boolean isNoServerChipsLeft(int[][] board){
		int score=0;
		for ( int i = 0 ; i <= 6; i++){
			for (int j = 0; j <=6 ; j++){
				if (board[i][j] == 1){
					score++;
				}

			}
		}

		if ( score == 0){
			return true;
		}else{
			return false;
		}

	}

	private static boolean isNoClientChipsLeft(int[][] board){
		int score=0;
		for ( int i = 0 ; i <= 6; i++){
			for (int j = 0; j <=6 ; j++){
				if (board[i][j] == 2){
					score++;
				}

			}
		}

		if ( score == 0){
			return true;
		}else{
			return false;
		}

	}

	private static int[][] lightFields(int[][] board,InfClientMessage message){

		int xcoord = message.getXcoord();
		int ycoord = message.getYcoord();

		for ( int i = 0 ; i <= 6; i++){
			for (int j = 0; j <=6 ; j++){
				if ( ((i >= xcoord-2)&(i<=xcoord+2)) & ((j >= ycoord-2)&(j<=ycoord+2)) ){
					if (board[i][j] == 0){
						board[i][j] = 5;
					}

				}
			}
		}	

		return board;
	}

	private static int[][] cleandLightFields(int[][] board,InfClientMessage message){
		for ( int i = 0 ; i <= 6; i++){
			for (int j = 0; j <=6 ; j++){
				if (board[i][j] == 5){
					board[i][j] = 0;
				}
			}
		}
		return board;
	}



}
