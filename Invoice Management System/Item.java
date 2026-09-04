public class Item {

    public String id;
    public int quantity;

    private String name;

    public double price;

    public Item(String invoiceId, String name, int quantity, double price) {

        id = invoiceId;

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Calculating total Item price
    public double calculateTotalPrice() {
        return price * quantity;
    }

    public String getInvoiceId() { return id; }

    public String getName() { return name; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }
}
