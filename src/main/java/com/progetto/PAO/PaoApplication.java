package com.progetto.PAO;

import com.progetto.PAO.models.File;
import com.progetto.PAO.services.Parser;
import com.progetto.PAO.utils.ConnectDropbox;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class PaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaoApplication.class, args);
		String url = "https://api.dropboxapi.com/2/files/list_folder";
		//String url = "https://api.dropboxapi.com/2/files/get_metadata";
		String token = "Bearer n06rPalf7Y8AAAAAAAAAAeL51ouBne0M2e78SzvwS4BdMpirjDTdmnC_dB72DUOU";
		String method = "POST";
		String body = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
				+ "    \"include_media_info\": true,\r\n" + "    \"include_deleted\": false,\r\n"
				+ "    \"include_has_explicit_shared_members\": false,\r\n"
				+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
				+ "}";
            /*String jsonBody = "{\r\n" +
                    "    \"path\": \"/Photos/Sample Album/img001.jpg\",\r\n"
                    "    \"include_media_info\": true,\r\n" +
                    "    \"include_deleted\": false,\r\n" +
                    "    \"include_has_explicit_shared_members\": false\r\n" +
                    "}";*/
		JSONObject obj = ConnectDropbox.request(url, method, token, body);
		HashMap<String, List<File>> map = Parser.JsonToFile(obj);
		System.out.println(map);
	}

}
