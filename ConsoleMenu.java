import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The ConsoleMenu class represents a console-based menu for managing reservations, rooms, and guests.
 * It provides options to search for rooms, add guests, add reservations, show rooms, show reservations,
 * delete reservations, delete guests, and exit the program.
 */
public class ConsoleMenu {
    private  int input;
    public  List<Reservation> reservations = new ArrayList<Reservation>();
    public  List<Room> rooms = new ArrayList<Room>();
    public List<Guest> guests = new ArrayList<Guest>(); 
    Scanner scanner = new Scanner(System.in);
    private Boolean err = false;

    
    /**
     * Displays the menu options and prompts the user for input.
     * 
     * The available options are:
     * 1. Search Room
     * 2. Add Guest
     * 3. Add Reservation
     * 4. Show Rooms
     * 5. Show Reservations
     * 6. Delete Reservation
     * 7. Delete Guest
     * 8. Exit
     * 
     * After receiving the user's input, it calls the GetInput method with the input value.
     */
    public  void Display(){
        
        System.out.println("Enter to:");
        System.out.println("1. Search Room");
        System.out.println("2. Add Guest");
        System.out.println("3. Add Reservation");
        System.out.println("4. Show Rooms");
        System.out.println("5. Show Reservations");
        System.out.println("6. Delete Reservation");
        System.out.println("7. Delete Guest");
        System.out.println("8. Exit");
        input = Integer.parseInt(scanner.nextLine());
        this.GetInput(input);
        
    }

    /**
     * Executes the corresponding action based on the user input.
     * 
     * @param input the user input representing the selected action
     */
    public  void GetInput (int input){
        switch (input){
            case 1:
                System.out.println("Search room:");
                SelectRoom();
                this.Display();
                break;
            case 2:
                System.out.println("Add guest:");
                guests.add(AddGuest());
                Display();
                break;
            case 3:
                System.out.println("Add reservation:");
                AddReservation();
                Display();
                break;
            case 4:
                System.out.println("Show rooms:");
                for(int i=0; i<rooms.size(); i++){
                    System.out.println(rooms.get(i).toString());
                    System.out.println("");
                }
                Display();
                break;
            case 5:
                System.out.println("Show reservations:");
                if(reservations.size()==0){
                    System.out.println("No reservations found.");
                }
                else
                for(int i=0; i<reservations.size(); i++){
                    System.out.println(reservations.get(i).toString());
                    System.out.println("");
                }
                Display();
                break;
            case 6:
            // Scanner scanner = new Scanner(System.in);
                System.out.println("Choose a reservation to delete:");
                for(int i=0; i<reservations.size(); i++){
                    System.out.println(i+1 + ". " + reservations.get(i).toString());
                }
                int reservationIndex;
                do{
                    err=false;
                    reservationIndex = Integer.valueOf(scanner.nextLine());
                    if(reservationIndex>reservations.size() || reservationIndex<1){
                        System.out.println("Invalid reservation index.");
                        err=true;
                    }
                }while(err);
                reservations.remove(reservationIndex-1);
                System.out.println("Reservation deleted!");
                Display();
                break;
            case 7:
                System.out.println("Choose a guest to delete:");
                for(int i=0; i<guests.size(); i++){
                    System.out.println(i+1 + ". " + guests.get(i).toString());
                    System.out.println("");
                }
                int guestIndex;
                do{
                    err=false;
                    guestIndex = Integer.valueOf(scanner.nextLine());
                    if(guestIndex>guests.size() || guestIndex<1){
                        System.out.println("Invalid guest index.");
                        err=true;
                    }
                }while(err);
                guests.remove(guestIndex-1);
                System.out.println("Guest deleted!");
                Display();
                break;
            case 8:
                System.out.println("Program finished");
                break;
            default:
                System.out.println("Invalid Input");
                Display();
                break;
        }
    }

    /**
     * Allows the user to select a room by entering its capacity, extra info, floor, price, and status.
     * If the room is found in the list of existing rooms, it displays a success message. Otherwise, it displays a failure message.
     */
    public  void SelectRoom(){
        Room room = new Room("",0, null, 0, null, 0);
        //enter room capacity
        do{
            err=false;
            System.out.println("Enter Room Capacity(1-3):");
            String capacity = scanner.nextLine();
        if(capacity.matches(Regex.ValidRoomCapacity)){
            room.Capacity = Integer.valueOf(capacity);
        }else
        {
            System.out.println("Invalid Input");
            err = true;
        }}while(err);
        //enter room extra info
        do{
            err=false;
            System.out.println("Enter Room Extra Info:");
            System.out.println("1. TV");
            System.out.println("2. Airconditioning");
            System.out.println("3. WiFi");
            System.out.println("4. Minibar");
            int extra= Integer.valueOf(scanner.nextLine());
            switch (extra){
                case 1:
                    room.ExtraInfo = Room.Extra.TV;
                    break;
                case 2:
                    room.ExtraInfo = Room.Extra.AIRCONDITIONING;
                    break;
                case 3:
                    room.ExtraInfo = Room.Extra.WIFI;
                    break;
                case 4:
                    room.ExtraInfo = Room.Extra.MINIBAR;
                    break;
                default:
                    System.out.println("Invalid Input");
                    err=true;
                    break;
            }
        }while(err);
        //enter room floor
        do{
            err=false;
            System.out.println("Enter Room Floor(1-6):");
            String floor = scanner.nextLine();
            if(!floor.matches(Regex.ValidRoomFloor)){
                err=true;
            }
            room.Floor = Integer.valueOf(floor);
        }while(err);
        //enter room price
        String price;
        do{
            err=false;
            System.out.println("Enter Room Price:");
            price = scanner.nextLine();
            if(!price.matches(Regex.ValidRoomPrice)){
                err=true;
            }
            room.Price = Integer.valueOf(price);
        }while(err);
        //enter room status
        boolean found = false;
        room.Status = Room.RoomAvailability.AVAILABLE;
        for(int i=0; i<rooms.size(); i++){
            if(rooms.get(i).Capacity == room.Capacity && rooms.get(i).ExtraInfo == room.ExtraInfo && rooms.get(i).Floor == room.Floor && rooms.get(i).Price == room.Price){
                System.out.println("Room found");
                found = true;
            }
            
        }
        if(!found){
            System.out.println("Room not found");
        }
    }
    /**
     * Represents a guest with their name, surname, phone number, and ID.
     */
    public  Guest AddGuest(){
         Guest guest = new Guest(null, null, null, null);
         //enter guest name
         do{
            err=false;
            System.out.println("Enter Guest Name:");
            String name = scanner.nextLine();
            if(!name.matches(Regex.ValidNameSurname)){
                System.out.println("Name should contain only letters.");
                err=true;
            }
            guest.Name = name;
         }while(err);
         //enter guest surname
         do{
            err=false;
            System.out.println("Enter Guest Surname:");
            String surname = scanner.nextLine();
            if(!surname.matches(Regex.ValidNameSurname)){
                System.out.println("Surname should contain only letters.");
                err=true;
            }
            guest.Surname = surname;
         }while(err);
         //enter guest phone
         do{
            err=false;
            System.out.println("Enter Guest Phone:");
            String phone = scanner.nextLine();
            if(!phone.matches(Regex.ValidPhone)){
                System.out.println("Incorrect phone number.");
                err=true;
            }
            guest.Phone = phone;
         }while(err);
         //enter guest ID
         do{
            err=false;
            System.out.println("Enter Guest ID:");
            String ID = scanner.nextLine();
            if(!ID.matches(Regex.ValidID)){
                System.out.println("Incorrect ID.");
                err=true;
            }
            guest.ID = ID;
         }while(err);
         System.out.println("Guest added!");
    return guest;
   }
    /**
     * Adds a reservation for a guest in a room.
     * 
     * If there are no guests available, it displays a message indicating that there are no guests to reserve a room for.
     * Otherwise, it prompts the user to choose a room and a guest, and then asks for the check-in and check-out dates and payment status.
     * The reservation is then added to the list of reservations.
     */
    private  void AddReservation(){
        int roomIndex;
        int guestIndex =-1;
        if(guests.size()==0){
            System.out.println("There is no guests to reserve room for.");
        }
        else{
            System.out.println("Choose a room:");
            for(int i=0; i<rooms.size(); i++){
                System.out.println(i+1 + ". " + rooms.get(i).toString());
                System.out.println("");
            }
            do{
                err=false;
                roomIndex = Integer.valueOf(scanner.nextLine());
                if(roomIndex>rooms.size() || roomIndex<1){
                    System.out.println("This room does not exist. Enter a valid room index:");
                    err=true;
                }

            }while(err);
            Room room = rooms.get(roomIndex-1);
            room.Status = Room.RoomAvailability.RESERVED;
             System.out.println("Choose a guest:");
            for(int i=0; i<guests.size(); i++){
                System.out.println(i+1 + ". " + guests.get(i).toString());
                System.out.println("");
            }
            do{
                err=false;
                try{ guestIndex = Integer.valueOf(scanner.nextLine());
                    if(guestIndex>guests.size() || guestIndex<1){
                        throw new IllegalArgumentException("This guest does not exist. Enter a valid guest index:");
                    }}
                catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    err=true;
                }
            }while(err);
            Guest guest = guests.get(guestIndex-1);
            System.out.println("Enter check in date:");
            String checkInDate;
            do{
                err=false;
                checkInDate = scanner.nextLine();
                if(!checkInDate.matches(Regex.ValidDate)){
                    System.out.println("Invalid date format. Enter a valid date:");
                    err=true;
                    break;
                }
            }while(err);
            System.out.println("Enter check out date:");
            String checkOutDate;
            do{
                err=false;
                checkOutDate = scanner.nextLine();
                if(!checkOutDate.matches(Regex.ValidDate)){
                    System.out.println("Invalid date format. Enter a valid date:");
                    err=true;
                    break;
                }
            }while(err);
            System.out.println("Enter payment status:");
            System.out.println("1. Paid");
            System.out.println("2. Not Paid");
            Paid status = Paid.NotPaid;
            int paymentStatus=0;
            do{
                err=false;
                paymentStatus = Integer.valueOf(scanner.nextLine());
                if(paymentStatus!=1 && paymentStatus!=2){
                    System.out.println("Invalid input. Enter a valid payment status:");
                    err=true;
                }
            }while(err);
            switch (paymentStatus) {
                case 1:
                    status = Paid.Paid;
                    break;
                case 2:
                    status = Paid.NotPaid;
                    break;
                default:
                    break;
            }
            reservations.add(new Reservation(guest, room, checkInDate, checkOutDate, status));
            System.out.println("Reservation added!");
        }
   }
  
/**
 * Adds rooms and guests to the hotel.
 */
   public void Rooms(){
    rooms.add(new Room("199",2, Room.Extra.TV, 3, Room.RoomAvailability.AVAILABLE, 10));
    rooms.add(new Room("110",2, Room.Extra.AIRCONDITIONING, 2, Room.RoomAvailability.OCCUPIED, 20));
    rooms.add(new Room("001",1, Room.Extra.AIRCONDITIONING, 1, Room.RoomAvailability.AVAILABLE, 30));
    rooms.add(new Room("425",5, Room.Extra.WIFI, 1, Room.RoomAvailability.AVAILABLE, 30));
    rooms.add(new Room("517",3, Room.Extra.TV, 6, Room.RoomAvailability.AVAILABLE, 30));
    rooms.add(new Room("038",1, Room.Extra.MINIBAR, 1, Room.RoomAvailability.AVAILABLE, 30));
    rooms.add(new Room("038",1, Room.Extra.TV, 1, Room.RoomAvailability.AVAILABLE, 10));
    guests.add(new Guest("John", "Doe", "123456789", "123456789"));    
}
}   