package com.pingr.Content.core.services;

import com.pingr.Content.core.Ping;
import com.pingr.Content.core.PingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SynchronizePing {
    private final PingRepository pingRepository;

    @Autowired
    public SynchronizePing(PingRepository pingRepository) {
        this.pingRepository = pingRepository;
    }

    public void store(Ping ping) {
        this.pingRepository.save(ping);
    }

    public void remove(Ping ping) {
        this.pingRepository.deleteById(ping.getId());
    }
}
