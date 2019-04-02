package dao;

import com.procourier.model.Order;
import com.procourier.model.Product;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class OrderDao {
    private EntityManager em;

    public OrderDao(EntityManager em) {
        this.em = em;
    }

    public void addOrder(Order order) {
        em.persist(order);
    }

    public Order getOrderById(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> getOrders() {
        String sql = "SELECT o FROM Order o";
        TypedQuery<Order> query = em.createQuery(sql, Order.class);
        return query.getResultList();
    }

}
