package ru.hse.jade.sample.behaviour;

import com.fasterxml.jackson.core.JsonProcessingException;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ru.hse.jade.sample.model.Person;
import ru.hse.jade.sample.util.ACLMessageUtil;

public class ReceiveMessageBehaviour extends Behaviour {
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null) {
            try {
                System.out.println("Received: " + ACLMessageUtil.getContent(msg, Person.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
