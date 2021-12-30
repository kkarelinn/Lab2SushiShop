package com.example.lab2sushishop.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


public interface Entity {

      String toString();
      int getID();

      void setID(int i);
}
