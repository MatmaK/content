package com.pingr.Content.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Table
@Entity
public class Ping {
    @Id
    private Long id;

    @Column
    private String body;

    @Column
    private Long authorId;

    public Ping() {
    }

    public Ping(Long id, String body, Long authorId) {
        this.id = id;
        this.body = body;
        this.authorId = authorId;
    }

    public Ping(Map<String, Object> payload) {
        this.id = Long.parseLong(payload.get("pingId").toString());
        this.body = payload.get("body").toString();
        this.authorId = Long.parseLong(payload.get("authorId").toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
