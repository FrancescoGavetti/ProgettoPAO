package com.progetto.PAO.controllers;

import com.progetto.PAO.models.File;
import com.progetto.PAO.services.Parser;
import com.progetto.PAO.utils.ConnectDropbox;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class DropboxController {

    @RequestMapping(value = "/usage", method = RequestMethod.GET, produces = "application/json")
    String getUsage() {
        String url = "https://api.dropboxapi.com/2/users/get_space_usage";
        String token = "Bearer n06rPalf7Y8AAAAAAAAAAeL51ouBne0M2e78SzvwS4BdMpirjDTdmnC_dB72DUOU";
        String method = "POST";
        String body = null;
        JSONObject obj = ConnectDropbox.request(url, method, token, body);
        return obj.toString();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
    String getCount() {
        String url = "https://api.dropboxapi.com/2/file_requests/count";
        String token = "Bearer n06rPalf7Y8AAAAAAAAAAeL51ouBne0M2e78SzvwS4BdMpirjDTdmnC_dB72DUOU";
        String method = "POST";
        String body = null;
        JSONObject obj = ConnectDropbox.request(url, method, token, body);
        return obj.toString();
    }

//ok funziona, filtrare per tag in caso
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    HashMap<String, List<File>> getAllFiles() {
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
        return map;
    }
}
