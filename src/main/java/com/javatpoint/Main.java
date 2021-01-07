package com.javatpoint;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String args[]) {
        String link = "http://localhost:8080/dequeue/";
        String channel = "";
        String count = "";
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the type of channel you want to dequeue from: ");
        channel = sc.nextLine();
        System.out.print("Enter the number of notification you want to dequeue or Type (All) if you want to dequeue all: ");
        count = sc.nextLine();
        System.out.println();


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(link + "/" + channel + "/" + count + "/")
                .method("GET", null)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String message = response.body().string();
            List<String> messageList = new ArrayList<>();
            if (message.length() != 2) {
                messageList = messagePrep(message);
            } else {
                messageList.add("The Queue is empty!");
            }

            System.out.println("------------------------------------------------------------------");
            System.out.println(channel + " Dequeue");
            System.out.println("------------------------------------------------------------------");

            for (int i = 0; i < messageList.size(); i++) {
                if (messageList.size() == 1) {
                    System.out.println("Notification:");
                    System.out.println(messageList.get(i));
                } else {
                    System.out.println("Notification Number " + (i + 1) + " :");
                    System.out.println(messageList.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> messagePrep(String mess) {
        List<String> messageList = new ArrayList<>();
        String message = "";
        mess = mess.substring(2, mess.length());
        mess = mess.substring(0, mess.length() - 2);
        for (int i = 0; i < mess.length(); i++) {
            if (mess.charAt(i) == '\\' && mess.charAt(i + 1) == 'n') {
                message += "\n";
                i += 1;
            } else if (mess.charAt(i) == '"' && mess.charAt(i + 1) == ',' && mess.charAt(i + 2) == '"') {
                messageList.add(message);
                message = "";
                i += 2;
            } else {
                message += mess.charAt(i);
            }

            if (i + 1 == mess.length()) {
                messageList.add(message);
            }
        }
        return messageList;

    }
}
