package ncellappcamp.example.com.retrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import android.os.Handler;

import ncellappcamp.example.com.retrofit.Model.List;
import ncellappcamp.example.com.retrofit.Model.WeatherData;
import ncellappcamp.example.com.retrofit.Service.APIManager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ScrollingActivity extends AppCompatActivity {
    private static final String TAG = "SPLASH";



    private Typeface weatherFont;
    private String place_location="";
    private ProgressBar spinner;

    TextView weather_report,place,weather_icon,country;
    List myList ;
    String API_KEY="bd82977b86bf27fb59a04b61b657fb6f";
    private final static String PATH_TO_WEATHER_FONT = "fonts/weather.ttf";
    private ListView lv;




        @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_scrolling);
            spinner = (ProgressBar)findViewById(R.id.progressBar1);
            spinner.setVisibility(View.VISIBLE);

        weather_icon=(TextView)findViewById(R.id.weather_icon);
            country=(TextView)findViewById(R.id.country);
        weatherFont = Typeface.createFromAsset(getAssets(), PATH_TO_WEATHER_FONT);
        weather_icon.setTypeface(weatherFont);



        weather_report = (TextView) findViewById(R.id.weather_report);
        place =(TextView)findViewById(R.id.place);


        // Instanciating an array list (you don't need to do this,
        // you already have yours).



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "you are view weather of "+place_location, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });


                APIManager.getApiService().getWeatherInfo("27.6988910",
                        "84.430396084",
                        "10",
                        API_KEY,
                        callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private Callback<WeatherData> callback = new Callback<WeatherData>() {
        @Override
        public void success (WeatherData response, Response response2) {


            weather_report.setText(response.getList().get(0).getWeather().get(0).getDescription());
            place.setText(response.getCity().getName());
            country.setText(response.getCity().getCountry());
            place_location =response.getCity().getName();


            Log.w("icon", response.getList().get(0).getWeather().get(0).getIcon());
            switch (response.getList().get(0).getWeather().get(0).getIcon()){
                case "01d":
                    weather_icon.setText(R.string.wi_day_sunny);
                    break;
                case "02d":
                    weather_icon.setText(R.string.wi_cloudy_gusts);
                    break;
                case "03d":
                    weather_icon.setText(R.string.wi_cloud_down);
                    break;
                case "10d":
                    weather_icon.setText(R.string.wi_day_rain_mix);
                    break;
                case "11d":
                    weather_icon.setText(R.string.wi_day_thunderstorm);
                    break;
                case "13d":
                    weather_icon.setText(R.string.wi_day_snow);
                    break;
                case "01n":
                    weather_icon.setText(R.string.wi_night_clear);
                    break;
                case "02n":
                    weather_icon.setText(R.string.wi_night_cloudy);
                    break;
                case "03n":
                    weather_icon.setText(R.string.wi_night_cloudy_gusts);
                    break;
                case "10n":
                    weather_icon.setText(R.string.wi_night_cloudy_gusts);
                    break;
                case "11n":
                    weather_icon.setText(R.string.wi_night_rain);
                    break;
                case "13n":
                    weather_icon.setText(R.string.wi_night_snow);
                    break;



            }

            spinner.setVisibility(View.GONE);


        }

        @Override
        public void failure (RetrofitError error) {

            place.setText("Unable to retrieve data");




            Log.d("", "failure", error);

        }
    };



}