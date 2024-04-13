import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoomTest {
    @Test
    public void testToString() {
        Room.Extra extraInfo = Room.Extra.TV;
        Room room = new Room("101", 2, extraInfo, 1, Room.RoomAvailability.AVAILABLE, 100);

        String expected = "Number: 101\nCapacity: 2\nExtraInfo: TV\nFloor: 1\nStatus: AVAILABLE\nPrice: 100";
        String actual = room.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testDefaultCapacity() {
        Room room = new Room("102", 1, null, 1, Room.RoomAvailability.AVAILABLE, 100);

        int expected = 1;
        int actual = room.Capacity;

        assertEquals(expected, actual);
    }

    @Test
    public void testRoomAvailability() {
        Room room = new Room("103", 3, null, 2, Room.RoomAvailability.OCCUPIED, 200);

        Room.RoomAvailability expected = Room.RoomAvailability.OCCUPIED;
        Room.RoomAvailability actual = room.Status;

        assertEquals(expected, actual);
    }

    @Test
    public void testExtraEnumTV() {
        Room.Extra extra = Room.Extra.TV;

        assertEquals(Room.Extra.TV, extra);
    }

    @Test
    public void testExtraEnumAirConditioning() {
        Room.Extra extra = Room.Extra.AIRCONDITIONING;

        assertEquals(Room.Extra.AIRCONDITIONING, extra);
    }

    @Test
    public void testExtraEnumWiFi() {
        Room.Extra extra = Room.Extra.WIFI;

        assertEquals(Room.Extra.WIFI, extra);
    }

    @Test
    public void testExtraEnumMinibar() {
        Room.Extra extra = Room.Extra.MINIBAR;

        assertEquals(Room.Extra.MINIBAR, extra);
    }
}