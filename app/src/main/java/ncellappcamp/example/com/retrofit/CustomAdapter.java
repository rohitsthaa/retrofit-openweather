package ncellappcamp.example.com.retrofit;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CustomAdapter extends BaseAdapter{
    private final static String PATH_TO_WEATHER_FONT = "fonts/weather.ttf";
    Typeface weather_font;
    String [] humidity;
    Context context;
    String [] rain;
    String [] icon;
    String [] time;
    private static LayoutInflater inflater=null;
    public CustomAdapter(ScrollingActivity mainActivity, String[] humidity, String[] rain,String[]icon,String[]time,Typeface weather_font) {
        // TODO Auto-generated constructor stub
        this.humidity=humidity;
        context=mainActivity;
        this.rain=rain;
        this.icon=icon;
        this.time=time;
        this.weather_font =weather_font;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return humidity.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView humidity;
        TextView rain;
        TextView icon_text;
        TextView time;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();

        View rowView;

        rowView = inflater.inflate(R.layout.forecast, null);
        holder.humidity=(TextView) rowView.findViewById(R.id.humidity);
        holder.rain=(TextView) rowView.findViewById(R.id.rain_description);
        holder.time=(TextView) rowView.findViewById(R.id.time);
        holder.icon_text=(TextView) rowView.findViewById(R.id.weather_icon_text);

        holder.icon_text.setTypeface(weather_font);

        switch (icon[position]){
            case "01d":
                holder.icon_text.setText(R.string.wi_day_sunny);
                break;
            case "02d":
                holder.icon_text.setText(R.string.wi_cloudy_gusts);
                break;
            case "03d":
                holder.icon_text.setText(R.string.wi_cloud_down);
                break;
            case "10d":
                holder.icon_text.setText(R.string.wi_day_rain_mix);
                break;
            case "11d":
                holder.icon_text.setText(R.string.wi_day_thunderstorm);
                break;
            case "13d":
                holder.icon_text.setText(R.string.wi_day_snow);
                break;
            case "01n":
                holder.icon_text.setText(R.string.wi_night_clear);
                break;
            case "04d":
                holder.icon_text.setText(R.string.wi_cloudy);
                break;
            case "04n":
                holder.icon_text.setText(R.string.wi_night_cloudy);
                break;
            case "02n":
                holder.icon_text.setText(R.string.wi_night_cloudy);
                break;
            case "03n":
                holder.icon_text.setText(R.string.wi_night_cloudy_gusts);
                break;
            case "10n":
                holder.icon_text.setText(R.string.wi_night_cloudy_gusts);
                break;
            case "11n":
                holder.icon_text.setText(R.string.wi_night_rain);
                break;
            case "13n":
                holder.icon_text.setText(R.string.wi_night_snow);
                break;



        }


        long timestamp = Long.parseLong(time[position]);
        Date expiry = new Date(timestamp * 1000);
        holder.time.setText(String.valueOf(expiry));
        holder.humidity.setText(humidity[position]);
        holder.rain.setText(rain[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+humidity[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

}