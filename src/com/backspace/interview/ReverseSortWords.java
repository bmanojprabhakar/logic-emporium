package com.backspace.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Sort the sentence based on each word length
 * - If they are equal, sort it lexicographically
 */
public class ReverseSortWords {
    public static void main(String[] args) {
        String input = "i am a java developer from bangalore";
        System.out.println(suggestedSolution_sortWordsInReverseOrder(input));
    }

    public static List<String> mySolution_sortWordsInReverseOrder(String input) {
        String[] in = input.split(" ");

        Arrays.sort(in, ((i1, i2) -> {
            if(i2.length() < i1.length())
                return -1;
            else if(i1.length()==(i2.length()))
                return i1.compareTo(i2);
            return 1;
        }));

        return Arrays.stream(in).toList();
    }


    public static List<String> suggestedSolution_sortWordsInReverseOrder(String input) {
        String[] in = input.split(" ");

        Arrays.sort(in, Comparator.comparing(String::length)
                .reversed()
                .thenComparing(String::compareTo)
        );

        return Arrays.stream(in).toList();
    }
}
