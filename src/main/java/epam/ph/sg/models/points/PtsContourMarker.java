package epam.ph.sg.models.points;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.theme.FixedThemeResolver;

public class PtsContourMarker {

	private Logger logger;
	private int first_point_y;
	private int first_point_x;
	private boolean clockwiseCounturFound = false;
	private int contourIdServer = 110;
	private int contourIdClient = 210;
	private Map<Integer, PtsContour> contourMap;

	// private int[][] logicBoard;

	// //private int[][] board;

	// private int userPointUnmarked;
	// private int userPointMarked;
	// private int rivalPointUnmarked;
	// private int rivalPointMarked;
	// private List<PtsCoord> pointsClockwiseUp;
	// private List<PtsCoord> pointsClockwiseRight;
	// private List<PtsCoord> pointsClockwiseDown;
	// private List<PtsCoord> pointsClockwiseLeft;

	// Set<Integer> aroundPointsSet;
	// Set<Integer> aroundContourPointsSet;

	public PtsContourMarker() {

		logger = Logger.getLogger(PtsCounturMarker.class);
		contourMap = new HashMap<Integer, PtsContour>();
		// logicBoard = new int[Pts.Y_LENGTH][Pts.X_LENGTH];
		// pointsClockwiseUp = new ArrayList<PtsCoord>();
		// pointsClockwiseRight = new ArrayList<PtsCoord>();
		// pointsClockwiseDown = new ArrayList<PtsCoord>();
		// pointsClockwiseLeft = new ArrayList<PtsCoord>();

		// initLogicBoard();
	}

	// public boolean markContour(int y, int x, int[][] board, String userType)
	// {
	//
	// this.first_point_y = y;
	// this.first_point_x = x;
	// this.board = board;
	//
	// pointsClockwiseUp.add(new PtsCoord(y, x));
	// pointsClockwiseRight.add(new PtsCoord(y, x));
	// pointsClockwiseDown.add(new PtsCoord(y, x));
	// pointsClockwiseLeft.add(new PtsCoord(y, x));
	//
	// setPointValues(userType);
	// System.out.println(!isPointInContour(y, x));
	// if (!isPointInContour(y, x)) {
	//
	// aroundPointsSet = getAllPointsAroundFirstPoint();
	// aroundContourPointsSet = getAllContourPointsAroundFirstPoint();
	// System.out.println(isPointValueInSet(aroundPointsSet,
	// userPointUnmarked));
	// if (isPointValueInSet(aroundPointsSet, userPointUnmarked)) {
	// Iterator<Integer> it = aroundPointsSet.iterator();
	// while (it.hasNext())
	// System.out.println(it.next());
	// for (int i = 0; i < 4; i++) {
	//
	// if (i == 0)
	// moveClockwise(y, x, new PtsCoord(y - 1, x),
	// pointsClockwiseUp);
	// else if (i == 1)
	// moveClockwise(y, x, new PtsCoord(y, x + 1),
	// pointsClockwiseLeft);
	// else if (i == 2)
	// moveClockwise(y, x, new PtsCoord(y + 1, x),
	// pointsClockwiseDown);
	// else if (i == 3)
	// moveClockwise(y, x, new PtsCoord(y, x - 1),
	// pointsClockwiseRight);
	//
	// }
	//
	// // TODO if (isContourEmpty(pointsClockwiseUp));
	//
	// } else {
	// return false;
	// }
	//
	// } else {
	// return false;
	// }
	//
	// System.out.println("UP");
	// for (int i = 0; i < pointsClockwiseUp.size(); i++) {
	// System.out.println(pointsClockwiseUp.get(i));
	// }
	//
	// pointsClockwiseUp.clear();
	// pointsClockwiseLeft.clear();
	// pointsClockwiseRight.clear();
	// pointsClockwiseDown.clear();
	//
	// return true;
	// }
	//

	// private boolean isContourPointAround(int y, int x) {
	//
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y - 1][x - 1]))
	// return true;
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y - 1][x]))
	// return true;
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y - 1][x + 1]))
	// return true;
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y][x + 1]))
	// return true;
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y + 1][x + 1]))
	// return true;
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y + 1][x]))
	// return true;
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y + 1][x - 1]))
	// return true;
	// if (isPointValueInSet(aroundContourPointsSet, logicBoard[y][x - 1]))
	// return true;
	//
	// return false;
	// }

	//
	// private boolean isPointInContour(int y, int x) {
	//
	// if (logicBoard[y][x] == Pts.POINT_IN_CONTOUR) {
	// return true;
	// }
	//
	// return false;
	// }

	// TODO private boolean isContourEmpty(List<PtsCoord> contourList) {
	//
	// }

	// private Set<Integer> getAllPointsAroundFirstPoint() {
	//
	// Set<Integer> aroundPointsList = new HashSet<Integer>();
	//
	// aroundPointsList.add(board[first_point_y - 1][first_point_x - 1]);
	//
	// return aroundPointsList;
	// }

	// private Set<Integer> getAllContourPointsAroundFirstPoint() {
	//
	// Set<Integer> aroundPointsList = new HashSet<Integer>();
	//
	// if (logicBoard[first_point_y - 1][first_point_x - 1] != -1) {
	// aroundPointsList
	// .add(logicBoard[first_point_y - 1][first_point_x - 1]);
	// }
	//
	// return aroundPointsList;
	//
	// }

	// private boolean isPointValueInSet(Set<Integer> aroundPoints, int
	// pointValue) {
	//
	// Iterator<Integer> iterator = aroundPoints.iterator();
	//
	// while (iterator.hasNext()) {
	// int value = iterator.next();
	// if (value == pointValue)
	// return true;
	// }
	//
	// return false;
	// }
	//
	// private boolean isPointInList(List<PtsCoord> list, int y, int x) {
	//
	// for (int i = 0; i < list.size(); i++) {
	// if (list.get(i).getY() == y && list.get(i).getX() == x)
	// return true;
	// }
	//
	// return false;
	// }

	// private void setPointValues(String userType) {
	//
	// if (userType.equals(PtsResources.getProperty("user.type.server"))) {
	// userPointUnmarked = Pts.SERVER_UNMARKED_POINT;
	// userPointMarked = Pts.SERVER_MARKED_POINT;
	// rivalPointMarked = Pts.CLIENT_MARKED_POINT;
	// rivalPointUnmarked = Pts.CLIENT_UNMARKED_POINT;
	// } else if (userType
	// .equals(PtsResources.getProperty("user.type.client"))) {
	// userPointUnmarked = Pts.CLIENT_UNMARKED_POINT;
	// userPointMarked = Pts.CLIENT_MARKED_POINT;
	// rivalPointMarked = Pts.SERVER_MARKED_POINT;
	// rivalPointUnmarked = Pts.SERVER_UNMARKED_POINT;
	// } else {
	// logger.error(PtsResources
	// .getProperty("error.user_type.don't_exist") + userType);
	// }
	// }

	public List<List<PtsCoord>> markContours(int[][] board, int[][] logicBoard,
			int y, int x, int pointsValue) {

		int[][] commonBoard = new int[Pts.Y_LENGTH][Pts.X_LENGTH];

		if (logicBoard[y][x] == Pts.POINT_IN_SERVER_CONTOUR
				|| logicBoard[y][x] == Pts.POINT_IN_CLIENT_CONTOUR) {

			board[y][x] = pointsValue * 10;
			logicBoard[y][x] = 0;
			return null;
		}

		int rivalPointsValue = 0;
		List<List<PtsCoord>> listOfContours = new ArrayList<List<PtsCoord>>();
		List<List<PtsCoord>> resultContours = new ArrayList<List<PtsCoord>>();
		List<List<PtsCoord>> commonContours = new ArrayList<List<PtsCoord>>();

		if (pointsValue == Pts.CLIENT_UNMARKED_POINT)
			rivalPointsValue = 1;
		else
			rivalPointsValue = 2;

		List<PtsCoord> firstContour = getContour(board, y, x, pointsValue,
				new PtsCoord(y - 1, x));
		List<PtsCoord> secondContour = getContour(board, y, x, pointsValue,
				new PtsCoord(y, x + 1));
		List<PtsCoord> thirdContour = getContour(board, y, x, pointsValue,
				new PtsCoord(y + 1, x));
		List<PtsCoord> forthContour = getContour(board, y, x, pointsValue,
				new PtsCoord(y, x - 1));

		if (firstContour.size() != 0)
			listOfContours.add(firstContour);
		if (secondContour.size() != 0)
			listOfContours.add(secondContour);
		if (thirdContour.size() != 0)
			listOfContours.add(thirdContour);
		if (forthContour.size() != 0)
			listOfContours.add(forthContour);

		resultContours = getDifferentContours(board, listOfContours,
				rivalPointsValue);

		initCommonBoard(commonBoard, board, pointsValue);
		commonContours = getContours(commonBoard, y, x, pointsValue);
		System.out.println("befire different. contours!!!!!!!!!!! = "
				+ commonContours);
		commonContours = getDifferentContours(commonBoard, commonContours,
				rivalPointsValue);
		System.out.println("common contours!!!!!!!!!!! = " + commonContours);

		if (resultContours != null) {
			writeContoursFieldsInLogicBoard(logicBoard, board, resultContours,
					pointsValue, rivalPointsValue);

			for (int i = 0; i < resultContours.size(); i++) {

				if (isRivalpointInsideContours(board, resultContours.get(i),
						rivalPointsValue)) {
					writeContourInBoard(board, logicBoard,
							resultContours.get(i), pointsValue,
							rivalPointsValue);
				}
			}
		}

		if (commonContours != null) {
			removeDefinedContours(commonContours, board, logicBoard,
					rivalPointsValue);
			System.out.println("after removeing. common = " + commonContours);
			writeContoursFieldsInLogicBoard(logicBoard, board, commonContours,
					pointsValue, rivalPointsValue);

			for (int i = 0; i < commonContours.size(); i++) {

				if (isRivalpointInsideContours(board, commonContours.get(i),
						rivalPointsValue)) {
					writeContourInBoard(board, logicBoard,
							commonContours.get(i), pointsValue,
							rivalPointsValue);
				}
			}
		}

		if (commonContours != null || resultContours != null) {

			return connectContoursList(commonContours, resultContours);
		}

		if (commonContours == null && resultContours == null) {

			if (logicBoard[y][x] - 90 > 0) {

				PtsContour contour = contourMap.get(logicBoard[y][x]);
				writeContourInBoard(board, logicBoard,
						contour.getContourPoints(), rivalPointsValue,
						pointsValue);
				board[y][x] = pointsValue * 10;
				List<PtsCoord> contourFields = contour.getContourFields();
				for (int i = 0; i < contourFields.size(); i++) {

					PtsCoord coord = contourFields.get(i);
					if (logicBoard[coord.getY()][coord.getX()] == logicBoard[y][x]) {
						logicBoard[coord.getY()][coord.getX()] = getPointInReadyContourValue(rivalPointsValue);
					}
				}

				contourMap.remove(logicBoard[y][x]);

			}

		}
		System.out.println("resultContours  " + resultContours);
		return null;
	}

	public List<PtsCoord> getContour(int[][] board, int y, int x,
			int pointsValue, PtsCoord beginPoint) {

		first_point_y = y;
		first_point_x = x;

		List<PtsCoord> contourPoints = new ArrayList<PtsCoord>();
		PtsCoord firstPoint = new PtsCoord(y, x);
		contourPoints.add(firstPoint);

		moveClockwise(board, firstPoint, pointsValue, contourPoints, beginPoint);

		clockwiseCounturFound = false;
		return contourPoints;
	}

	private List<List<PtsCoord>> connectContoursList(
			List<List<PtsCoord>> firstContoursList,
			List<List<PtsCoord>> secondContoursList) {

		List<List<PtsCoord>> resultContoursList = new ArrayList<List<PtsCoord>>();

		if (firstContoursList != null) {
			for (int i = 0; i < firstContoursList.size(); i++) {
				resultContoursList.add(firstContoursList.get(i));
			}
		}

		if (secondContoursList != null) {
			for (int i = 0; i < secondContoursList.size(); i++) {
				resultContoursList.add(secondContoursList.get(i));
			}
		}

		return resultContoursList;

	}

	private List<List<PtsCoord>> getContours(int[][] commonBoard, int y, int x,
			int pointsValue) {

		List<List<PtsCoord>> contoursList = new ArrayList<List<PtsCoord>>();

		List<PtsCoord> firstContour = getContour(commonBoard, y, x,
				pointsValue, new PtsCoord(y - 1, x));
		List<PtsCoord> secondContour = getContour(commonBoard, y, x,
				pointsValue, new PtsCoord(y, x + 1));
		List<PtsCoord> thirdContour = getContour(commonBoard, y, x,
				pointsValue, new PtsCoord(y + 1, x));
		List<PtsCoord> forthContour = getContour(commonBoard, y, x,
				pointsValue, new PtsCoord(y, x - 1));

		if (firstContour.size() != 0)
			contoursList.add(firstContour);
		if (secondContour.size() != 0)
			contoursList.add(secondContour);
		if (thirdContour.size() != 0)
			contoursList.add(thirdContour);
		if (forthContour.size() != 0)
			contoursList.add(forthContour);

		return contoursList;
	}

	private void removeDefinedContours(List<List<PtsCoord>> contoursList,
			int[][] board, int[][] logicBoard, int rivalPointsValue) {

		for (int i = contoursList.size() - 1; i >= 0; i--) {

			boolean isUnique = false;
			List<PtsCoord> contour = contoursList.get(i);
			List<PtsCoord> contourFields = getFieldsInsideContour(board,
					contour, rivalPointsValue);
			for (int j = 0; j < contourFields.size(); j++) {

				PtsCoord coord = contourFields.get(j);
				if ((board[coord.getY()][coord.getX()] == 0 || board[coord
						.getY()][coord.getX()] == rivalPointsValue)
						&& logicBoard[coord.getY()][coord.getX()] == 0)
					isUnique = true;
			}

			if (!isUnique) {
				contoursList.remove(contour);
			}
		}
	}

	private void writeContoursFieldsInLogicBoard(int[][] logicBoard,
			int[][] board, List<List<PtsCoord>> contoursList, int pointsValue,
			int rivalPointsValue) {

		boolean emptyField = false;

		for (int i = 0; i < contoursList.size(); i++) {
			List<PtsCoord> pointsList = contoursList.get(i);

			List<PtsCoord> contourFields = getFieldsInsideContour(board,
					pointsList, rivalPointsValue);
			if (!isRivalpointInsideContours(board, pointsList, rivalPointsValue)) {

				for (int j = 0; j < contourFields.size(); j++) {
					PtsCoord coord_field = contourFields.get(j);
					if (board[coord_field.getY()][coord_field.getX()] == 0) {
						emptyField = true;
						logicBoard[coord_field.getY()][coord_field.getX()] = getContourId(pointsValue);
					}
					PtsCoord coord = contourFields.get(j);
					if (board[coord.getY()][coord.getX()] == pointsValue
							|| board[coord.getY()][coord.getX()] == (pointsValue * 10 + pointsValue))
						board[contourFields.get(j).getY()][contourFields.get(j)
								.getX()] = getUnusablePointValue(pointsValue);
				}
				if (emptyField) {
					emptyField = false;
					contourMap.put(getContourId(pointsValue), new PtsContour(
							pointsList, contourFields));
					incrementContourId(pointsValue);
				}

			} else {

				for (int j = 0; j < contourFields.size(); j++) {

					PtsCoord coord = contourFields.get(j);
					if (board[contourFields.get(j).getY()][contourFields.get(j)
							.getX()] == 0)
						if (pointsValue == Pts.SERVER_UNMARKED_POINT) {
							logicBoard[contourFields.get(j).getY()][contourFields
									.get(j).getX()] = Pts.POINT_IN_SERVER_CONTOUR;
						} else {
							logicBoard[contourFields.get(j).getY()][contourFields
									.get(j).getX()] = Pts.POINT_IN_CLIENT_CONTOUR;
						}
					if (board[coord.getY()][coord.getX()] == pointsValue
							|| board[coord.getY()][coord.getX()] == (pointsValue * 10 + pointsValue)
							|| board[coord.getY()][coord.getX()] == (pointsValue * 10)) {
						board[contourFields.get(j).getY()][contourFields.get(j)
								.getX()] = getUnusablePointValue(pointsValue);
						logicBoard[contourFields.get(j).getY()][contourFields
								.get(j).getX()] = 0;
					}

					if (board[coord.getY()][coord.getX()] == rivalPointsValue
							|| board[coord.getY()][coord.getX()] == (rivalPointsValue * 10 + rivalPointsValue)
							|| board[coord.getY()][coord.getX()] == (rivalPointsValue * 10)
							|| board[coord.getY()][coord.getX()] == getUnusablePointValue(rivalPointsValue)) {
						board[contourFields.get(j).getY()][contourFields.get(j)
								.getX()] = rivalPointsValue * 10;
						logicBoard[contourFields.get(j).getY()][contourFields
								.get(j).getX()] = 0;
					}

				}
			}

			for (int j = 0; j < pointsList.size(); j++) {
				PtsCoord coord_1 = pointsList.get(j);
				if (pointsValue == Pts.SERVER_UNMARKED_POINT)
					logicBoard[coord_1.getY()][coord_1.getX()] = 11;
				else if (pointsValue == Pts.CLIENT_UNMARKED_POINT)
					logicBoard[coord_1.getY()][coord_1.getX()] = 22;
			}

		}
	}

	private void initCommonBoard(int[][] commonBoard, int[][] board,
			int pointsValue) {

		for (int i = 0; i < Pts.Y_LENGTH; i++) {

			for (int j = 0; j < Pts.X_LENGTH; j++) {

				if (board[i][j] == pointsValue
						|| board[i][j] == (pointsValue * 10 + pointsValue))
					commonBoard[i][j] = 1;
			}
		}
	}

	private int getPointInReadyContourValue(int pointsValue) {

		if (pointsValue == Pts.SERVER_UNMARKED_POINT) {
			return Pts.POINT_IN_SERVER_CONTOUR;
		} else
			return Pts.POINT_IN_CLIENT_CONTOUR;
	}

	private int getContourId(int pointsValue) {

		if (pointsValue == 1)
			return contourIdServer;
		else
			return contourIdClient;
	}

	private void incrementContourId(int pointsValue) {

		if (pointsValue == 1)
			contourIdServer++;
		else
			contourIdClient++;
	}

	private int getUnusablePointValue(int pointsValue) {

		if (pointsValue == Pts.SERVER_MARKED_POINT
				|| pointsValue == Pts.SERVER_UNMARKED_POINT) {
			return Pts.UNUSABLE_POINT_SERVER;
		} else {
			return Pts.UNUSABLE_POINT_CLIENT;
		}
	}

	private void writeContourInBoard(int[][] board, int[][] logicBoard,
			List<PtsCoord> contourPoints, int pointsValue, int rivalPointsValue) {

		List<PtsCoord> fieldsInsideContours = getFieldsInsideContour(board,
				contourPoints, pointsValue);
		for (int j = 0; j < contourPoints.size(); j++) {
			PtsCoord coord = contourPoints.get(j);
			if (pointsValue == 1) {
				board[coord.getY()][coord.getX()] = 11;
			} else if (pointsValue == 2) {
				board[coord.getY()][coord.getX()] = 22;
			}
		}

		for (int j = 0; j < fieldsInsideContours.size(); j++) {

			PtsCoord coord = fieldsInsideContours.get(j);
			if (board[coord.getY()][coord.getX()] == rivalPointsValue
					|| board[coord.getY()][coord.getX()] == (rivalPointsValue * 10 + rivalPointsValue)) {
				board[coord.getY()][coord.getX()] = rivalPointsValue * 10;
				logicBoard[coord.getY()][coord.getX()] = 0;
			}
		}
	}

	private List<List<PtsCoord>> getDifferentContours(int[][] board,
			List<List<PtsCoord>> listOfContours, int rivalPointsValue) {

		int min_points_count;
		boolean sameFields = false;
		List<List<PtsCoord>> minContours = new ArrayList<List<PtsCoord>>();

		for (int i = listOfContours.size() - 1; i >= 0; i--) {

			if (getFieldsInsideContour(board, listOfContours.get(i),
					rivalPointsValue).size() == 0) {
				listOfContours.remove(i);
			}

		}

		if (listOfContours.size() == 0)
			return null;

		min_points_count = listOfContours.get(0).size();
		for (int i = 0; i < listOfContours.size(); i++) {
			if (min_points_count > listOfContours.get(i).size())
				min_points_count = listOfContours.get(i).size();
		}

		for (int i = listOfContours.size() - 1; i >= 0; i--) {

			if (listOfContours.get(i).size() != min_points_count) {
				listOfContours.add(listOfContours.get(i));
				listOfContours.remove(i);
			}

		}

		minContours.add(listOfContours.get(0));
		for (int i = 0; i < listOfContours.size(); i++) {
			sameFields = false;
			for (int j = 0; j < minContours.size(); j++) {
				if (isContourWithSameFields(board, listOfContours.get(i),
						minContours.get(j), rivalPointsValue))
					sameFields = true;
			}
			if (!sameFields)

				minContours.add(listOfContours.get(i));
		}

		return minContours;
	}

	private boolean isContourWithSameFields(int[][] board,
			List<PtsCoord> firstContour, List<PtsCoord> secondContour,
			int rivalPointsValue) {

		List<PtsCoord> firstContourFields = getFieldsInsideContour(board,
				firstContour, rivalPointsValue);
		List<PtsCoord> secondContourFields = getFieldsInsideContour(board,
				secondContour, rivalPointsValue);
		boolean result = false;

		for (int i = 0; i < firstContourFields.size(); i++) {

			for (int j = 0; j < secondContourFields.size(); j++) {

				if (firstContourFields.get(i)
						.equals(secondContourFields.get(j)))
					result = true;
			}
		}

		return result;
	}

	private void moveClockwise(int[][] board, PtsCoord point, int pointsValue,
			List<PtsCoord> contourPoints, PtsCoord beginPoint) {

		int iterationIndex = getIterationClockwiseIndex(beginPoint, point);
		iterateClockwise(board, point, pointsValue, contourPoints,
				iterationIndex);
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
				+ iterationPoint + "    point   " + point);
		return 0;
	}

	private void iterateClockwise(int[][] board, PtsCoord point,
			int pointsValue, List<PtsCoord> contourPoints, int iterationIndex) {

		PtsCoord currentPtsCoord = getIterationPtsCoords(iterationIndex, point);
		if (checkAllConditionsClockwise(board, currentPtsCoord, contourPoints,
				pointsValue)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(board, currentPtsCoord, pointsValue,
					contourPoints);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, point);
		if (checkAllConditionsClockwise(board, currentPtsCoord, contourPoints,
				pointsValue)) {
			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(board, currentPtsCoord, pointsValue,
					contourPoints);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, point);
		if (checkAllConditionsClockwise(board, currentPtsCoord, contourPoints,
				pointsValue)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(board, currentPtsCoord, pointsValue,
					contourPoints);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, point);
		if (checkAllConditionsClockwise(board, currentPtsCoord, contourPoints,
				pointsValue)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(board, currentPtsCoord, pointsValue,
					contourPoints);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, point);
		if (checkAllConditionsClockwise(board, currentPtsCoord, contourPoints,
				pointsValue)) {
			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(board, currentPtsCoord, pointsValue,
					contourPoints);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, point);
		if (checkAllConditionsClockwise(board, currentPtsCoord, contourPoints,
				pointsValue)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(board, currentPtsCoord, pointsValue,
					contourPoints);

		}

		iterationIndex = incrementIterationIndex(iterationIndex);
		currentPtsCoord = getIterationPtsCoords(iterationIndex, point);
		if (checkAllConditionsClockwise(board, currentPtsCoord, contourPoints,
				pointsValue)) {

			if (isEndPointClockwise(currentPtsCoord.getY(),
					currentPtsCoord.getX()))
				return;
			nextIterationClockwise(board, currentPtsCoord, pointsValue,
					contourPoints);

		}

		if (clockwiseCounturFound)
			return;
		else {
			contourPoints.remove(contourPoints.size() - 1);
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

	private boolean checkAllConditionsClockwise(int[][] board,
			PtsCoord pointPtsCoord, List<PtsCoord> pointsInContour,
			int pointsValue) {

		int y = pointPtsCoord.getY();
		int x = pointPtsCoord.getX();

		if (!clockwiseCounturFound && y >= 0 && x >= 0 && y < Pts.Y_LENGTH
				&& x < Pts.X_LENGTH
				&& !isPointAlreadyDefinedClockwise(y, x, pointsInContour)
				&& (board[y][x] == pointsValue))
			return true;

		return false;
	}

	private void nextIterationClockwise(int[][] board, PtsCoord point,
			int pointsValue, List<PtsCoord> contourPoints) {

		contourPoints.add(point);
		moveClockwise(board, point, pointsValue, contourPoints,
				contourPoints.get(contourPoints.size() - 2));
		return;
	}

	private boolean isPointAlreadyDefinedClockwise(int y, int x,
			List<PtsCoord> pointsInContour) {

		for (int i = 1; i < pointsInContour.size(); i++) {
			if (pointsInContour.get(i).getX() == x
					&& pointsInContour.get(i).getY() == y)
				return true;
		}
		return false;
	}

	private boolean isEndPointClockwise(int y, int x) {

		if (y == first_point_y && x == first_point_x) {
			clockwiseCounturFound = true;
			return true;
		}

		return false;
	}

	private int incrementIterationIndex(int iterationIndex) {

		iterationIndex++;
		if (iterationIndex == 9) {
			iterationIndex = 1;
		}

		return iterationIndex;
	}

	private boolean isRivalpointInsideContours(int[][] board,
			List<PtsCoord> contourPoints, int rivalPointsValue) {

		List<PtsCoord> fieldsInsideContour = getFieldsInsideContour(board,
				contourPoints, rivalPointsValue);
		for (int i = 0; i < fieldsInsideContour.size(); i++) {
			PtsCoord coord = fieldsInsideContour.get(i);
			if (board[coord.getY()][coord.getX()] == rivalPointsValue
					|| board[coord.getY()][coord.getX()] == (rivalPointsValue * 10 + rivalPointsValue)
					|| board[coord.getY()][coord.getX()] == (rivalPointsValue * 10))
				return true;
		}

		return false;
	}

	private List<PtsCoord> getFieldsInsideContour(int[][] board,
			List<PtsCoord> contourPoints, int rivalPointsValue) {

		List<PtsCoord> fieldsInsideContour = new ArrayList<PtsCoord>();
		List<PtsCoord> fieldsInsideXVectors = getCoordinatesInsideXVectors(
				board, contourPoints, rivalPointsValue);
		List<PtsCoord> fieldsInsideYVectors = getCoordinatesInsideYVectors(
				board, contourPoints, rivalPointsValue);

		for (int i = 0; i < fieldsInsideXVectors.size(); i++) {

			PtsCoord x_coord = fieldsInsideXVectors.get(i);
			for (int j = 0; j < fieldsInsideYVectors.size(); j++) {

				PtsCoord y_coord = fieldsInsideYVectors.get(j);
				if (x_coord.getY() == y_coord.getY()
						&& x_coord.getX() == y_coord.getX())
					fieldsInsideContour.add(y_coord);
			}
		}

		return fieldsInsideContour;
	}

	private List<PtsCoord> getCoordinatesInsideXVectors(int[][] board,
			List<PtsCoord> contourPoints, int rivalPointsValue) {

		Set<Integer> y_set = new HashSet<Integer>();
		List<PtsCoord> fieldsInsideXVectors = new ArrayList<PtsCoord>();

		for (int j = 0; j < contourPoints.size(); j++) {
			y_set.add(contourPoints.get(j).getY());
		}

		Iterator<Integer> it = y_set.iterator();
		while (it.hasNext()) {

			int min_x = 23;
			int max_x = -1;
			int y = it.next();

			for (int i = 0; i < contourPoints.size(); i++) {

				PtsCoord coord = contourPoints.get(i);
				if (coord.getY() == y && coord.getX() < min_x)
					min_x = contourPoints.get(i).getX();
				if (coord.getY() == y && coord.getX() > max_x)
					max_x = contourPoints.get(i).getX();

			}

			for (int i = min_x + 1; i < max_x; i++) {

				fieldsInsideXVectors.add(new PtsCoord(y, i));
			}

		}

		return fieldsInsideXVectors;

	}

	private List<PtsCoord> getCoordinatesInsideYVectors(int[][] board,
			List<PtsCoord> contourPoints, int rivalPointsValue) {

		Set<Integer> x_set = new HashSet<Integer>();
		List<PtsCoord> fieldsInsideYVectors = new ArrayList<PtsCoord>();

		for (int j = 0; j < contourPoints.size(); j++) {
			x_set.add(contourPoints.get(j).getX());
		}

		Iterator<Integer> it = x_set.iterator();
		while (it.hasNext()) {

			int min_y = 27;
			int max_y = -1;
			int x = it.next();

			for (int i = 0; i < contourPoints.size(); i++) {

				PtsCoord coord = contourPoints.get(i);
				if (coord.getX() == x && coord.getY() < min_y)
					min_y = contourPoints.get(i).getY();
				if (coord.getX() == x && coord.getY() > max_y)
					max_y = contourPoints.get(i).getY();

			}

			for (int i = min_y + 1; i < max_y; i++) {

				fieldsInsideYVectors.add(new PtsCoord(i, x));
			}

		}

		return fieldsInsideYVectors;

	}

	// private void initLogicBoard() {
	//
	// for (int i = 0; i < Pts.Y_LENGTH; i++) {
	// for (int j = 0; j < Pts.X_LENGTH; j++) {
	// logicBoard[i][j] = -1;
	// }
	// }
	// }
	// TODO private List<PtsCoord> getXCoordsInsideContour(List<PtsCoord>
	// contourPoints) {
	//
	// List<PtsCoord> xCoords = new ArrayList<PtsCoord>();
	// List<PtsCoord> pointXCoords = new ArrayList<PtsCoord>();
	// int first_x = -1;
	// int last_x = -1;
	//
	// for (int i = 0; i < contourPoints.size(); i++) {
	//
	// PtsCoord coord = contourPoints.get(i);
	// for (int j = 0; j )
	// pointXCoords.add(coord);
	// for (int j = 0; j < i; j++) {
	// if (coord.getY() == contourPoints.get(j).getY())
	// pointXCoords.add(new PtsCoord(contourPoints.get(j).getY(),
	// contourPoints.get(j).getX()));
	// }
	//
	// for (int j = i; j < contourPoints.size(); j++) {
	// if (coord.getY() == contourPoints.get(j).getY())
	// pointXCoords.add(new PtsCoord(contourPoints.get(j).getY(),
	// contourPoints.get(j).getX()));
	// }
	//
	// for (int j = 0; j < pointXCoords.size(); j++) {
	//
	// if (first_x != -1) {
	// if (pointXCoords.get(j).getX() < first_x)
	// first_x = pointXCoords.get(j).getX();
	// if (pointXCoords.get(j).getX() > last_x)
	// last_x = pointXCoords.get(j).getX();
	// }
	// else {
	// first_x = pointXCoords.get(j).getX();
	// last_x = pointXCoords.get(j).getX();
	// }
	// }
	//
	// if (first_x != last_x) {
	// for (int j = first_x + 1; j < last_x; j++) {
	// xCoords.add(new PtsCoord(coord.getY(), j));
	// }
	// }
	//
	// pointXCoords.clear();
	//
	// }
	// }
}
