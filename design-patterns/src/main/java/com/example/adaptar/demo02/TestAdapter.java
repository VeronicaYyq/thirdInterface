package com.example.adaptar.demo02;

public class TestAdapter {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        GBSocketInterface gbSocket = new GBSocket();
        DBSocketInterface socketAdapter = new SocketAdapter(gbSocket);
        hotel.setSocket(socketAdapter);
        hotel.charge();

    }
}