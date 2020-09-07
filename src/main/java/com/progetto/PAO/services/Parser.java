package com.progetto.PAO.services;

import com.progetto.PAO.models.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    static public HashMap<String, List<File>> JsonToFile(JSONObject obj){
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
