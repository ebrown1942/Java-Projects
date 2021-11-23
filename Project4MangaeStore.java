package project.pkg4.mangae.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project4MangaeStore {

    public static void main(String[] args) {
        System.out.println("Hey do you want to manage, Shop, or Exit the Store?");
        Scanner sc = new Scanner(System.in);
        String Option = " ";

        String item;
        double price;
        int quantity;
        try {
            while (!Option.equalsIgnoreCase("Exit")) {
                Option = sc.nextLine();
                if (Option.equalsIgnoreCase("Manage")) {
                    String AddOrRemove;
                    System.out.println("Manage or Remove Item ");
                    AddOrRemove = sc.nextLine();

                    //Add
                    if (AddOrRemove.equalsIgnoreCase("Manage")) {
                        System.out.println(" Choose your item?");

                        item = sc.nextLine();
                        File YourStore = new File(item + ".txt");
                        if (!YourStore.exists()) {
                            System.out.println("Whats the price?");

                            price = Double.parseDouble(sc.nextLine());

                            System.out.println("Whats the quantity?");

                            quantity = Integer.parseInt(sc.nextLine());

                            PrintWriter ReadAndWriteFile = new PrintWriter(YourStore);
                            ReadAndWriteFile.println(price);
                            ReadAndWriteFile.println(quantity);
                            ReadAndWriteFile.close();
                            System.out.println("Hey do you want to manage, Shop, or Exit the Store?");
                            Option = sc.nextLine();

                        } else {
                            System.out.println("Read File");
                            Scanner ReadFile = new Scanner(YourStore);
                            price = Double.parseDouble(ReadFile.nextLine());
                            quantity = Integer.parseInt(ReadFile.nextLine());

                            System.out.println("Current Price and quantity " + price + " " + quantity);

                        }

                    } //Remove
                    else if (AddOrRemove.equalsIgnoreCase("Remove")) {
                        System.out.println("Which item would you like to remove?");

                        String RemovedItem = sc.nextLine() + ".txt";

                        File MyFile = new File(RemovedItem);

                        if (MyFile.delete()) {
                            System.out.println("Removing " + RemovedItem);
                            System.out.println("Hey do you want to manage, Shop, or Exit the Store?");
                            Option = sc.nextLine();
                        } else {
                            System.out.println("Error");
                        }

                    }

                }//Shop
                else if (Option.equalsIgnoreCase("Shop")) {

                    System.out.println("Which item would you like to purchase?");

                    String PurchasedItem = sc.next();

                    String FileName = PurchasedItem.trim() + ".txt";
                   
                    File YourStore = new File(FileName);

                    if ((new File(FileName)).exists()) {
                        Scanner ReadFile = new Scanner(YourStore);
                        System.out.println("This is the price");
                        price = Double.parseDouble(ReadFile.nextLine());
                        quantity = Integer.parseInt(ReadFile.nextLine());

                        System.out.println("The price is " + price);
                        System.out.println("We have" + quantity + " in stock");

                        System.out.println("How many would you like to buy?");
                        int PurchaseQuantity = sc.nextInt();

                        if (PurchaseQuantity > quantity) {
                            System.out.println("We dom't have that many in stock");
                        } else {
                            System.out.println("Please enter your payment details");
                            double PaymentDetails = sc.nextDouble();

                            if (PaymentDetails > 1) {

                                System.out.println("Thanks for purchasing from our store, Please come again!");

                                int NewQuality = quantity - PurchaseQuantity ;
                                System.out.print(NewQuality);
                            }
                        }

                    } else {

                        System.out.println("Item is not avaible");
                        System.out.println("Please select another item");
                        PurchasedItem = sc.nextLine();

                    }

                } 

            } //end of while loop
                    System.out.println("Thanks for visiting!");
               
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
                   
                

}
