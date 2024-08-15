package com.niewiadoma.shooting_application.service;

import com.niewiadoma.shooting_application.model.Board;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShootingService {


    // Funkcja solveSingleBoard ma za zadanie rozwiązać problem dla pojedynczej planszy Board
    public String solveSingleBoard(Board board) {
        int r = board.getRow_count();
        int c = board.getColumn_count();
        List<int[]> whiteCells = board.getWhiteCells();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < c; i++) {
            int[] cells = whiteCells.get(i);
            adj.get(i).add(cells[0] - 1);
            adj.get(i).add(cells[1] - 1);
        }

        int[] match = new int[r];
        for (int i = 0; i < r; i++) {
            match[i] = -1;
        }

        for (int u = 0; u < c; u++) {
            boolean[] vis = new boolean[r];
            if (!dfs(u, match, vis, adj)) {
                return "NO";
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            if (match[i] != -1) {
                result.add(match[i] + 1);
            }
        }

        if (result.size() != c) {
            return "NO";
        }

        StringBuilder resultStr = new StringBuilder();
        for (Integer res : result) {
            resultStr.append(res).append(" ");
        }

        return resultStr.toString().trim();
    }


    // funkcja dfs jest używana do znajdowania skojarzeń w grafie dwudzielnym
    private boolean dfs(int u, int[] match, boolean[] vis, List<List<Integer>> adj) {
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                vis[v] = true;
                if (match[v] == -1 || dfs(match[v], match, vis, adj)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}

