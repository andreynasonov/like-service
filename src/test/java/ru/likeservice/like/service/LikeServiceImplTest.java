package ru.likeservice.like.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.likeservice.player.service.PlayerService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LikeServiceImplTest {

    private final String PLAYER_ID = "123456789";

    @Autowired
    private LikeServiceImpl likeService;

    @Test
    public void whenLikePlayerThenLikesCountIncrementForThisPlayer() {
        {
            likeService.like(PLAYER_ID);
            long likes = likeService.getLikes(PLAYER_ID);
            assertEquals(1, likes);
        }
        {
            likeService.like(PLAYER_ID);
            long likes = likeService.getLikes(PLAYER_ID);
            assertEquals(2, likes);
        }
        {
            likeService.like(PLAYER_ID);
            long likes = likeService.getLikes(PLAYER_ID);
            assertEquals(3, likes);
        }
    }

    @Test
    public void whenLikePlayerOneHundredTimesThenReturnOneHundredLikes() {
        {
            for (int i = 0; i < 100; i++) {
                likeService.like(PLAYER_ID);
            }
            long likes = likeService.getLikes(PLAYER_ID);
            assertEquals(100, likes);
        }
    }

    @Test
    public void whenPlayerNotExistThenReturnZeroLikes() {
        long likes = likeService.getLikes(PLAYER_ID);
        assertEquals(0, likes);
    }
}