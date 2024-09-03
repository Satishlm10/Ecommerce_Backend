package com.SmProjects.dreamshops.service.order;

import com.SmProjects.dreamshops.dto.OrderDto;
import com.SmProjects.dreamshops.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
