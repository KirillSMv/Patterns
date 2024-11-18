package ru.development.factory.factory_method.service;

import ru.development.factory.factory_method.coffee_enum.CoffeeType;
import ru.development.factory.factory_method.model.Americano;
import ru.development.factory.factory_method.model.Cappuccino;
import ru.development.factory.factory_method.model.Coffee;
import ru.development.factory.factory_method.model.Espresso;

public class AmericanCoffeeShop extends CoffeeShop {
    @Override
    public void startMakingCoffee(CoffeeType coffeeType) {
        Coffee coffee;
        switch (coffeeType) {
            case AMERICANO -> coffee = new Americano();
            case ESPRESSO -> coffee = new Espresso();
            case CAPPUCCINO -> coffee = new Cappuccino();
            default -> throw new IllegalArgumentException("Такого варианта кофе в заведении не предусмотрено");
        }
        makeCoffee(coffee);
    }
}
