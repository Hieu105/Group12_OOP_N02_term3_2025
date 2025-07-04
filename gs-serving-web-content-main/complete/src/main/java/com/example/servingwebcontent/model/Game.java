package com.example.servingwebcontent.model;

public class Game {
    private int width = 10;   // Chiều rộng của bàn cờ
    private int height = 10;  // Chiều cao của bàn cờ
    private int mineCount = 10;  // Số lượng mìn

    // Getter và Setter cho các thuộc tính
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }
}
