package com.progetto.PAO.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/***
 * Entità che mi permette di calcolare e restituire le statistiche sui file
 */
public class Statistic {
    private List<File> list;
    private int sizeMax;
    private int sizeMin;
    private int sizeSum;
    private int sizeAvg;
    // HashMap che ha come chiave l'estensione dei file e come valore la relativa numerosità
    private HashMap<String, Integer> extensionMap;

    public List<File> getList() {
        return list;
    }

    public void setList(List<File> list) {
        this.list = list;
    }

    public int getSizeMax() {
        return sizeMax;
    }

    public void setSizeMax(int sizeMax) {
        this.sizeMax = sizeMax;
    }

    public int getSizeMin() {
        return sizeMin;
    }

    public void setSizeMin(int sizeMin) {
        this.sizeMin = sizeMin;
    }

    public int getSizeSum() {
        return sizeSum;
    }

    public void setSizeSum(int sizeSum) {
        this.sizeSum = sizeSum;
    }

    public int getSizeAvg() {
        return sizeAvg;
    }

    public void setSizeAvg(int sizeAvg) {
        this.sizeAvg = sizeAvg;
    }

    public HashMap<String, Integer> getExtensionMap() {
        return extensionMap;
    }

    public void setExtensionMap(HashMap<String, Integer> extensionMap) {
        this.extensionMap = extensionMap;
    }

    public Statistic(List<File> list, int sizeMax, int sizeMin, int sizeSum, int sizeAvg, HashMap<String, Integer> extensionMap) {
        this.list = list;
        this.sizeMax = sizeMax;
        this.sizeMin = sizeMin;
        this.sizeSum = sizeSum;
        this.sizeAvg = sizeAvg;
        this.extensionMap = extensionMap;
    }

    /***
     * Costruttore in grado di calcolare e popolare le statistiche sulla size e il count delle estensioni
     * @param list lista di file
     */
    public Statistic(List<File> list) {
        this.list = list;
        this.sizeMax = list.get(0).getSize();
        this.sizeMin = list.get(0).getSize();
        for(int i=0; i<list.size(); i++){
            int size = list.get(i).getSize();
            this.sizeSum += size;
            if(list.get(i).getSize()>sizeMax)
                this.sizeMax = list.get(i).getSize();
            if(list.get(i).getSize()<sizeMin)
                this.sizeMin = list.get(i).getSize();
        }
        this.sizeAvg = (int)Math.round(sizeSum/ list.size());
        this.extensionMap = createMap(list);
    }

    /***
     * Metodo privato per realizzare l'HashMap contenente le estensioni dei file come chiave e la loro cardinalità
     * come valore
     * @param list dei file per creare l'HashMap
     * @return HashMap
     */
    private HashMap<String, Integer> createMap(List<File> list){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            String name = list.get(i).getName();
            String[] array = name.split("\\.");
            String key = array[array.length-1];
            if (map.containsKey(key)){
                int count = map.get(key);
                count++;
                map.put(key, count);
            }else{
                map.put(key, 1);
            }
        }
        return map;
    }

    /***
     * Metodo per estrarre le informazioni della classe in formato JSON
     * @return il JSON contenente le informazioni
     */
    public JSONObject toJson(){
        JSONObject json = new JSONObject(this.extensionMap);
        try {
            json.put("size max", this.sizeMax);
            json.put("size min", this.sizeMin);
            json.put("size sum", this.sizeSum);
            json.put("size average", this.sizeAvg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "list=" + list +
                ", sizeMax=" + sizeMax +
                ", sizeMin=" + sizeMin +
                ", sizeSum=" + sizeSum +
                ", sizeAvg=" + sizeAvg +
                ", extensionMap=" + extensionMap +
                '}';
    }
}