package com.pavlyshyn.task3;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public void showStatistic(int number){

        List<Integer> list = new Generator().next();
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(list);
        System.out.println("Average value: " + list.stream().mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println("Min value: " + intSummaryStatistics.getMin());
        System.out.println("Max value: " + intSummaryStatistics.getMax());
        System.out.println("Sum value: " + intSummaryStatistics.getSum());
        System.out.println("Sum value: " + list.stream().mapToInt(Integer::intValue).reduce((a,b)->a+b).getAsInt());

        double average = intSummaryStatistics.getAverage();
        System.out.println("Bigger than average " + average + ": " + list.stream().mapToInt(Integer::intValue).filter((a)->a>average).count());

    }
    public static void main(String[] args) {
        new Main().showStatistic(10);
    }
}
