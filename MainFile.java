/**
 * The MainFile class is the entry point of the program.
 * It creates an instance of the ConsoleMenu class and calls its methods to display the menu and interact with the user.
 */
public class MainFile {
    public static void main(String[] args) {
        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.Rooms();
        consoleMenu.Display();
    }
}
