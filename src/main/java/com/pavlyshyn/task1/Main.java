package com.pavlyshyn.task1;



public class Main {
    public static void main(String[] args) {
        TripleFunction maxFunction =
                (a,b,c)-> (a>b)&&(a>c)?a:(b>c)?b:c;


        System.out.println("Max value " + maxFunction.apply(3,3,1));
        TripleFunction averageFunction=
                (a,b,c)-> (int)Math.round((double)(a+b+c)/3);
        System.out.println("Average value" + averageFunction.apply(5,6,7));
    }


}
