package com.javatpoint;

import com.javatpoint.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;


public class Main {
    @Autowired
    public static QueueService q = new QueueService();

    public static void main(String args[]) {
        //q.dequeue();
    }
}
