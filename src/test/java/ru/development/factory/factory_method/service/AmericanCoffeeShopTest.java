package ru.development.factory.factory_method.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.development.factory.factory_method.coffee_enum.CoffeeType;
import ru.development.factory.factory_method.model.Americano;
import ru.development.factory.factory_method.model.Coffee;
import ru.development.factory.factory_method.model.Ristretto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AmericanCoffeeShopTest {
    private static CoffeeShop coffeeShop;
    private static Coffee coffeeAmericano;

    @BeforeEach
    void setUp() {
        coffeeShop = new AmericanCoffeeShop();
        coffeeAmericano = new Americano();
    }

    @Test
    void startMakingCoffee_whenIncorrectCoffeeTypePassed_thenExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () ->
                coffeeShop.startMakingCoffee(CoffeeType.RISTRETTO), "Такого варианта кофе в заведении не предусмотрено");
    }

    @Test
    void startMakingCoffee_whenCorrectCoffeeTypePassed_thenCoffeeMade() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coffeeShop.startMakingCoffee(CoffeeType.AMERICANO);

        String expectedOutput = "Ваш заказ: Американо" + System.lineSeparator() +
                "Приготовление кофе займет " + coffeeAmericano.getTimeToMake() + " минуты" + System.lineSeparator() +
                "Кофе готовится" + System.lineSeparator() +
                "Ваш " + coffeeAmericano.getName() + " готов!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}