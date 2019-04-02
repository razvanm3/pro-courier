package com.procourier.app;

import com.procourier.handlers.GetOrderByIdHandler;
import com.procourier.handlers.GetOrdersHandler;
import com.procourier.model.Address;
import com.procourier.model.Buyer;
import com.procourier.model.Courier;
import com.procourier.model.Order;
import com.procourier.model.OrderLine;
import com.procourier.model.Product;
import com.procourier.model.Seller;
import com.procourier.repository.CollectionRepository;
import main.MainApp;
import service.OrderService;
import spark.Spark;

import java.util.List;

public final class OrderServiceMain {

    public static void main(String[] args) throws Exception {
        MainApp.main(new String[]{});
        final var repository = new CollectionRepository();
        final var handler = new OrdersHandler(repository);
        final var getOrderByIdHandler = new GetOrderByIdHandler(OrderService.getInstance());
        final var getOrdersHandler = new GetOrdersHandler(OrderService.getInstance());

        final Address address = new Address("DJ", "Craiova", "Nicolae Titulescu");
        final Seller seller = new Seller("Evomag", address);

        final Address cosminAddress = new Address("DJ", "Craiova", "Ileana Cosanzeana");
        final Buyer buyer = new Buyer("Cosmin", cosminAddress);

        final Address courierAddress = new Address("OT", "Slatina", "Cantemir");
        final Courier courier = new Courier("ExpressFan", courierAddress,
                5L, 7L);


        final List<OrderLine> products = List.of(new OrderLine(new Product(20L, "Jeans", "Men Jeans", 22L), 4L));

        final Order order = new Order(seller, buyer, courier, products);
        order.setId(6L);
        repository.put(order);

        Spark.port(8082);
        Spark.threadPool(26, 10, 2000);
        //Spark.get("/orders/:id", handler);

        Spark.get("/orders/:id", getOrderByIdHandler);
        Spark.get("/orders", getOrdersHandler);



    }
}
