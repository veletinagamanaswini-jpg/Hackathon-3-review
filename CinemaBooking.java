
class CinemaBooking {

    String movieName;
    double ticketPrice;
    int numberOfTickets;
    String customerName;

    // 1. Default constructor
    CinemaBooking() {
        movieName = "Unknown";
        ticketPrice = 0.0;
        numberOfTickets = 0;
        customerName = "Guest";
    }

    // 2. Parameterized constructor
    CinemaBooking(String movieName, double ticketPrice,
                  int numberOfTickets, String customerName) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        this.customerName = customerName;
    }

    // 3. Overloaded constructor
    CinemaBooking(String movieName, String customerName) {
        this.movieName = movieName;
        this.customerName = customerName;
        this.ticketPrice = 200.0;
        this.numberOfTickets = 1;
    }

    // 4. Booking method without arguments
    void bookTickets() {
        bookTickets(numberOfTickets);
    }

    // 5. Overloaded method with number of tickets
    void bookTickets(int tickets) {
        if (tickets <= 0) {
            System.out.println("Invalid number of tickets!");
            return;
        }

        numberOfTickets = tickets;
        displayBooking();
    }

    // 6. Overloaded method with tickets and customer name
    void bookTickets(int tickets, String customer) {
        if (customer == null || customer.trim().isEmpty()) {
            System.out.println("Invalid customer name!");
            return;
        }

        customerName = customer.trim();
        bookTickets(tickets);
    }

    // 7. Display booking summary
    void displayBooking() {
        String upperMovieName = movieName.toUpperCase();
        String upperCustomerName = customerName.toUpperCase();

        double totalAmount = ticketPrice * numberOfTickets;
        double discount = 0.0;

        // Apply 10% discount for five or more tickets
        if (numberOfTickets >= 5) {
            discount = totalAmount * 0.10;
        }

        double finalAmount = totalAmount - discount;

        System.out.println("========== CINEMA TICKET BOOKING ==========");
        System.out.printf("%-17s: %s%n",
                "Customer Name", upperCustomerName);
        System.out.printf("%-17s: %s%n",
                "Movie Name", upperMovieName);
        System.out.printf("%-17s: Rs. %.2f%n",
                "Ticket Price", ticketPrice);
        System.out.printf("%-17s: %d%n",
                "Number of Tickets", numberOfTickets);
        System.out.printf("%-17s: %s%n",
                "Booking Status", "Booking Successful");
        System.out.printf("%-17s: Rs. %.2f%n",
                "Total Amount", totalAmount);
        System.out.printf("%-17s: Rs. %.2f%n",
                "Discount", discount);
        System.out.printf("%-17s: Rs. %.2f%n",
                "Final Amount", finalAmount);
    }

    // 8. Compare customer names
    static void compareCustomers(String name1, String name2) {
        if (name1 != null && name2 != null
                && name1.trim().equalsIgnoreCase(name2.trim())) {
            System.out.println(
                    "Both bookings belong to the same customer.");
        } else {
            System.out.println(
                    "Bookings belong to different customers.");
        }
    }

    // 9. Main method
    public static void main(String[] args) {

        // Booking 1: Using the parameterized constructor
        CinemaBooking booking1 = new CinemaBooking(
                "Avatar", 200.00, 5, "Sneha");

        booking1.bookTickets();

        System.out.println();

        // Booking 2: Using the overloaded constructor
        CinemaBooking booking2 = new CinemaBooking(
                "Inception", "Rahul");

        booking2.bookTickets(3, "Rahul");

        System.out.println();

        // Booking 3: Using the default constructor
        CinemaBooking booking3 = new CinemaBooking();

        booking3.movieName = "Interstellar";
        booking3.ticketPrice = 250.00;
        booking3.customerName = "Priya";

        booking3.bookTickets(6);

        System.out.println();

        // Compare customer names
        compareCustomers("Sneha", "SNEHA");
        compareCustomers("Rahul", "Priya");
    }
}
