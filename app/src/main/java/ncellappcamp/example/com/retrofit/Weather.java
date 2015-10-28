package ncellappcamp.example.com.retrofit;

/**
 * Created by rohit on 10/28/15.
 */
class Weather {
    String weather_icon;
    String humidity;
    String rain_descr;
    String time;

    Weather(String weather_icon, String humidity, String rain_descr, String time) {
        this.weather_icon = weather_icon;
        this.humidity = humidity;
        this.rain_descr = rain_descr;
        this.time = time;
    }
}
