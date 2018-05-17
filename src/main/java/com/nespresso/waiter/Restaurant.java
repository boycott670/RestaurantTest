package com.nespresso.waiter;

import java.util.HashMap;
import java.util.Map;

final class Restaurant
{
  private int nextTableId;
  
  private final Map<Integer, Table> tables;
  
  Restaurant()
  {
    nextTableId = 1;
    tables = new HashMap<>();
  }
  
  int initTable(final int size)
  {
    tables.put(nextTableId, new Table(size));
    
    return nextTableId++;
  }
  
  void customerSays(final int tableId, final String order)
  {
    final String[] orderTokens = order.split(": ");
    
    tables.get(tableId).customerSays(orderTokens[0], orderTokens[1]);
  }
  
  String createOrder(final int tableId)
  {
    return tables.get(tableId).createOrder();
  }
}
