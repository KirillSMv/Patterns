package ru.development.proxy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectionProxyTest {

    @Test
    void getConnection_whenNameIsPassed_thenEnsureConnection() {
        Connection connection = new ConnectionImpl();
        ConnectionProxy connectionProxy = new ConnectionProxy(connection);
        String dbName = "postgres";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        connectionProxy.getConnection(dbName);

        String expectedOutput = "подключено localhost:port/" + dbName + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void getConnection_whenAnotherNameIsPassed_thenEnsureConnection() {
        Connection connection = new ConnectionImpl();
        ConnectionProxy connectionProxy = new ConnectionProxy(connection);
        String dbName = "mysql";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        connectionProxy.getConnection(dbName);

        String expectedOutput = "подключено localhost:port/" + dbName + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}