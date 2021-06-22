package ru.likeservice.player.service;

import ru.likeservice.player.domain.Player;

import java.util.Optional;

public interface PlayerService {

    /**
     * Лайк игрока по его id.
     *
     * @param id ID игрока.
     */
    void like(String id);

    /**
     * Получение игрока по его id.
     *
     * @param id ID игрока.
     * @return объект игрока.
     */
    Optional<Player> findById(String id);
}
