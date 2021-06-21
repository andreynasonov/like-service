package ru.likeservice.player.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.likeservice.player.domain.Player;
import ru.likeservice.player.repository.PlayerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerServiceImplTest {

    private final String PLAYER_ID = "123456789";

    @Autowired
    private PlayerServiceImpl playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void whenLikePlayerThenThisPlayerLikesCountIncrement() {
        {
            Long likes = playerService.findById(PLAYER_ID).map(Player::getLikesCount).orElse(0L);
            assertEquals(0, likes);
        }

        playerService.like(PLAYER_ID);

        {
            Long likes = playerService.findById(PLAYER_ID).map(Player::getLikesCount).orElse(0L);
            assertEquals(1, likes);
        }

        playerService.like(PLAYER_ID);

        {
            Long likes = playerService.findById(PLAYER_ID).map(Player::getLikesCount).orElse(0L);
            assertEquals(2, likes);
        }

        playerService.like(PLAYER_ID);
        playerService.like(PLAYER_ID);
        playerService.like(PLAYER_ID);

        {
            Long likes = playerService.findById(PLAYER_ID).map(Player::getLikesCount).orElse(0L);
            assertEquals(5, likes);
        }
    }

    @Test
    public void whenPlayerHasNoLikesThenReturnZero() {
        Player savedPlayer = playerRepository.save(new Player(PLAYER_ID));
        long zeroLikes = savedPlayer.getLikesCount();
        assertEquals(0, zeroLikes);

        Long likes = playerService.findById(savedPlayer.getId()).map(Player::getLikesCount).orElse(0L);
        assertEquals(0, likes);
    }

    @Test
    public void whenPlayerNotExistThenReturnZeroLikes() {
        Long likes = playerService.findById(PLAYER_ID).map(Player::getLikesCount).orElse(0L);
        assertEquals(0, likes);
    }
}