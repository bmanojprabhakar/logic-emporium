package com.backspace.hackerrank;

public class chocolateFeast {
    public static int findMaxChocolates(int n, int c, int m) {
        int totalBars = n/c;
        int wrappersRemaining = n/c;

        while(wrappersRemaining >= m) {
            int bars = wrappersRemaining/m;
            totalBars += bars;
            wrappersRemaining = bars+(wrappersRemaining%m);
        }
        return totalBars;
    }

    public static void main(String[] args) {
        System.out.println(findMaxChocolates(6,2,2));
    }
}


/**
 * Little Bobby loves chocolate. He frequently goes to his favorite  store, Penny Auntie, to buy them. They are having a promotion at Penny Auntie. If Bobby saves enough wrappers, he can turn them in for a free chocolate.
 *
 * Example
 *
 * He has  to spend, bars cost , and he can turn in  wrappers to receive another bar.
 *  Initially, he buys  bars and has  wrappers after eating them. He turns in  of them,
 *  leaving him with , for  more bars. After eating those two, he has  wrappers, turns in
 *  leaving him with  wrapper and his new bar. Once he eats that one, he has  wrappers and turns
 *  them in for another bar. After eating that one, he only has  wrapper, and his feast ends.
 *  Overall, he has eaten  bars.
 *
 * Function Description
 * chocolateFeast has the following parameter(s):
 *
 * int n: Bobby's initial amount of money
 * int c: the cost of a chocolate bar
 * int m: the number of wrappers he can turn in for a free bar
 * Returns
 *
 * int: the number of chocolates Bobby can eat after taking full advantage of the promotion
 * Note: Little Bobby will always turn in his wrappers if he has enough to get a free chocolate.
 *
 */