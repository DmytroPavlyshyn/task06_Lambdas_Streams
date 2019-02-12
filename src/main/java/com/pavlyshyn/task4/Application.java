package com.pavlyshyn.task4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    List<String> readListString() {
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
   long countDistinctWords(List<String> text){
        return text.stream().flatMap((line)-> Stream.of(line.split(" "))).distinct().count();
   }
   List<String> uniqueWords(List<String> text){
        return text.stream().flatMap((line)-> Stream.of(line.split(" "))).distinct().sorted().collect(Collectors.toList());
   }
    Map<String,Long> countWords(List<String> text){
        return text.stream().flatMap((line)-> Stream.of(line.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
    Map<String,Long> countSymbol(List<String> text){
        return text.stream()
                .flatMap((line)-> Stream.of(line.split(" ")))
                .flatMap(word->Stream.of(word.split("")).filter(ch->!Character.isUpperCase(ch.charAt(0))))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
    public static void main(String[] args) {
        Application application = new Application();
        //System.out.println(application.readListString());
        System.out.println(application.countDistinctWords(new ArrayList<>(Arrays.asList("hello 12", "13 hello 12 45 45"))));
        System.out.println(application.uniqueWords(new ArrayList<>(Arrays.asList("hello 12", "13 hello 12 45 45"))));
        //---------------------------------------------------------------------------------------------------------
        System.out.println(application.countSymbol(new ArrayList<>(Arrays.asList("hello 12", "13 heGGllo 12 45 45"))));
    }
}
