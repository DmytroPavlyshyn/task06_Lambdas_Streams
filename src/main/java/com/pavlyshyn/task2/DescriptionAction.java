package com.pavlyshyn.task2;

public class DescriptionAction {
    private String description;
    private Command action;

    public DescriptionAction(String description, Command action) {
        this.description = description;
        this.action = action;

    }

    public String getDescription() {
        return description;
    }

    public Command getCommand() {
        return action;
    }
}
