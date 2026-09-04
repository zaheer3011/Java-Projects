import java.util.Map;
import java.util.HashMap;

public class Customer {

    private String id;
    private String name;

    private InvoiceService invoiceService;

    public Customer(String id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getCustomerId() { return id; }

    public String getCustomerName() { return name; }

}
