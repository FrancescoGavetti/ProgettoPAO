package com.progetto.PAO.utils;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectDropbox {

    public static void request(){
        String url = "https://api.dropboxapi.com/2/files/list_folder";
        //String url = "https://api.dropboxapi.com/2/files/get_metadata";
        try {

            HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
            openConnection.setRequestMethod("POST");
            openConnection.setRequestProperty("Authorization",
                    "Bearer n06rPalf7Y8AAAAAAAAAAeL51ouBne0M2e78SzvwS4BdMpirjDTdmnC_dB72DUOU");
            openConnection.setRequestProperty("Content-Type", "application/json");
            openConnection.setRequestProperty("Accept", "application/json");
            openConnection.setDoOutput(true);
			String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
					+ "    \"include_media_info\": false,\r\n" + "    \"include_deleted\": false,\r\n"
					+ "    \"include_has_explicit_shared_members\": false,\r\n"
					+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
					+ "}";
            /*String jsonBody = "{\r\n" +
                    "    \"path\": \"/Photos/Sample Album/img001.jpg\",\r\n"
                    "    \"include_media_info\": true,\r\n" +
                    "    \"include_deleted\": false,\r\n" +
                    "    \"include_has_explicit_shared_members\": false\r\n" +
                    "}";*/

            try (OutputStream os = openConnection.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            InputStream in = openConnection.getInputStream();

            String data = "";
            String line = "";
            try {
                InputStreamReader inR = new InputStreamReader(in);
                BufferedReader buf = new BufferedReader(inR);

                while ((line = buf.readLine()) != null) {
                    data += line;
                    System.out.println(line);
                }
            } finally {
                in.close();
            }
            JSONObject obj = new JSONObject(data);
            System.out.println(data.toString());
            System.out.println("OK");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
