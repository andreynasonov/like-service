package ru.likeservice.player.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class Player implements Serializable {

    @Id
    private String id;

    private long likesCount;

    public Player(String id) {
        this.id = id;
    }

    public void like() {
        likesCount++;
    }
}
