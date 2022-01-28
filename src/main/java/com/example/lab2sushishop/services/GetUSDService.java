package com.example.lab2sushishop.services;

import com.example.lab2sushishop.Log.LoggingAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetUSDService {

    private final static Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Value("${currency.USDurl}")
    private String sourceUrl;

    @Value("${currency.USDdef}")
    private double defUSD;


    public double getRate() {
        Document answer = null;
        try {
            System.out.println("connect to " + sourceUrl);
            answer = Jsoup.connect(sourceUrl).get();
            String rate = answer.selectFirst("rate").text();
            System.out.println("get rec.USD course:  "+rate);
            return Double.parseDouble(rate);
        } catch (Exception e) {
            logger.error("EXCEPTION getRate() {}\n", e.getMessage());
            System.out.println("get default USD cource: " + defUSD);
            return defUSD;
        }
    }

}
