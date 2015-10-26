import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DiamondTest {

    public interface LinesChecker {
        void check(char c, String[] lines);
    }

    @Test
    public void line_count() {
        checkLines((c, lines) ->
            assertEquals("For character " + c, lineCountFor(c), lines.length)
        );
    }


    @Test
    public void character_count() {
        checkLines((c, lines) -> {
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                assertEquals(String.format("For character %s, line %s, %s", c, i, line), lineCountFor(c), line.length());
            }
        });
    }

    private void checkLines(LinesChecker checker) {
        for (char c = 'A'; c <= 'Z'; c++) {
            checker.check(c, diamond(c));
        }
    }

    private int lineCountFor(char c) {
        return 2 * (c - 'A') + 1;
    }

    private String[] diamond(char c) {
        int ordinal = c - 'A';
        int lineCount = 2 * ordinal + 1;
        String[] result = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            char[] chars = new char[lineCount];
            Arrays.fill(chars, ' ');
            result[i] = new String(chars);
        }
        return result;
    }
}
