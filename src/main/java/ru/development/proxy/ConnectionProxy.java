package ru.development.proxy;

public class ConnectionProxy implements Connection {
    private final Connection connection;
    private final String hostNameAndPort = "localhost:port/";

    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getConnection(String dbName) {
        connection.getConnection(hostNameAndPort + dbName);
    }
}
