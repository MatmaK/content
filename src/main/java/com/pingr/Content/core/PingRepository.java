package com.pingr.Content.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingRepository extends JpaRepository<Ping, Long> {
}
