package com.clianz.actor.system;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public abstract class BaseActor implements Runnable {

    protected final BlockingQueue inboundQueue;
    protected final BlockingQueue outboundQueue;

    public BaseActor(BlockingQueue inboundQueue, BlockingQueue outboundQueue) {
        this.inboundQueue = inboundQueue;
        this.outboundQueue = outboundQueue;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume(inboundQueue.take());
            }
        } catch (InterruptedException ex) {
            log.error("Error in Actor: ", ex);
        }
    }

    abstract void consume(Object msg);
}
