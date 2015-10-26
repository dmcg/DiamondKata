import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DiamondTest {

    @Test
    public void a_is_a_single_line() {
        assertArrayEquals(
                new String[]{"A"}, diamond('A')
        );
    }

    private String[] diamond(char a) {
        return new String[] {"A"};
    }
}
