package ru.development.adapter.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.development.adapter.adapter.UsbMemoryCardAdapter;
import ru.development.adapter.interfaces.Computer;
import ru.development.adapter.interfaces.MemoryCard;
import ru.development.adapter.interfaces.UsbDevice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputerImplTest {
    private static Computer computer;
    private static UsbDevice usbDevice;
    private static MemoryCard memoryCard;
    private static ByteArrayOutputStream outContent;

    @BeforeAll
    static void beforeAll() {
        computer = new ComputerImpl();
        usbDevice = new UsbDeviceImpl();
        memoryCard = new MemoryCardImpl();
        outContent = new ByteArrayOutputStream();
    }

    @AfterEach
    void reset() {
        outContent.reset();
    }

    @Test
    void readData_whenUsbDeviceIsUsed_thenDataIsRed() throws IOException {
        System.setOut(new PrintStream(outContent));
        computer.readData(usbDevice);

        String expectedOutput = "Начинаю чтение данных" + System.lineSeparator() +
                "Данные считаны c usb устройства" + System.lineSeparator() +
                "Процесс окончен." + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    void readData_whenMemoryCardIsUsedWithAdapter_thenDataIsRed() throws IOException {
        System.setOut(new PrintStream(outContent));

        UsbMemoryCardAdapter adapter = new UsbMemoryCardAdapter(memoryCard);
        computer.readData(adapter);

        String expectedOutput = "Начинаю чтение данных" + System.lineSeparator() +
                "Данные считаны c карты памяти" + System.lineSeparator() +
                "Процесс окончен." + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }
}