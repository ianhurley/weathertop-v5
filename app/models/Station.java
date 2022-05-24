package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    public String name;
    public double latitude;
    public double longitude;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();


    public Station(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Reading latestReading() {
        if (readings.size() == 0) {
            return null;
        } else {
            return readings.get(readings.size() - 1);
        }
    }

    public Reading minTemp() {
        if (readings.size() != 0) {
            Reading minReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemperature() < minReading.getTemperature())
                    minReading = reading;
            }
            return minReading;
        }
        return null;
    }

    public Reading maxTemp() {
        if (readings.size() != 0) {
            Reading maxReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemperature() > maxReading.getTemperature())
                    maxReading = reading;
            }
            return maxReading;
        }
        return null;
    }

    public Reading minWind() {
        if (readings.size() != 0) {
            Reading minReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getWindSpeed() < minReading.getWindSpeed())
                    minReading = reading;
            }
            return minReading;
        }
        return null;
    }

    public Reading maxWind() {
        if (readings.size() != 0) {
            Reading maxReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getWindSpeed() > maxReading.getWindSpeed())
                    maxReading = reading;
            }
            return maxReading;
        }
        return null;
    }

    public Reading minPressure() {
        if (readings.size() != 0) {
            Reading minReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() < minReading.getPressure())
                    minReading = reading;
            }
            return minReading;
        }
        return null;
    }

    public Reading maxPressure() {
        if (readings.size() != 0) {
            Reading maxReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() > maxReading.getPressure())
                    maxReading = reading;
            }
            return maxReading;
        }
        return null;
    }

}
