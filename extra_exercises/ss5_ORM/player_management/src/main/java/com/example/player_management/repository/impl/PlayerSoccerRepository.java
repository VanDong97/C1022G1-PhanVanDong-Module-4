package com.example.player_management.repository.impl;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.repository.BaseRepository;
import com.example.player_management.repository.IPLayerSoccerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class PlayerSoccerRepository implements IPLayerSoccerRepository {
    @Override
    public List<PlayerSoccer> findAll() {
        List<PlayerSoccer> playerSoccerList = BaseRepository.entityManager.
                createQuery("select s from PlayerSoccer as s",PlayerSoccer.class).getResultList();
        return playerSoccerList;
    }

    @Override
    public PlayerSoccer findById(int id) {
        PlayerSoccer playerSoccer = BaseRepository.entityManager.find(PlayerSoccer.class,id);
        return playerSoccer;
    }

    @Override
    public void deletePlayer(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public void createPlayer(PlayerSoccer playerSoccer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(playerSoccer);
        entityTransaction.commit();
    }

    @Override
    public void editPlayer(PlayerSoccer playerSoccer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(playerSoccer);
        entityTransaction.commit();
    }
}
