

/**
 * The Room class represents a room in a building.
 */
public class Room extends Object {
    public Room(String Number, int Capacity, Extra ExtraInfo, int Floor, RoomAvailability Status, int Price) {
        this.Capacity = Capacity;
        this.ExtraInfo = ExtraInfo;
        this.Floor = Floor;
        this.Status = Status;
        this.Price = Price;
        this.Number = Number;
    }

    public String Number;
    public int Capacity = 1;
    public Extra ExtraInfo;
    public int Floor = 1;
    public RoomAvailability Status;
    public int Price;

    /**
     * Returns a string representation of the Room object.
     *
     * @return The string representation of the Room object.
     */
    public String toString() {
        return "Number: " + Number + "\nCapacity: " + Capacity + "\nExtraInfo: " + ExtraInfo + "\nFloor: " + Floor + "\nStatus: " + Status + "\nPrice: " + Price;
    }
    public enum Extra{
        TV,
        AIRCONDITIONING,
        WIFI,
        MINIBAR
    }
    public enum RoomAvailability{
        AVAILABLE,
        OCCUPIED,
        RESERVED
    }
}
