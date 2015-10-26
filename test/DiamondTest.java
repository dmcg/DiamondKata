import org.junit.Test;

import java.util.function.Predicate;

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

    @Test
    public void line_count() {
        for (char c = 'A'; c <= 'Z'; c++) {
            int ordinal = c - 'A';
            int lineCount = 2 * ordinal + 1;
            String[] diamond = diamond(c);
            assertEquals("For character " + c, lineCount, diamond.length);
        }
    }

    private void assertDiamond(char c, String... lines) {
        assertArrayEquals(lines, diamond(c));
    }

    private String[] diamond(char c) {
        int ordinal = c - 'A';
        int lineCount = 2 * ordinal + 1;
        if (c == 'A')
        return new String[] {"A"};
        else if (c == 'B') return                new String[]
                {
                        "A",
                        "BB",
                        "A"
                };
        else return new String[lineCount];
    }
}
