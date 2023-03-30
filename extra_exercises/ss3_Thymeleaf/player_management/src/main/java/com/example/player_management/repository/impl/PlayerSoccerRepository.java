package com.example.player_management.repository.impl;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.repository.IPlayerSoccerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerSoccerRepository implements IPlayerSoccerRepository {

    private static List<PlayerSoccer> playerSoccerList = new ArrayList<>();
    static {
        playerSoccerList.add(new PlayerSoccer(1, "Phan Văn Tài Em", "02/02/2002", "5 năm", "Tiền Đạo", "https://media.bongda.com.vn/resize/392x522/files/huy.phandang/2018/02/03/tee-1827.jpg"));
        playerSoccerList.add(new PlayerSoccer(2, "Bùi Tiến Dũng", "02/02/2002", "5 năm", "Tiền Đạo", "https://media.bongda.com.vn/resize/392x522/files/huy.phandang/2018/02/03/tee-1827.jpg"));
        playerSoccerList.add(new PlayerSoccer(3, "Phan Văn Sơn", "02/02/2002", "5 năm", "Tiền Đạo", "https://media.bongda.com.vn/resize/392x522/files/huy.phandang/2018/02/03/tee-1827.jpg"));
        playerSoccerList.add(new PlayerSoccer(4, "Lê Công Vinh", "02/02/2002", "5 năm", "Tiền Đạo", "https://media.bongda.com.vn/resize/392x522/files/huy.phandang/2018/02/03/tee-1827.jpg"));
        playerSoccerList.add(new PlayerSoccer(5, "Phan Văn Tài Em", "02/02/2002", "5 năm", "Tiền Đạo", "https://media.bongda.com.vn/resize/392x522/files/huy.phandang/2018/02/03/tee-1827.jpg"));
    }
    @Override
    public List<PlayerSoccer> findAll() {
        return playerSoccerList;
    }

    @Override
    public PlayerSoccer findById(int id) {
        for (int i = 0; i < playerSoccerList.size(); i++) {
            if (playerSoccerList.get(i).getId() == id){
                return playerSoccerList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deletePlayer(int id) {
        playerSoccerList.remove(findById(id));
    }

    @Override
    public void createPlayer(PlayerSoccer playerSoccer) {
        playerSoccerList.add(playerSoccer);
    }

    @Override
    public void editPlayer(PlayerSoccer playerSoccer) {
        playerSoccerList.set(playerSoccer.getId(), playerSoccer);
    }
}
