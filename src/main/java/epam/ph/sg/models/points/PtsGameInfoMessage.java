package epam.ph.sg.models.points;

import java.util.ArrayList;
import java.util.List;

public class PtsGameInfoMessage {

	private int COUNT_Y = 26;
	private int COUNT_X = 22;
	private String type;
	private String clientName;
	private String serverName;
	private boolean serverLock;
	private boolean clientLock;
	public List<Integer> b0 = new ArrayList<Integer>(22);
	public List<Integer> b1 = new ArrayList<Integer>(22);
	public List<Integer> b2 = new ArrayList<Integer>(22);
	public List<Integer> b3 = new ArrayList<Integer>(22);
	public List<Integer> b4 = new ArrayList<Integer>(22);
	public List<Integer> b5 = new ArrayList<Integer>(22);
	public List<Integer> b6 = new ArrayList<Integer>(22);
	public List<Integer> b7 = new ArrayList<Integer>(22);
	public List<Integer> b8 = new ArrayList<Integer>(22);
	public List<Integer> b9 = new ArrayList<Integer>(22);
	public List<Integer> b10 = new ArrayList<Integer>(22);
	public List<Integer> b11 = new ArrayList<Integer>(22);
	public List<Integer> b12 = new ArrayList<Integer>(22);
	public List<Integer> b13 = new ArrayList<Integer>(22);
	public List<Integer> b14 = new ArrayList<Integer>(22);
	public List<Integer> b15 = new ArrayList<Integer>(22);
	public List<Integer> b16 = new ArrayList<Integer>(22);
	public List<Integer> b17 = new ArrayList<Integer>(22);
	public List<Integer> b18 = new ArrayList<Integer>(22);
	public List<Integer> b19 = new ArrayList<Integer>(22);
	public List<Integer> b20 = new ArrayList<Integer>(22);
	public List<Integer> b21 = new ArrayList<Integer>(22);
	public List<Integer> b22 = new ArrayList<Integer>(22);
	public List<Integer> b23 = new ArrayList<Integer>(22);
	public List<Integer> b24 = new ArrayList<Integer>(22);
	public List<Integer> b25 = new ArrayList<Integer>(22);
	
	public List<List<Integer>> matrix;
	
	PtsGameInfoMessage() {

		matrix = new ArrayList<List<Integer>>();
		matrix.add(b0);
		matrix.add(b1);
		matrix.add(b2);
		matrix.add(b3);
		matrix.add(b4);
		matrix.add(b5);
		matrix.add(b6);
		matrix.add(b7);
		matrix.add(b8);
		matrix.add(b9);
		matrix.add(b10);
		matrix.add(b11);
		matrix.add(b12);
		matrix.add(b13);
		matrix.add(b14);
		matrix.add(b15);
		matrix.add(b16);
		matrix.add(b17);
		matrix.add(b18);
		matrix.add(b19);
		matrix.add(b20);
		matrix.add(b21);
		matrix.add(b22);
		matrix.add(b23);
		matrix.add(b24);
		matrix.add(b25);
		
		type = "initialize";
		clientName = "none";
		serverName = "none";
		serverLock = true;
		clientLock = true;
	}
	
	

	public void initializeBoard(int[][] board) {
		for (int i = 0; i < COUNT_Y; i++) {
			for (int j = 0; j < COUNT_X; j++) {
				matrix.get(i).add(board[i][j]);
			}
		}
	}
	
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getServerName() {
		return serverName;
	}


	public void setServerName(String serverName) {
		this.serverName = serverName;
	}


	public boolean isServerLock() {
		return serverLock;
	}


	public void setServerLock(boolean serverLock) {
		this.serverLock = serverLock;
	}


	public boolean isClientLock() {
		return clientLock;
	}


	public void setClientLock(boolean clientLock) {
		this.clientLock = clientLock;
	}


	public List<Integer> getB0() {
		return b0;
	}


	public void setB0(List<Integer> b0) {
		this.b0 = b0;
	}


	public List<Integer> getB1() {
		return b1;
	}


	public void setB1(List<Integer> b1) {
		this.b1 = b1;
	}


	public List<Integer> getB2() {
		return b2;
	}


	public void setB2(List<Integer> b2) {
		this.b2 = b2;
	}


	public List<Integer> getB3() {
		return b3;
	}


	public void setB3(List<Integer> b3) {
		this.b3 = b3;
	}


	public List<Integer> getB4() {
		return b4;
	}


	public void setB4(List<Integer> b4) {
		this.b4 = b4;
	}


	public List<Integer> getB5() {
		return b5;
	}


	public void setB5(List<Integer> b5) {
		this.b5 = b5;
	}


	public List<Integer> getB6() {
		return b6;
	}


	public void setB6(List<Integer> b6) {
		this.b6 = b6;
	}


	public List<Integer> getB7() {
		return b7;
	}


	public void setB7(List<Integer> b7) {
		this.b7 = b7;
	}


	public List<Integer> getB8() {
		return b8;
	}


	public void setB8(List<Integer> b8) {
		this.b8 = b8;
	}


	public List<Integer> getB9() {
		return b9;
	}


	public void setB9(List<Integer> b9) {
		this.b9 = b9;
	}


	public List<Integer> getB10() {
		return b10;
	}


	public void setB10(List<Integer> b10) {
		this.b10 = b10;
	}


	public List<Integer> getB11() {
		return b11;
	}


	public void setB11(List<Integer> b11) {
		this.b11 = b11;
	}


	public List<Integer> getB12() {
		return b12;
	}


	public void setB12(List<Integer> b12) {
		this.b12 = b12;
	}


	public List<Integer> getB13() {
		return b13;
	}


	public void setB13(List<Integer> b13) {
		this.b13 = b13;
	}


	public List<Integer> getB14() {
		return b14;
	}


	public void setB14(List<Integer> b14) {
		this.b14 = b14;
	}


	public List<Integer> getB15() {
		return b15;
	}


	public void setB15(List<Integer> b15) {
		this.b15 = b15;
	}


	public List<Integer> getB16() {
		return b16;
	}


	public void setB16(List<Integer> b16) {
		this.b16 = b16;
	}


	public List<Integer> getB17() {
		return b17;
	}


	public void setB17(List<Integer> b17) {
		this.b17 = b17;
	}


	public List<Integer> getB18() {
		return b18;
	}


	public void setB18(List<Integer> b18) {
		this.b18 = b18;
	}


	public List<Integer> getB19() {
		return b19;
	}


	public void setB19(List<Integer> b19) {
		this.b19 = b19;
	}


	public List<Integer> getB20() {
		return b20;
	}


	public void setB20(List<Integer> b20) {
		this.b20 = b20;
	}


	public List<Integer> getB21() {
		return b21;
	}


	public void setB21(List<Integer> b21) {
		this.b21 = b21;
	}


	public List<Integer> getB22() {
		return b22;
	}


	public void setB22(List<Integer> b22) {
		this.b22 = b22;
	}


	public List<Integer> getB23() {
		return b23;
	}


	public void setB23(List<Integer> b23) {
		this.b23 = b23;
	}


	public List<Integer> getB24() {
		return b24;
	}


	public void setB24(List<Integer> b24) {
		this.b24 = b24;
	}


	public List<Integer> getB25() {
		return b25;
	}


	public void setB25(List<Integer> b25) {
		this.b25 = b25;
	}


	
}
