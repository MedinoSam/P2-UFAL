import entities.Reservation;
import exceptions.InvalidDateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int roomNumber;
        String checkInString;
        String checkOutString;
        LocalDate checkIn;
        LocalDate checkOut;

        System.out.printf("Room number: ");
        roomNumber = sc.nextInt();
        System.out.printf("Check-in date (dd/MM/yyyy): ");
        checkInString = sc.next();
        System.out.printf("Check-out date (dd/MM/yyyy): ");
        checkOutString = sc.next();


        checkIn = LocalDate.parse(checkInString, formatter);
        checkOut = LocalDate.parse(checkOutString, formatter);


        Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

        try {
            reservation.validateDates();
            System.out.println("entities.Reservation: Room " + reservation.getRoomNumber() + " check-in " + reservation.getCheckIn() +
                    " check-out " + reservation.getCheckOut() + " " + reservation.duration() + " nights");
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Enter data to update the reservation:");
        System.out.printf("Check-in date (dd/MM/yyyy): ");
        LocalDate updatedCheckIn = LocalDate.parse(sc.next(), formatter);
        System.out.printf("Check-out date (dd/MM/yyyy): ");
        LocalDate updatedCheckOut = LocalDate.parse(sc.next(), formatter);

        try {
            reservation.updateDates(updatedCheckIn, updatedCheckOut);
            reservation.validateDates();
            System.out.println("entities.Reservation: Room " + reservation.getRoomNumber() + " check-in " + reservation.getCheckIn() +
                    " check-out " + reservation.getCheckOut() + " " + reservation.duration() + " nights");
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}