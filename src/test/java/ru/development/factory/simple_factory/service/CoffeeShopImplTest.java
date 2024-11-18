package ru.development.factory.simple_factory.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.development.factory.simple_factory.coffee_enum.CoffeeType;
import ru.development.factory.simple_factory.model.Americano;
import ru.development.factory.simple_factory.model.Coffee;
import ru.development.factory.simple_factory.model.Espresso;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeShopImplTest {
    private static CoffeeShop coffeeShop;
    private static Coffee coffeeAmericano;
    private static Coffee coffeeEspresso;

    @BeforeAll
    static void setUp() {
        coffeeShop = new CoffeeShopImpl();
        coffeeAmericano = new Americano();
        coffeeEspresso = new Espresso();
    }

    @Test
    void makeCoffee_whenAmericanoPassedToMethod_thenMakeAmericano() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coffeeShop.makeCoffee(CoffeeType.AMERICANO);

        String expectedOutput = "Ваш заказ: Американо" + System.lineSeparator() +
                "Приготовление кофе займет " + coffeeAmericano.getTimeToMake() + " минуты" + System.lineSeparator() +
                "Кофе готовится" + System.lineSeparator() +
                "Ваш " + coffeeAmericano.getName() + " готов!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void makeCoffee_whenEspressoPassedToMethod_thenMakeEspresso() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        coffeeShop.makeCoffee(CoffeeType.ESPRESSO);

        String expectedOutput = "Ваш заказ: Эспрессо" + System.lineSeparator() +
                "Приготовление кофе займет " + coffeeEspresso.getTimeToMake() + " минуты" + System.lineSeparator() +
                "Кофе готовится" + System.lineSeparator() +
                "Ваш " + coffeeEspresso.getName() + " готов!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}