package ru.development.factory.simple_factory.factory;

import ru.development.factory.simple_factory.coffee_enum.CoffeeType;
import ru.development.factory.simple_factory.model.Americano;
import ru.development.factory.simple_factory.model.Coffee;
import ru.development.factory.simple_factory.model.Espresso;

public class CoffeeFactory {
    public static Coffee getCoffee(CoffeeType coffeeType) {
        Coffee coffee = switch (coffeeType) {
            case ESPRESSO -> new Espresso();
            case AMERICANO -> new Americano();
            default -> throw new IllegalArgumentException("Такого типа кофе еще не предусмотрено");
        };
        return coffee;
    }
}
