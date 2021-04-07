package com.hillogy.functionaljava.functionaltechniques.tailcalloptimization;

//also known as TCO or TailCallRecursion
public class TailCallOptimization {

    public static void main(String[] args) {

 //       System.out.println(tailReFact(3,4));
        System.out.println(tailReFact(2,3 * 4));

    }

    public static long reFact(int n){   //regular recursion
        if(n <= 1)
            return 1;
        else
            return n * reFact(n-1);
    }

    public static long tailReFact(int n, int a){
        if(n <= 1)
            return a;
        else
            return tailReFact(n-1, n*a);
    }

}
