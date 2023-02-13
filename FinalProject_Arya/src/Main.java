//LnTMidProject_Mobile-A_Arya_Nathan_Bara_2602064222
import java.util.Scanner;
import java.util.Vector;

public class Main {
   public void space() {
      for (int i = 0; i < 32; i++) {
         System.out.println("");
      }
   }
   static Scanner scan = new Scanner(System.in);
   static String typeChecker() {
      boolean checker = false;
      String tempVehicleType = new String();
      while (!checker) {
         System.out.print("Input type [Car | Motorcycle]: ");
         tempVehicleType = scan.nextLine();
         if (tempVehicleType.equalsIgnoreCase("car") || tempVehicleType.equalsIgnoreCase("motorcycle")) {
            checker = true;
         }
      }
      return (tempVehicleType.equalsIgnoreCase("car") ? "Car" : "Motorcycle");
   }
   public Main() {
      String vehicleType;
      Vector < Motorcycle > motor = new Vector < > ();
      Vector < Car > cars = new Vector < > ();
      int choice = 0, carNumber = 0, motorNumber = 0;
      while (true) {
         space();
         System.out.println("1. Input");
         System.out.println("2. View");
         System.out.println("3. Exit Program");
         System.out.print("[Input]:");
         choice = scan.nextInt();
         scan.nextLine();
         switch (choice) {
         case 1:
            vehicleType = typeChecker();
            if (vehicleType.equalsIgnoreCase("car")) {
               carNumber++;
               cars.add(new Car(vehicleType));
            } else {
               motorNumber++;
               motor.add(new Motorcycle(vehicleType));
            }
            System.out.print("ENTER to return");
            scan.nextLine();
            break;
         case 2:
            System.out.println("|----|--------------------|--------------------|");
            System.out.println("|No  |Type                |Name                |");
            System.out.println("|----|--------------------|--------------------|");
            for (int i = 0; i < carNumber; i++) {
               System.out.printf("|%-5d|%-24s|%-24s|\n", i + 1, cars.get(i).vehicleType, cars.get(i).vehicleName);
            }
            System.out.println("|----|--------------------|--------------------|");
            for (int i = 0; i < motorNumber; i++) {
               System.out.printf("|%-5d|%-24s|%-24s|\n", i + carNumber + 1, motor.get(i).vehicleType, motor.get(i).vehicleName);
            }
            System.out.println("|----|--------------------|--------------------|");
            System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
            int choiches = scan.nextInt();
            scan.nextLine();
            if (choiches >= 1 && choiches <= motorNumber + carNumber) {
               System.out.println();
               if (choiches > carNumber) {
                  int i = choiches - carNumber - 1;
                  System.out.println("Brand			: " + motor.elementAt(i).vehicleBrand);
                  System.out.println("Name			: " + motor.elementAt(i).vehicleName);
                  System.out.println("License Plate	: " + motor.elementAt(i).vehicleLicense);
                  System.out.println("Type			: " + motor.elementAt(i).vehicleModel);
                  System.out.println("Gas Capacity	: " + motor.elementAt(i).vehicleGasCap);
                  System.out.println("Top Speed		: " + motor.elementAt(i).vehicleTopSpeed);
                  System.out.println("Wheel(s)		: " + motor.elementAt(i).vehicleWheel);
                  System.out.println("Helm			: " + motor.elementAt(i).helmet);
                  motor.elementAt(i).entertainmentS();
                  System.out.print("\nHelmet price: ");
                  int priceHelmet = scan.nextInt();
                  scan.nextLine();
                  System.out.println("Price: <Motorcycle Price> + " + priceHelmet * motor.elementAt(i).helmet);
               } else {
                  int i = choiches - 1;
                  System.out.println("Brand				: " + cars.elementAt(i).vehicleBrand);
                  System.out.println("Name				: " + cars.elementAt(i).vehicleName);
                  System.out.println("License Plate		: " + cars.elementAt(i).vehicleLicense);
                  System.out.println("Type				: " + cars.elementAt(i).vehicleModel);
                  System.out.println("Gas Capacity		: " + cars.elementAt(i).vehicleGasCap);
                  System.out.println("Top Speed			: " + cars.elementAt(i).vehicleTopSpeed);
                  System.out.println("Wheel(s)			: " + cars.elementAt(i).vehicleWheel);
                  System.out.println("Entertainment System: " + cars.elementAt(i).entertainmentSystem);
                  cars.elementAt(choiches - 1).entertainmentS();
               }
               System.out.print("ENTER to continue");
               scan.nextLine();
            }
            break;
         case 3:
            System.out.println("Thank You For Using Me, Bye~");
            System.exit(0);
            break;
         default:
            break;
         }
      }
   }
   public static void main(String[] args) {
      new Main();
   }
}