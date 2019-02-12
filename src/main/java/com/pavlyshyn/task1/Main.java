package com.pavlyshyn.task1;



public class Main {
    public static void main(String[] args) {
        TripleFunction<Integer, Integer,Integer,Integer> maxFunction =
                (a,b,c)-> (a>b)&&(a>c)?a:(b>c)?b:c;


        System.out.println("Max value " + maxFunction.apply(3,3,1));
        TripleFunction<Integer,Integer,Integer,Integer> averageFunction=
                (a,b,c)-> (int)Math.round((double)(a+b+c)/3);
        System.out.println("Avarage value" + averageFunction.apply(5,6,7));
    }


}
