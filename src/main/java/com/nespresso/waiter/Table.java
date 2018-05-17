package com.nespresso.waiter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

final class Table
{
  private final int size;
  private final Map<String, Recipe> orders;
  
  private String lastCustomerToSay;
  
  Table(final int size)
  {
    this.size = size;
    orders = new LinkedHashMap<>();
  }
  
  void customerSays(final String customer, final Recipe recipe)
  {
    if (Objects.equals("Same", recipe.getName()))
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
    else
    {
      final Optional<Recipe> possibleMissingRecipe = orders.values().stream().filter(recipe -> recipe.getQuantity() > 1).findFirst();
      
      if (possibleMissingRecipe.isPresent())
      {
        final long countOfOthersForPossibleMissingRecipe = orders.values().stream().filter(possibleMissingRecipe.get()::equals).count() - 1;
        
        if (possibleMissingRecipe.get().getQuantity() - 1 > countOfOthersForPossibleMissingRecipe)
        {
          return String.format("MISSING %d for %s", possibleMissingRecipe.get().getQuantity() - 1 - countOfOthersForPossibleMissingRecipe, possibleMissingRecipe.get().createOrder());
        }
      }
      
      return orders.values().stream().map(Recipe::createOrder).collect(Collectors.joining(", "));
    }
  }
}
