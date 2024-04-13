enum Paid{
    Paid,
    NotPaid
}
/**
 * The Reservation class represents a reservation made by a guest for a room.
 */
public class Reservation {

    /**
     * Constructs a Reservation object with the specified guest, room, check-in date, check-out date, and payment status.
     *
     * @param guest         the guest making the reservation
     * @param room          the room reserved
     * @param checkInDate   the date of check-in
     * @param checkOutDate  the date of check-out
     * @param paymentStatus the payment status of the reservation
     */
    public Reservation(Guest guest, Room room, String checkInDate, String checkOutDate, Paid paymentStatus) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentStatus = paymentStatus;
    }

    public Guest guest;
    public Room room;
    public String checkInDate;
    public String checkOutDate;
    public Paid paymentStatus;

    /**
     * Returns a string representation of the Reservation object.
     *
     * @return a string representation of the reservation
     */
    public String toString() {
        return "Guest: " + guest.Name + " " + guest.Surname + "\nRoom: " + room.Number + "\nCheck in date: " + checkInDate + "\nCheck out date: " + checkOutDate + "\nPayment status: " + paymentStatus;
    }
}
