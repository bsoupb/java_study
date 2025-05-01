package day2.예제2;

// 1. 인터페이스 구현
public interface Logger {
    void log(String message);
    void error(String message);
    LogLevel getLogLevel();
}
