package com.nespresso.waiter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestaurantTest
{
  @Test
  public void createOrder()
  {
    final Restaurant restaurant = new Restaurant();
    final int tableId = restaurant.initTable(4);
    restaurant.customerSays(tableId, "Joe: Soup");
    restaurant.customerSays(tableId, "Jim: Same");
    restaurant.customerSays(tableId, "Jack: Chips");
    restaurant.customerSays(tableId, "John: Chips");
    assertEquals("Soup, Soup, Chips, Chips", restaurant.createOrder(tableId));
  }
}
