package model;

/**
 * Represents a time slot for booking
 */
public class TimeSlot {
    private int startHour;
    private int endHour;

    public TimeSlot(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getDuration() {
        return endHour - startHour;
    }

    /**
     * Check if this time slot overlaps with another time slot
     */
    public boolean overlaps(TimeSlot other) {
        return (this.startHour < other.endHour && this.endHour > other.startHour);
    }

    @Override
    public String toString() {
        return String.format("%02d:00 - %02d:00", startHour, endHour);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) obj;
        return startHour == timeSlot.startHour && endHour == timeSlot.endHour;
    }

    @Override
    public int hashCode() {
        return 31 * startHour + endHour;
    }
}
