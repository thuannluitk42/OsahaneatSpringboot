package com.thuannluit.osahaneat.service;

import com.thuannluit.osahaneat.entity.*;
import com.thuannluit.osahaneat.entity.keys.KeyOrdersItem;
import com.thuannluit.osahaneat.payload.request.OrderRequest;
import com.thuannluit.osahaneat.repository.OrderItemRepository;
import com.thuannluit.osahaneat.repository.OrderRepository;
import com.thuannluit.osahaneat.service.imp.OrderServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public boolean insertOrder(OrderRequest orderRequest) {

        try {
            Users users = new Users();
            users.setId(orderRequest.getUserId());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getRestId());

            Orders orders = new Orders();
            orders.setUsers(users);
            orders.setRestaurant(restaurant);

            orderRepository.save(orders);

            List<OrderItem> items = new ArrayList<>();

            for(int idFood:orderRequest.getFoodIds()){
                Food food = new Food();
                food.setId(idFood);

                OrderItem orderItem = new OrderItem();
                KeyOrdersItem keyOrdersItem = new KeyOrdersItem(orders.getId(),idFood);
                orderItem.setKeys(keyOrdersItem);

                items.add(orderItem);
            }

            orderItemRepository.saveAll(items);

            return true;
        } catch (Exception exception){
            System.out.println("Error insert order: "+exception.getMessage());
            return false;
        }

    }
}
