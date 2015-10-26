import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DiamondTest {

    @Test
    public void test() {
        assertArrayEquals(arrayOf("A"), diamond('A'));

        assertArrayEquals(arrayOf(
            " A ",
            "B B",
            " A "),
            diamond('B'));

        assertArrayEquals(arrayOf(
            "  A  ",
            " B B ",
            "C   C",
            " B B ",
            "  A  "),
            diamond('C'));
    }

    public static String[] diamond(char c) {
        int lineCount = 2 * (c - 'A') + 1;
        String[] result = new String[lineCount];

        for (int i = 0; i <= lineCount / 2; i++) {
            result[i] = lineFor(i, lineCount);
            result[lineCount - i - 1] = result[i];
        }
        return result;
    }

    private static String lineFor(int lineIndex, int lineLength) {
        char characterForLine = (char) ('A' + lineIndex);
        int centre = lineLength / 2;

        char[] chars = new char[lineLength];
        Arrays.fill(chars, ' ');
        chars[centre - lineIndex] = characterForLine;
        chars[centre + lineIndex] = characterForLine;
        return new String(chars);
    }

    private String[] arrayOf(String... strings) {
        return strings;
    }

}
