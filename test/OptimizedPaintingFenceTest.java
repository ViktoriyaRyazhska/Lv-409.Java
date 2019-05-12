import org.junit.Test;

import java.util.Scanner;
import static org.junit.Assert.*;

public class OptimizedPaintingFenceTest {

    @Test
    public void defaultValueTest(){
        OptimizedPaintingFence opf = new OptimizedPaintingFence(new Scanner(System.in));
        assertEquals(16, opf.countWaysToColor(2,4));
        assertEquals(1, opf.countWaysToColor(1,1));
    }
}
