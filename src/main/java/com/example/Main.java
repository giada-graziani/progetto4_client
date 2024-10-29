package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client avviato...");
        Socket s= new Socket("localhost", 3000);
        Scanner scanner = new Scanner(System.in);

        BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String messaggio;
        String numero;
        String tentativiS;
        
        String scelta;
            do{
                System.out.println("voi fare una partita? si o no");
                scelta=scanner.nextLine();
                out.writeBytes(scelta+ "\n");

                messaggio=in.readLine();
                if(messaggio.equals("n")){
                    System.out.println("finito");
                }
                else{

                    System.out.println("CONTINUIAMO CAMPIONE");

                    do{
                        System.out.println("indovina il numero ");
                        numero = scanner.nextLine();
            
                        out.writeBytes(numero +"\n");
                        messaggio= in.readLine();
                        if(messaggio.equals("e")){
                            System.out.println("hai inserito un numero fuori dal range");
                        }
                        else if(messaggio.equals("=")){
                            tentativiS=in.readLine();
                            System.out.println("HAI INDOVINATO CAMPIONE E CI HAI MESSO: "+tentativiS+" TENTATIVI");
                        }
                        else if(messaggio.equals("<")){
                            System.out.println("numero troppo piccolo");
                        }
                        else if(messaggio.equals(">")){
                            System.out.println("numero tropppo grande");
                        }
            
                    }while(!messaggio.equals("=")); 
                }
            }while(!messaggio.equals("n"));
    }
}