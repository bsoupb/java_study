package day7;

import day7.데이터베이스연결관리자.DatabaseConnectionManager;
import day7.로깅매니저.LogManager;
import day7.설정관리자.ConfigurationManager;
import day7.스레드풀매니저.ThreadPoolManager;
import day7.의존성주입싱글톤.ApplicationContext;
import day7.캐시매니저.CacheManager;

import java.sql.SQLException;

public class SingletonExample {
    public static void main(String[] args) {
//        DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();

//        try {
//            System.out.println("DB 연결 객체: " + dbManager.getConnection());
//            System.out.println("동일 객체 여부: " + (dbManager == DatabaseConnectionManager.getInstance()));
//        } catch (SQLException e) {
//            System.out.println("DB 연결 실패: " + e.getMessage());
//        }

//        LogManager log = LogManager.getInstance();
//
//        log.log(LogManager.LogLevel.INFO, "어플리케이션 시작");
//        log.log(LogManager.LogLevel.DEBUG, "디버그 메시지");
//        log.log(LogManager.LogLevel.WARNING, "경고 메시지");

//        CacheManager cacheManager = CacheManager.getInstance();
//        cacheManager.put("user.1", "김철수");
//        cacheManager.put("user.2", "김영희");
//        cacheManager.put("user.3", "홍길동");
//        System.out.println("캐시에서 user.1조회: " + cacheManager.get("user.1"));
//        System.out.println("동일 객체 여부: " + (cacheManager == CacheManager.getInstance()));

//        ConfigurationManager configManager = ConfigurationManager.INSTANCE;
//
//        configManager.setProperty("app.name", "SingleTone Demo");
//        configManager.setProperty("app.version", "1.0.0");
//
//        System.out.println("app.name: " + configManager.getProperty("app.name"));
//        System.out.println("app.version: " + configManager.getProperty("app.version"));
//        System.out.println("동일 객체 여부: " + (configManager == ConfigurationManager.INSTANCE));

//        ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstance();
//
//        threadPoolManager.execute(() -> {
//            // 동기
//            System.out.println("CPU 집약적 작업 실행 - " + Thread.currentThread().getName());
//        }, true);
//
//        threadPoolManager.execute(() -> {
//            System.out.println("I/O 집약적 작업 실행 - " + Thread.currentThread().getName());
//        }, false);
//
//        threadPoolManager.scheduleAtFixedRate(() -> {
//            System.out.println("예약된 작업 실행 - " + Thread.currentThread().getName());
//        }, 100, 1000);
//
//        System.out.println("동일 객체 여부: " + (threadPoolManager == ThreadPoolManager.getInstance()));
//
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ApplicationContext context = ApplicationContext.getInstance();


    }
}
