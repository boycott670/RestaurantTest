package com.nespresso.waiter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class Restaurant
{
  private final OrderParser orderParser;
  
  private int nextTableId;
  
  private final Map<Integer, Table> tables;
  
  Restaurant()
  {
    orderParser = new DefaultOrderParser();
    
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
    final Entry<String, Recipe> parsedOrder = orderParser.parseOrder(order);
    
    tables.get(tableId).customerSays(parsedOrder.getKey(), parsedOrder.getValue());
  }
  
  String createOrder(final int tableId)
  {
    return tables.get(tableId).createOrder();
  }
}
