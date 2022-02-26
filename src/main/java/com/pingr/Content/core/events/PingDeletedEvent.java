package com.pingr.Content.core.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pingr.Content.core.Ping;

import java.util.Map;

@JsonSerialize
public class PingDeletedEvent {

    @JsonProperty
    private String eventType;

    @JsonProperty
    private Long pingId;

    @JsonProperty
    private Map<String, Object> payload;

    public PingDeletedEvent() {
    }

    public PingDeletedEvent(String eventType, Long pingId, Map<String, Object> payload) {
        this.eventType = eventType;
        this.pingId = pingId;
        this.payload = payload;
    }

    // operação inversa do método estático AccountCreatedEvent.of(Account)
    public Ping extract() {
        return new Ping(this.getPayload());
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getPingId() {
        return pingId;
    }

    public void setPingId(Long pingId) {
        this.pingId = pingId;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "PingDeletedEvent{" +
                "eventType='" + eventType + '\'' +
                ", pingId=" + pingId +
                ", payload=" + payload +
                '}';
    }
}
