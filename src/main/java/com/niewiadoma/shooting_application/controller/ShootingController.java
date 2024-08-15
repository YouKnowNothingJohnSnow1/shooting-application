package com.niewiadoma.shooting_application.controller;

import com.niewiadoma.shooting_application.model.Board;
import com.niewiadoma.shooting_application.service.ShootingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ShootingController {


    @Autowired
    private ShootingService shootingService;


   // Funkcja solve jest odpowiedzialna za obsługę całego procesu rozwiązania wielu plansz na podstawie danych
   // z pliku wejściowego SHO.IN i zapisanie wyników do pliku wyjściowego SHO.OUT
    @GetMapping("/solve")
    public String solve() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("SHO.IN"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("SHO.OUT"));

            int numberOfBlocks = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < numberOfBlocks; i++) {
                String[] dimensions = reader.readLine().trim().split(" ");
                int r = Integer.parseInt(dimensions[0]);
                int c = Integer.parseInt(dimensions[1]);

                List<int[]> whiteCells = new ArrayList<>();
                for (int j = 0; j < c; j++) {
                    String[] cells = reader.readLine().trim().split(" ");
                    int first = Integer.parseInt(cells[0]);
                    int second = Integer.parseInt(cells[1]);
                    whiteCells.add(new int[]{first, second});
                }

                Board board = new Board(r, c, whiteCells);
                String result = shootingService.solveSingleBoard(board);
                writer.write(result + "\n");
            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Processed";
    }









}
