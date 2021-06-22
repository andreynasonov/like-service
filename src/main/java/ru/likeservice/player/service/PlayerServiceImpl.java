package ru.likeservice.player.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.likeservice.player.domain.Player;
import ru.likeservice.player.repository.PlayerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    /**
     * Лайк игрока по его id.
     *
     * @param id ID игрока.
     */
    @Transactional
    @Override
    public void like(String id) {
        Player player = playerRepository.findById(id).orElse(new Player(id));
        player.like();
        playerRepository.save(player);
    }

    /**
     * Получение игрока по его id.
     *
     * @param id ID игрока.
     * @return объект игрока.
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Optional<Player> findById(String id) {
        return playerRepository.findById(id);
    }

}
