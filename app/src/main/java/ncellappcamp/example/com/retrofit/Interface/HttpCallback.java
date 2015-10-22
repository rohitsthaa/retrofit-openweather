package ncellappcamp.example.com.retrofit.Interface;


import ncellappcamp.example.com.retrofit.Model.Weather;

/**
 * Created by rohit on 10/15/15.
 */
public interface HttpCallback {

    public void onSuccess (Weather response);

    public void onFailure (String error);

}