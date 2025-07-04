package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GameService {

    public String startGame(Game game) {
        // Logic khởi tạo trò chơi (chưa có mìn, bàn cờ trống)
        return "Game started with " + game.getMineCount() + " mines!";
    }

    // Phương thức tạo danh sách các nút cho bàn cờ (chẳng hạn, danh sách các số)
    public List<Integer> generateButtons(Game game) {
        // Tạo danh sách số (ví dụ: từ 1 đến 20)
        return IntStream.range(1, 21).boxed().collect(Collectors.toList());
    }
}
