package com.progetto.PAO.models;

import java.util.List;

public class Statistic {
    private List<File> list;
    private int max;
    private int min;
    private int average;

    public Statistic(List<File> list) {
        this.list = list;
    }

    public List<File> getList() {
        return list;
    }

    public void setList(List<File> list) {
        this.list = list;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "list=" + list +
                ", max=" + max +
                ", min=" + min +
                ", average=" + average +
                '}';
    }
}
