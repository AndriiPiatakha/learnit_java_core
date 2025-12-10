package com.itbulls.learnit.javacore.oop.grasp.infoexpert.solution.example2;

import java.util.List;

//Pure data, no domain rules
public class OrderDto {

 private List<OrderLineDto> lines;
 private String customerId;
 private String status;

 public List<OrderLineDto> getLines() {
     return lines;
 }

 public String getCustomerId() {
     return customerId;
 }

 public String getStatus() {
     return status;
 }
}
