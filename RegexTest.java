import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegexTest {

    @Test
    public void testValidRoomCapacity() {
        String roomCapacity = "2";
        assertTrue(roomCapacity.matches(Regex.ValidRoomCapacity));
    }
    
    @Test
    public void testValidRoomPrice() {
        String roomPrice = "100";
        assertTrue(roomPrice.matches(Regex.ValidRoomPrice));
    }
    
    @Test
    public void testValidNameSurname() {
        String nameSurname = "John";
        assertTrue(nameSurname.matches(Regex.ValidNameSurname));
    }
    
    @Test
    public void testValidID() {
        String id = "123456789";
        assertTrue(id.matches(Regex.ValidID));
    }
    
    @Test
    public void testValidPhone() {
        String phone = "1234567890";
        assertTrue(phone.matches(Regex.ValidPhone));
    }
    
    @Test
    public void testValidDate() {
        String date = "31.12.2022";
        assertTrue(date.matches(Regex.ValidDate));
    }
    
    @Test
    public void testValidRoomFloor() {
        String roomFloor = "3";
        assertTrue(roomFloor.matches(Regex.ValidRoomFloor));
    }
}