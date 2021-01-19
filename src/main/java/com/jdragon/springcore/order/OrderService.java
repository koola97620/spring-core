package com.jdragon.springcore.order;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public interface OrderService {
  Order createOrder(Long memberId, String itemName, int itemPrice);

}
