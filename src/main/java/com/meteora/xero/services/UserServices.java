package com.meteora.xero.services;

import com.meteora.xero.api.model.*;
import com.meteora.xero.api.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public UserServices(UserRepository userRepository, AddressRepository addressRepository, CartItemRepository cartItemRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.cartItemRepository = cartItemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Optional<User> getUser(Long id){
        return this.userRepository.findById(id);
    }

    public User addUser(User user){
        return this.userRepository.save(user);
    }

    public Address addAddress(Address address){
        return this.addressRepository.save(address);
    }
    public List<Address> getAddresses(Long id){return this.addressRepository.findAddressesByUserId(id);}
    public List<CartItem> getUserCart(Long id){
        return this.cartItemRepository.getUserCart(id);
    }
    public CartItem addToCart(CartItem item){
        return this.cartItemRepository.save(item);
    }
    public List<Order> getOrderHistory(Long id){return this.orderRepository.findOrderByUserId(id);}

    @Transactional
    public Order placeOrder(Long userId,Long addressId){
        List<CartItem> items = cartItemRepository.getUserCart(userId);
        if (items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Order.OrderStatus.PENDING);
        order.setUser(userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found")));
        order.setAddress(addressRepository.findById(addressId).orElseThrow(() -> new EntityNotFoundException("Address not found")));
        Double totalPrice = items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
        order.setTotalAmount(totalPrice);
        order = orderRepository.save(order);
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem item : items){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItems.add(orderItem);
        }
        orderItemRepository.saveAll(orderItems);
        cartItemRepository.deleteAll(items);
        return order;
    }
}
