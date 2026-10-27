Program : 
import java.util.ArrayList; 
import java.util.Scanner; 
class Bus { 
 int busNo; 
 String busName; 
 String source; 
 String destination; 
 int totalSeats; 
 int availableSeats; 
 Bus(int busNo, String busName, String source,  String destination, int totalSeats) { 
 this.busNo = busNo; 
 this.busName = busName; 
 this.source = source; 
 this.destination = destination; 
 this.totalSeats = totalSeats; 
 this.availableSeats = totalSeats;  } 
 void displayBus() { 
 System.out.println( 
 busNo + "\t" + busName + "\t" +  source + "\t" + destination + "\t" +  availableSeats 
 ); 
 } 
} 
class Ticket { 
 int ticketNo; 
 String passengerName; 
 int age; 
 int busNo; 
 String busName; 
 String source;
 String destination; 
 Ticket(int ticketNo, String passengerName, int age,  int busNo, String busName, 
 String source, String destination) { 
 this.ticketNo = ticketNo; 
 this.passengerName = passengerName; 
 this.age = age; 
 this.busNo = busNo; 
 this.busName = busName; 
 this.source = source; 
 this.destination = destination; 
 } 
 void displayTicket() { 
 System.out.println("\n-----------------------------");  System.out.println(" TICKET DETAILS");  System.out.println("-----------------------------");  System.out.println("Ticket No : " + ticketNo);  System.out.println("Passenger Name: " + passengerName);  System.out.println("Age : " + age); 
 System.out.println("Bus No : " + busNo);  System.out.println("Bus Name : " + busName);  System.out.println("From : " + source);  System.out.println("To : " + destination);  System.out.println("-----------------------------");  } 
} 
public class BusReservationSystem { 
 static Scanner sc = new Scanner(System.in); 
 static ArrayList<Bus> buses = new ArrayList<>();  static ArrayList<Ticket> tickets = new ArrayList<>(); 
 static int ticketCounter = 1001; 
 public static void main(String[] args) {
 // Adding buses 
 buses.add(new Bus(101, "Green Express", 
 "Chennai", "Madurai", 40)); 
 buses.add(new Bus(102, "Tamil Travels", 
 "Chennai", "Coimbatore", 35)); 
 buses.add(new Bus(103, "City Rider", 
 "Madurai", "Trichy", 30)); 
 int choice; 
 do { 
 System.out.println("\n================================");  System.out.println(" BUS RESERVATION SYSTEM");  System.out.println("================================");  System.out.println("1. View Available Buses"); 
 System.out.println("2. Book Ticket"); 
 System.out.println("3. View Booked Tickets"); 
 System.out.println("4. Cancel Ticket"); 
 System.out.println("5. Exit"); 
 System.out.println("================================"); 
 System.out.print("Enter your choice: "); 
 choice = sc.nextInt(); 
 switch (choice) { 
 case 1: 
 viewBuses(); 
 break; 
 case 2: 
 bookTicket(); 
 break; 
 case 3: 
 viewTickets(); 
 break;
 case 4: 
 cancelTicket(); 
 break; 
 case 5: 
 System.out.println( 
 "\nThank you for using Bus Reservation System!"  ); 
 break; 
 default: 
 System.out.println( 
 "\nInvalid choice! Please try again." 
 ); 
 } 
 } while (choice != 5); 
 sc.close(); 
 } 
 // Display buses 
 static void viewBuses() { 
 System.out.println("\n------------- AVAILABLE BUSES -------------"); 
 System.out.println( 
 "Bus No\tBus Name\tSource\tDestination\tSeats"  ); 
 for (Bus bus : buses) { 
 bus.displayBus(); 
 } 
 } 
 // Book ticket 
 static void bookTicket() { 
 viewBuses();
 System.out.print("\nEnter Bus Number: ");  int busNo = sc.nextInt(); 
 Bus selectedBus = null; 
 for (Bus bus : buses) { 
 if (bus.busNo == busNo) { 
 selectedBus = bus; 
 break; 
 } 
 } 
 if (selectedBus == null) { 
 System.out.println("Bus not found!");  return; 
 } 
 if (selectedBus.availableSeats <= 0) {  System.out.println("Sorry! No seats available.");  return; 
 } 
 sc.nextLine(); 
 System.out.print("Enter Passenger Name: ");  String name = sc.nextLine(); 
 System.out.print("Enter Age: "); 
 int age = sc.nextInt(); 
 Ticket ticket = new Ticket( 
 ticketCounter++, 
 name, 
 age, 
 selectedBus.busNo, 
 selectedBus.busName, 
 selectedBus.source, 
 selectedBus.destination 
 );
 tickets.add(ticket); 
 selectedBus.availableSeats--; 
 System.out.println("\nTicket booked successfully!"); 
 ticket.displayTicket(); 
 } 
 // View tickets 
 static void viewTickets() { 
 if (tickets.isEmpty()) { 
 System.out.println("\nNo tickets booked yet."); 
 return; 
 } 
 System.out.println("\n========== BOOKED TICKETS =========="); 
 for (Ticket ticket : tickets) { 
 ticket.displayTicket(); 
 } 
 } 
 // Cancel ticket 
 static void cancelTicket() { 
 if (tickets.isEmpty()) { 
 System.out.println("\nNo tickets available to cancel.");  return; 
 } 
 System.out.print("\nEnter Ticket Number: "); 
 int ticketNo = sc.nextInt(); 
 Ticket cancelTicket = null; 
 for (Ticket ticket : tickets) { 
 if (ticket.ticketNo == ticketNo) { 
 cancelTicket = ticket;
 break; 
 } 
 } 
 if (cancelTicket == null) { 
 System.out.println("Ticket not found!");  return; 
 } 
 // Increase available seat 
 for (Bus bus : buses) { 
 if (bus.busNo == cancelTicket.busNo) {  bus.availableSeats++; 
 break; 
 } 
 } 
 tickets.remove(cancelTicket); 
 System.out.println( 
 "\nTicket cancelled successfully!"  ); 
 } 
} 
Output: 
========================================  BUS RESERVATION SYSTEM 
======================================== 
1. View Available Buses 
2. Book Ticket 
3. View Booked Tickets 
4. Cancel Ticket 
5. Exit
Enter your choice: 1 
------------- AVAILABLE BUSES ------------- 
Bus No Bus Name Source Destination Seats 101 Green Express Chennai Madurai 40 102 Tamil Travels Chennai Coimbatore 35 103 City Rider Madurai Trichy 30
