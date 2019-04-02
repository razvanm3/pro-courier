package main;

import com.procourier.model.OrderLine;
import com.procourier.model.Product;
import com.procourier.model.Seller;
import com.procourier.model.Address;
import com.procourier.model.Courier;
import com.procourier.model.Buyer;
import com.procourier.model.Order;
import service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Server.createWebServer("-webPort", "10500").start();
        OrderService orderService = OrderService.getInstance();

        //Order 1
        Product phone = new Product(1000L, "Huawei P30", "New Phone", 270L);
        Product laptop = new Product(1500L, "Sony Vayo", "Old laptop", 1200L);
        Address emagAddress = new Address("Bucuresti", "Bucuresti", "Soseaua Virtutii", "20A");
        Address johnAddress = new Address("Dolj", "Craiova", "Ecaterina Teodoriu", "11");
        Address proCourier = new Address("Timis", "Timisoara", "AI Cuza", "86");
        Courier courier1 = new Courier("ProCourier", proCourier, 12L, 13L);

        Buyer john = new Buyer("John", johnAddress);
        Seller emag = new Seller("Emag", emagAddress);

        OrderLine olPhone = new OrderLine(phone, 10L);
        OrderLine olLaptop = new OrderLine(laptop, 7L);

        List<OrderLine> orderLines_1 = new ArrayList<>();
        orderLines_1.add(olPhone);
        orderLines_1.add(olLaptop);
        Order order_1 = new Order(emag, john, courier1, orderLines_1);

        //Order 2
        Product pc = new Product(8000L, "iMac Pro", "High Performance Workstation", 12600L);
        Product monitor = new Product(2000L, "LG UltraFine 5K", "5K Professional Grade Monitor", 180L);
        Product phone2 = new Product(2500L, "Galaxy Note 9", "The best phone of 2018", 65L);
        Address neweggAddress = new Address("California", "San Jose", "Moorpark Ave", "21");
        Address razvanAddress = new Address("Ilfov", "Bucuresti", "Iuliu Maniu", "103");
        Address proCourier2 = new Address("Ilfov", "Bucuresti", "Rezervelor", "27");
        Courier courier2 = new Courier("proCourier", proCourier2, 15L, 18L);

        Buyer razvan = new Buyer("Razvan", razvanAddress);
        Seller newegg = new Seller("Newegg", neweggAddress);

        OrderLine olPc = new OrderLine(pc, 1L);
        OrderLine olMonitor = new OrderLine(monitor, 1L);
        OrderLine olPhone2 = new OrderLine(phone, 1L);

        List<OrderLine> orderLines_2 = new ArrayList<>();
        orderLines_2.add(olPc);
        orderLines_2.add(olMonitor);
        orderLines_2.add(olPhone2);
        Order order_2 = new Order(newegg, razvan, courier2, orderLines_2);
        //endregion

        orderService.addOrder(order_1);
        orderService.addOrder(order_2);

        System.out.println("Ok");
    }
}


