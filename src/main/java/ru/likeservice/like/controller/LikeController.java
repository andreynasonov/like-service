package ru.likeservice.like.controller;

import ru.likeservice.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{playerId}")
    public void like(@PathVariable("playerId") String playerId) {
        likeService.like(playerId);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Long> getLikes(@PathVariable("playerId") String playerId) {
        long likesCount = likeService.getLikes(playerId);
        return ResponseEntity.ok(likesCount);
    }
}
