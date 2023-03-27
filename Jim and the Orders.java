import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class JimAndTheOrders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int t = scanner.nextInt();
            int d = scanner.nextInt();
            orders.add(new Order(i, t + d));
        }

        List<Integer> result = serveCustomers(orders);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> serveCustomers(List<Order> orders) {
        // Sort the orders by their serving time
        Collections.sort(orders);

        List<Integer> result = new ArrayList<>();
        for (Order order : orders) {
            result.add(order.id);
        }
        return result;
    }

    static class Order implements Comparable<Order> {
        int id;
        int servingTime;

        public Order(int id, int servingTime) {
            this.id = id;
            this.servingTime = servingTime;
        }

        @Override
        public int compareTo(Order o) {
            return Integer.compare(this.servingTime, o.servingTime);
        }
    }
}
