package com.nespresso.waiter;

final class Recipe
{
  private final String name;
  private final int quantity;
  
  Recipe(String name)
  {
    this(name, 1);
  }

  Recipe(String name, int quantity)
  {
    this.name = name;
    this.quantity = quantity;
  }

  String getName()
  {
    return name;
  }

  int getQuantity()
  {
    return quantity;
  }
  
  String createOrder()
  {
    return String.format("%s%s", name, quantity > 1 ? String.format(" for %d", quantity) : "");
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + quantity;
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Recipe other = (Recipe) obj;
    if (name == null)
    {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (quantity != other.quantity)
      return false;
    return true;
  }
}
