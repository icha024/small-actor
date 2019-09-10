package com.clianz.actor.system;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class Actor1 extends BaseActor {

    public Actor1(BlockingQueue inboundQueue, BlockingQueue outboundQueue) {
        super(inboundQueue, outboundQueue);
    }

    @Override
    void consume(Object msg) {
        log.info("Actor1 Received: {}", msg);
        this.outboundQueue.offer(msg + " + with extras");
    }
}
