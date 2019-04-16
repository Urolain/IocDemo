package eazy;

public class Solution {


    public static void main(String[] args) {

        /*
        //  E-2 整数翻转
        int i = 50680120;
        System.out.println(i+"翻转后="+ReverseInteger.reverse(i));
        //  6ms 33MB
        */

        int i = 121;
        System.out.println(i + (PalindromeNumber.isPalindromeNumber(i)?"是回文数":"不是回文数"));

    }
}
