package leetcode;

/**
 * Created by huangd on 9/20/15.
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num == num / 2 * 2) {
            return isUgly(num / 2);
        }
        if (num == num / 3 * 3) {
            return isUgly(num / 3);
        }
        if (num == num / 5 * 5) {
            return isUgly(num / 5);
        }
        return false;
    }
}
