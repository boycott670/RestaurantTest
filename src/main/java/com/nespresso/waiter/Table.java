package com.nespresso.waiter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

final class Table
{
  private final int size;
  private final Map<String, String> orders;
  
  private String lastCustomerToSay;
  
  Table(final int size)
  {
    this.size = size;
    orders = new LinkedHashMap<>();
  }
  
  void customerSays(final String customer, final String recipe)
  {
    if (Objects.equals("Same", recipe))
    {
      orders.put(customer, orders.get(lastCustomerToSay));
    }
    else
    {
      orders.put(customer, recipe);
    }
    
    lastCustomerToSay = customer;
  }
  
  String createOrder()
  {
    if (size > orders.size())
    {
      return String.format("MISSING %d", size - orders.size());
    }
    
    return orders.values().stream().collect(Collectors.joining(", "));
  }
}
