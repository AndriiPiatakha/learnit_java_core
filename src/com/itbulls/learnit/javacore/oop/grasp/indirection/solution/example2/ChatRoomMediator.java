package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example2;

import java.util.LinkedHashMap;
import java.util.Map;

// Indirection: participants do not talk to each other directly.
// They talk to the mediator, and the mediator routes messages.

public class ChatRoomMediator implements ChatMediator {

    private final Map<String, ChatParticipant> participants = new LinkedHashMap<>();

    @Override
    public void register(ChatParticipant participant) {
        participants.put(participant.name(), participant);
    }

    @Override
    public void send(String from, String message) {
        for (ChatParticipant p : participants.values()) {
            if (!p.name().equals(from)) {
                p.receive(from, message);
            }
        }
    }
}
