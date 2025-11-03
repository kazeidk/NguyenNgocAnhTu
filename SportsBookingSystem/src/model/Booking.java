package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a booking for a sports facility
 */
public class Booking {
    private static int bookingCounter = 1000;
    private String bookingId;
    private String customerName;
    private String phoneNumber;
    private Facility facility;
    private LocalDate bookingDate;
    private TimeSlot timeSlot;
    private double totalPrice;
    private String status; // ACTIVE, CANCELLED

    public Booking(String customerName, String phoneNumber, Facility facility, 
                   LocalDate bookingDate, TimeSlot timeSlot) {
        this.bookingId = "BK" + (++bookingCounter);
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.facility = facility;
        this.bookingDate = bookingDate;
        this.timeSlot = timeSlot;
        this.totalPrice = facility.getPricePerHour() * timeSlot.getDuration();
        this.status = "ACTIVE";
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void cancel() {
        this.status = "CANCELLED";
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Booking ID: %-10s | Customer: %-20s | Phone: %-12s\n" +
                           "Facility: %-30s | Date: %-12s\n" +
                           "Time: %-15s | Price: $%-8.2f | Status: %s",
                bookingId, customerName, phoneNumber,
                facility.getName(), bookingDate.format(formatter),
                timeSlot.toString(), totalPrice, status);
    }
}
