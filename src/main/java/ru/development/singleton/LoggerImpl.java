package ru.development.singleton;

import java.time.LocalDate;

public class LoggerImpl implements Logger {
    private static volatile LoggerImpl loggerClass;

    private LoggerImpl() {
    }

    public static LoggerImpl getInstance() {
        if (loggerClass == null) {
            synchronized (LoggerImpl.class) {
                if (loggerClass == null) {
                    loggerClass = new LoggerImpl();
                }
            }
        }
        return loggerClass;
    }

    @Override
    public void classLogg(Object obj, String info) {
        System.out.println("Log info: " + LocalDate.now() + " - " + obj.getClass().getSimpleName() + " - " + info);

    }
}
