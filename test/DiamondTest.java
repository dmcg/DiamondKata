import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DiamondTest {

    @Test
    public void line_count() {
        for (char c = 'A'; c <= 'Z'; c++) {
            int ordinal = c - 'A';
            int lineCount = 2 * ordinal + 1;
            String[] diamond = diamond(c);
            assertEquals("For character " + c, lineCount, diamond.length);
        }
    }

    @Test
    public void character_count() {
        for (char c = 'A'; c <= 'Z'; c++) {
            int ordinal = c - 'A';
            int lineCount = 2 * ordinal + 1;
            String[] diamond = diamond(c);
            for (int i = 0; i < diamond.length; i++) {
                String line = diamond[i];
                assertEquals(String.format("For character %s, line %s, %s", c, i, line), lineCount, line.length());
            }
        }
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
