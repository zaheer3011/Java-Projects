import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int choice;

        InvoiceService invoiceService = new InvoiceService();

        do {

            System.out.println("\n--- Invoice Management System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Add an Invoice");
            System.out.println("3. Add Item to an Invoice");
            System.out.println("4. List all Customers");
            System.out.println("5. List all Invoices");
            System.out.println("6. List all invoices of a customer");
            System.out.println("7. Display the full details of an invoice");
            System.out.println("8. Exit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch(choice) {

                case 1 : {

                    sc.nextLine();
                    System.out.println("Enter Customer Id : ");
                    String customerId = sc.nextLine().toLowerCase();
                    System.out.println("Enter Customer Name : ");
                    String name = sc.nextLine();

                    Customer customer = new Customer(customerId, name);

                    invoiceService.addCustomer(customer);

                    break;
                }

                case 2 : {

                    sc.nextLine();
                    System.out.println("Enter Invoice Id : ");
                    String invoiceId = sc.nextLine().toLowerCase();
                    System.out.println("Enter Customer Id : ");
                    String customerId = sc.nextLine().toLowerCase();

                    Invoice invoice = new Invoice(invoiceId, customerId);

                    invoiceService.addInvoiceId(customerId, invoice);

                    break;
                }

                case 3 : {

                    sc.nextLine();
                    System.out.println("Enter invoice id : ");
                    String invoiceId = sc.nextLine();
                    System.out.println("Enter Item name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter Item quantity : ");
                    int quantity = sc.nextInt();
                    System.out.println("Enter Item price : ");
                    int price = sc.nextInt();

                    Item item = new Item(invoiceId, name, quantity, price);
                    invoiceService.addItems(item);

                    break;
                }

                case 4 : {

                    invoiceService.displayCustomers();

                    break;
                }

                case 5 : {

                    invoiceService.displayInvoice();

                    break;
                }

                case 6 : {

                    sc.nextLine();
                    System.out.println("Enter Customer Id : ");
                    String customerId = sc.nextLine();

                    invoiceService.displayInvoiceOfCustomers(customerId);

                    break;
                }

                case 7 : {

                    sc.nextLine();
                    System.out.println("Enter Invoice Id : ");
                    String invoiceId = sc.nextLine();

                    invoiceService.displayInvoiceFullDetails(invoiceId);

                    break;
                }

                case 8 : {

                    break;
                }

                default : {
                    System.out.println("Invalid Choice");
                }
            }

        } while (choice != 8);
    }
}