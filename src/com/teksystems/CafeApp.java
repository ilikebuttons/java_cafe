package com.teksystems;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class CafeApp {
    public static void main(String[] args) {

        final double SALES_TAX = .07;
        DecimalFormat df = new DecimalFormat("$0.00");
        Scanner input = new Scanner(System.in);

        List<Product> products = new ArrayList<>(List.of(
                new Product("coffee", 2.00, "just regular ol' coffee"),
                new Product("espresso", 3.00, "super strong coffee"),
                new Product("cappuccino", 5.00, "coffee with a bunch of other crap")
        ));

        // calculate padding based on the longest product description
        int padDesc = 5 + products
                .stream()
                .max(comparing(p -> p.getDescription().length()))
                .get()
                .getDescription()
                .length();

        // calculate padding based on the longest name description
        int padName = 5 + products
                .stream()
                .max(comparing(p -> p.getName().length()))
                .get()
                .getName()
                .length();

        // prompt user for quantity of each product, keep track of total
        double subtotal = products
                .stream()
                .map(p -> {
                    String name = p.getName(), desc = p.getDescription();

                    System.out.print("How many " + name + "s would you like? ");
                    p.setQuantity(input.nextInt());
                    double psub = p.calculateProductTotal();

                    System.out.printf("%-" + padName + "s%-" + padDesc + "s%s\n\n", name, desc, df.format(psub));
                    return psub;
                })
                .reduce(0.0d, Double::sum);

        System.out.printf("\n%-" + padName + "s%-" + padDesc + "s%s\n", "Subtotal", "", df.format(subtotal));
        double tax = subtotal * SALES_TAX;
        System.out.printf("%-" + padName + "s%-" + padDesc + "s%s\n", "Sales Tax", "", df.format(tax));
        System.out.print("___________________________________________________________");
        System.out.printf("\n%-" + padName + "s%-" + padDesc + "s%s\n\n", "Total", "", df.format(subtotal + tax));

    }

}
        //System.out.format("The total shopping amount is = %.2f", total);
        //System.out.println(name + "( " + desc + "):\t" + df.format(psub));
        //System.out.printf("\n%s %15s", p.getName(), p.getDescription());
