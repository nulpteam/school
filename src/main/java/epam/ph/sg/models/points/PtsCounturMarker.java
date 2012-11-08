package epam.ph.sg.models.points;

/**
 * @author Kostya Skromnuy
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

public class PtsCounturMarker {

	private static Logger logger = Logger.getLogger(PtsCounturMarker.class);

	private List<PtsCoord> clockwisePtsCoords = new ArrayList<PtsCoord>();
	private List<PtsCoord> counturPtsCoords = new ArrayList<PtsCoord>();

	private int[][] matrix;
	private int point_y;
	private int point_x;
	private boolean clockwiseCounturFound = false;

	private int userPointUnmarked;
	private int userPointMarked;
	private int rivalPointUnmarked;
	private int rivalPointMarked;

	public PtsCounturMarker() {

	}

	public boolean markCountur(int[][] mas, int y, int x, String userType) {

		matrix = mas;
		this.point_y = y;
		this.point_x = x;

		boolean resultOfMarking = false;

		counturPtsCoords.clear();

		if (userType.equals(PtsResources.getProperty("user.type.server"))) {
			userPointUnmarked = Pts.SERVER_UNMARKED_POINT;
			userPointMarked = Pts.SERVER_MARKED_POINT;
			rivalPointMarked = Pts.CLIENT_MARKED_POINT;
			rivalPointUnmarked = Pts.CLIENT_UNMARKED_POINT;
		} else if (userType
				.equals(PtsResources.getProperty("user.type.client"))) {
			userPointUnmarked = Pts.CLIENT_UNMARKED_POINT;
			userPointMarked = Pts.CLIENT_MARKED_POINT;
			rivalPointMarked = Pts.SERVER_MARKED_POINT;
			rivalPointUnmarked = Pts.SERVER_UNMARKED_POINT;
		} else {
			logger.error(PtsResources
					.getProperty("error.user_type.don't_exist") + userType);
		}

		for (int i = 0; i < 4; i++) {

			clockwisePtsCoords.add(new PtsCoord(y, x));

			if (i == 0)
				clockwise(y, x, new PtsCoord(y - 1, x));
			else if (i == 1)
				clockwise(y, x, new PtsCoord(y, x + 1));
			else if (i == 2)
				clockwise(y, x, new PtsCoord(y + 1, x));
			else if (i == 3)
				clockwise(y, x, new PtsCoord(y, x - 1));

			if (clockwiseCounturFound) {
				resultOfMarking = true;
				for (int j = 0; j < clockwisePtsCoords.size(); j++) {
					if (!isCoordInList(clockwisePtsCoords.get(j), counturPtsCoords))
						counturPtsCoords.add(clockwisePtsCoords.get(j));
				}
				clockwisePtsCoords.clear();
			}

			clockwiseCounturFound = false;

		}

		Iterator<PtsCoord> it = counturPtsCoords.iterator();
		while (it.hasNext()) {
			PtsCoord PtsCoord = it.next();
			mas[PtsCoord.getY()][PtsCoord.getX()] = userPointMarked;
		}

		markRivalPointsInsideCountur(mas);

		return resultOfMarking;

	}

	public List<PtsCoord> getCounturPtsCoords() {
		return counturPtsCoords;
	}

	private void clockwise(int y, int x, PtsCoord beginIteration) {

		int iterationIndex = getIterationClockwiseIndex(beginIteration,
				new PtsCoord(y, x));
		iterateClockwise(iterationIndex, new PtsCoord(y, x));
	}

	private void iterateClockwise(int iterationIndex, PtsCoord pointPtsCoord) {

		PtsCoord currentPtsCoord = getIterationPtsCoords(iterationIndex,
				pointPtsCoord);
		if (checkAllConditionsClockwise(currentPtsCoord)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX(), pointPtsCoord);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, pointPtsCoord);
		if (checkAllConditionsClockwise(currentPtsCoord)) {
			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX(), pointPtsCoord);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, pointPtsCoord);
		if (checkAllConditionsClockwise(currentPtsCoord)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX(), pointPtsCoord);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, pointPtsCoord);
		if (checkAllConditionsClockwise(currentPtsCoord)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX(), pointPtsCoord);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, pointPtsCoord);
		if (checkAllConditionsClockwise(currentPtsCoord)) {
			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX(), pointPtsCoord);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, pointPtsCoord);
		if (checkAllConditionsClockwise(currentPtsCoord)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX(), pointPtsCoord);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, pointPtsCoord);
		if (checkAllConditionsClockwise(currentPtsCoord)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX(), pointPtsCoord);

		}

		if (clockwiseCounturFound)
			return;
		else {
			clockwisePtsCoords.remove(clockwisePtsCoords.size() - 1);
		}

	}

	private PtsCoord getIterationPtsCoords(int iteration, PtsCoord pointPtsCoord) {

		if (iteration == 1) {
			return new PtsCoord(pointPtsCoord.getY() - 1,
					pointPtsCoord.getX() - 1);
		}

		if (iteration == 2) {
			return new PtsCoord(pointPtsCoord.getY() - 1, pointPtsCoord.getX());
		}

		if (iteration == 3) {
			return new PtsCoord(pointPtsCoord.getY() - 1,
					pointPtsCoord.getX() + 1);
		}

		if (iteration == 4) {
			return new PtsCoord(pointPtsCoord.getY(), pointPtsCoord.getX() + 1);
		}

		if (iteration == 5) {
			return new PtsCoord(pointPtsCoord.getY() + 1,
					pointPtsCoord.getX() + 1);
		}

		if (iteration == 6) {
			return new PtsCoord(pointPtsCoord.getY() + 1, pointPtsCoord.getX());
		}

		if (iteration == 7) {
			return new PtsCoord(pointPtsCoord.getY() + 1,
					pointPtsCoord.getX() - 1);
		}

		if (iteration == 8) {
			return new PtsCoord(pointPtsCoord.getY(), pointPtsCoord.getX() - 1);
		}

		logger.error(PtsResources
				.getProperty("error.iteration.number.don't_exist") + iteration);
		return new PtsCoord(-1, -1);
	}

	private int incrementIterationIndex(int iterationIndex) {

		iterationIndex++;
		if (iterationIndex == 9) {
			iterationIndex = 1;
		}

		return iterationIndex;
	}

	private int getIterationClockwiseIndex(PtsCoord iterationPoint,
			PtsCoord point) {

		if (point.getY() - 1 == iterationPoint.getY()
				&& point.getX() - 1 == iterationPoint.getX())
			return 2;
		if (point.getY() - 1 == iterationPoint.getY()
				&& point.getX() == iterationPoint.getX())
			return 3;
		if (point.getY() - 1 == iterationPoint.getY()
				&& point.getX() + 1 == iterationPoint.getX())
			return 4;
		if (point.getY() == iterationPoint.getY()
				&& point.getX() + 1 == iterationPoint.getX())
			return 5;
		if (point.getY() + 1 == iterationPoint.getY()
				&& point.getX() + 1 == iterationPoint.getX())
			return 6;
		if (point.getY() + 1 == iterationPoint.getY()
				&& point.getX() == iterationPoint.getX())
			return 7;
		if (point.getY() + 1 == iterationPoint.getY()
				&& point.getX() - 1 == iterationPoint.getX())
			return 8;
		if (point.getY() == iterationPoint.getY()
				&& point.getX() - 1 == iterationPoint.getX())
			return 1;

		logger.error(PtsResources
				.getProperty("error.iteration.coord.don't_exist")
				+ iterationPoint);
		return 0;
	}

	private boolean checkAllConditionsClockwise(PtsCoord pointPtsCoord) {

		int y = pointPtsCoord.getY();
		int x = pointPtsCoord.getX();

		if (!clockwiseCounturFound
				&& y >= 0
				&& x >= 0
				&& y < Pts.Y_LENGTH
				&& x < Pts.X_LENGTH
				&& !isPointAlreadyDefinedClockwise(y, x)
				&& (matrix[y][x] == userPointUnmarked || matrix[y][x] == userPointMarked))
			return true;

		return false;
	}

	private boolean isEndPointClockwise(int y, int x) {

		if (y == point_y && x == point_x) {
			clockwiseCounturFound = true;
			return true;
		}

		return false;
	}

	private boolean isPointAlreadyDefinedClockwise(int y, int x) {

		for (int i = 1; i < clockwisePtsCoords.size(); i++) {
			if (clockwisePtsCoords.get(i).getX() == x
					&& clockwisePtsCoords.get(i).getY() == y)
				return true;
		}
		return false;
	}

	private void nextIterationClockwise(int y, int x, PtsCoord pointBefore) {

		PtsCoord coord = new PtsCoord(y, x);
		clockwisePtsCoords.add(coord);
		clockwise(y, x, pointBefore);
		return;
	}
	
	private boolean isCoordInList(PtsCoord coord, List<PtsCoord> coords) {
		
		for (int i = 0; i < coords.size(); i++) {
			if (coords.get(i).getY() == coord.getY()
					&& coords.get(i).getX() == coord.getX())
				return true;
		}
		
		return false;
	}

	private void markRivalPointsInsideCountur(int[][] mas) {

		List<PtsCoord> x_coords = getCoordinatesInsideXVectors(mas);
		List<PtsCoord> y_coords = getCoordinatesInsideYVectors(mas);
		Set<PtsCoord> res_coords = new HashSet<PtsCoord>();

		for (int i = 0; i < x_coords.size(); i++) {
			boolean common = false;
			for (int j = 0; j < y_coords.size(); j++) {
				if (x_coords.get(i).equals(y_coords.get(j)))
					common = true;
			}
			if (common)
				res_coords.add(x_coords.get(i));
		}

		Iterator<PtsCoord> it = res_coords.iterator();
		while (it.hasNext()) {
			PtsCoord coord = it.next();
			mas[coord.getY()][coord.getX()] = mas[coord.getY()][coord.getX()] * 10;
		}

	}

	private List<PtsCoord> getCoordinatesInsideXVectors(int[][] mas) {

		List<PtsCoord> coordListX = new ArrayList<PtsCoord>();

		for (int y = 0; y < Pts.Y_LENGTH; y++) {

			int first_x = -1;
			int last_x = -1;

			for (int x = 0; x < Pts.X_LENGTH; x++) {

				if (mas[y][x] == userPointMarked && first_x != -1)
					last_x = x;
				if (mas[y][x] == userPointMarked && first_x == -1)
					first_x = x;
			}

			if (first_x != -1 && last_x != -1) {
				System.out.println(first_x + "-" + last_x);
				for (int l = first_x; l <= last_x; l++) {
					if (mas[y][l] == rivalPointUnmarked
							|| mas[y][l] == rivalPointMarked
							|| mas[y][l] == userPointUnmarked)
						coordListX.add(new PtsCoord(y, l));
				}

			}
		}

		return coordListX;
	}

	private List<PtsCoord> getCoordinatesInsideYVectors(int[][] mas) {

		List<PtsCoord> coordListY = new ArrayList<PtsCoord>();

		for (int x = 0; x < Pts.X_LENGTH; x++) {

			int first_y = -1;
			int last_y = -1;

			for (int y = 0; y < Pts.Y_LENGTH; y++) {

				if (mas[y][x] == userPointMarked && first_y != -1)
					last_y = y;
				if (mas[y][x] == userPointMarked && first_y == -1) {
					first_y = y;
				}
			}
			if (first_y != -1 && last_y != -1) {

				for (int l = first_y; l <= last_y; l++) {
					if (mas[l][x] == rivalPointUnmarked
							|| mas[l][x] == rivalPointMarked
							|| mas[l][x] == userPointUnmarked)
						coordListY.add(new PtsCoord(l, x));
				}

			}
		}

		return coordListY;
	}

}
