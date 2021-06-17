package com.redhat.demo;
import java.util.UUID;

import io.vertx.core.AbstractVerticle;

public class HelloVerticle extends AbstractVerticle{
    
    String verticleId = UUID.randomUUID().toString();

    @Override
    public void start(){
        vertx.eventBus().consumer("hello.vertx.addr", msg->{
            msg.reply("hello Vert.x World");
        });
        vertx.eventBus().consumer("hello.named.addr",msg->{
            String name = (String)msg.body();//java lang obj casted to string
            msg.reply(String.format("Hello %s , from%s!",name,verticleId));
        });
    }
}
