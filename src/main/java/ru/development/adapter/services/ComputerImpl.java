package ru.development.adapter.services;

import ru.development.adapter.interfaces.Computer;
import ru.development.adapter.interfaces.UsbDevice;

public class ComputerImpl implements Computer {
    @Override
    public void readData(UsbDevice usbDevice) {
        System.out.println("Начинаю чтение данных");
        usbDevice.getData();
        System.out.println("Процесс окончен.");
    }
}
