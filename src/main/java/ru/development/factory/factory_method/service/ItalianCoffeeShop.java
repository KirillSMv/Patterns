package ru.development.factory.factory_method.service;

import ru.development.factory.factory_method.coffee_enum.CoffeeType;
import ru.development.factory.factory_method.model.Coffee;
import ru.development.factory.factory_method.model.Lungo;
import ru.development.factory.factory_method.model.Ristretto;
import ru.development.factory.factory_method.model.Shakerato;

public class ItalianCoffeeShop extends CoffeeShop {

    @Override
    public void startMakingCoffee(CoffeeType coffeeType) {
        Coffee coffee;
        switch (coffeeType) {
            case RISTRETTO -> coffee = new Ristretto();
            case LUNGO -> coffee = new Lungo();
            case SHAKERATO -> coffee = new Shakerato();
            default -> throw new IllegalArgumentException("Такого варианта кофе в заведении не предусмотрено");
        }
        makeCoffee(coffee);
    }
}
