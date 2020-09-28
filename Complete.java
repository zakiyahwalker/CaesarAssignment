package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.print("plaintext: ");
        String plnTxt = input.nextLine();
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
