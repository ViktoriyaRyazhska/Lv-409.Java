import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import org.junit.*;

/**
 * @author Rostyslav Hlynka
 */
public class WaysToSumTest {
    
    private WaysToSum waysToSum;
    
    @Before  
    public void init() {     
        waysToSum = new WaysToSum(new Scanner(System.in));     
    }
    
    @After  
    public void deleteObject() {     
        waysToSum = null;     
    } 
    
    @Test
    public void testCalculate() {
        
        // valid input
        int[] array1 = {1, 5, 6};
        int digitNum1 = 7;
        int expectedResult1 = 6;
        
        // invalid inputted digitNum
        int[] array2 = {1, 5, 6};
        int digitNum2 = 0;
        int expectedResult2 = 0;
        
        // invalid inputted array
        int[] array3 = {3, 4, 5, -1};
        int digitNum3 = 7;
        int expectedResult3 = 0;
        
        assertEquals(expectedResult1, waysToSum.calculate(digitNum1, array1));
        assertEquals(expectedResult2, waysToSum.calculate(digitNum2, array2));
        assertEquals(expectedResult3, waysToSum.calculate(digitNum3, array3));
        
    }

}
