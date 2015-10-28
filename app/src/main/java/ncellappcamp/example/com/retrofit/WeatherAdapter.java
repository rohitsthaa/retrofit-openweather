package ncellappcamp.example.com.retrofit;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 * Created by rohit on 10/28/15.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private final static String PATH_TO_WEATHER_FONT = "fonts/weather.ttf";
    Typeface weather_font;
    Context ctx;
    public static class WeatherViewHolder extends RecyclerView.ViewHolder {



        CardView cv;
        TextView weather_icon;
        TextView humidity;
        TextView rain_description;
        TextView time;
        Typeface weatherfont;


        WeatherViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.recycler_id);
            weather_icon = (TextView)itemView.findViewById(R.id.weather_icon_text);
            humidity = (TextView)itemView.findViewById(R.id.humidity_TextView);
            rain_description = (TextView)itemView.findViewById(R.id.rain_description__TextView);
            time = (TextView)itemView.findViewById(R.id.time_TextView);

        }
    }

    List<Weather> weather;

    WeatherAdapter(List<Weather> weathers,Typeface font){
        Log.w("strong", String.valueOf(weathers.get(0).weather_icon));
        this.weather_font=font;
        this.weather=weathers;
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous

        return position;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_forecast, viewGroup, false);
        WeatherViewHolder pvh = new WeatherViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder weatherViewHolder, int i) {

        weatherViewHolder.weather_icon.setTypeface(weather_font);

        switch (weather.get(i).weather_icon){
            case "01d":
                weatherViewHolder.weather_icon.setText(R.string.wi_day_sunny);
                break;
            case "02d":
                weatherViewHolder.weather_icon.setText(R.string.wi_cloudy_gusts);
                break;
            case "03d":
                weatherViewHolder.weather_icon.setText(R.string.wi_cloud_down);
                break;
            case "10d":
                weatherViewHolder.weather_icon.setText(R.string.wi_day_rain_mix);
                break;
            case "11d":
                weatherViewHolder.weather_icon.setText(R.string.wi_day_thunderstorm);
                break;
            case "13d":
                weatherViewHolder.weather_icon.setText(R.string.wi_day_snow);
                break;
            case "01n":
                weatherViewHolder.weather_icon.setText(R.string.wi_night_clear);
                break;
            case "04d":
                weatherViewHolder.weather_icon.setText(R.string.wi_cloudy);
                break;
            case "04n":
                weatherViewHolder.weather_icon.setText(R.string.wi_night_cloudy);
                break;
            case "02n":
                weatherViewHolder.weather_icon.setText(R.string.wi_night_cloudy);
                break;
            case "03n":
                weatherViewHolder.weather_icon.setText(R.string.wi_night_cloudy_gusts);
                break;
            case "10n":
                weatherViewHolder.weather_icon.setText(R.string.wi_night_cloudy_gusts);
                break;
            case "11n":
                weatherViewHolder.weather_icon.setText(R.string.wi_night_rain);
                break;
            case "13n":
                weatherViewHolder.weather_icon.setText(R.string.wi_night_snow);
                break;



        }
        Log.w("time:",weather.get(i).time);
        long timestamp = Long.parseLong(weather.get(i).time);
        Date expiry = new Date(timestamp * 1000);
        weatherViewHolder.time.setText(String.valueOf(expiry));

        weatherViewHolder.rain_description.setText(weather.get(i).rain_descr);
        weatherViewHolder.humidity.setText("humidity:"+weather.get(i).humidity);
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }
}