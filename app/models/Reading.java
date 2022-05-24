package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import java.util.Date;

import static java.lang.Math.pow;
import static java.lang.Math.round;

@Entity
public class Reading extends Model {
    public Date date;
    public int code;
    public double temperature;
    public double windSpeed;
    public int windDirection;
    public int pressure;

    public int beaufort;
    public double fahrenheit;
    public String weather;
    public String compass;
    public double windChill;


    public Reading(Date date, int code, double temperature, double windSpeed, int windDirection, int pressure) {
        this.date = date;
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
    }


    // helper methods//

    public int calcBeaufort() {
        if (windSpeed <= 1.0) {
            beaufort = 0;
        } else if ((windSpeed > 1.0) && (windSpeed <= 5.0)) {
            beaufort = 1;
        } else if ((windSpeed >= 6.0) && (windSpeed <= 11.0)) {
            beaufort = 2;
        } else if ((windSpeed >= 12.0) && (windSpeed <= 19.0)) {
            beaufort = 3;
        } else if ((windSpeed >= 20.0) && (windSpeed <= 28.0)) {
            beaufort = 4;
        } else if ((windSpeed >= 29.0) && (windSpeed <= 38.0)) {
            beaufort = 5;
        } else if ((windSpeed >= 39.0) && (windSpeed <= 49.0)) {
            beaufort = 6;
        } else if ((windSpeed >= 50.0) && (windSpeed <= 61.0)) {
            beaufort = 7;
        } else if ((windSpeed >= 62.0) && (windSpeed <= 74.0)) {
            beaufort = 8;
        } else if ((windSpeed >= 75.0) && (windSpeed <= 88.0)) {
            beaufort = 9;
        } else if ((windSpeed >= 89.0) && (windSpeed <= 102.0)) {
            beaufort = 10;
        } else if ((windSpeed >= 103.0) && (windSpeed <= 117.0)) {
            beaufort = 11;
        }
        return beaufort;
    }

    public double calcFahrenheit() {
        fahrenheit = (temperature * 9.0/5.0) + 32;
        return fahrenheit;
    }

    public String codeWeather() {
        if (code == 100) {
            weather = "Clear";
        } else if (code == 200) {
            weather = "Partial Clouds";
        } else if (code == 300) {
            weather = "Cloudy";
        } else if (code == 400) {
            weather = "Light Showers";
        } else if (code == 500) {
            weather = "Heavy Showers";
        } else if (code == 600) {
            weather = "Rain";
        } else if (code == 700) {
            weather = "Snow";
        } else if (code == 800) {
            weather = "Thunder";
        }
        return weather;

    }

    public String compassDirection() {
        if ((windDirection >= 0.00) && (windDirection<= 11.25)) {
            compass = "North";
        } else if ((windDirection > 11.25) && (windDirection <= 33.75)) {
            compass = "North North East";
        } else if ((windDirection > 33.75) && (windDirection <= 56.25)) {
            compass = "North East";
        } else if ((windDirection > 56.25) && (windDirection <= 78.75)) {
            compass = "East North East";
        } else if ((windDirection > 78.75) && (windDirection <= 101.25)) {
            compass = "East";
        } else if ((windDirection > 101.25) && (windDirection <= 123.75)) {
            compass = "East South East";
        } else if ((windDirection > 123.75) && (windDirection <= 146.25)) {
            compass = "South East";
        } else if ((windDirection > 146.25) && (windDirection <= 168.75)) {
            compass = "South South East";
        } else if ((windDirection > 168.75) && (windDirection <= 191.25)) {
            compass = "South";
        } else if ((windDirection > 191.25) && (windDirection <= 213.75)) {
            compass = "South South West";
        } else if ((windDirection > 213.75) && (windDirection <= 236.25)) {
            compass = "South West";
        } else if ((windDirection > 236.25) && (windDirection <= 258.75)) {
            compass = "West South West";
        } else if ((windDirection > 258.75) && (windDirection <= 281.25)) {
            compass = "West";
        } else if ((windDirection > 281.25) && (windDirection <= 303.75)) {
            compass = "West North West";
        } else if ((windDirection > 303.75) && (windDirection <= 326.25)) {
            compass = "North West";
        } else if ((windDirection > 326.25) && (windDirection <= 348.75)) {
            compass = "North North West";
        } else if ((windDirection > 348.75) && (windDirection <= 360.00)) {
            compass = "North";
        }
        return compass;
    }

    public double calcWindChill() {
        windChill = (13.12 + (0.6215 * temperature)) - (11.37 * pow(windSpeed, 0.16)) + ((0.3965 * temperature) * pow(windSpeed, 0.16));
        return windChill;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public int getCode() {
        return code;
    }

}
