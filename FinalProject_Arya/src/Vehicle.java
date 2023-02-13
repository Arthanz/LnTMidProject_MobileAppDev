//LnTMidProject_Mobile-A_Arya_Nathan_Bara_2602064222
import java.util.Scanner;
public class Vehicle { //abstract
   static Scanner scan = new Scanner(System.in);
   int vehicleTopSpeed, vehicleGasCap, vehicleWheel;
   String vehicleType, vehicleBrand, vehicleName, vehicleLicense, vehicleModel;
   public void template() {
      System.out.println("Vehicle has entertainment system");
   }
   static String brands() {
      String tempStrings = new String();
      boolean checker = false;
      while (!checker) {
         System.out.print("Input brand [>= 5]: ");
         tempStrings = scan.nextLine();
         if (tempStrings.length() >= 5) {
            checker = true;
         }
      }
      if (tempStrings.charAt(0) <= 'z' && tempStrings.charAt(0) >= 'a') {
         tempStrings = tempStrings.substring(0, 1).toUpperCase() + tempStrings.substring(1);
      }
      return tempStrings;
   }
   static String names() {
      String tempStrings = new String();
      boolean checker = false;
      while (!checker) {
         System.out.print("Input name [>= 5]: ");
         tempStrings = scan.nextLine();
         if (tempStrings.length() >= 5) {
            checker = true;
         }
      }
      if (tempStrings.charAt(0) <= 'z' && tempStrings.charAt(0) >= 'a') {
         tempStrings = tempStrings.substring(0, 1).toUpperCase() + tempStrings.substring(1);
      }
      return tempStrings;
   }
   static String License() {
      String vehicleLicenses = new String();
      boolean checker = false;
      while (!checker) {
         boolean choice = true;
         System.out.print("Input license: ");
         vehicleLicenses = scan.nextLine();
         int len = vehicleLicenses.length();
         if (!((vehicleLicenses.charAt(0) >= 'A' && vehicleLicenses.charAt(0) <= 'Z' || vehicleLicenses.charAt(0) >= 'a' && vehicleLicenses.charAt(0) <= 'z') && vehicleLicenses.charAt(1) == ' ')) {
            choice = false;
         }
         int count;
         for (count = 2; count < 7 && choice; count++) {
            if (!(vehicleLicenses.charAt(count) >= '0' && vehicleLicenses.charAt(count) <= '9') && vehicleLicenses.charAt(count) != ' ' || count > len - 1) {
               choice = false;
               break;
            } else if (vehicleLicenses.charAt(count) == ' ') {
               count++;
               break;
            } else if (count == 6) {
               choice = false;
               break;
            }
         }
         if (len - count - 1 >= 3 || len - count - 1 < 0) {
            choice = false;
         }
         for (; count < len && choice; count++) {
            if (!(vehicleLicenses.charAt(count) >= 'A' && vehicleLicenses.charAt(count) <= 'Z' || vehicleLicenses.charAt(count) >= 'a' && vehicleLicenses.charAt(count) <= 'z')) {
               choice = false;
               break;
            }
         }
         if (choice) {
            checker = true;
         }
      }
      return vehicleLicenses.toUpperCase();
   }
   static int topSpeed() {
      int vehicleMaxSpeed = 0;
      boolean checker = false;
      while (!checker) {
         System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
         vehicleMaxSpeed = scan.nextInt();
         scan.nextLine();
         if (vehicleMaxSpeed >= 100 && vehicleMaxSpeed <= 250) {
            checker = true;
         }
      }
      return vehicleMaxSpeed;
   }
   static int gasCap() {
      int cap = 0;
      boolean checker = false;
      while (!checker) {
         System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
         cap = scan.nextInt();
         scan.nextLine();
         if (cap <= 60 && cap >= 30) {
            checker = true;
         }
      }
      return cap;
   }
}
class Motorcycle extends Vehicle { //inheritance
   int helmet;
   public void template() { //override
      System.out.println(vehicleName + " is standing!");
   }
   static int wheels() {
      while (true) {
         System.out.print("Input wheel [2 <= wheel <= 3]: ");
         int wheels = scan.nextInt();
         scan.nextLine();
         if (wheels <= 3 && wheels >= 2) {
            return wheels;
         }
      }
   }
   public int Helm() {
      while (true) {
         System.out.print("Input helmet amount [>= 1]: ");
         int helm = scan.nextInt();
         scan.nextLine();
         if (helm >= 1) {
            return helm;
         }
      }
   }
   public String Model() {
      while (true) {
         boolean checker = false;
         System.out.print("Input type [Automatic | Manual]: ");
         String x = scan.nextLine();
         if (x.equalsIgnoreCase("automatic") || x.equalsIgnoreCase("manual")) {
            checker = true;
         }
         if (checker) {
            x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
            return x;
         }
      }
   }
   public int entertainmentS() {
      while (true) {
         System.out.print("Input entertainment system amount [>= 1]: ");
         int template = scan.nextInt();
         scan.nextLine();
         if (template >= 1) {
            return template;
         }
      }
   }
   public Motorcycle(String type) {
      vehicleType = type;
      vehicleBrand = brands();
      vehicleName = names();
      vehicleLicense = License();
      vehicleTopSpeed = topSpeed();
      vehicleGasCap = gasCap();
      vehicleWheel = wheels();
      vehicleModel = Model();
      helmet = Helm();
   }
}

class Car extends Vehicle { //inheritance
   int entertainmentSystem;
   public void template() { // override
      if (vehicleModel.equalsIgnoreCase("supercar")) {
         System.out.println("Boosting!");
      } else {
         System.out.println("Turning on entertainment system...");
      }
   }
   static int wheels() {
      while (true) {
         System.out.print("Input wheel [4 <= wheel <= 6]: ");
         int wheels = scan.nextInt();
         scan.nextLine();
         if (wheels >= 4 && wheels <= 6) {
            return wheels;
         }
      }
   }
   public String Model() {
      while (true) {
         boolean checker = false;
         System.out.print("Input type [SUV | Supercar | Minivan]: ");
         String temp = scan.nextLine();
         if (temp.equalsIgnoreCase("suv") || temp.equalsIgnoreCase("supercar") || temp.equalsIgnoreCase("minivan")) {
            checker = true;
         }
         if (checker) {
            if (temp.equalsIgnoreCase("SUV")) {
               temp = temp.toUpperCase();
            } else {
               temp = temp.substring(0, 1).toUpperCase() + temp.substring(1).toLowerCase();
            }
            return temp;
         }
      }
   }
   public int entertainmentS() {
      while (true) {
         System.out.print("Input entertainment system amount [>= 1]: ");
         int template = scan.nextInt();
         scan.nextLine();
         if (template >= 1) {
            return template;
         }
      }
   }
   public Car(String type) {
      vehicleType = type;
      vehicleBrand = brands();
      vehicleName = names();
      vehicleLicense = License();
      vehicleTopSpeed = topSpeed();
      vehicleGasCap = gasCap();
      vehicleWheel = wheels();
      vehicleModel = Model();
      entertainmentSystem = entertainmentS();
   }
}