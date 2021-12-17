package com.company.DiscreteMath;

public class Combinatorics {
    public static int NewtonBinomial(int a, int b, int n) {
        int out = 0;
        for (int i = 0; i < n + 1; i++) {
            out += (factorial(n) / (factorial(i) * factorial(n - i))) * Math.pow(a, i) * Math.pow(b, n - i);
        }
        return out;
    }

    public static int variations(int n, int k){
        return factorial(n) / factorial(n - k);
    }
    public static int variationsWithRepetition(int n, int[] k){
        int denominator = 1;
        for (int n_i: k) {
            denominator *= factorial(n_i);
        }
        return factorial(n) / denominator;
    }

    public static int permutations(int a) {
        return (factorial(a));
    }

    public static int combinations(int n, int k){
        return variations(n, k) / factorial(k);
    }

    public static int factorial(int n){
        int out = 1;
        for (int i = 2; i <= n; i++){
            out *= i;
        }
        return out;
    }

    public static void testOfCombinationsWithRepetition(int n, int k){
        for (int k_i = 0; k_i < k; k_i ++){
            System.out.println(n + "/" + 1);
        }
    }

    public static int pow(int a, int n){
        int out = a;
        for (int i = 1; i < n; i++){
            out *= a;
        }
        return out;
    }
}
