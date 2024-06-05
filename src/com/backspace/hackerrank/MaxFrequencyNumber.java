package com.backspace.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxFrequencyNumber {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1 ,2, 3, 1, 2, 3, 3, 3);
        System.out.println(maxFrequencyInteger(input));
    }

    public static int maxFrequencyInteger(List<Integer> input) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i: input) {
            if(frequency.containsKey(i))
                frequency.computeIfPresent( i, (k,v) -> v+1);
            else
                frequency.put(i, 1);
        }

        Integer max = Collections.max(frequency.values());
        return input.size() - max;
    }
}
