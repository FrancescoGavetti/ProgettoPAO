package com.progetto.PAO.services;

import com.progetto.PAO.models.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    /***
     * Metodo statico per parsare i metadati restituiti da Dropbox API
     * @param obj json da parsare
     * @return Map oggetto che modella il json restiuito da Dropbox API
     */
    public static HashMap<String, List<File>> JsonToFile(JSONObject obj){
        HashMap<String, List<File>> map = new HashMap<String, List<File>>();
        try {
            JSONArray entries = obj.getJSONArray("entries");
            for(int i = 0; i < entries.length(); i++){
                File f = new File(entries.getJSONObject(i));
                List<File> list = new LinkedList<>();
                if(map.containsKey(f.getTag())){
                    list = map.get(f.getTag());
                    list.add(f);
                    map.put(f.getTag(), list);
                }else{
                    list.add(f);
                    map.put(f.getTag(), list);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }
}
