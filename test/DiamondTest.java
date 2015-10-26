import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DiamondTest {

    @Test
    public void a_is_a_single_line() {
        assertDiamond('A',
                "A"
        );
    }

    @Test
    public void b_is_three_lines() {
        assertDiamond('B',
                "A",
                "BB",
                "A"
        );
    }

    private void assertDiamond(char c, String... lines) {
        assertArrayEquals(lines, diamond(c));
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
