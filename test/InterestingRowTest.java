import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterestingRowTest {

    private InterestingRow task;

    @Before
    public void init() {
        task = new InterestingRow();
    }

    @After
    public void deleteObject() {
        task = null;
    }

    @Test
    public void findInterestingRowMember() {
        assertEquals(0, task.findIntrestingRowMember(-4));
        assertEquals(0, task.findIntrestingRowMember(0));
        assertEquals(43, task.findIntrestingRowMember(7));
        assertEquals(11, task.findIntrestingRowMember(5));
    }

}