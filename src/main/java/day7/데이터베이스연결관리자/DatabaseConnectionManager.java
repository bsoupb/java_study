package day7.데이터베이스연결관리자;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    데이터베이스 연결관리자 -> Double-Checked Locking 싱글톤 패턴

    장점
        1. 지연 초기화 -> 실제로 쓰기 전까지 인스턴스를 생성하지 않기 때문에 메모리 효율적
        2. 멀티 스레드 환경에서 안전하게 작동
        3. getInstance() 호출 후에 첫 번째 검사에서 이미 인스턴스가 있으면 동기화 블록을 실행하지 않기 때문에 성능 최적화

    단점
        1. 자바 1.5 이전 버전에서는 volatile 키워드가 작동하지 않아서 사용이 불가능
        2. 코드가 다소 복잡


 */
public class DatabaseConnectionManager {
    // volatile -> 멀티 스레드 환경에서 변수의 가시성(visibility) 보장
    private static volatile DatabaseConnectionManager instance;

    // 데이터베이스 연결 객체
    private Connection connection;

    // 데이터베이스 접속 정보
    private final String url;
    private final String username;
    private final String password;

    private DatabaseConnectionManager() {
        // 기본 데이터베이스 정보를 저장
        this.url = "jdbc:mysql://localhost:3306/db";
        this.username = "user";
        this.password = "password";
    }

    // 다른 곳에서 사용할 수 있게 default로 설정
    DatabaseConnectionManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // 싱글톤 인스턴스 반환
    public static DatabaseConnectionManager getInstance() {
        // 첫번째 검사 -> 동기화 없이 빠른 검사
        if(instance == null) {
            // 여러 스레드가 동시에 이 블록에 접근하는 것을 방지
            synchronized (DatabaseConnectionManager.class) {
                if(instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    // 데이터베이스 연결 반환
    public Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()) {
            // 데이터베이스 연결로직
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if(connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;  // 가비지 컬렉터
        }
    }

    public static void reset() {
        synchronized (DatabaseConnectionManager.class) {
            if(instance != null) {
                try {
                    instance.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                instance = null;
            }
        }
    }
}
