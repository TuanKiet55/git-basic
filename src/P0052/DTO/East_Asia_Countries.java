package P0052.DTO;

public class East_Asia_Countries extends Country{
    
    private String countryTerrain;

    public East_Asia_Countries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public East_Asia_Countries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }   

    @Override
    public void display() {
        super.display();
        System.out.printf("%-22s\n", countryTerrain);
    }  
}