package com.nespresso.waiter;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

final class DefaultOrderParser implements OrderParser
{

  @Override
  public Entry<String, Recipe> parseOrder(String order)
  {
    final String[] orderTokens = order.split(": ");
    
    if (orderTokens[1].contains("for"))
    {
      final String[] recipeTokens = orderTokens[1].split(" for ");
      
      return new SimpleImmutableEntry<>(orderTokens[0], new Recipe(recipeTokens[0], Integer.parseInt(recipeTokens[1])));
    }
    
    return new SimpleImmutableEntry<>(orderTokens[0], new Recipe(orderTokens[1]));
  }

}
