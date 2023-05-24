public class Location {
    
    private String city;
    private String country;

    private int aqiVal;
    private String aqiCategory;
    private int COAqiVal;
    private String COAqiCategory;
    private int NO2AqiVal;
    private String NO2AqiCategory;
    private int O3AqiVal;
    private String O3AqiCategory;
    private int PMAqiVal;
    private String PMAqiCategory;

    private double lat;
    private double lng;

    public Location(String city, String country, int aqiVal, String aqiCategory, int COAqiVal, String COAqiCategory, int NO2AqiVal, String NO2AqiCategory, int O3AqiVal, String O3AqiCategory, int PMAqiVal, String PMAqiCategory, double lat, double lng){
        this.city = city;
        this.country = country;
        this.aqiVal = aqiVal;
        this.aqiCategory = aqiCategory;
        this.COAqiVal = COAqiVal;
        this.COAqiCategory = COAqiCategory;
        this.NO2AqiVal = NO2AqiVal;
        this.NO2AqiCategory = NO2AqiCategory;
        this.O3AqiVal = O3AqiVal;
        this.O3AqiCategory = O3AqiCategory;
        this.PMAqiVal = PMAqiVal;
        this.PMAqiCategory = PMAqiCategory;
        this.lat = lat;
        this.lng = lng;
    }

    public String getCity(){
        return city;
    }

    public String getCountry(){
        return country;
    }

    public int getAQIValue(){
        return aqiVal;
    }

    public String getAQICategory(){
        return aqiCategory;
    }

    public int getCOValue(){
        return COAqiVal;
    }

    public String getCOCategory(){
        return COAqiCategory;
    }

    public int getNO2Value(){
        return NO2AqiVal;
    }

    public String getNO2Category(){
        return NO2AqiCategory;
    }

    public int getO3Value(){
        return O3AqiVal;
    }

    public String getO3Category(){
        return O3AqiCategory;
    }

    public int getPMValue(){
        return PMAqiVal;
    }

    public String getPMCategory(){
        return PMAqiCategory;
    }

    public double getLat(){
        return lat;
    }

    public double getLng(){
        return lng;
    }

    public String toString(){
        return "Location: " + city + ", " + country + "\n" + "Coordinates: " + lat + " latitude, " + lng + " longitude" + "\n" + "PM2.5 Concentration: " + PMAqiVal + "\n" + "Carbon Monoxide Concentration: " + COAqiVal + "\n" + "Nitrogen Dioxide Concentration: " + NO2AqiVal + "\n" + "Ozone Concentration: " + O3AqiVal + "\n";
    }

}
