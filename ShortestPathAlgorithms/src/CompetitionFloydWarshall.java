import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CompetitionFloydWarshall {
	int userSpeedA;
	int userSpeedB;
	int userSpeedC;
	double matrix[][];
	Integer numIntersections;
	String filename;

	public static final int INFINITY = Integer.MAX_VALUE;

	CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {
		this.userSpeedA = sA;
		this.userSpeedB = sB;
		this.userSpeedC = sC;
		this.filename = filename;

	}

	public int timeRequiredforCompetition() {
		if (filename == null) {
			return -1;
		}
		File file = new File(filename);
		if (!file.exists()) {
			return -1;
		}

		int slowestSpeed;
		if ((this.userSpeedA > 100 || this.userSpeedA < 50) || (this.userSpeedB > 100 || this.userSpeedB < 50)
				|| (this.userSpeedC > 100 || this.userSpeedC < 50)) {
			return -1;
		}
		if (this.userSpeedA < this.userSpeedB && this.userSpeedA < this.userSpeedC) {
			slowestSpeed = this.userSpeedA;
		} else if (this.userSpeedB < this.userSpeedA && this.userSpeedB < this.userSpeedC) {
			slowestSpeed = this.userSpeedB;
		} else {
			slowestSpeed = this.userSpeedC;
		}

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			this.numIntersections = Integer.parseInt(br.readLine());
			if (this.numIntersections == 2) {
				return -1;
			}
			this.matrix = new double[numIntersections][numIntersections];
			for (int i = 0; i < numIntersections; i++) {
				for (int j = 0; j < numIntersections; j++) {
					matrix[i][j] = Double.MAX_VALUE;
				}
			}
			Integer numStreets = Integer.parseInt(br.readLine());
			String contentLine = br.readLine();

			while (contentLine != null) {
				System.out.println(contentLine);
				contentLine = contentLine.trim().replaceAll("\\s{2,}", " ");
				String[] parts = contentLine.split(" ");
				int fromIntersection = Integer.parseInt(parts[0]);
				int toIntersection = Integer.parseInt(parts[1]);
				double distance = Double.parseDouble(parts[2]);
				matrix[fromIntersection][toIntersection] = distance * 1000;
				contentLine = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				System.out.println("Error in closing the BufferedReader");
			}
		}
		for (int k = 0; k < numIntersections; k++) {
			for (int i = 0; i < numIntersections; i++) {
				for (int j = 0; j < numIntersections; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
		// System.out.println(Arrays.deepToString(matrix));
		// get max distance
		double maxDistance = 0;
		for (int a = 0; a < numIntersections; a++) {
			for (int b = 0; b < numIntersections; b++) {
				if (matrix[a][b] > maxDistance && a != b) {
					maxDistance = matrix[a][b];
				}
			}
		}

		// TO DO
		// return -1;
		Double finalResult = Math.ceil(maxDistance / slowestSpeed);
		System.out.println("Final Result:" + finalResult.intValue());
		if (finalResult.intValue() < 1) {
			return -1;
		}
			return finalResult.intValue();
	}
}
