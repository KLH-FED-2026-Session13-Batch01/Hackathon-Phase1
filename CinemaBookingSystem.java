class TicketBooking {
    private String customerName;
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private double totalAmount;
    private double discount;
    private double finalAmount;
    private String bookingStatus;

    // Constructor 1: Basic booking details
    public TicketBooking(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        this.customerName = customerName != null ? customerName.toUpperCase() : "";
        this.movieName = movieName != null ? movieName.toUpperCase() : "";
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }

    // Overloaded Method 1: Book tickets with specific pricing and count
    public void bookTicket(int numberOfTickets, double ticketPrice) {
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
        processBooking();
    }

    // Overloaded Method 2: Book tickets updating movie and ticket details
    public void bookTicket(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName != null ? movieName.toUpperCase() : "";
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
        processBooking();
    }

    // Core logic for validation, discount calculation, and total amounts
    private void processBooking() {
        if (numberOfTickets > 0 && ticketPrice > 0) {
            bookingStatus = "Booking Successful";
            totalAmount = numberOfTickets * ticketPrice;

            // Apply 10% discount if 5 or more tickets are booked
            if (numberOfTickets >= 5) {
                discount = totalAmount * 0.10;
            } else {
                discount = 0.0;
            }
            finalAmount = totalAmount - discount;
        } else {
            bookingStatus = "Booking Failed: Invalid Details";
            totalAmount = 0.0;
            discount = 0.0;
            finalAmount = 0.0;
        }
    }

    // Method to display booking summary
    public void displaySummary() {
        System.out.println("========== CINEMA TICKET BOOKING ==========");
        System.out.println("Customer Name      : " + customerName);
        System.out.println("Movie Name         : " + movieName);
        if (ticketPrice > 0 && numberOfTickets > 0) {
            System.out.printf("Ticket Price       : Rs. %.2f\n", ticketPrice);
        }
        System.out.println("Number of Tickets  : " + numberOfTickets);
        System.out.println();
        System.out.println("Booking Status     : " + bookingStatus);
        System.out.printf("Total Amount       : Rs. %.2f\n", totalAmount);
        System.out.printf("Discount           : Rs. %.2f\n", discount);
        System.out.printf("Final Amount       : Rs. %.2f\n", finalAmount);
        System.out.println();
    }

    // Getter for customer name used in comparison
    public String getCustomerName() {
        return customerName;
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        // First Booking: 5 tickets (Eligible for 10% discount)
        TicketBooking booking1 = new TicketBooking("sneha", "Avatar", 200.00, 5);
        booking1.displaySummary();

        // Second Booking: 2 tickets (No discount)
        TicketBooking booking2 = new TicketBooking("arjun", "Avatar", 200.00, 2);
        booking2.displaySummary();

        // Customer Name Comparison using String manipulation
        System.out.print("Customer Verification: ");
        if (booking1.getCustomerName().equals(booking2.getCustomerName())) {
            System.out.println("Names Match");
        } else {
            System.out.println("Names Do Not Match");
        }
        System.out.println("=============================================");
    }
}