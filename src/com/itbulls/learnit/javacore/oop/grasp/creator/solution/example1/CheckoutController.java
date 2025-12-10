package com.itbulls.learnit.javacore.oop.grasp.creator.solution.example1;

//Solution:
//Controller delegates creation to the domain expert (ShoppingCart).

public class CheckoutController {

 public Order checkout(ShoppingCart cart) {
     // Cart is the Creator of Order now.
     return cart.createOrder();
 }
}
