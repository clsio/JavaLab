package me.zhang.generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhangxiangdong on 2017/4/25.
 */
public class UtilityTest {

    @Test
    public void collectExample() {
        List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");
        String result = list.parallelStream().collect(StringBuilder::new,
                (response, element) -> response.append(" ").append(element),
                (response1, response2) -> response1.append(",").append(response2.toString()))
                .toString();
        System.out.println("Result: " + result);
    }

    @Test
    public void reverseASequence() {
        String[] stringSequence = {"A", "B", "C", "D", "E"};
        Utility.reverse(stringSequence);
        final String stringExpected = "E, D, C, B, A";
        assertEquals(stringExpected, toString(stringSequence));

        Integer[] numberSequence = {1, 2, 3, 4, 5};
        Utility.reverse(numberSequence);
        final String numberExpected = "5, 4, 3, 2, 1";
        assertEquals(numberExpected, toString(numberSequence));
    }

    private <T> String toString(T[] sequence) {
        StringBuilder seqBuilder = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            seqBuilder.append(sequence[i]);
            if (i < sequence.length - 1) {
                seqBuilder.append(", ");
            }
        }
        return seqBuilder.toString();
    }

}