package ru.development.factory.factory_method.service;


import ru.development.factory.factory_method.coffee_enum.CoffeeType;
import ru.development.factory.factory_method.model.Coffee;

public abstract class CoffeeShop {
    void makeCoffee(Coffee coffee) {
        confirmOrder(coffee);
        prepareCoffee();
        handTheOrder(coffee);
    }
    public abstract void startMakingCoffee(CoffeeType coffeeType);

    private void confirmOrder(Coffee coffee) {
        System.out.println("Ваш заказ: " + coffee.getName());
        System.out.println("Приготовление кофе займет " + coffee.getTimeToMake() + " минуты");
    }

    private void prepareCoffee() {
        System.out.println("Кофе готовится");
    }

    private void handTheOrder(Coffee coffee) {
        System.out.println("Ваш " + coffee.getName() + " готов!");
    }
}
