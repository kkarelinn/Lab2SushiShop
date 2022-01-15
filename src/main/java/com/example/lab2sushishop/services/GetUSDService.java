package com.example.lab2sushishop.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class GetUSDService {

    @Value("${currency.USDurl}")
    private String sourceUrl;

    @Value("${currency.USDdef}")
    private double defUSD;


    public double getRate() {
        Document answer = null;
        try {
            answer = Jsoup.connect(sourceUrl).get();
            System.out.println("title doc " + answer.title());
            String rate = answer.selectFirst("rate").text();
            return Double.parseDouble(rate);

        } catch (IOException e) {
           e.getMessage();
            return defUSD;
        }
    }

}
