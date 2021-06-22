package ru.likeservice.like.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.likeservice.player.domain.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.likeservice.player.service.PlayerService;

/**
 * Получение и сохранение лайков для игроков.
 */
@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final PlayerService playerService;

    /**
     * Сохранение лайка для игрока по его id.
     *
     * @param playerId ID игрока.
     */
    @Transactional
    @Override
    public void like(String playerId) {
        playerService.like(playerId);
    }

    /**
     * Получение кол-ва лайков игрока по его id.
     * Если пользователя с таким id нет то возвращается 0.
     *
     * @param playerId ID игрока.
     * @return кол-во лайков у игрока.
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public long getLikes(String playerId) {
        return playerService.findById(playerId)
                .map(Player::getLikesCount)
                .orElse(0L);
    }
}
