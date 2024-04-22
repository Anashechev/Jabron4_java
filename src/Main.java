
import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    String name;
    String email;
    String phoneNumber;
    String[] product;
    int quantity;

    public Customer(String name, String email, String phoneNumber, String[] product, int quantity) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.product = product;
        this.quantity = quantity;
    }
}

public class Main {
    static String[] firms = {"Rolex", "Omega", "Dota2", "Rust", "Cs2"};
    static String[][] firmsBrands = {{"Rolex", "Submariner"}, {"Omega", "Speedmaster"}, {"Dota2", "Valve"}, {"Rust", "Facepunch"}, {"Cs2", "Valve"}};

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            createOrder(customers);
        }
        for (Customer customer : customers) {
            printCustomer(customer);
        }
    }

    private static void createOrder(ArrayList<Customer> customers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Введите вашу почту:");
        String email = scanner.nextLine();
        System.out.println("Введите ваш номер телефона:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Выберите продукт:");
        for (int i = 0; i < firms.length; i++) {
            System.out.println((i + 1) + ". " + firms[i]);
        }
        int productIndex = scanner.nextInt() - 1;
        System.out.println("Выберите бренд:");
        for (String[] firmBrand : firmsBrands) {
            System.out.println((firmsBrands[productIndex][0].equals(firmBrand[0])) ? (firmBrand[1] + ", ") : "");
        }
        String brand = scanner.next();
        System.out.println("Введите кол-во:");
        int quantity = scanner.nextInt();
        Customer customer = new Customer(name, email, phoneNumber, new String[]{firms[productIndex], brand}, quantity);
        customers.add(customer);
    }

    private static void printCustomer(Customer customer) {
        System.out.println("Покупатель: " + customer.name);
        System.out.println("Имейл: " + customer.email);
        System.out.println("Номер телефона: " + customer.phoneNumber);
        System.out.println("Продукт: " + customer.product[0] + " " + customer.product[1]);
        System.out.println("Кол-во: " + customer.quantity);
    }
}