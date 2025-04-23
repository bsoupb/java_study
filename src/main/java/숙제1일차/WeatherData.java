package 숙제1일차;

/*
    날씨 정보를 나타내는 불변 클래스
    double temperatureCelsius,
    int humidityPercent,
    double pressureHPa,
    double windSpeedMps,
    int widDirectionDegrees

    1. 유효성 검증(온도 범위, 습도 범위 등)
    2. 온도 단위 변환 메소드 (섭씨 <-> 화씨)
    3. 날씨 상태 계산 메소드 (추움, 더움, 적당함) 
    4. 불쾌지수 계산 메소드
    5. withCelsius, withHumidity
    * enum 으로 표현하는게 좋음
    * 기준은 상수로 고정해서 하는게 좋음
    
    시간 남으면 테스트 코드도 해보기
 */
public record WeatherData() {
}
