package bca.Hapepedia.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.dto.OrderForm;
import bca.Hapepedia.entity.Cart;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.OrderDetail;
import bca.Hapepedia.entity.OrderStatus;
import bca.Hapepedia.entity.ProductDetail;
import bca.Hapepedia.repo.OrderDetailRepo;
import bca.Hapepedia.repo.OrderRepo;
import bca.Hapepedia.repo.OrderStatusRepo;
import bca.Hapepedia.repo.ProductDetailRepo;

@Service("orderService")
@Transactional
public class OrderService {

    @Autowired
    OrderRepo orderRepo;
    
    @Autowired
    OrderDetailRepo orderDetailRepo;
    
    @Autowired
    OrderStatusRepo orderStatusRepo;
    
    @Autowired
    private ProductDetailRepo productDetailRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public Order update(Order order) {
        return orderRepo.save(order);
    }

    public Iterable<Order> findAll() {
        return orderRepo.findAll();
    }

    public List<Order> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepo.findAll(pageable).getContent();
    }

    public Optional<Order> findById(Long id) {
        return orderRepo.findById(id);
    }

    public List<Order> findByCustomer(Customer customer) {
        return orderRepo.findByCustomer(customer);
    }

    public List<Order> findByOrderStatus(OrderStatus orderStatus) {
        return orderRepo.findByOrderStatus(orderStatus);
    }

    public boolean delete (Long id){
        orderRepo.deleteById(id);
        return true;
    }
    
    public Order checkout(Customer customer, Iterable<Cart> shoppingCart, OrderForm orderForm) {
    	
    	//total price
    	Double totalPrice = 0d;
    	Double totalWeight = 0d;
    	Double shippingFee = orderForm.getShippingFee();
    	for (Cart cart : shoppingCart) {
			totalPrice += cart.getProductDetail().getPrice() * cart.getQuantity();
			totalWeight += cart.getProductDetail().getProduct().getWeight();
		}
    	
    	Order orderTemp = new Order();
    	orderTemp.setCustomer(customer);
    	Date date = new Date();
    	orderTemp.setDateOrder(new Timestamp(date.getTime()));
    	orderTemp.setDeliveryAddress(orderForm.getDeliveryAddress());//orderform
    	orderTemp.setShippingFee(shippingFee);

    	orderTemp.setOrderStatus(orderStatusRepo.findById(1).get());
    	orderTemp.setTotalPrice(totalPrice);
    	orderTemp.setTotalWeight(totalWeight);
    	
    	Double totalPayment = totalPrice + shippingFee;
    	orderTemp.setTotalPayment(totalPayment);
    	
    	Order savedOrder = orderRepo.save(orderTemp);
    	
    	for (Cart cart : shoppingCart) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(savedOrder);
			orderDetail.setProductDetail(cart.getProductDetail());
			orderDetail.setQuantity(cart.getQuantity());
			orderDetailRepo.save(orderDetail);
			
			//DECREASE STOCK
			ProductDetail productDetail = productDetailRepo.findById(orderDetail.getProductDetail().getId()).get();
			productDetail.setStock(productDetail.getStock() - orderDetail.getQuantity());
			productDetailRepo.save(productDetail);
		}
    	
    	return savedOrder;
    }
    
}
