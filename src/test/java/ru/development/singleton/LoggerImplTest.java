package ru.development.singleton;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class LoggerImplTest {

    @Test
    void getInstance_whenMethodCalledTwice_thenReturnTheSameInstance() {
        LoggerImpl logger1 = LoggerImpl.getInstance();
        LoggerImpl logger2 = LoggerImpl.getInstance();
        assertSame(logger1, logger2);
    }

    @Test
    void getInstance_whenMethodCalledInConcurrentThreads_thenReturnTheSameInstance() throws InterruptedException {
        final int threadsNumber = 10;
        Logger[] loggers = new Logger[threadsNumber];
        CountDownLatch latch = new CountDownLatch(threadsNumber);

        for (int i = 0; i < threadsNumber; i++) {
            final int l = i;
            new Thread(() -> {
                loggers[l] = LoggerImpl.getInstance();
                latch.countDown();
            }).start();
        }
        latch.await();

        for (int i = 0; i < threadsNumber - 1; i++) {
            assertSame(loggers[i], loggers[i + 1]);
        }
    }

    @Test
    void classLogg_whenObjectAndInformationPassed_thenPrintRequiredInformation() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Logger logger = LoggerImpl.getInstance();
        Object objectForTest = new Object();

        logger.classLogg(objectForTest, "information for test");

        String expectedOutput = "Log info: " + LocalDate.now() + " - " + objectForTest.getClass().getSimpleName() + " - information for test" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}