import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Vehicle class(superclass for its subclasses) with vehicle properties - vehicle type,vehicle number 
 */
abstract class Vehicle {
	private String vehicleType;
	private String vehicleNumber;
	
	public void setVehicleType(String vehicleType) {
		this.vehicleType=vehicleType;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber=vehicleNumber;
	}
	public String getVehicleType() {
		return this.vehicleType;
	}
	public String getVehicleNumber() {
		return this.vehicleNumber;
	}
}
//******************************************************************************************/
/**
 * Vehicle subclasses with constructor which initialises the vehicle type
 * -->For Custom class has an addition custom vechicle name property
 */

class Bike extends Vehicle{
	public Bike() {
		super.setVehicleType("Bike");
	}
}
class Car extends Vehicle{
	public Car() {
		super.setVehicleType("Car");
	}
}
class Handicapped extends Vehicle{
    public Handicapped(){
        super.setVehicleType("Handicapped");
    }
}
class Jeep extends Vehicle{
	public Jeep() {
		super.setVehicleType("Jeep");
	}
}
class Van extends Vehicle{
	public Van() {
		super.setVehicleType("Van");
	}
}
class Electric extends Vehicle{
	public Electric() {
		super.setVehicleType("Electric Vehicle");
	}
}
class Mini_Bus extends Vehicle{
	public Mini_Bus() {
		super.setVehicleType("Mini Bus");
	}
}
class Bus extends Vehicle{
	public Bus() {
		super.setVehicleType("Bus");
	}
}
class Overloaded extends Vehicle{
	public Overloaded() {
		super.setVehicleType("Overloaded Vehicle");
	}
}
class Truck extends Vehicle{
	public Truck() {
		super.setVehicleType("Truck");
	}
}
class Custom extends Vehicle{
	public Custom() {
		super.setVehicleType("Custom Vehicle");
	}
    private String customName;
    public String getCustomName() {
        return customName;
    }
    public void setCustomName(String customName) {
        this.customName = customName;
    }

}
/**
 * Ticket class which has the properties -date of parking in and parking out ,amount,ticket id,vehicle properties,floor number,account details of
 * the customer,ticket status and printing of ticket
 */
class Ticket {
	private Date d1;
	private Date d2;
	private double amount;
    private String TicketID;
    private String vehicleType;
    private String vehicleNumber;
    private int floorNumber;
    private boolean ticketStatus=false;
    public boolean getTicketStatus(){
        return this.ticketStatus;
    }
    public void setTicketStatus(boolean ticketStatus)
    {
        this.ticketStatus=ticketStatus;
    }

    public void setFloorNumber(int floorNumber){
        this.floorNumber=floorNumber;
    }
    public int getFloorNumber()
    {
        return this.floorNumber;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getTicketID() {
        return TicketID;
    }
    public void setTicketID(String ticketID) {
        TicketID = ticketID;
    }
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    String customVehicleType;
    public String getCustomVehicleType() {
        return customVehicleType;
    }
    public void setCustomVehicleType(String customVehicleType) {
        this.customVehicleType = customVehicleType;
    }
	public void printingTickets(Accounts a,ParkingDate d,ParkingSpot spot) {
		d1 = new Date();
		d.setDate(d1);
		System.out.println();
		System.out.println("Your Ticket");
        System.out.println("Ticket ID: "+getTicketID());
		System.out.println("Name: "+a.getCustomerName());
		System.out.println("Mobile Number: "+a.getMobileNumber());
        System.out.println("Handicapped Status: "+a.getHandicapped());
        if(customVehicleType!=null)
        {
            System.out.println("Vehicle Type: "+getCustomVehicleType());
        }
        else
        {
            System.out.println("Vehicle Type: "+getVehicleType());
        }
		System.out.println("Vehicle Number: "+getVehicleNumber());
		System.out.println("Your Spot ID is: "+spot.getSpotID());
		System.out.println("Parked at: ");
		System.out.println(d1);
		System.out.println();
        this.floorNumber=spot.getFloorNumber();
	}
	public void printingBill(ParkingDate d,Accounts a) {
		d2 = new Date();
        d.setDate(d1);
		long diff = d2.getTime()-d.getDate().getTime();
		long diffDays = diff/(1000*60*60*24);
		long diffHours = diff/(1000*60*60) - 24*diffDays;
		long diffMinutes= diff/(1000*60) - 60*diffHours;
		long diffSeconds = diff/1000 - 60*diffMinutes;
		long diffHours_2 = diff/(1000*60*60);
        amount=20;
		if(diffHours_2>1 && diffHours_2<2) {
			amount = 30; 
		}
		if(diffHours_2>2 && diffHours_2<3) {
			amount = 40; 
		}
		if(diffHours_2>3) {
			amount = 40 + Math.ceil(diffHours_2-3)*5; 
		}
		System.out.println();
		System.out.println("Your Bill");
		System.out.println("Name: "+a.getCustomerName());
		System.out.println("Mobile Number: "+a.getMobileNumber());
        System.out.println("Handicapped Status: "+a.getHandicapped());
        if(customVehicleType!=null)
        {
            System.out.println("Vehicle Type: "+getCustomVehicleType());
        }
        else
        {
            System.out.println("Vehicle Type: "+getVehicleType());
        }
		System.out.println("Vehicle Number: "+getVehicleNumber());
		System.out.println("Parking in time: ");
		System.out.println(d.getDate());
		System.out.println("Parking out time: ");
		System.out.println(d2);
		System.out.println("Total time parked: (Days/Hours/Minutes/Seconds) ");
		System.out.println(diffDays + ":" + diffHours + ":" + diffMinutes + ":" + diffSeconds);
		System.out.println("Total Amount: ");
		System.out.println(amount);
		System.out.println();
	}
	public double getAmount() {
		return amount;
	}

}
/**
 * ParkingSpot class contains information about spotID,status of the spot(is vacant or not),type of spot ,floor number,parked vehicle ID and 
 * the allocated ticket id.
 * It also contains methods for parking the vehicle and emptying the spots.
 */
class ParkingSpot {
    private String spotID;
    private boolean isVacant;
    private String spotType;
    private int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    private String parkedVehicleID;
    private String allocatedTicketID;

    public String getAllocatedTicketID() {
        return allocatedTicketID;
    }

    public void setAllocatedTicketID(String allocatedTicketID) {
        this.allocatedTicketID = allocatedTicketID;
    }

    public void setIsVacant(boolean isVacant) {
        this.isVacant = isVacant;
    }

    public boolean getIsVacant() {
        return isVacant;
    }

    public void setSpotType(String spotType) {
        this.spotType = spotType;
    }

    public String getSpotID() {
        return spotID;
    }

    public void setSpotID(String spotID) {
        this.spotID = spotID;
    }

    public void parkVehicle(String vehicleID) {
        this.isVacant = false;
        this.parkedVehicleID = vehicleID;
    }

    public void emptyTheSlot() {
        this.isVacant = true;
        this.parkedVehicleID = null;
    }
}
/**
 * TicketCounter class contains details like ticket counter name,there would be list of allocated vehicles for each ticket counter
 * so that vehicles of comparable parking spots could be managed together from one ticket counter
 * -->Unused function checkVehicle() - This function can be used to ensure that the customer goes to a fixed Ticket counter to park out
 */
class TicketCounter {
    String ticketCounterName;
    public String getTicketCounterName() {
        return ticketCounterName;
    }
    public void setTicketCounterName(String ticketCounterName) {
        this.ticketCounterName = ticketCounterName;
    }
    List<String> allowedVehicleTypes ;

    /**
     * Allocating the ticket counter names and adding allowed vehicle types for each ticket counter
     */

    TicketCounter(int ticketCounterNumber,List<String> allowedTypes){
        allowedVehicleTypes=new ArrayList<>();
        this.ticketCounterName="TC-"+Integer.toString(ticketCounterNumber);
        for (int i = 0; i < allowedTypes.size(); i++) {
            allowedVehicleTypes.add(allowedTypes.get(i));
        }
    }
    boolean isCorrectVehicle=false;
    void checkVehicle(Vehicle vehicle){
        for (int i = 0; i < allowedVehicleTypes.size();i++) {
            if(allowedVehicleTypes.get(i).equals(vehicle.getVehicleType())){
                isCorrectVehicle=true;
                return;
            }
        }
    }

}
/**
 * Parking floor class
 */
class ParkingFloor {

    int floorNumber = 0;
    /**
     * Map with key as type of parking spot and value as a collection(List) of
     * parking spots For each parking spot ,a list of parking spots would be
     * allocated.
     */
    private Map<String, ArrayList<ParkingSpot>> parkingSpots = new HashMap<>();
    /**
     * Array of spot types to store the initialised spot types
     */
    private String[] spotTypes = {"Bike", "Car","Handicapped", "Jeep","Van", "Electric Vehicle","Overloaded Vehicle","Truck","Custom Vehicle" };
    /**
     * Initialising the parkingSpot map
     * spotListSizes-->the size of list for each spot type (here the list size is initialised as 3)
     * setting he floor number,spot type,spot Id
     * setting all the spots as vacant
     * Advantage of this approach is each list could be initialised separately thus the number of parking spots allocated for each floor type 
     * could be adjusted.
     */
    private int spotListSizes=3;
    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        
        for (int i = 0; i < spotTypes.length; i++) {
            parkingSpots.put(spotTypes[i], new ArrayList<>());
            for (int j = 0; j < spotListSizes; j++) {
                parkingSpots.get(spotTypes[i]).add(new ParkingSpot());
                parkingSpots.get(spotTypes[i]).get(j).setFloorNumber(this.floorNumber);
                parkingSpots.get(spotTypes[i]).get(j).setSpotType(spotTypes[i]);
                parkingSpots.get(spotTypes[i]).get(j)
                        .setSpotID(spotTypes[i] + "-" +Integer.toString(this.floorNumber) + "-" + Integer.toString(j));
                parkingSpots.get(spotTypes[i]).get(j).setIsVacant(true);
            }
        }
    }
    /**
     * Checking if the floor is full or not
     * @return
     */
    public boolean isFloorFull() {
        for (int i = 0; i < spotTypes.length; i++) {
            if (isParkingSpaceAvailableAtFloor(spotTypes[i])) {
                return false;
            }
        }
        return true;
    }
    /**
     * Checking if the parking space i.e. parking spots are available for the vehicle type on the floor
     * @param vehicleType
     * @return
     */
    public boolean isParkingSpaceAvailableAtFloor(String vehicleType) {
        for (int i = 0; i < parkingSpots.get(vehicleType).size(); i++) {
            if (parkingSpots.get(vehicleType).get(i).getIsVacant()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Allocating spots for the vehicle
     * @param vehicleType
     * @param vehicleID
     * @return
     */
    public ParkingSpot allocateSpot(String vehicleType, String vehicleID) {
        for (int i = 0; i < parkingSpots.get(vehicleType).size(); i++) {
            if (parkingSpots.get(vehicleType).get(i).getIsVacant()) {
                parkingSpots.get(vehicleType).get(i).parkVehicle(vehicleID);
                return parkingSpots.get(vehicleType).get(i);
            }
        }
        return null;
    }
    /**
     * Vacating the spot by identifying the ticket if the payment is done
     * @param ticket
     * @return
     */
    public ParkingSpot vacateSpot(Ticket ticket) {

        for (int i = 0; i < parkingSpots.get(ticket.getVehicleType()).size(); i++) {
            if (ticket.getTicketID().equals(parkingSpots.get(ticket.getVehicleType()).get(i).getAllocatedTicketID())) {
                // check futher credentials
                parkingSpots.get(ticket.getVehicleType()).get(i).emptyTheSlot();
                return parkingSpots.get(ticket.getVehicleType()).get(i);
            }
        }
        return null;
    }
    /**
     * Checking if the floor is empty or not
     * @return
     */
    public boolean isFloorEmpty(){
        for (int i = 0; i < spotTypes.length; i++) {
            for (int j = 0; j < spotListSizes; j++) {
                if(!parkingSpots.get(spotTypes[i]).get(j).getIsVacant())
                {
                    return false;
                }
                
            }
        }
        return true;
    }
}
/**
 * Parking lot class
 */
class ParkingLot {
    /**
     * name,addess ,status of the parking lot
     */
    private String name;
    private String address;
    private boolean isOpen=true;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    public boolean getIsOpen() {
        return this.isOpen;
    }
    /**
     * Parking lot would have a list of parking floors and ticket counters
     * number of floors could also be changed by admin
     */
    public List<ParkingFloor> parkingFloors;
    public List<TicketCounter> ticketCounters;
    private int numberOfFloors=3;
    /**
     * Initialising the above lists using constructor
     */
    ParkingLot(String name,String address) {

        parkingFloors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            parkingFloors.add(new ParkingFloor(i));
        }
        ticketCounters = new ArrayList<>();
        List<String> tc1 = Arrays.asList("Bike", "Car","Handicapped");
        ticketCounters.add(new TicketCounter(0, tc1));
        List<String> tc2 = Arrays.asList("Jeep","Van");
        ticketCounters.add(new TicketCounter(1, tc2));
        List<String> tc3 = Arrays.asList("Electric Vehicle");
        ticketCounters.add(new TicketCounter(2, tc3));
        List<String> tc4 = Arrays.asList("Overloaded Vehicle","Truck");
        ticketCounters.add(new TicketCounter(3, tc4));
        List<String> tc5 = Arrays.asList("Custom Vehicle");
        ticketCounters.add(new TicketCounter(4, tc5));
        this.name=name;
        this.address=address;
    }
    /**
     * Returns the available floor object if there is any vacant spot available on that floor for that vehicle type 
     * @param vehicleType
     * @return
     */
    public ParkingFloor getAvailabeFloorNumber(String vehicleType) {
        for (int i = 0; i < parkingFloors.size(); i++) {
            if (parkingFloors.get(i).isParkingSpaceAvailableAtFloor(vehicleType)) {
                return parkingFloors.get(i);
            }
        }
        return null;
    }

}
/**
 * Account class for user account
 */
class Accounts {
	private String customerName;
	private String mobileNumber;
	private boolean handicapped;
	
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setHandicapped(boolean handicapped) {
		this.handicapped =handicapped;
	}
	public boolean getHandicapped() {
		return this.handicapped;
	}
}
/**
 * class to set and get dates
 */
class ParkingDate{
    private Date d;
    public void setDate(Date d) {
        this.d=d;
    }
    public Date getDate() {
        return d;
    }
}
/**
 * Interface for payment methods
 */
interface PaymentMehods{
    void paymentCash(Ticket ticket,Scanner scan);
    void paymentCreditCard(Ticket ticket,Scanner scan);
    void paymentDebitCard(Ticket ticket,Scanner scan);
}
/**
 * Payment class implements the PaymentMehods
 */
class Payment implements PaymentMehods{
	private boolean status =false;
	private int pin;
	public void paymentCash(Ticket ticket,Scanner scan) {
		System.out.println("Please provide an amount of "+ticket.getAmount());
		double take = scan.nextDouble();
		if(take<ticket.getAmount()) {
			System.out.println("Cash insufficient\nPayment fail\ntry again");
		}
		if(take==ticket.getAmount()) {
			System.out.println("Payment Successful");
			status=true;
		}
		if(take>ticket.getAmount()) {
			System.out.println("Payment Successful");
			System.out.println("Collect your change: "+(take-ticket.getAmount()));
			status=true;	
		}
	}
	public void paymentCreditCard(Ticket ticket,Scanner scan) {
		System.out.println("Please insert your credit card\n Enter your pin");
		pin=scan.nextInt();
		System.out.println("Payment Successful\nCollect your Card");
		status=true;
	}
	public void paymentDebitCard(Ticket ticket,Scanner scan) {
		System.out.println("Please insert your debit card\n Enter your pin");
		pin=scan.nextInt();
		System.out.println("Payment Successful\nCollect your Card");
		status=true;
	}
	public boolean getStatus() {
		return status;
	}
}
/**
 * Main gate to display information about the Parking lot
 */
class MainGate{
    void display(ParkingLot parkingLot){
        System.out.println("Welcome to "+parkingLot.getName()+" parking lot");
        System.out.println("Address: "+parkingLot.getAddress());
        System.out.println("Parking lot is "+(parkingLot.getIsOpen()?"Open" : "Closed"));
        System.out.println("Ticket counter ---- Vehicle list");
        for (int i = 0; i < parkingLot.ticketCounters.size(); i++) {
            System.out.println(parkingLot.ticketCounters.get(i).getTicketCounterName()+"                "+parkingLot.ticketCounters.get(i).allowedVehicleTypes);
        }
    }
}
/**
 * Info interface to get the information
 */
interface Info{
    void display(Scanner in,ParkingLot parkingLot);
    
}
/**
 * Entrypanel to obtain the information.
 * Features recursive calling of functions
 */
class EntryPanel implements Info{
    
    Map<String,Ticket> mapTicketID=new HashMap<>();
    Map<String,Vehicle> mp =new HashMap<>();
    Map<Ticket,Accounts> mapTicketsToAccounts=new HashMap<>();
    /***
     * list of tickets for storing the ticket information of the users
     */
    List<Ticket> tickets=new ArrayList<>();  
    public void display(Scanner in,ParkingLot parkingLot)
    {
        mp.put("Car", new Car());
        mp.put("Bike", new Bike());
        mp.put("Handicapped", new Handicapped());
        mp.put("Jeep", new Jeep());
        mp.put("Van", new Van());
        mp.put("Electric Vehicle", new Electric());
        mp.put("Overloaded", new Overloaded());
        mp.put("Truck", new Truck());
        mp.put("Custom Vehicle",new Custom());
        System.out.println("Do you want to change account:\n1) YES\n2) NO ");
        int changeAccount=in.nextInt();
        if(changeAccount==1)
        {
            System.out.println(changeAccount);
            return;
        }
        else 
        {
            if((changeAccount!=2))
            {
                System.out.println("Invalid option number");
                return;

            }
        }
        System.out.println("Enter the ticket counter number: ");
        int tcNumber=in.nextInt();
        System.out.println("Welcome to "+parkingLot.ticketCounters.get(tcNumber).ticketCounterName);
        System.out.println("1) Park in\n2 Park out");
        int option0=in.nextInt();
        if(option0==1)
        {
            Ticket t=new Ticket();
            System.out.println("Please select your vehicle type : \n");
            System.out.println("---------------------------------------------");
            System.out.println("Choice number   Vehicle Type  Is parking spot available\n");
            System.out.println("---------------------------------------------");
            Map<Integer,String> isSpotAvailable=new HashMap<>();
            for (int i = 0; i < parkingLot.ticketCounters.get(tcNumber).allowedVehicleTypes.size() ; i++) {
    
                if(parkingLot.getAvailabeFloorNumber(parkingLot.ticketCounters.get(tcNumber).allowedVehicleTypes.get(i))==null)
                {
                    isSpotAvailable.put(i, "NO");
                }
                else if(parkingLot.getAvailabeFloorNumber(parkingLot.ticketCounters.get(tcNumber).allowedVehicleTypes.get(i)).isParkingSpaceAvailableAtFloor(parkingLot.ticketCounters.get(tcNumber).allowedVehicleTypes.get(i)))
                {
                    isSpotAvailable.put(i, "YES");
                }
                else{
                    isSpotAvailable.put(i, "NO");
                }
                System.out.println((i)+"                 "+parkingLot.ticketCounters.get(tcNumber).allowedVehicleTypes.get(i)+"        "+isSpotAvailable.get(i));
            }
            System.out.println("---------------------------------------------");
            int vehicleType=in.nextInt();
            if(isSpotAvailable.get(vehicleType).equals("YES"))
            {
                Vehicle v=mp.get(parkingLot.ticketCounters.get(tcNumber).allowedVehicleTypes.get(vehicleType));
                ParkingFloor floor=parkingLot.getAvailabeFloorNumber(v.getVehicleType());
                if(v.getVehicleType().equals("Custom Vehicle"))
                {
                    System.out.println("Give your custom vehicle type:");
                    in.nextLine();
                    String customVehicleType=in.nextLine();
                    t.setCustomVehicleType(customVehicleType);
                }
                else
                {
                    t.setVehicleType(v.getVehicleType());
                    in.nextLine();
                }
                System.out.println("Please give your Vehicle Number :");
                String vehicleNumber=in.nextLine();
                v.setVehicleNumber(vehicleNumber);
                t.setVehicleNumber(vehicleNumber);
                ParkingSpot spot=floor.allocateSpot(v.getVehicleType(), v.getVehicleNumber());
                t.setTicketID(UUID.randomUUID().toString());
                spot.setAllocatedTicketID(t.getTicketID());
                Accounts a=new Accounts();
                System.out.println("Please give your name :");
                String customerName=in.nextLine();
                a.setCustomerName(customerName);
                System.out.println("Please give your Mobilenumber :");
                String mobileNumber=in.nextLine();
                a.setMobileNumber(mobileNumber);
                System.out.println("Do you need a handicapped spot?\n1) Yes\n2) No ");
                int handicappedChoice=in.nextInt();
                while(handicappedChoice!=2 && handicappedChoice!=1)
                {
                    System.out.println("Enter a valid choice");
                    handicappedChoice=in.nextInt();
                    if(handicappedChoice==1 || handicappedChoice==2)
                    {
                        break;
                    }
                }
                if(handicappedChoice==1)
                {
                   a.setHandicapped(true);
                }
                else if(handicappedChoice==2)
                {
                   a.setHandicapped(false);
                }
                ParkingDate date=new ParkingDate();
                mapTicketID.put(t.getTicketID(),t);
                tickets.add(t);
                mapTicketsToAccounts.put(t,a);
                t.printingTickets( a, date, spot);
            }
            else
            {
                System.out.println("Sorry no space available for you vehicle.");
            }
            display(in, parkingLot);
        }
        else if(option0==2)
        {
            int incorrectIDsSubmitted=0;
            in.nextLine();
            System.out.println("Please provide the Ticket ID\n");
            String TicketID=in.nextLine();
            System.out.println(TicketID);
            Ticket ticket=mapTicketID.get(TicketID);
            if(ticket==null)
            {
                incorrectIDsSubmitted++;
                System.out.println("Incorrect ID provided");
            }
            else if(ticket.getTicketStatus())
            {
                System.out.println("Invalid ticket id");
            }
            else
            {
                System.out.println("Welcome to floor number: "+mapTicketID.get(TicketID).getFloorNumber());
                System.out.println("Here is your bill: ");
                ParkingDate date=new ParkingDate();
                ticket.printingBill(date,mapTicketsToAccounts.get((mapTicketID.get(TicketID))));
                System.out.println("Where would you like to pay the bill: \n1) Customer Info Portal\n 2) Parking Attendent\n 3) Exit Gate");
    
                Payment payment=new Payment();
                int ticketPaymentChoice=in.nextInt();
                if(ticketPaymentChoice==1)
                {
                    System.out.println("Welcome to customer info portal.On what topic do you need information :\n1) Locating Vehicle\n2) Payment ");
                    int choice=in.nextInt();
                    if(choice==1)
                    {
                        while(choice==1)
                        {
                            System.out.println("Your ticket contains a String -'SpotID'.It has three portions separated by '-'. ");
                            System.out.println("The first contains the vehicle type ");
                            System.out.println("The second contains your floor number");
                            System.out.println("The third contains your spot number");
                            System.out.println("Welcome to customer info portal.On what topic do you need information :\n1) Locating Vehicle\n2) Payment ");
                            choice=in.nextInt();
        
                        }
    
                    }
                    if(choice==2)
                    {
                        System.out.println("Select a payment method: \n1) Cash\n2) Credit Card\n3) Debit Card");
            
                        int paymentChoice=in.nextInt();
                        switch(paymentChoice)
                        {
                            case 1:
                            payment.paymentCash(mapTicketID.get(TicketID),in);
                            break;
                            case 2:
                            payment.paymentCreditCard(mapTicketID.get(TicketID), in);
                            break;
                            case 3:
                            payment.paymentDebitCard(mapTicketID.get(TicketID), in);
                            break;
                        }
                        if(payment.getStatus())
                        {
                            ticket.setTicketStatus(true);
                            ParkingSpot spot= parkingLot.parkingFloors.get(mapTicketID.get(TicketID).getFloorNumber()).vacateSpot(mapTicketID.get(TicketID));
                            System.out.println("Vehicle vacated from SpotID : "+spot.getSpotID());
                            System.out.println("Payment Completed\nThankyou");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid option");
                    }
    
                }
                else if(ticketPaymentChoice==2)
                {
                    System.out.println("Hi! parking assistant this side.Please check the payment status");
                    payment.paymentCash(ticket, in);
                    if(payment.getStatus())
                    {
                        ticket.setTicketStatus(true);
                        ParkingSpot spot= parkingLot.parkingFloors.get(mapTicketID.get(TicketID).getFloorNumber()).vacateSpot(mapTicketID.get(TicketID));
                        System.out.println("Vehicle vacated from SpotID : "+spot.getSpotID());
                        System.out.println("Payment Completed\nThankyou");
                    }
                }
                else if(ticketPaymentChoice==3 || !payment.getStatus())
                {
                    System.out.println("Welcome to the exit gate.");
                    System.out.println("Select a payment method: \n1) Cash\n2) Credit Card\n3) Debit Card");
    
                    int paymentChoice=in.nextInt();
                    switch(paymentChoice)
                    {
                        case 1:
                        payment.paymentCash(mapTicketID.get(TicketID),in);
                        break;
                        case 2:
                        payment.paymentCreditCard(mapTicketID.get(TicketID), in);
                        break;
                        case 3:
                        payment.paymentDebitCard(mapTicketID.get(TicketID), in);
                        break;
                    }
                    if(payment.getStatus())
                    {
                        ticket.setTicketStatus(true);
                        ParkingSpot spot= parkingLot.parkingFloors.get(mapTicketID.get(TicketID).getFloorNumber()).vacateSpot(mapTicketID.get(TicketID));
                        System.out.println("Vehicle vacated from SpotID : "+spot.getSpotID());
                        System.out.println("Payment Completed\nThankyou");
                    }
                }
                else
                {
                    System.out.println("Invalid option"); 
                }
                display(in, parkingLot);

            }

        }
        else
        {


            display(in, parkingLot);
        }

    }

}
/**
 * Admin class for admin works 
 * --> Admin can only register once
 * --> The option of changing the name and status of parking lot could be added as functions
 * --> The option of blacklisting the vehicle could also be added if the customers do ont follow the parking lot rules
 */
class Admin{
    private static Map<String,String> namePinMap=new HashMap<>();
    private String name;
    private String mobileNumber;
    private String pin;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    private static boolean registerStatus=false;
    void adminRegister(Scanner in)
    {
        if(!registerStatus)
        {
            System.out.println("Welcome to admin register portal : ");
            System.out.println("Enter name :");
            String name=in.nextLine();
            setName(name);
            System.out.println("Enter mobile number :");
            String mobileNumber=in.nextLine();
            setMobileNumber(mobileNumber);
            System.out.println("Enter pin :");
            String pin=in.nextLine();
            setPin(pin);
            namePinMap.put(name, pin);
            System.out.println(namePinMap.get(name));
            registerStatus=true;
        }
        else
        {
            System.out.println("Admin has already registered ");
        }

        
    }
    void adminLogin(Scanner in,ParkingLot parkingLot)
    {
        System.out.println("Welcome to admin login portal : ");
        System.out.println("Enter name :");
        String name=in.nextLine();
        System.out.println("Enter pin :");
        String pin=in.nextLine();
        if(namePinMap.get(name)==null)
        {
            System.out.println("Please make an account.");
            adminRegister(in);   
        }
        else if(namePinMap.get(name).equals(pin))
        {
            System.out.println("Successfully logged in.");
            parkingLotChanges(in, parkingLot);
        }
        else
        {
            System.out.println("Incorrect name/pin");
            adminLogin(in,parkingLot);
        }

    }
    void parkingLotChanges(Scanner in,ParkingLot parkingLot){
        System.out.println("Select the options :\n1)Add parking floor\n2)Remove parking floor\n3)Return");
        int choice=in.nextInt();
        if(choice==1)
        {
            parkingLot.parkingFloors.add(new ParkingFloor(parkingLot.parkingFloors.size()));
            System.out.println("Added a new floor with number "+parkingLot.parkingFloors.size());
            parkingLotChanges(in, parkingLot);
        }
        else if(choice==2)
        {
            if(parkingLot.parkingFloors.size()==1)
            {
                System.out.println("Cannot have an empty parling lot");
                parkingLotChanges(in, parkingLot);
            }
            else if(!parkingLot.parkingFloors.get(parkingLot.parkingFloors.size()-1).isFloorEmpty())
            {
                System.out.println("The floor is not empty");
                parkingLotChanges(in, parkingLot);
            }
            else
            {
                ParkingFloor topFloor=parkingLot.parkingFloors.get(parkingLot.parkingFloors.size()-1);
                parkingLot.parkingFloors.remove(topFloor);
                System.out.println("Removed floor no "+(parkingLot.parkingFloors.size()+1));
                parkingLotChanges(in, parkingLot);
            }   
        }
        else if(choice==3)
        {
            System.out.println("Returned");
            return;
        }
        else
        {
            System.out.println("Invalid Number");
        }
        
    }

}
/**
 * Class for changing the account options
 */
class AccountOption{
    void display(Scanner in,EntryPanel en,ParkingLot parkingLot)
    {
        System.out.println("Please select one:");
		System.out.println("1) Customer\n2) Admin\n3) Exit");
        int option=in.nextInt();
        if(option==1)
        {
            en.display(in, parkingLot);
            display(in, en, parkingLot);
        }
        else if(option==2)
        {
            Admin admin=new Admin();
            System.out.println("Welcome to admin portal :\n1) Login\n2) Register");
            int choice=in.nextInt();
            if(choice==1)
            {
                in.nextLine();
                admin.adminLogin(in, parkingLot);
            }
            else if(choice==2)
            {
                in.nextLine();
                admin.adminRegister(in);
            }
            else
            {
                System.out.println("Invalid Option");
            }
            display(in, en, parkingLot);
        }
        else if(option==3)
        {
            System.out.println("Exited from system");
            return;
        }
        else
        {
            System.out.println("Invalid Number");
            display(in, en, parkingLot);
        }

    }
}
public class ParkingLotMain {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot("team 8","LocalDriveC");
        Scanner in=new Scanner(System.in);
        MainGate mainGate=new MainGate();
        mainGate.display(parkingLot);
        EntryPanel en=new EntryPanel();
        AccountOption ac=new AccountOption();
        ac.display(in, en, parkingLot);
    }

}
