package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example1;

//Pure Fabrication: persistence does not belong to Order entity
public class OrderRepository {

 public void save(Order order) {
     System.out.println("DB: INSERT INTO orders ... id=" + order.getId()
             + " total=" + order.totalAmount());
 }
}
