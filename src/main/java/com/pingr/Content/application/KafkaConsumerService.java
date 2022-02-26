package com.pingr.Content.application;

import com.pingr.Content.core.Account;
import com.pingr.Content.core.Ping;
import com.pingr.Content.core.events.PingCreatedEvent;
import com.pingr.Content.core.events.PingDeletedEvent;
import com.pingr.Content.core.services.SynchronizeAccount;
import com.pingr.Content.core.events.AccountCreatedEvent;
import com.pingr.Content.core.events.AccountDeletedEvent;
import com.pingr.Content.core.services.SynchronizePing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private SynchronizeAccount syncAcc;

    @Autowired
    private SynchronizePing syncPing;

    @KafkaListener(
            containerFactory = "accountCreatedEventKafkaListenerContainerFactory",
            topics = "${topics.acc_created}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void handleAccountCreation(AccountCreatedEvent event) {
        Account account = event.extract();
        this.syncAcc.store(account);
    }

    @KafkaListener(
            containerFactory = "accountDeletedEventKafkaListenerContainerFactory",
            topics = "${topics.acc_deleted}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void handleAccountDeletion(AccountDeletedEvent event) {
        Account account = event.extract();
        this.syncAcc.remove(account);
    }

    //PINGS LISTENER
    @KafkaListener(
            containerFactory = "pingCreatedEventKafkaListenerContainerFactory",
            topics = "${topics.ping_created}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void handlePingCreation(PingCreatedEvent event) {
        Ping ping = event.extract();
        this.syncPing.store(ping);
    }

    @KafkaListener(
            containerFactory = "pingDeletedEventKafkaListenerContainerFactory",
            topics = "${topics.ping_deleted}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void handlePingDeletion(PingDeletedEvent event) {
        Ping ping = event.extract();
        this.syncPing.remove(ping);
    }
}
