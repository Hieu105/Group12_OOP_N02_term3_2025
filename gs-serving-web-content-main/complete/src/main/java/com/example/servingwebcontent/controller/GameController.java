package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Game;
import com.example.servingwebcontent.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")  // Đường dẫn chính để người dùng truy cập vào trò chơi
    public String showGamePage(Model model) {
        Game game = new Game();  // Khởi tạo một game mới
        model.addAttribute("message", gameService.startGame(game));  // Truyền thông điệp vào model
        model.addAttribute("buttons", gameService.generateButtons(game));  // Truyền danh sách các nút vào model
        return "game";  // Trả về game.html trong thư mục templates
    }
}
