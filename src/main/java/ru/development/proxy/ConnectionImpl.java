package ru.development.proxy;

public class ConnectionImpl implements Connection {

    @Override
    public void getConnection(String dbUrl) {
        //имитация фактического подключения к базе данных
        System.out.println("подключено " + dbUrl);
    }
}
