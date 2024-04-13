import org.junit.Test;
import static org.junit.Assert.*;

public class ReservationTest {

    @Test
    public void testToString() {
        Guest guest = new Guest("John", "Doe", "123456789", "1234567890");
        Room room = new Room("001", 0, null, 1, Room.RoomAvailability.AVAILABLE, 100);
        String checkInDate = "12.12.2024";
        String checkOutDate = "18.12.2024";
        Paid paymentStatus = Paid.NotPaid;

        Reservation reservation = new Reservation(guest, room, checkInDate, checkOutDate, paymentStatus);

        String expected = "Guest: John Doe\nRoom: 001\nCheck in date: 12.12.2024\nCheck out date: 18.12.2024\nPayment status: NotPaid";
        String actual = reservation.toString();

        assertEquals(expected, actual);
    }
}