package 숙제1일차;

import java.util.Objects;

/*
    날씨 정보를 나타내는 불변 클래스
    double temperatureCelsius(온도),
    int humidityPercent(습도),
    double pressureHPa(기압),
    double windSpeedMps(풍속),
    int widDirectionDegrees(바람 불어오는 방향)

    1. 유효성 검증(온도 범위, 습도 범위 등)
    2. 온도 단위 변환 메소드 (섭씨 <-> 화씨)
    3. 날씨 상태 계산 메소드 (추움, 더움, 적당함) 
    4. 불쾌지수 계산 메소드
    5. withCelsius, withHumidity
    * enum 으로 표현하는게 좋음
    * 기준은 상수로 고정해서 하는게 좋음
    
    시간 남으면 테스트 코드도 해보기
 */

enum WeatherStatus {
    Cold,
    Hot,
    Cool
}

public record WeatherData(
        double temperatureCelsius,
        int humidityPercent,
        double pressureHPa,
        double windSpeedMps,
        int widDirectionDegrees
) {

    public WeatherData {
        if (temperatureCelsius < 0 || temperatureCelsius > 40) {
            throw new IllegalArgumentException("temperatureCelsius must be between 0 and 40");
        }

        if (humidityPercent < 0 || humidityPercent > 100) {
            throw new IllegalArgumentException("humidityPercent must be between 0 and 100");
        }

        if (pressureHPa < 0 || pressureHPa > 100) {
            throw new IllegalArgumentException("pressureHPa must be between 0 and 100");
        }

        if (windSpeedMps < 0 || windSpeedMps > 20) {
            throw new IllegalArgumentException("windSpeedMps must be between 0 and 20");
        }

        if (widDirectionDegrees < 0 || widDirectionDegrees > 360) {
            throw new IllegalArgumentException("widDirectionDegrees must be between 0 and 360");
        }
    }

    // 화씨온도 = (섭씨온도 * 9/5) + 32
    public double temperatureUnitConversion() {
        return (temperatureCelsius * 9 / 5) + 32;
    }

    // Cold -> temperatureCelsius < 15
    // Hot -> temperatureCelsius > 25
    // Cool -> 그 외
    public WeatherStatus calculateWeatherStatus() {
        WeatherStatus weatherStatus;
        if (temperatureCelsius > 25) {
            weatherStatus = WeatherStatus.Hot;
        } else if (temperatureCelsius > 15) {
            weatherStatus = WeatherStatus.Cool;
        } else {
            weatherStatus = WeatherStatus.Cold;
        }
        return weatherStatus;
    }

    // 불쾌지수 = 0.72 * (기온 + 습도) + 40.6
    public double calculateDI() {
        return 0.72 * (temperatureCelsius + humidityPercent) + 40.6;
    }

}
