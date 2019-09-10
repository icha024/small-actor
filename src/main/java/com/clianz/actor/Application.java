package com.clianz.actor;

import com.clianz.actor.system.Actor1;
import com.clianz.actor.system.Actor2;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class Application {

    public static void main(String[] argv) throws InterruptedException {
        log.info("Starting Actor system...");

        LinkedBlockingQueue<String> startingQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<String> linkingQueue = new LinkedBlockingQueue<>();

        new Actor1(startingQueue, linkingQueue);
        new Actor2(linkingQueue, null);

        startingQueue.offer("Hello!");

        while (true) {
            Thread.sleep(10_000);
        }
    }
}
