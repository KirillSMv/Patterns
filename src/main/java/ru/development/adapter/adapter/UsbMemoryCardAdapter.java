package ru.development.adapter.adapter;

import ru.development.adapter.interfaces.MemoryCard;
import ru.development.adapter.interfaces.UsbDevice;

public class UsbMemoryCardAdapter implements UsbDevice {
    MemoryCard memoryCard;

    public UsbMemoryCardAdapter(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void getData() {
        memoryCard.getData();
    }
}
