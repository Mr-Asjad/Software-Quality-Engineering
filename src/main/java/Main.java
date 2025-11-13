//
//import model.Flight;
//import model.Passenger;
//import model.Payment;
//import model.Reservation;
//import service.FlightSearchEngine;
//import service.PaymentProcessor;
//import service.ReservationManager;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//   private static FlightSearchEngine searchEngine = new FlightSearchEngine();
//   private static ReservationManager reservationManager = new ReservationManager();
//   private static PaymentProcessor paymentProcessor = new PaymentProcessor();
//
//   public static void main(String[] args) {
//       Scanner scanner = new Scanner(System.in);
//
//       // Sample Data
//       initializeSampleData();
//
//       while (true) {
//           displayMenu();
//           String choice = scanner.nextLine();
//
//           switch (choice) {
//               case "1":
//                   searchFlights(scanner);
//                   break;
//               case "2":
//                   makeReservation(scanner);
//                   break;
//               case "3":
//                   processPayment(scanner);
//                   break;
//               case "4":
//                   System.out.println("Exiting system...");
//                   scanner.close();
//                   return;
//               default:
//                   System.out.println("Invalid choice. Please try again.");
//           }
//       }
//   }
//
//   private static void displayMenu() {
//       System.out.println("\n=== Flight Reservation System ===");
//       System.out.println("1. Search Flights");
//       System.out.println("2. Make Reservation");
//       System.out.println("3. Process Payment");
//       System.out.println("4. Exit");
//       System.out.print("Enter your choice: ");
//   }
//
//   private static void initializeSampleData() {
//       LocalDateTime travelDate = LocalDateTime.of(2025, 10, 15, 10, 0);
//       Flight flight1 = new Flight("FL001", "Karachi", "Lahore", travelDate, travelDate.plusHours(2), 100, 5000, "PIA");
//       Flight flight2 = new Flight("FL002", "Lahore", "Islamabad", travelDate.plusHours(3), travelDate.plusHours(4), 150, 3500, "AirBlue");
//
//       searchEngine.addFlight(flight1);
//       searchEngine.addFlight(flight2);
//   }
//
//   private static void searchFlights(Scanner scanner) {
//       System.out.print("Enter source city: ");
//       String source = scanner.nextLine();
//       System.out.print("Enter destination city: ");
//       String destination = scanner.nextLine();
//       System.out.print("Enter travel date (yyyy-MM-dd HH:mm): ");
//       String dateInput = scanner.nextLine();
//
//       LocalDateTime travelDate;
//       try {
//           travelDate = LocalDateTime.parse(dateInput.replace(" ", "T"));
//       } catch (Exception e) {
//           System.out.println("Invalid date format.");
//           return;
//       }
//
//       List<Flight> flights = searchEngine.searchFlights(source, destination, travelDate);
//       if (flights.isEmpty()) {
//           System.out.println("No flights available.");
//       } else {
//           System.out.println("Available Flights:");
//           flights.forEach(flight -> System.out.println(flight));
//       }
//   }
//
//   private static void makeReservation(Scanner scanner) {
//       System.out.print("Enter flight ID to reserve: ");
//       String flightId = scanner.nextLine();
//       Flight flight = searchEngine.findFlightById(flightId);
//
//       if (flight == null) {
//           System.out.println("Flight not found.");
//           return;
//       }
//
//       Reservation reservation = reservationManager.createReservation(flight);
//       System.out.print("Enter passenger ID: ");
//       String passengerId = scanner.nextLine();
//       System.out.print("Enter passenger name: ");
//       String name = scanner.nextLine();
//       System.out.print("Enter passenger email: ");
//       String email = scanner.nextLine();
//       System.out.print("Enter passenger phone: ");
//       String phone = scanner.nextLine();
//
//       Passenger passenger = new Passenger(passengerId, name, "", email, phone, 30); // Assuming age is 30 for simplicity
//       reservationManager.addPassengerToReservation(reservation, passenger);
//       System.out.println("Reservation created: " + reservation.getReservationId());
//   }
//
//   private static void processPayment(Scanner scanner) {
//       System.out.print("Enter reservation ID for payment: ");
//       String reservationId = scanner.nextLine();
//       System.out.print("Enter amount: ");
//       double amount;
//
//       try {
//           amount = Double.parseDouble(scanner.nextLine());
//       } catch (NumberFormatException e) {
//           System.out.println("Invalid amount entered.");
//           return;
//       }
//
//       System.out.print("Enter card number: ");
//       String cardNumber = scanner.nextLine();
//       System.out.print("Enter CVV: ");
//       String cvv = scanner.nextLine();
//       System.out.print("Enter expiry date (MM/yy): ");
//       String expiryDate = scanner.nextLine();
//
//       try {
//           Payment payment = paymentProcessor.processPayment(reservationId, amount, cardNumber, cvv, expiryDate);
//           System.out.println("Payment processed successfully. Payment ID: " + payment.getPaymentId());
//       } catch (IllegalArgumentException e) {
//           System.out.println("Payment error: " + e.getMessage());
//       } catch (Exception e) {
//           System.out.println("An error occurred while processing payment: " + e.getMessage());
//       }
//   }
//}
