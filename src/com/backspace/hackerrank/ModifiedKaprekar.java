package com.backspace.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ModifiedKaprekar {
    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }

    public static void kaprekarNumbers(int p, int q) {
        List<Long> kaprekarNos = new ArrayList<>();
        for(long i=p; i<=q; i++) {
            String squaredString = String.valueOf(i*i);
            int d = String.valueOf(i).length();

            long sumOfSquaredString = splitString(squaredString, d)
                    .stream()
                    .mapToLong(Long::parseLong)
                    .sum();

            if(sumOfSquaredString == i)
                kaprekarNos.add(i);
        }

        if(kaprekarNos.isEmpty())
            System.out.println("INVALID RANGE");
        else
            kaprekarNos.stream()
                    .map(i -> String.valueOf(i).concat(" "))
                    .forEach(System.out::print);
    }

    private static List<String> splitString(String input, int d) {
        int end = input.length(), start;
        List<String> splitStrings = new ArrayList<>();

        while(end > 0) {
            start = Math.max(0, end - d);
            splitStrings.add(input.substring(start, end));
            end = start;
        }
        return splitStrings;
    }

}

/**
 * Given two positive integers  and  where  is lower than,
 *  write a program to print the modified Kaprekar numbers in the
 *  range between and, inclusive. If no modified Kaprekar numbers
 *  exist in the given range, print INVALID RANGE.
 *
 * Function Description
 *  - Complete the kaprekarNumbers function in the editor below.
 *  - kaprekarNumbers has the following parameter(s):
 * int p: the lower limit
 * int q: the upper limit
 * Prints
 *  - It should print the list of modified Kaprekar numbers,
 *  space-separated on one line and in ascending order.
 *  If no modified Kaprekar numbers exist in the given range,
 *  print INVALID RANGE. No return value is required.
 */