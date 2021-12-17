package com.company.Euklid;

public class GCD {
    public static int GCD(int a, int b) {
        while (b != 0){
            a = a % b;
            a = a + b;
            b = a - b;
            a = a - b;
        }
        return a;
    }
}
