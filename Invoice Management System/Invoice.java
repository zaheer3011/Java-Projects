public class Invoice {

    private String invoiceId;
    private String customerId;

    public Invoice(String invoiceId, String customerId) {

        this.invoiceId = invoiceId;
        this.customerId = customerId;

    }

    public String getInvoiceId() { return invoiceId; }

    public String getCustomerId() { return customerId; }
}
