package com.progetto.PAO.controllers;

import com.progetto.PAO.models.File;
import com.progetto.PAO.models.Statistic;
import com.progetto.PAO.services.Parser;
import com.progetto.PAO.utils.ConnectDropbox;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class DropboxController {
    /***
     * Metodo che restituisce informazioni sullo spazio utilizzato dall'account a cui si è acceduto.
     * @return un JSONObject che riporta lo spazio totale utilizzato e lo spazio di allocazione dell'utente
     */
    @RequestMapping(value = "/usage", method = RequestMethod.GET, produces = "application/json")
    String getUsage() {
        String url = "https://api.dropboxapi.com/2/users/get_space_usage";
        String token = "Bearer n06rPalf7Y8AAAAAAAAAAeL51ouBne0M2e78SzvwS4BdMpirjDTdmnC_dB72DUOU";
        String method = "POST";
        String body = null;
        JSONObject obj = ConnectDropbox.request(url, method, token, body);
        return obj.toString();
    }

    /***
     * Metodo che restituisce l'elenco di tutti i file a cui ha accesso l'utente
     * @param tag chiave aggiuntiva che permette di "filtrare" i dati restituiti da Dropbox API
     * @return un HashMap contenente le informazioni fornite da Dropbox API
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    HashMap<String, List<File>> getAllFiles(
            @RequestParam(value = "tag", required = false, defaultValue = "") String tag
    ) {
        String url = "https://api.dropboxapi.com/2/files/list_folder";
        String token = "Bearer n06rPalf7Y8AAAAAAAAAAeL51ouBne0M2e78SzvwS4BdMpirjDTdmnC_dB72DUOU";
        String method = "POST";
        String body = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
                + "    \"include_media_info\": true,\r\n" + "    \"include_deleted\": false,\r\n"
                + "    \"include_has_explicit_shared_members\": false,\r\n"
                + "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
                + "}";
        JSONObject obj = ConnectDropbox.request(url, method, token, body);
        HashMap<String, List<File>> map = Parser.JsonToFile(obj);
        if(tag.isEmpty()){
            return map;
        }else{
            HashMap<String, List<File>> newMap = new HashMap<String, List<File>>();
            if(map.get(tag) == null){
                newMap.put("tag non trovata",map.get(tag));
                return newMap;
            }else{
                newMap.put(tag,map.get(tag));
                return newMap;
            }
        }
    }

    /***
     * Metodo per richiedere le statistiche sui file
     * @return una stringa
     */
    @RequestMapping(value = "/statistic", method = RequestMethod.GET, produces = "application/json")
    String getStatistics() {
        HashMap<String, List<File>> map = getAllFiles("file");
        Statistic statistic = new Statistic(map.get("file"));
        JSONObject json = statistic.toJson();
        return json.toString();
    }
}
