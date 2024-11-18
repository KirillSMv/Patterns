package ru.development.adapter.services;

import ru.development.adapter.interfaces.UsbDevice;

public class UsbDeviceImpl implements UsbDevice {
    @Override
    public void getData() {
        System.out.println("Данные считаны c usb устройства");
    }
}
