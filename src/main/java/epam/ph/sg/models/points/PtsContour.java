package epam.ph.sg.models.points;

import java.util.List;

public class PtsContour {

	private List<PtsCoord> contourPoints;
	private List<PtsCoord> contourFields;

	public PtsContour(List<PtsCoord> contourPoints, List<PtsCoord> contourFields) {
		this.contourPoints = contourPoints;
		this.contourFields = contourFields;
	}

	public List<PtsCoord> getContourFields() {
		return contourFields;
	}

	public void setContourFields(List<PtsCoord> contourFields) {
		this.contourFields = contourFields;
	}

	public List<PtsCoord> getContourPoints() {
		return contourPoints;
	}

	public void setContourPoints(List<PtsCoord> contourPoints) {
		this.contourPoints = contourPoints;
	}

}
