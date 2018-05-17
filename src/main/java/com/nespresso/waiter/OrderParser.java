package com.nespresso.waiter;

import java.util.Map.Entry;

interface OrderParser
{
  Entry<String, Recipe> parseOrder(final String order);
}
