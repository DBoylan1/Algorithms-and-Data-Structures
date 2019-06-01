
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*
 *  Justify the choice of the data structures used in CompetitionDijkstra and CompetitionFloydWarshall
 *  The data structure used in CompetitionDijkstra contains: the individual speeds of the three contestants and the name of the file that is being passed used.
 *  The file name is part of the data structure because it determines what the graph look like and it is what the graph is based on. The individual speeds are components
 *  of the data structure because they stay constant in this program.
 *  
 *   The data structure used in CompetitionFloydWarshall contains: the individual speeds of the three contestants, the name of the file being used,the 2D array,
 *   the number of intersections. The file name is part of the data structure because it determines what the graph look like and it is what the graph is based on. The individual speeds are components
 *  of the data structure because they stay constant in this program. The 2d array will contain the weights of the edges, the number of intersections is used to initialize the array.
 *  
 *  Explain theoretical differences in the performance of Dijkstra and Floyd-Warshall algorithms in the given problem.
 *  In general depending on the size of the input file, Dijkstra performed at a slightly slower rate than Floyd-Warshall. In this problem Dijkstra gets one point and finds the distance from that point to every other point in the graph.
 *  Where as Floyd-Warshall finds distance between all vertices. Time complexity of Dijkstra is O(E log n) and time complexity of Floyd-Warshall is O(N^3)
 *   
 *  Also explain how would their relative performance be affected by the density of the graph.
 *  Dijkstra's performance will be affected more with a denser graph as there more nodes that it has to find shortest path of.
 *  Floyd -warshall would take longer but it wouldn't be affected as much as the implementation consists mainly of three nested for loops. 
 *  Which would you choose in which set of circumstances and why?
 *  I would choose to use the floyd warshall algorithm. There are more applications of this algorithm such as it can be used in a distributed system and it can also contain negative edges. 
 *  It's performance time it also better than the performance time of Dijkstra.
 */

public class CompetitionTests {

	@Test
	public void testDijkstraConstructor() {

		// TODO
		// Test where SA, SB, SC are outside range of 50 <= SA,SB,SC => 100
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 40, 30, 110);
		assertEquals("Time Required", -1, competitionDijkstra.timeRequiredforCompetition());

	}

	@Test
	public void testFWConstructor() {
		// TODO
		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 1, 2, 3);
		assertEquals("Time Required", -1, competitionFloydWarshall.timeRequiredforCompetition());
	}

	// TODO - more tests
	@Test
	public void testNullFile() {
		// test for a null file
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("null.txt", 40, 30, 110);
		assertEquals("Time Required", -1, competitionDijkstra.timeRequiredforCompetition());

		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("null.txt", 20, 200, 60);
		assertEquals("Time Required", -1, competitionFloydWarshall.timeRequiredforCompetition());

	}

	@Test
	public void testSpeed() {
		// Test where SA, SB, SC are outside range of 50 <= SA,SB,SC => 100
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 40, 30, 110);
		assertEquals("Time Required", -1, competitionDijkstra.timeRequiredforCompetition());

		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 20, 200, 60);
		assertEquals("Time Required", -1, competitionFloydWarshall.timeRequiredforCompetition());

	}

	@Test
	// Test for speed less than 50
	public void testSpeed50() {
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 40, 30, 10);
		assertEquals("Time Required", -1, competitionDijkstra.timeRequiredforCompetition());

		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 20, 20, 30);
		assertEquals("Time Required", -1, competitionFloydWarshall.timeRequiredforCompetition());
	}

	@Test
	// Test for speed greater than 1000
	public void testSpeed100() {
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("tinyEWD.txt", 400, 134, 110);
		assertEquals("Time Required", -1, competitionDijkstra.timeRequiredforCompetition());

		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("tinyEWD.txt", 205, 200, 600);
		assertEquals("Time Required", -1, competitionFloydWarshall.timeRequiredforCompetition());
	}

	@Test
	public void testInputIDijkstra() {
		// input-I.txt with speed = [60,70,84] should return 200
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("Input-I.txt", 60, 70, 84);
		assertEquals("Time Required", 200, competitionDijkstra.timeRequiredforCompetition());
	}

	@Test
	public void testInputIFloydWarshall() {
		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("Input-I.txt", 60, 70, 84);
		assertEquals("Time Required", 200, competitionFloydWarshall.timeRequiredforCompetition());
	}

	@Test
	public void testInputKDijkstra() {
		// input-K.txt with speed = [51,70,88] should return 314
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("Input-K.txt", 51, 70, 88);
		assertEquals("Time Required", 314, competitionDijkstra.timeRequiredforCompetition());
	}

	@Test
	public void testInputKFloydWarshall() {
		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("Input-K.txt", 51, 70, 88);
		assertEquals("Time Required", 314, competitionFloydWarshall.timeRequiredforCompetition());
	}

	/*
	 * input-J.txt with speed = [98,70,84] should return -1 input-A.txt with
	 * speed = [50,50,50] should return -1
	 * 
	 */
	@Test
	public void testInputJDijkstra() {
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("Input-J.txt", 98, 70, 84);
		assertEquals("Time Required", -1, competitionDijkstra.timeRequiredforCompetition());
	}

	@Test
	public void testInputJFloydWarshall() {
		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("Input-J.txt", 98, 70, 84);
		assertEquals("Time Required", -1, competitionFloydWarshall.timeRequiredforCompetition());
	}

	@Test
	public void testInputADijkstra() {
		CompetitionDijkstra competitionDijkstra = new CompetitionDijkstra("Input-A.txt", 50, 50, 50);
		assertEquals("Time Required", -1, competitionDijkstra.timeRequiredforCompetition());
	}

	@Test
	public void testInputAFloydWarshall() {
		CompetitionFloydWarshall competitionFloydWarshall = new CompetitionFloydWarshall("Input-A.txt", 50, 50, 50);
		assertEquals("Time Required", -1, competitionFloydWarshall.timeRequiredforCompetition());
	}

}
