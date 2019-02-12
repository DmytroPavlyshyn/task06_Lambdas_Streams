package com.pavlyshyn.task2;


import java.util.ArrayList;

public class TodoList extends ArrayList<String> implements Command {
    @Override
    public void execute(String s) {
        if (s.equals("run")) {
            showToDo();
        }
        else {
            add(s);
        }
    }



    private void showToDo() {
        int i = 1;
        System.out.println("Tasks");
        forEach((s) ->
            System.out.println("-\t" + s)
        );
    }

}
