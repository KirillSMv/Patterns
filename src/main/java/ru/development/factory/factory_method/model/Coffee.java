package ru.development.factory.factory_method.model;

public abstract class Coffee {
    String name;
    Integer timeToMake;

    public Coffee(String name, Integer timeToMake) {
        this.name = name;
        this.timeToMake = timeToMake;
    }

    public String getName() {
        return name;
    }

    public Integer getTimeToMake() {
        return timeToMake;
    }
}
