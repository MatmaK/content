package com.pingr.Content.core.services;

import com.pingr.Content.core.Friendship;
import com.pingr.Content.core.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SynchronizeFriendship {
    private final FriendshipRepository friendshipRepository;

    @Autowired
    public SynchronizeFriendship(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public void store(Friendship friendship) {
        this.friendshipRepository.save(friendship);
    }

    public void remove(Friendship friendship) {
        this.friendshipRepository.deleteById(friendship.getId());
    }
}
