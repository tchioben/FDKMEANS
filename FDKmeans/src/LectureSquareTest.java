import java.util.ArrayList;

import org.junit.Test;


public class LectureSquareTest {

	@Test
	public void test() {
		ArrayList<Point> liste= LectureSquare.LectureFichier("test.txt");
		for(Point p: liste){
			System.out.println(p);
		}
	}

}
