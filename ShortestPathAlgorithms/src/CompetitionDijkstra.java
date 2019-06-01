import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompetitionDijkstra {
	int userSpeedA;
	int userSpeedB;
	int userSpeedC;
	String filename;
	//Integer numStreets;

	CompetitionDijkstra(String filename, int sA, int sB, int sC) {
		this.userSpeedA = sA;
		this.userSpeedB = sB;
		this.userSpeedC = sC;
		this.filename = filename;
	}

	private static double[][] getGraphArray(String filename) {
		BufferedReader br = null;
		double[][] graph = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			Integer numIntersections = Integer.parseInt(br.readLine());
			Integer numStreets = Integer.parseInt(br.readLine());
			String contentLine = br.readLine();
			graph = new double[numIntersections][numIntersections];
			initialiseArray(graph, -1.0);
			while (contentLine != null) {
				System.out.println(contentLine);
				contentLine = contentLine.trim().replaceAll("\\s{2,}", " ");
				String[] parts = contentLine.split(" ");
				int fromIntersection = Integer.parseInt(parts[0]);
				int toIntersection = Integer.parseInt(parts[1]);
				double distance = Double.parseDouble(parts[2]);
				graph[fromIntersection][toIntersection] = distance;
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
		return graph;
	}

	private static void initialiseArray(double[][] arr, double initialVal) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = initialVal;
			}
		}
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

		// TO DO
		// return -1;
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

		double[][] distanceGraph = getGraphArray(filename);

		double overallLongest = 0;
		for (int i = 0; i < distanceGraph.length; i++) {
			double longestDist = getDijkstraLongest(distanceGraph, i);
			System.out.println("\t longestDist for " + i + " : " + longestDist);
			if (longestDist > overallLongest) {
				overallLongest = longestDist;
			}
		}
		System.out.println("overallLongest: " + overallLongest);

		if (overallLongest == Double.MAX_VALUE) {
			// 2 random locations in a city between which no path exists
			return -1;
		}
		// Round minutes for distance
		Double longestMins = Math.ceil((overallLongest * 1000) / slowestSpeed);
		if(longestMins.intValue() < 1){
			return -1;
		}
		return longestMins.intValue();
	}

	int minDistance(double dist[], Boolean sptSet[]) {
		// Initialize min value
		double min = Double.MAX_VALUE;
		int min_index = -1;

		for (int v = 0; v < dist.length; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	void printSolution(int dist[], int n) {
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + " tt " + dist[i]);
	}

	double getLongest(double dist[], int n) {
		double longest = 0;
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] > longest) {
				longest = dist[i];
			}
		}
		return longest;
	}

	double getDijkstraLongest(double graph[][], int src) {
		double dist[] = new double[graph.length];

		// shortestPathSet[i] will true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean shortestPathSet[] = new Boolean[dist.length];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Double.MAX_VALUE;
			shortestPathSet[i] = false;
		}

		// Distance of source intersection from itself is always 0
		dist[src] = 0;

		// Find shortest path for all intersections
		for (int count = 0; count < dist.length - 1; count++) {
			int u = minDistance(dist, shortestPathSet);
			shortestPathSet[u] = true;

			// Update connected intersections.
			for (int v = 0; v < dist.length; v++)
				if (!shortestPathSet[v] && graph[u][v] != -1 && dist[u] != Integer.MAX_VALUE
						&& dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// printSolution(dist, dist.length);
		return getLongest(dist, src);
	}
}
