package com.pingr.Content.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Table
@Entity
public class Friendship {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long idAccountApplied;

    //Usuário que recebeu a amizade
    @Column(nullable = false)
    private Long idAccountReceived;

    public Friendship() {
    }

    public Friendship(Long id, Long idAccountApplied, Long idAccountReceived) {
        this.id = id;
        this.idAccountApplied = idAccountApplied;
        this.idAccountReceived = idAccountReceived;
    }

    public Friendship(Map<String, Object> payload) {
        this.id = Long.parseLong(payload.get("id").toString());
        this.idAccountApplied = Long.parseLong(payload.get("idAccountApplied").toString());
        this.idAccountReceived = Long.parseLong(payload.get("idAccountReceived").toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAccountApplied() {
        return idAccountApplied;
    }

    public void setIdAccountApplied(Long idAccountApplied) {
        this.idAccountApplied = idAccountApplied;
    }

    public Long getIdAccountReceived() {
        return idAccountReceived;
    }

    public void setIdAccountReceived(Long idAccountReceived) {
        this.idAccountReceived = idAccountReceived;
    }
}
