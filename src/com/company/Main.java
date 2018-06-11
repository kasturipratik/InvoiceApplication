package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int quantity =0;
        String description="", item="";
        double price ,total;

        Scanner input = new Scanner(System.in);

        ArrayList<Double> totalStore = new ArrayList<>();
        ArrayList<Double>priceStore = new ArrayList<>();
        ArrayList<String> descriptionStore = new ArrayList<>();
        ArrayList<Integer> quantityStore = new ArrayList<>();
        ArrayList<String> itemStore = new ArrayList<>();


        Invoice invoice = new Invoice();

        p("Enter the item number of the product or q to exit");
        item = input.nextLine();

        while (!item.equals("q")){

            p("Enter the Quantity of the product: ");
            quantity=input.nextInt();
            input.nextLine();
            p("Enter the Description of the product: ");
            description= input.nextLine();
            p("Enter the Price of the product: ");
            price = input.nextDouble();
            input.nextLine();
            invoice.setItem(item);
            invoice.setQuantity(quantity);
            invoice.setDescription(description);
            invoice.setPrice(price);

            totalStore.add(invoice.total());
            quantityStore.add(invoice.getQuantity());
            itemStore.add(invoice.getItem());
            priceStore.add(invoice.getPrice());
            descriptionStore.add(invoice.getDescription());

            p(":::::::::::::::::::::::::::::::::::::::::::::::::::");
            p("Enter the Next item number of the product or q to exit");
            item = input.nextLine();
        }

        p("Item  | Quantity  | Description | Price  | Total  ");
        for(int i =0; i <totalStore.size();i++){
            p(itemStore.get(i)+"    "+quantityStore.get(i)+"    "+descriptionStore.get(i)+"    "+
                    priceStore.get(i)+"    "+totalStore.get(i));
        }

        p("Taxable sub-total: " + invoice.taxableSubTotal(totalStore));
        p("Untaxable Subtotal: " + invoice.untaxable());
        p("Tax: "+ invoice.tax(totalStore));
        p("Grand Total: "+ invoice.grandTotal(totalStore));

    }
    public static void p(String s){
        System.out.println(s);
    }
}
