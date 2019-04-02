package main;
package clientapp;

import com.procourier.model.Order;
import http.GetOrderByIdClient;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final GetOrderByIdClient client = new GetOrderByIdClient();
        final GetOrderByIdClient byIdClient = new GetOrderByIdClient();
        final GetOrdersClient allClient = new GetOrdersClient();

        List<Order> orders = allClient.getOrders();
        System.out.println(orders);
    }
}
