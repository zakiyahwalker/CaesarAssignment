package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int rot = 0;
        do {
            System.out.print("rotation: ");
            rot = input.nextInt();
            if (rot > 25) {
                System.out.println("Too High");
            } else if (rot < 1) {
                System.out.println("Too Low");
            }
        } while (rot > 25 || rot < 1);
        System.out.println("Success");

        Scanner keys = new Scanner(System.in); //why did I have to put a new Scanner here? Diff data types?
        System.out.print("plaintext: ");
        String plnTxt = keys.nextLine();
        String message = encode(plnTxt.toLowerCase(),rot);
        System.out.println("ciphertext: " + message);

    }

    static String encode(String ciphertext, int rotation){
        String mssg = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            int ascii = ciphertext.charAt(i);
            if (ascii > 122 || ascii < 65) {
                char newLet = (char) ascii;
                mssg += newLet;
            } else {
                int rotLet = ascii + rotation;
                //this rotates lowercase letters
                if (rotLet > 122) {
                    rotLet = (rotLet - 97) % 26 +97;
                }
                char newLet = (char) rotLet;
                mssg += newLet;
                //need to create condition to rotate uppercase letters
            }

        }
        return mssg;
    }
}
