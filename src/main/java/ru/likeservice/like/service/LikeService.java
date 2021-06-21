package ru.likeservice.like.service;

public interface LikeService {

    /**
     * Сохранение лайка для игрока по его id.
     *
     * @param playerId ID игрока.
     */
    void like(String playerId);

    /**
     * Получение кол-ва лайков игрока по его id.
     * Если пользователя с таким id нет то возвращается 0.
     *
     * @param playerId ID игрока.
     * @return кол-во лайков у игрока.
     */
    long getLikes(String playerId);
}
