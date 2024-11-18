package ru.development.factory.simple_factory.service;

import ru.development.factory.simple_factory.coffee_enum.CoffeeType;
import ru.development.factory.simple_factory.factory.CoffeeFactory;
import ru.development.factory.simple_factory.model.Coffee;

public class CoffeeShopImpl implements CoffeeShop {
    @Override
    public void makeCoffee(CoffeeType coffeeType) {
        Coffee coffee = CoffeeFactory.getCoffee(coffeeType);
        confirmOrder(coffee);
        prepareCoffee();
        handOverTheOrder(coffee);
    }

    private void confirmOrder(Coffee coffee) {
        System.out.println("Ваш заказ: " + coffee.getName());
        System.out.println("Приготовление кофе займет " + coffee.getTimeToMake() + " минуты");
    }

    private void prepareCoffee() {
        System.out.println("Кофе готовится");
    }

    private void handOverTheOrder(Coffee coffee) {
        System.out.println("Ваш " + coffee.getName() + " готов!");
    }
}
