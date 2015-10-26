import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DiamondTest {

    @Test
    public void line_count() {
        checkLines((c, lines) ->
            assertEquals("For character " + c, lineCountFor(c), lines.length)
        );
    }

    @Test
    public void character_count() {
        checkLines((c, index, line) -> {
            assertEquals(String.format("For character %s, line %s, %s", c, index, line), lineCountFor(c), line.length());
        });
    }

    @Test
    public void character_for_line_goes_up_then_down() {
        assertEquals('A', characterForLine('A', 0));

        assertEquals('A', characterForLine('C', 0));
        assertEquals('B', characterForLine('C', 1));
        assertEquals('C', characterForLine('C', 2));
        assertEquals('B', characterForLine('C', 3));
        assertEquals('A', characterForLine('C', 4));

    }

    private char characterForLine(char c, int index) {
        int distanceFromEnd = index <= ordinal(c) ? index : lineCountFor(c) - index - 1;
        return (char) ('A' + distanceFromEnd);
    }


    private String[] diamond(char c) {
        int ordinal = ordinal(c);
        int lineCount = 2 * ordinal + 1;
        String[] result = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            char[] chars = new char[lineCount];
            Arrays.fill(chars, ' ');
            result[i] = new String(chars);
        }
        return result;
    }


    interface LinesChecker {
        void check(char c, String[] lines);
    }

    interface LineChecker {
        void check(char c, int index, String line);
    }

    private void checkLines(LineChecker checker) {
        checkLines((c, lines) -> {
            for (int i = 0; i < lines.length; i++) {
                checker.check(c, i, lines[i]);
            }
        });
    }

    private void checkLines(LinesChecker checker) {
        for (char c = 'A'; c <= 'Z'; c++) {
            checker.check(c, diamond(c));
        }
    }

    private int lineCountFor(char c) {
        return 2 * ordinal(c) + 1;
    }

    private int ordinal(char c) {
        return c - 'A';
    }

}
