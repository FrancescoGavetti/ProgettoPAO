package com.progetto.PAO.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/***
 *
 */
public class Statistic {
    private List<File> list;
    private int max;
    private int min;
    private int sum;
    private int average;

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

    public int getSum() { return sum; }

    public void setSum(int sum) { this.sum = sum; }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public Statistic(List<File> list) {
        this.list = list;
        this.max = list.get(0).getSize();
        this.min = list.get(0).getSize();
        for(int i=0; i<list.size(); i++){
            int size = list.get(i).getSize();
            this.sum += size;
            if(list.get(i).getSize()>max)
                this.max = list.get(i).getSize();
            if(list.get(i).getSize()<min)
                this.min = list.get(i).getSize();
        }
        this.average = (int)Math.round(sum/ list.size());
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        try {
            json.put("max", this.max);
            json.put("min", this.min);
            json.put("sum", this.sum);
            json.put("average", this.average);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "list=" + list +
                ", max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                ", average=" + average +
                '}';
    }
}