package epam.ph.sg.models.points;

import java.util.Timer;
import java.util.TimerTask;

public class PtsTimer {

	private int time;
	private Timer timer;
	private final long DELAY = 1000;
	
	public PtsTimer() {
		time = 60;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void startTimer(final PtsGame game) {
		timer = new Timer();
		time = Integer.parseInt(game.getTimerState());
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				game.setTimerState(new Integer(time--).toString());

			}
		}, 0, DELAY);
	}
	
	public void stopTimer() {
		timer.cancel();
	}
	
	
}
