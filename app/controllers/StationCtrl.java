package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import java.util.Date;

public class StationCtrl extends Controller
{
    //private static long timestamp;

    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        render("station.html", station);
    }

    public static void addReading(Long id, Date date, int code, double temperature, double windSpeed, int windDirection, int pressure)
    {
        Reading reading = new Reading(date, code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        //timestamp = System.currentTimeMillis();
        station.save();
        redirect ("/station/" + id);
    }

    public static void deleteReading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing " + reading);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }

}
