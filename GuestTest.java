import org.junit.Test;
import static org.junit.Assert.*;

public class GuestTest {

    @Test
    public void testToString() {
        Guest guest = new Guest("John", "Doe", "123456789", "1234567890");
        String expected = "Name: John\nSurname: Doe\nID: 123456789\nPhone: 1234567890";
        assertEquals(expected, guest.toString());
    }
}