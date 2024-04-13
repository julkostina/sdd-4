import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

 public class ConsoleMenuTest {
    private ConsoleMenu consoleMenu;
     List<Reservation> reservations = new ArrayList<>();
     List<Room> rooms = new ArrayList<>();
     List<Guest> guests = new ArrayList<>();

    @Test
    public void testSelectRoom() {
        // Test case for selecting an existing room
        Room room1 = new Room("Room 1", 2, Room.Extra.TV, 1, Room.RoomAvailability.AVAILABLE, 100);
        rooms.add(room1);
        String input = "2\n3\n2\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        consoleMenu.SelectRoom();
        assertEquals(Room.RoomAvailability.AVAILABLE, room1.Status);

        // Test case for selecting a non-existing room
        String input2 = "2\n3\n2\n1\n";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        consoleMenu.SelectRoom();
        assertEquals(Room.RoomAvailability.AVAILABLE, room1.Status);
    }

    @Test
    public void testAddGuest() {
        // Test case for adding a valid guest
        String input = "John\nDoe\n1234567890\nABC123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        consoleMenu.AddGuest();
        assertEquals(1, guests.size());

        // Test case for adding a guest with an invalid name
        String input2 = "123\nDoe\n1234567890\nABC123\n";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        consoleMenu.AddGuest();
        assertEquals(1, guests.size());

        // Test case for adding a guest with an invalid phone number
        String input3 = "John\nDoe\n123\nABC123\n";
        InputStream in3 = new ByteArrayInputStream(input3.getBytes());
        System.setIn(in3);
        consoleMenu.AddGuest();
        assertEquals(1, guests.size());

        // Test case for adding a guest with an invalid ID
        String input4 = "John\nDoe\n1234567890\n123\n";
        InputStream in4 = new ByteArrayInputStream(input4.getBytes());
        System.setIn(in4);
        consoleMenu.AddGuest();
        assertEquals(1, guests.size());
    }
}



