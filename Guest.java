/**
 * The Guest class represents a guest with their name, surname, ID, and phone number.
 */
public class Guest {
    public Guest(String Name, String Surname, String ID, String Phone){
        this.Name=Name;
        this.Surname=Surname;
        this.ID=ID;
        this.Phone=Phone;
    }
    
    public String Name;
    public String Surname;
    public String ID;
    public String Phone;
    
    /**
     * Returns a string representation of the guest.
     * @return A string containing the guest's name, surname, ID, and phone number.
     */
    public String toString(){
        return "Name: "+Name+"\nSurname: "+Surname+"\nID: "+ID+"\nPhone: "+Phone;
    }
}
