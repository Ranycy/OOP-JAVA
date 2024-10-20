import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void viewItems() {
        System.out.println("Daftar Barang:");
        System.out.println("Kode\tNama\tHarga\tJumlah\tSub-total");
        for (Item item : items) {
            double subTotal = item.getPrice() * item.getQuantity();
            System.out.println(item.getCode() + "\t" + item.getName() + "\t" + item.getPrice() + "\t" + item.getQuantity() + "\t" + subTotal);
        }
    }

    public void displayTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        System.out.println("Total belanja: " + total);
    }

    public void processPayment(double payment) {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        if (payment >= total) {
            double change = payment - total;
            System.out.println("Total belanja: " + total);
            System.out.println("Dibayar: " + payment);
            System.out.println("Kembalian: " + change);
        } else {
            System.out.println("Uang tidak cukup.");
        }
    }
}
