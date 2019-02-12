package com.pavlyshyn.task2;

import java.awt.*;
import java.util.*;

public class Menu {
    Map<String, DescriptionAction> descriptionActionMap;

    public Menu() {
        descriptionActionMap = new LinkedHashMap<>();
    }

    public Menu(Map<String, DescriptionAction> descriptionActionMap) {
        this.descriptionActionMap = descriptionActionMap;
    }

    public void put(String command, String description, Command actionable) {
        descriptionActionMap.put(command, new DescriptionAction(description, actionable));
    }

    public void outputMenu() {
        System.out.println("\nMenu:");
        descriptionActionMap.entrySet()
                .stream()
                .forEach((Map.Entry<String, DescriptionAction> m) -> {
                    System.out.println(m.getKey() + " " + m.getValue().getDescription());
                });

    }

    public void run() {
        String keyMenu;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            outputMenu();
            System.out.println("Please select option.");
            keyMenu = scanner.nextLine().toUpperCase();
            try {
                String parameter = null;
                switch (keyMenu) {
                    case "1":
                    case "3":
                    case "4":
                        System.out.println("Enter value");
                        parameter = scanner.nextLine();
                        break;
                }
                descriptionActionMap.get(keyMenu).getCommand().execute(parameter);
            } catch (Exception e) {
            }
        }
    }

    static Menu createDemoMenu() {
        Menu menuMap = new Menu();
        menuMap.put("1", "Say hello to somebody", (s) -> {
            System.out.println("Hello " + s + "!");
        });
        menuMap.put("2", "Make a beep", new Command() {
                    @Override
                    public void execute(String s) {
                        Toolkit.getDefaultToolkit().beep();
                    }
                }
        );
        menuMap.put("3", "Message", System.out::println);
        menuMap.put("4", "TODO list", new TodoList());

        menuMap.put("Q", "exit", (s) -> {
            System.exit(0);
        });
        return menuMap;
    }
}
