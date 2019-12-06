package cyweather;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.*;
import org.json.simple.*;
import java.lang.*; 

@SuppressWarnings("unused")

public class Seed {
	  public static double currentTemp;
	  public static double maximumTemp;
	  public static double minimumTemp;
	  public static double averageTemp;
	  public static double lattitude;
	  public static double longitude;
	  public static long humid;
	  public static double rain;

	  public static void seedForecast(String city) {
		  String url = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=1yww6BUQLLsigzdnuOfgr9VOcwbEe7N0&q=";
		  String forecastUrl = "http://dataservice.accuweather.com/currentconditions/v1/?apikey=1yww6BUQLLsigzdnuOfgr9VOcwbEe7N0&details=true";
          StringBuffer newUrl = new StringBuffer(url);
          newUrl.insert(104, city);
          //System.out.println(newUrl);
          url = newUrl.toString();
	        CloseableHttpClient client = HttpClients.createDefault();
	        HttpGet get = new HttpGet(url);
	        CloseableHttpResponse resp = null;
	        try {
	            resp = client.execute(get);
	            HttpEntity entity = resp.getEntity();
	            //System.out.println("Json response");
	            //System.out.println(EntityUtils.toString(entity));
	            String response = EntityUtils.toString(entity);
	            
	            
	            JSONParser parser = new JSONParser();
	            JSONArray json = (JSONArray) parser.parse(response);
	            JSONObject jsonObj = (JSONObject) json.get(0);
	            //System.out.println(jsonObj.get("GeoPosition"));
	            String locationKey = (String)jsonObj.get("Key");
	            //Get the Latitude and Logitude of the location
	            JSONObject geoLocation = (JSONObject) jsonObj.get("GeoPosition");
	            lattitude = (Double) geoLocation.get("Latitude");
	            longitude = (Double) geoLocation.get("Longitude");
	            
	            //Append the key in forecast URL
	            StringBuffer newString = new StringBuffer(forecastUrl);
	            newString.insert(56, locationKey);
	            forecastUrl = newString.toString();
	            
	            //GET request for the weather information.
	            
	            CloseableHttpClient newClient = HttpClients.createDefault();
	            HttpGet getForecast = new HttpGet(forecastUrl);
	            CloseableHttpResponse respForecast = null;
	            respForecast = client.execute(getForecast);
	            HttpEntity entityForecast = respForecast.getEntity();
	            String responseForecast = EntityUtils.toString(entityForecast);
	            
	            //parsing the forecast response
	            JSONParser parserForecast = new JSONParser();
	            JSONArray jsonForecast = (JSONArray) parser.parse(responseForecast);
	            JSONObject jsonObjForecast = (JSONObject) jsonForecast.get(0);
	            
	            
	            //get the current temperature
	            JSONObject jsontempForecast = (JSONObject) jsonObjForecast.get("Temperature");
	            JSONObject jsontempMetricForecast = (JSONObject) jsontempForecast.get("Metric");
	            currentTemp = (Double) jsontempMetricForecast.get("Value");
	            
	            //get the maximum temperature
	            JSONObject jsonMaxForecast = (JSONObject) jsonObjForecast.get("TemperatureSummary");
	            JSONObject jsonMaxRangeTempForecast = (JSONObject) jsonMaxForecast.get("Past6HourRange");

	            
	            JSONObject jsonMaxTempForecast = (JSONObject) jsonMaxRangeTempForecast.get("Maximum");
	            JSONObject jsonMaxTempMetricForecast = (JSONObject) jsonMaxTempForecast.get("Metric");
	            
	            maximumTemp = (Double) jsonMaxTempMetricForecast.get("Value");
	            //System.out.println(maximumTemp);
	            
	            //get the minimum temperature
	            JSONObject jsonMinTempForecast = (JSONObject) jsonMaxRangeTempForecast.get("Minimum");
	            JSONObject jsonMinTempMetricForecast = (JSONObject) jsonMinTempForecast.get("Metric");
	            minimumTemp = (Double) jsonMinTempMetricForecast.get("Value");
//	            System.out.println(minimumTemp);
//	            System.out.println(maximumTemp);
	            
	            //get the average temperature
	            JSONObject jsonAvgRangeTempForecast = (JSONObject) jsonMaxForecast.get("Past12HourRange");
	            JSONObject jsonAvgTempForecast = (JSONObject) jsonAvgRangeTempForecast.get("Minimum");
	            JSONObject jsonAvgTempMetricForecast = (JSONObject) jsonAvgTempForecast.get("Metric");
	            //System.out.println(jsonAvgTempMetricForecast);
	            averageTemp = (Double) jsonAvgTempMetricForecast.get("Value");
	            
	            //get the humidity
	            humid = (Long) jsonObjForecast.get("RelativeHumidity");
	            
	            //get the rainfall
	            JSONObject jsonRainForecast = (JSONObject) jsonObjForecast.get("PrecipitationSummary");
	            JSONObject jsonMaxRangeRainForecast = (JSONObject) jsonRainForecast.get("Past12Hours");
	            JSONObject jsonMaxRainForecast = (JSONObject) jsonMaxRangeRainForecast.get("Metric");
	            rain = (Double) jsonMaxRainForecast.get("Value");
	            

	              

	        }
	        catch (IOException ioe) { System.err.println("Something went wrong getting the weather: ");  ioe.printStackTrace(); }
	        catch (Exception e ){ System.err.println("Unknown error: "); e.printStackTrace(); }
	  }
	  
	  public static void details() {
	      System.out.println(currentTemp);
	      System.out.println(maximumTemp);
	      System.out.println(minimumTemp);
	      System.out.println(averageTemp);
	      System.out.println(humid);
	      System.out.println(rain);
	  }


}
