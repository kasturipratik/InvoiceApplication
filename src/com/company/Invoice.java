package com.company;

import java.util.ArrayList;

public class Invoice {
/*
    private variable for invoice method
*/
    private String item;
    private int quantity;
    private String description;
    private double price;

 /*
    getter and setters for the variables
 */
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantiry) {
        this.quantity = quantiry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
/*
    calculating the total of individual item using quantity and price
*/
    public double total(){
        double total = getQuantity()*getPrice();
        return total;
    }

 /*
    calculating the taxable amount by adding all the item total
 */
    public double taxableSubTotal(ArrayList<Double> subTotal){
        double taxable = 0.0;
        for(int i =0; i <subTotal.size();i++){
            taxable += subTotal.get(i);
        }
        return taxable;
    }
  /*
   returning the untaxable amount
  */
    public double untaxable(){
        return 0;
    }

    /*
        calculating the tax of the subtotal amount
    */
    public double tax(ArrayList<Double> subTotal){
        double taxRate =6.0;
        double tax = (taxRate * taxableSubTotal(subTotal))/100;
        return tax;
    }

    /*
        calculating the grandtotal of items entered by the users
    */
    public String grandTotal(ArrayList<Double> subTotal){
        //adding subtotal and tax
        double total = tax(subTotal)+ taxableSubTotal(subTotal);
        // formating the grand total to print 2 decimal places
        String grandTotal = String.format("%.02f",total);
        return grandTotal;
    }
}
