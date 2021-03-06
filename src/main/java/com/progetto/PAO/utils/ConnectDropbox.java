package com.progetto.PAO.utils;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectDropbox {
    /***
     * Metodo statico per collegarsi a Dropbox API
     * @param url l'url è importante per capire la tipologia di richiesta
     * @param method può essere POST o GET
     * @param token è la chiave univoca per accedere al mio account
     * @param body ==null solo per richieste GET o POST senza body
     * @return un JSON contenente le informazioni fornite dall'API
     */
    public static JSONObject request(String url, String method, String token, String body){
        JSONObject obj = null;
        try {
            HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
            openConnection.setRequestMethod(method);
            openConnection.setRequestProperty("Authorization", token);
            openConnection.setRequestProperty("Accept", "application/json");
            openConnection.setDoOutput(true);

            if(body != null) {
                openConnection.setRequestProperty("Content-Type", "application/json");
                try (OutputStream os = openConnection.getOutputStream()) {
                    byte[] input = body.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            InputStream in = openConnection.getInputStream();

            String data = "";
            String line = "";
            try {
                InputStreamReader inR = new InputStreamReader(in);
                BufferedReader buf = new BufferedReader(inR);

                while ((line = buf.readLine()) != null) {
                    data += line;
                }
            } finally {
                in.close();
            }
            obj = new JSONObject(data);
            System.out.println("JSON ottenuto da Dropbox");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}