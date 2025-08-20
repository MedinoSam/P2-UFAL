package entities;

import exceptions.InvalidDateException;

import java.time.LocalDate;
import java.time.Period;


public class Reservation {

    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int duration() {
        Period period = Period.between(this.checkIn, this.checkOut);
        return period.getDays() + period.getMonths() * 30 + period.getYears() * 365;
    }

    public void updateDates(LocalDate newCheckIn, LocalDate newCheckOut) {
        //se a atualização for para uma data anterior a data atual, tem q dar bo
        if (newCheckIn.isBefore(this.checkIn) || newCheckOut.isBefore(this.checkOut)) {
            throw new InvalidDateException("Error in reservation: entities.Reservation dates for update must be future dates");
        }
        this.checkIn = newCheckIn;
        this.checkOut = newCheckOut;
    }

    public void validateDates() {
        if (!this.checkIn.isBefore(this.checkOut)) {
            throw new InvalidDateException("Error in reservation: Check-out date must be after check-in date");
        }
    }
}