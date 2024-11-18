package ru.development;

import ru.development.proxy.Connection;
import ru.development.proxy.ConnectionImpl;
import ru.development.proxy.ConnectionProxy;

public class Main {
    public static void main(String[] args) {
        Connection connection = new ConnectionImpl();
        ConnectionProxy connectionProxy = new ConnectionProxy(connection);
        connectionProxy.getConnection("postgres");
        connectionProxy.getConnection("mySql");
    }
}