package ncellappcamp.example.com.retrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import ncellappcamp.example.com.retrofit.Model.List;
import ncellappcamp.example.com.retrofit.Model.WeatherData;
import ncellappcamp.example.com.retrofit.Service.APIManager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ScrollingActivity extends AppCompatActivity {

    TextView retrofittext,place;
    List myList ;
    String API_KEY="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        retrofittext =(TextView)findViewById(R.id.retrofit);
        place =(TextView)findViewById(R.id.place);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

    APIManager.getApiService().getWeatherInfo("51.507351",
            "-0.127758",
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


                retrofittext.setText(response.getList().get(0).getWeather().get(0).getDescription());
            place.setText(response.getCity().getCountry());


            Log.w("icon", response.getList().get(0).getWeather().get(0).getIcon());
            if (response.getList().get(0).getWeather().get(0).getIcon().equals("10d")) {
                //setting icon

            }

        }

        @Override
        public void failure (RetrofitError error) {

            retrofittext.setText("Retrofit error");




            Log.d("", "failure", error);

        }
    };



}
