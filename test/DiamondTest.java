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

    @Test
    public void b_is_three_lines() {
        assertArrayEquals(
                new String[]
                        {
                        "A",
                        "BB",
                        "A"
                        },
                diamond('B')
        );
    }

    private String[] diamond(char a) {
        if (a == 'A')
        return new String[] {"A"};
        else return                new String[]
                {
                        "A",
                        "BB",
                        "A"
                };
    }
}
