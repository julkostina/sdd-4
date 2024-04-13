/**
 * The Regex class contains regular expressions for validating different types of data.
 */
public class Regex {
    /**
     * Regular expression for validating room capacity.
     * It matches numbers from 1 to 3.
     */
    public static String ValidRoomCapacity="^[1-3]";

    /**
     * Regular expression for validating room floor.
     * It matches numbers from 1 to 6.
     */
    public static String ValidRoomFloor="^[1-6]";

    /**
     * Regular expression for validating room price.
     * It matches positive integers greater than or equal to 1.
     */
    public static String ValidRoomPrice="^[1-9][0-9]*$";

    /**
     * Regular expression for validating name and surname.
     * It matches alphabetic characters.
     */
    public static String ValidNameSurname="^[a-zA-Z]+";

    /**
     * Regular expression for validating ID.
     * It matches a 9-digit number.
     */
    public static String ValidID="^[0-9]{9}$";

    /**
     * Regular expression for validating phone number.
     * It matches a 10-digit number.
     */
    public static String ValidPhone="^[0-9]{10}$";

    /**
     * Regular expression for validating date in the format dd.mm.yyyy.
     * It matches valid dates from 01.01.0000 to 31.12.9999.
     */
    public static String ValidDate="^([1-9]|[1-2][0-9]|3[0-1])\\.([1-9]|1[0-2])\\.\\d{4}$";
}
