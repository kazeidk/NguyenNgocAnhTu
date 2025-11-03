package model;

/**
 * Represents a sports facility (e.g., Tennis Court, Football Field)
 */
public class Facility {
    private String facilityId;
    private String name;
    private String type;
    private double pricePerHour;
    private boolean isAvailable;

    public Facility(String facilityId, String name, String type, double pricePerHour) {
        this.facilityId = facilityId;
        this.name = name;
        this.type = type;
        this.pricePerHour = pricePerHour;
        this.isAvailable = true;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("ID: %-10s | Name: %-20s | Type: %-15s | Price: $%.2f/hour | Status: %s",
                facilityId, name, type, pricePerHour, isAvailable ? "Available" : "Unavailable");
    }
}
