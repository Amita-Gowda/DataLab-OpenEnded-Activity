import core.data.*;
import java.util.*;

public class main {
   public static void main(String[] args) {

      DataSource ds = DataSource.connect("AQI and Lat Long of Countries.csv").load();
      //ds.printUsageString();

      ArrayList<Location> loc = ds.fetchList("Location", "City", "Country", "AQI Value", 
                                             "AQI Category", "CO AQI Value", "CO AQI Category", 
                                             "NO2 AQI Value", "NO2 AQI Category", "Ozone AQI Value", 
                                             "Ozone AQI Category", "PM2.5 AQI Value", "PM2.5 AQI Category", 
                                             "lat", "lng");

      Scanner scan = new Scanner(System.in);

      System.out.println("Enter the Latitude and Longitude of your city (west and south should be written with a negative): ");
      double lat = scan.nextDouble();
      double lng = scan.nextDouble();
      scan.nextLine();

      Location city = getCity(loc, lat, lng);

      System.out.println(city.getCity() + ", " + city.getCountry() + " has an air quality index that is " + city.getAQICategory());
      System.out.println("Prominent Pollutant in " + city.getCity() + ", " + city.getCountry() + ": " + getProminentPollutent(city));

   }

   public static Location getCity(ArrayList<Location> loc, double lat, double lng){

      Location city = null;

      for(int i = 0; i < loc.size(); i++){
         if((loc.get(i).getLat() == lat) && loc.get(i).getLng() == lng){
            city = loc.get(i);
         }
      }

      return city;

   }

   public static String getProminentPollutent(Location city){
      
      if(city.getO3Value() > city.getPMValue()){
         
         return "Ozone (Level: " + city.getO3Category() + ")" + "\n\n" + getGuide("Ozone", city.getO3Category()) + "\n";

      } else {
         
         return "PM2.5 (Level: " + city.getPMCategory() + ")" + "\n\n" + getGuide("PM2.5", city.getPMCategory()) + "\n";

      }

   }

   public static String getGuide(String prominentPollutent, String level){

      if(prominentPollutent == "Ozone"){
         if(level.equals("Good")){
            return "It’s a great day to be active outside.";
         } else if(level.equals("Moderate")){
            return "Unusually sensitive people: \nConsider making outdoor activities shorter and less intense. Watch for symptoms such as coughing or shortness of breath. These are signs to take it easier. \n\nEveryone else: \nIt’s a good day to be active outside.";
         } else if(level.equals("Unhealthy for Sensitive Groups")){
            return "Sensitive groups: \nMake outdoor activities shorter and less intense. Take more breaks. Watch for symptoms such as coughing or shortness of breath. Plan outdoor activities in the morning when ozone is lower. \n\nPeople with asthma: \nFollow your asthma action plan and keep quick-relief medicine handy. \n\nEveryone else: \nConsider making outdoor activities shorter and less intense.";    
         } else if(level.equals("Unhealthy")){
            return "Sensitive groups: \nDo not do long or intense outdoor activities. Schedule outdoor activities in the morning when ozone is lower. Consider moving activities indoors.\n\n People with asthma: \nFollow your asthma action plan and keep quick-relief medicine handy.\n\nEveryone else: \nReduce long or intense outdoor activity. Take more breaks, do less intense activities. Schedule outdoor activities in the morning when ozone is lower.";
         } else if(level.equals("Very Unhealthy")){
            return "Sensitive groups: \nAvoid all physical activity outdoors. Move activities indoors* or reschedule to when air quality will be better. \n\nPeople with asthma: \nFollow your asthma action plan and keep quick-relief medicine handy. \n\nEveryone else: \nAvoid long or intense outdoor exertion. Schedule outdoor activities in the morning when ozone is lower. Consider moving activities indoors.*\n\n *Note: \nIf you don't have an air conditioner, staying inside with the windows closed may be dangerous in extremely hot weather. If you are hot, go someplace with air conditioning or check with your local government to find out if cooling centers are available in your community.";
         } else if (level.equals("Hazardous")){
            return "Everyone: \nAvoid all physical activity outdoors.* \n\nPeople with asthma: \nFollow your asthma action plan and keep quick-relief medicine handy. \n\n *Note: \nIf you don't have an air conditioner, staying inside with the windows closed may be dangerous in extremely hot weather. If you are hot, go someplace with air conditioning or check with your local government to find out if cooling centers are available in your community.";
         }
      } else if(prominentPollutent == "PM2.5"){
         if(level.equals("Good")){
            return "It’s a great day to be active outside.";
         } else if(level.equals("Moderate")){
            return "Unusually sensitive people: \nConsider making outdoor activities shorter and less intense. Watch for symptoms such as coughing or shortness of breath. These are signs to take it easier. \n\nEveryone else: \nIt’s a good day to be active outside.";
         } else if(level.equals("Unhealthy for Sensitive Groups")){
            return "Sensitive groups: \nMake outdoor activities shorter and less intense. Take more breaks. Watch for symptoms such as coughing or shortness of breath. Plan outdoor activities in the morning when ozone is lower. \n\nPeople with asthma: \nFollow your asthma action plan and keep quick-relief medicine handy. \n\nEveryone else: \nConsider making outdoor activities shorter and less intense.";    
         } else if(level.equals("Unhealthy")){
            return "Sensitive groups: \nAvoid long or intense outdoor activities. Consider rescheduling or moving activities indoors.*\n\n Everyone else: \nReduce long or intense outdoor activity. Take more breaks, do less intense activities.\n\n *Note: \nIf you don't have an air conditioner, staying inside with the windows closed may be dangerous in extremely hot weather. If you are hot, go someplace with air conditioning or check with your local government to find out if cooling centers are available in your community.";
         } else if(level.equals("Very Unhealthy")){
            return "Sensitive groups: \nAvoid all physical activity outdoors. Move activities indoors* or reschedule to when air quality will be better. \n\nEveryone else: \nAvoid long or intense activities. Consider moving activities indoors.*\n\n *Note: \nIf you don't have an air conditioner, staying inside with the windows closed may be dangerous in extremely hot weather. If you are hot, go someplace with air conditioning or check with your local government to find out if cooling centers are available in your community.";
         } else if (level.equals("Hazardous")){
            return "Everyone: \nAvoid all physical activity outdoors. \n\nSensitive groups: \nRemain indoors and keep activity levels low. Follow tips for keeping particle levels low indoors.* \n\n *Note: \nIf you don't have an air conditioner, staying inside with the windows closed may be dangerous in extremely hot weather. If you are hot, go someplace with air conditioning or check with your local government to find out if cooling centers are available in your community.";
         }
      }
      return "";

   }
}