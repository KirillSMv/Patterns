package ru.development.factory.factory_method.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.development.factory.factory_method.coffee_enum.CoffeeType;
import ru.development.factory.factory_method.model.Coffee;
import ru.development.factory.factory_method.model.Ristretto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItalianCoffeeShopTest {
    private static CoffeeShop coffeeShop;
    private static Coffee coffeeRistretto;

    @BeforeAll
    static void setUp() {
        coffeeShop = new ItalianCoffeeShop();
        coffeeRistretto = new Ristretto();
    }

    @Test
    void startMakingCoffee_whenIncorrectCoffeeTypePassed_thenExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () ->
                coffeeShop.startMakingCoffee(CoffeeType.AMERICANO), "Такого варианта кофе в заведении не предусмотрено");
    }

    @Test
    void startMakingCoffee_whenCorrectCoffeeTypePassed_thenCoffeeMade() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coffeeShop.startMakingCoffee(CoffeeType.RISTRETTO);

        String expectedOutput = "Ваш заказ: Ристретто" + System.lineSeparator() +
                "Приготовление кофе займет " + coffeeRistretto.getTimeToMake() + " минуты" + System.lineSeparator() +
                "Кофе готовится" + System.lineSeparator() +
                "Ваш " + coffeeRistretto.getName() + " готов!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}