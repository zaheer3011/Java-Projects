import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class InvoiceService {

    public static InvoiceService invoiceService;

    // To store the Customer List
    private Map<String, Customer> customerList = new HashMap <> ();

    // To store the Invoice List
    private Map<String, Invoice> invoiceList = new HashMap <> ();

    // To store the Item
    private List<Item> itemList = new ArrayList <> ();

    public InvoiceService() {}

    public boolean isCustomerIdExists(String id) {

       return customerList.containsKey(id);
    }

    public void addCustomer(Customer customer) {

        String newCustomerId = customer.getCustomerId();

        if(!isCustomerIdExists(newCustomerId)) {
            customerList.put(newCustomerId, customer);
            System.out.println("Customer Added Successfully.");
        }

        else {
            System.out.println("Customer Id already Exists");
        }
    }

    public void addInvoiceId(String customerId, Invoice invoice) {

        String newInvoiceId = invoice.getInvoiceId();

        if(isCustomerIdExists(customerId)) {
            invoiceList.put(newInvoiceId, invoice);
            System.out.println("InvoiceId Added Successfully.");
        }

        else {
            System.out.println("Customer Id doesn't exists");
        }
    }

    public void displayCustomers() {

        for(Customer customer : customerList.values()) {
            System.out.println("Customer Id : " + customer.getCustomerId() + " , " +
                    "Customer Name : " + customer.getCustomerName());
        }
    }

    public void displayInvoice() {

        for(Invoice invoice : invoiceList.values()) {
            System.out.println("Invoice Id : " + invoice.getInvoiceId() + " , " +
                    "Customer Id : " + invoice.getCustomerId());
        }
    }

    public void displayInvoiceOfCustomers(String customerId) {

        Invoice invoice = checkCustomerIdExistsInInvoice(customerId);

        if(invoice == null) {
            System.out.println("Invalid Customer Id ");
            return;
        }

        System.out.println("--- Invoice for Customer Id : " + customerId);
        System.out.println("Invoice id : " + invoice.getInvoiceId());
    }

    public void addItems(Item newItem) {

        itemList.add(newItem);
        System.out.println("Items Added.");
    }

    public Invoice checkCustomerIdExistsInInvoice(String customerId) {

        for(Invoice invoice : invoiceList.values()) {

            if(invoice.getCustomerId().equalsIgnoreCase(customerId))
                return invoice;
        }

        return null;
    }

    // Displaying all the details from Invoice
    public void displayInvoiceFullDetails(String invoiceId) {

        Item item = checkInvoiceIdExistsInItems(invoiceId);

        if(item == null) {
            System.out.println("Invalid Invoice Id");
            return;
        }

        String customerId = getCustomerIdFromInvoice(invoiceId);

        if(customerId.equals("")) return;

        System.out.println("Customer Id : " + customerId);
        System.out.println("Invoice Id : " + invoiceId);
        System.out.println("Item : ");
        System.out.println(item.getName() + ": " + item.getQuantity() + " x " +
                item.getPrice() + " = " + item.calculateTotalPrice());
        System.out.println("Total Price : " + item.calculateTotalPrice());
    }


    public Item checkInvoiceIdExistsInItems(String invoiceId) {

        for(Item item : itemList) {
            if(item.getInvoiceId().equalsIgnoreCase(invoiceId))
                return item;
        }

        return null;
    }

    public String getCustomerIdFromInvoice(String invoiceId){

        for(Invoice invoice : invoiceList.values()) {

            if(invoice.getInvoiceId().equalsIgnoreCase(invoiceId))
                return invoice.getCustomerId();
        }

        return "";
    }

}
