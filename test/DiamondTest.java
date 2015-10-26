import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DiamondTest {

    @Test
    public void line_count() {
        checkLines((c, lines) ->
            assertEquals("For character " + c, 2 * ordinal(c) + 1, lines.length)
        );
    }

    @Test
    public void character_count() {
        checkLines((c, index, line) -> {
            assertEquals(String.format("For character %s, line %s, %s", c, index, line), lineCountFor(c), line.length());
        });
    }

    @Test
    public void characterForLine_goes_up_then_down() {
        assertEquals('A', characterForLine('A', 0));

        assertEquals('A', characterForLine('C', 0));
        assertEquals('B', characterForLine('C', 1));
        assertEquals('C', characterForLine('C', 2));
        assertEquals('B', characterForLine('C', 3));
        assertEquals('A', characterForLine('C', 4));
    }

    @Test
    public void locationsInLine_goes_out_then_in() {
        assertArrayEquals(pair(0, 0), locationsInLine('A', 0));

        assertArrayEquals(pair(2, 2), locationsInLine('C', 0));
        assertArrayEquals(pair(1, 3), locationsInLine('C', 1));
        assertArrayEquals(pair(0, 4), locationsInLine('C', 2));
        assertArrayEquals(pair(1, 3), locationsInLine('C', 3));
        assertArrayEquals(pair(2, 2), locationsInLine('C', 4));
    }

    @Test
    public void lineFor_combines_character_and_location() {
        assertEquals("A", lineFor('A', 0));

        assertEquals("  A  ", lineFor('C', 0));
        assertEquals(" B B ", lineFor('C', 1));
        assertEquals("C   C", lineFor('C', 2));
        assertEquals(" B B ", lineFor('C', 3));
        assertEquals("  A  ", lineFor('C', 4));
    }

    @Test
    public void test() {
        assertArrayEquals(arrayOf("A"), diamond('A'));

        assertArrayEquals(arrayOf(
                "  A  ",
                " B B ",
                "C   C",
                " B B ",
                "  A  "),
            diamond('C'));
    }

    private String lineFor(char c, int lineIndex) {
        int lineLength = lineCountFor(c);
        char[] chars = new char[lineLength];
        Arrays.fill(chars, ' ');
        int[] locations = locationsInLine(c, lineIndex);
        chars[locations[0]] = characterForLine(c, lineIndex);
        chars[locations[1]] = characterForLine(c, lineIndex);
        return new String(chars);
    }

    private int[] locationsInLine(char c, int lineIndex) {
        int lineLength = lineCountFor(c);
        int centre = lineLength / 2;
        int distanceFromEnd = lineIndex <= ordinal(c) ? lineIndex : lineLength - lineIndex - 1;
        return new int[] {centre - distanceFromEnd, centre + distanceFromEnd};
    }

    private char characterForLine(char c, int lineIndex) {
        int distanceFromEnd = lineIndex <= ordinal(c) ? lineIndex : lineCountFor(c) - lineIndex - 1;
        return (char) ('A' + distanceFromEnd);
    }

    private String[] diamond(char c) {
        int ordinal = ordinal(c);
        int lineCount = 2 * ordinal + 1;
        String[] result = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            result[i] = lineFor(c, i);
        }
        return result;
    }

    private int[] pair(int i1, int i2) {
        return new int[]{i1, i2};
    }

    private String[] arrayOf(String... strings) {
        return strings;
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
