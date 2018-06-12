package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// variable declaration
        int quantity =0;
        String description="", item="";
        double price ,total;

        Scanner input = new Scanner(System.in);
/*
    array list for storing the user inputs
*/
        ArrayList<Double> totalStore = new ArrayList<>();
        ArrayList<Double>priceStore = new ArrayList<>();
        ArrayList<String> descriptionStore = new ArrayList<>();
        ArrayList<Integer> quantityStore = new ArrayList<>();
        ArrayList<String> itemStore = new ArrayList<>();

// instantiate  invoice class
        Invoice invoice = new Invoice();

        p("Enter the item number of the product or q to exit");
        item = input.nextLine();

        while (!item.equals("q")){
/*
    user input
*/
            p("Enter the Quantity of the product: ");
            quantity=input.nextInt();
            input.nextLine();

            p("Enter the Description of the product: ");
            description= input.nextLine();

            p("Enter the Price of the product: ");
            price = input.nextDouble();
            input.nextLine();
/*
    setting the data to the variable of the invoice method
*/
            invoice.setItem(item);
            invoice.setQuantity(quantity);
            invoice.setDescription(description);
            invoice.setPrice(price);
/*
    Adding the data to the array list
*/
            totalStore.add(invoice.total());
            quantityStore.add(invoice.getQuantity());
            itemStore.add(invoice.getItem());
            priceStore.add(invoice.getPrice());
            descriptionStore.add(invoice.getDescription());

            p(":::::::::::::::::::::::::::::::::::::::::::::::::::");
            p("Enter the Next item number of the product or q to exit");
            item = input.nextLine();
        }
/*
    printing the stored data from the array list
*/
        p("Item  | Quantity  | Description | Price  | Total  ");
        for(int i =0; i <totalStore.size();i++){
            p(itemStore.get(i)+"    "+quantityStore.get(i)+"    "+descriptionStore.get(i)+"    "+
                    priceStore.get(i)+"    "+totalStore.get(i));
        }

        /*
            printing the calculations done using methods
        */
        //formating the double into 2 decimal places ** String.format("any string  %.2f", value); **
        p(String.format("Taxable sub-total: %.2f" ,invoice.taxableSubTotal(totalStore)));
        p("Untaxable Subtotal: " + invoice.untaxable());
        p(String.format("Tax: %.2f", invoice.tax(totalStore)));
        p("Grand Total: "+ invoice.grandTotal(totalStore));

    }
    /*
        printing statement for easier use
    */
    public static void p(String s){
        System.out.println(s);
    }
}
