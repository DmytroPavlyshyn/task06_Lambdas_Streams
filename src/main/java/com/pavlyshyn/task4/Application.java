package com.pavlyshyn.task4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    private List<String> readListString() {
        List<String> strings = new ArrayList<>();

        String line;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!(line = scanner.nextLine()).isEmpty()) {
                strings.add(line);
            }
            return strings;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private long countDistinctWords(List<String> text) {
        return text.stream().flatMap((line) -> Stream.of(line.split(" "))).distinct().count();
    }

    private List<String> uniqueWords(List<String> text) {
        return text.stream().flatMap((line) -> Stream.of(line.split(" "))).distinct().sorted().collect(Collectors.toList());
    }

    private Map<String, Long> countWords(List<String> text) {
        return text.stream().flatMap((line) -> Stream.of(line.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Map<String, Long> countSymbol(List<String> text) {
        return text.stream()
                .flatMap((line) -> Stream.of(line.split(" ")))
                .flatMap(word -> Stream.of(word.split("")).filter(ch -> !Character.isUpperCase(ch.charAt(0))))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void run() {
        List<String> list = readListString();
        System.out.println("Number of unique words: " + countDistinctWords(list));
        System.out.println("Sorted list of all unique words: " + uniqueWords(list));
        System.out.println("Word count: " + countWords(list));
        System.out.println("Symbol count except upper case: " + countSymbol(list));
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
