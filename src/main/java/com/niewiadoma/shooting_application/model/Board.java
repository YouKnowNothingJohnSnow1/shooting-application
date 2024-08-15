package com.niewiadoma.shooting_application.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity(name = "boards")
public class Board {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_count;
    private int column_count;
    private List<int[]> whiteCells;

    public Board(int rows, int columns, List<int[]> whiteCells) {
        this.row_count = rows;
        this.column_count = columns;
        this.whiteCells = whiteCells;
    }

    public int getRow_count() {
        return row_count;
    }

    public void setRow_count(int row_count) {
        this.row_count = row_count;
    }

    public int getColumn_count() {
        return column_count;
    }

    public void setColumn_count(int column_count) {
        this.column_count = column_count;
    }

    public List<int[]> getWhiteCells() {
        return whiteCells;
    }

    public void setWhiteCells(List<int[]> whiteCells) {
        this.whiteCells = whiteCells;
    }
}
