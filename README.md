# retrofit-openweather
![screenshot](https://github.com/rohitsthaa/retrofit-openweather/blob/master/device-2015-10-25-025059.png)


This is a simple app that uses retrofit to parse the json data received from openweather API 

##Change API KEY 
Add your API KEY to String API_KEY="";

##Change Latitude & Longitude
You can change  you latitude and longitude at 
 APIManager.getApiService().getWeatherInfo("27.6988910",
                        "84.430396084",
                        "10",
                        API_KEY,
                        callback);
