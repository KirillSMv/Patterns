package ru.development.adapter.services;

import ru.development.adapter.interfaces.MemoryCard;

public class MemoryCardImpl implements MemoryCard {
    @Override
    public void getData() {
        System.out.println("Данные считаны c карты памяти");
    }
}
