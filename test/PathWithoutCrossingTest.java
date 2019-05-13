import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.*;

public class PathWithoutCrossingTest {

    private PathWithoutCrossing pathWithoutCrossing;

    @Before
    public void init() {
        pathWithoutCrossing = new PathWithoutCrossing(new Scanner(System.in));
    }

    @After
    public void deleteObject() {
        pathWithoutCrossing = null;
    }

    @Test
    public void testCalculate() {

        // valid input
        int innerPointNum1 = 4;
        int expectedResult1 = 2;

        // invalid inputted innerPointNum
        int innerPointNum2 = 1;
        int expectedResult2 = 0;

        assertEquals(expectedResult1, pathWithoutCrossing.calculate(innerPointNum1));
        assertEquals(expectedResult2, pathWithoutCrossing.calculate(innerPointNum2));

    }

}
