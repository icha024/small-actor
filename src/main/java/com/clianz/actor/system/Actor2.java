package com.clianz.actor.system;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class Actor2 extends BaseActor {

    public Actor2(BlockingQueue inboundQueue, BlockingQueue outboundQueue) {
        super(inboundQueue, outboundQueue);
    }

    @Override
    void consume(Object msg) {
        log.info("Actor2 Received: {}", msg);
    }
}
