package com.pavlyshyn.task3;

import javafx.scene.control.RadioButton;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {

    List<Integer> next(int number) {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(100)).limit(number).collect(Collectors.toList());

    }
    List<Integer> next() {
        Random random = new Random();
        return Stream.iterate(1,(s)->random.nextInt(100)).limit(10).collect(Collectors.toList());
    }
}
