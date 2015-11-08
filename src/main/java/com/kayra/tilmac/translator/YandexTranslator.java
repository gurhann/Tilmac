/*
 *  This file is part of Tilmac.
 *
 *  Tilmac is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  Tilmac is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with Tilmac.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.kayra.tilmac.translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.kayra.tilmac.db.DBManager;
import com.kayra.tilmac.ui.UpdateWords;

/**
 *
 * @author gurhan
 */
public class YandexTranslator implements Runnable {

    private HashMap<Integer, String> words;
    private HashMap<Integer, String> means;
    private ArrayList<String> newWords;
    private Thread t;

    /**
     * words hash mapinde internette aranıcak kelimelerin bir listesi bulunur.
     * Bu kelimelerin karşılıkları means hash mapine aktarılır. Bu kısım
     * sözlükte daha önce ekli olan kelimelerin karşılıklarını aramak için.
     *
     * @param words
     */
    public YandexTranslator(HashMap<Integer, String> words) {
        this.words = words;
        this.means = new HashMap<>();
    }

    public YandexTranslator() {

    }

    public boolean isInternetReachable() {
        try {

            URL url = new URL("http://www.google.com");

            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

            Object objData = urlConnect.getContent();

        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {

            return false;
        }
        return true;
    }

    public String translateWord(String word) {
        return search("dict", word);
    }

    private boolean translate() throws SQLException {

        UpdateWords frame = new UpdateWords();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTotalWords(words.size());
        int counter = 1;
        if (isInternetReachable()) {
            for (Integer index : words.keySet()) {
                String mean = "";
                if (!words.get(index).contains(" ")) {
                    mean = translateWord(words.get(index));
                }
                frame.changeLabel(counter);
                if (!mean.equals("") && !mean.equals(words.get(index)) && !words.get(index).contains(" ")) {
                    frame.changeList(words.get(index) + ":" + mean);
                    means.put(index, mean);
                } else {
                    frame.changeList(words.get(index) + " silindi");
                    DBManager.connector.removeWordFromWords(index);
                    DBManager.connector.removeWordFromfileWord(index);
                }
                counter++;

            }
            frame.dispose();
            DBManager.connector.uptadeTheWords(means);
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String, String> translateNewWords() {
        HashMap<String, String> newWordMeans = new HashMap<>();

        for (String word : newWords) {
            String mean = search("dict", word);
            if (!mean.equals(word) && !word.contains(" ")) {
                newWordMeans.put(word, mean);
            }
        }
        return newWordMeans;

    }

    private String search(String where, String word) {
        String URL = "";
        HttpClient client = new DefaultHttpClient();

        HttpResponse response = null;
        if (where.equals("dict")) {
            URL = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20140823T062641Z.70f794a8aa21f919.7f2ec2ba886dcc8a15679e1f1eb44209640da996&lang=en-tr&text=" + word;
        } else if (where.equals("translate")) {
            URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20140823T085734Z.0c87d73c24509f03.c4ac0c01312f7fa91fed68943068b0d08a6e6df3&lang=en-tr&text=" + word;
        }

        try {
            HttpGet request = new HttpGet(URL);
            response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream data = entity.getContent();
                String result = convertStreamToString(data);
                if (where.equals("dict")) {
                    return parseDictData(result) != null ? parseDictData(result) : search("translate", word);
                } else if (where.equals("translate")) {
                    return parseTranslateData(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private String parseDictData(String jsonString) throws JSONException {
        String wordMeans = "";
        JSONObject jsonObject = new JSONObject(jsonString);
        if (!jsonObject.getJSONArray("def").isNull(0)) {
            JSONArray def = jsonObject.getJSONArray("def");
            for (int i = 0; i < def.length(); i++) {
                JSONObject obj = def.getJSONObject(i);
                JSONArray tr = obj.getJSONArray("tr");
                for (int j = 0; j < tr.length(); j++) {
                    JSONObject word = tr.getJSONObject(j);
                    wordMeans += word.getString("text") + ", ";
                }
            }
            if (wordMeans.endsWith(", ")) {
                wordMeans = wordMeans.substring(0, wordMeans.length() - 2);
            }
            return wordMeans;
        } else {
            return null;
        }
    }

    private String parseTranslateData(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.getJSONArray("text").getString(0);
    }

    private String convertStreamToString(InputStream is) {
        // Gelen veri akışı bir String değişkeni içine atılır
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        return sb.toString();
    }

    @Override
    public void run() {
        try {
            boolean ok = translate();
            if (ok == false) {
                JOptionPane.showMessageDialog(null, "Sözlük güncellenemedi lütfen internet bağlantınızı kontrol edin !");
            } else {
                JOptionPane.showMessageDialog(null, "Sözlük başarıyla güncellendi.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(YandexTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

}
