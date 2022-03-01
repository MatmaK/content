package com.pingr.Content.core.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pingr.Content.core.Friendship;
import com.pingr.Content.core.Ping;

import java.util.Map;

@JsonSerialize
public class FriendshipDeletedEvent {

    @JsonProperty
    private String eventType;

    @JsonProperty
    private Long friendshipId;

    @JsonProperty
    private Map<String, Object> payload;

    public FriendshipDeletedEvent() {
    }

    public FriendshipDeletedEvent(String eventType, Long friendshipId, Map<String, Object> payload) {
        this.eventType = eventType;
        this.friendshipId = friendshipId;
        this.payload = payload;
    }

    // operação inversa do método estático AccountCreatedEvent.of(Account)
    public Friendship extract() {
        return new Friendship(this.getPayload());
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Long pingId) {
        this.friendshipId = friendshipId;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "FriendshipDeletedEvent{" +
                "eventType='" + eventType + '\'' +
                ", friendshipId=" + friendshipId +
                ", payload=" + payload +
                '}';
    }
}
