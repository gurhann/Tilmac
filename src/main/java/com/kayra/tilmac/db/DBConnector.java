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
package com.kayra.tilmac.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import com.kayra.tilmac.translator.YandexTranslator;
import com.kayra.tilmac.ui.AddDictLoadingPage;

/**
 *
 * @author gurhan
 */
public class DBConnector {

    Connection connection;
    private boolean isOnline;

    public DBConnector() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/dict.sqlite");
            System.out.println("baglantı başarıyla yapıldı");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    /**
     * Yeni sözlük ekleme kısmında ilk çalışan fonksiyon. İlk başta dosya ismi
     * filiName tablosuna eklenir ve id si alınır. Daha sonra gelen kelime
     * listesindeki her bir kelimenin words tablosundan id si alınır ve
     * wordIDList listesine eklenir. Eğer kelime words tablosunda bulunmuyorsa
     * internet varmı diye kontrol edilir. Eğer internet yoksa kelimenin türkçe
     * karşılıgı null olarak eklenir. Eğer internet varsa da kelimenin karşılığı
     * alınır karşılıgı yoksa atlanır varsa ise o şekilde eklenip id si alınıp
     * wordIDList listesine eklenir. En son olarakda elde edilen wordIDList
     * listesi ve fileId si addWordtoFileWords fonskiyonuna gönderilir.
     *
     * @param fileName
     * @param wordList
     * @throws SQLException
     */
    public void addWordstoDB(String fileName, ArrayList<String> wordList) throws SQLException {
        AddDictLoadingPage form = new AddDictLoadingPage();
        form.setVisible(true);
        form.setTotalWords(wordList.size());
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        int count = 1;
        ArrayList<Integer> wordIDList = new ArrayList<>();
        if (!isExist(fileName, "fileNames", "fileName")) {
            System.out.println("bu isim de dosya yok işleme devam");
            int fileId;
            int wordId;
            String message;
            addFileName(fileName);
            YandexTranslator translator = new YandexTranslator();
            fileId = getFileNameId(fileName);
            if (fileId != -1) {
                for (String word : wordList) {
                    wordId = getwordId(word);
                    if (wordId == -1) {
                        message = word + " sözlük veri tabanında bulunamadı \n";
                        if (!isOnline) {
                            addNewWord(word);
                            message += "=> güncellenecek kelimeler arasına eklendi";

                        } else {
                            if (!word.contains(" ")) {
                                String mean = translator.translateWord(word);
                                if (!mean.equals(word) && !mean.contains(" ")) {
                                    addNewWord(word, mean);
                                    message += word + "=>" + mean + " ---- yeni kelime eklendi";
                                } else {
                                    message += word + " => kelimesi anlamlandırılamadı";
                                    continue;
                                }
                            }

                        }
                        wordId = getwordId(word);

                    }
                    form.changeLabelAndProgressBar(count);
                    count++;
                    message = word + " =>  listeye eklendi";
                    wordIDList.add(wordId);
                    form.addToList(message);
                    message = "";
                }
                form.changeLabelAndProgressBar(wordList.size());
                form.addToList("Ayrıştırılan kelime listesi veritabanına ekleniyor. Lütfen Bekleyin");

                addWordtoFileWords(fileId, wordIDList);
                form.addToList("İşlem tamamlandı");

            }
        }
    }

    /**
     * Gönderilen s değerinin table tablosunun column kolununda bulunup
     * bulunmadığını kontrol eden fonksiyon.
     *
     * @param s
     * @param table
     * @param column
     * @return
     * @throws SQLException
     */
    private boolean isExist(String s, String table, String column) throws SQLException {
        int rowCount = -1;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM " + table + " WHERE " + column + "=?";
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, s);
            rs = pstmt.executeQuery();
            rs.next();
            rowCount = rs.getInt(1);

            if (rowCount >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return true;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     * Gelen fileName parametresini fileNames tablosuna ekleyen fonksiyon.
     *
     * @param fileName
     * @throws SQLException
     */
    private void addFileName(String fileName) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO fileNames(fileName) VALUES(?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, fileName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }

    /**
     * Gönderilen fileName parametresinin fileNames tablosundaki idsini veren
     * fonksiyon.
     *
     * @param fileName
     * @return
     * @throws SQLException
     */
    private int getFileNameId(String fileName) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM fileNames WHERE fileName = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, fileName);
            rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     * Gönderilen word parametresinin words tablosundaki id sini döndüren
     * fonksiyon.
     *
     * @param word
     * @return
     * @throws SQLException
     */
    private int getwordId(String word) throws SQLException {
//        if(!isExist(word, "words","eng") && !isOnline){
//            addNewWord(word);
//        }
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM words WHERE eng = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, word);
            rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            return -1;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     * Gönderilen ingilizce yeni kelimeyi words tablosuna ekleyen fonksyion.
     *
     * @param word
     * @throws SQLException
     */
    private void addNewWord(String word) throws SQLException {

        PreparedStatement pstmt = null;
        String sql = "INSERT INTO words (eng) VALUES (?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, word);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }

    /**
     * Gönderilen ingilizce kelime ve anlamını words tablosuna ekleyen
     * fonksiyon.
     *
     * @param word
     * @param mean
     * @throws SQLException
     */
    private void addNewWord(String word, String mean) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO words (eng, tr) VALUES (?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, word);
            pstmt.setString(2, mean);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }

    /**
     * Gönderilen wordIDList ve fileId parametrelerini fileWord tablosuna
     * ekleyen fonksiyon.
     *
     * @param fileId
     * @param wordIDList
     * @throws SQLException
     */
    private void addWordtoFileWords(int fileId, ArrayList<Integer> wordIDList) throws SQLException {
        PreparedStatement pstmt = null;
        connection.setAutoCommit(false);
        String sql = "INSERT INTO fileWord (fileID, wordID) VALUES(?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < wordIDList.size(); i++) {
                pstmt.setInt(1, fileId);
                pstmt.setInt(2, wordIDList.get(i));
                System.out.println(i);
                pstmt.addBatch();
                if ((i + 1) % 100 == 0) {

                    pstmt.executeBatch();
                }
            }
            pstmt.executeBatch();
            System.out.println("bitti");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            connection.commit();
            connection.setAutoCommit(true);
        }
    }

    /**
     * words tablosunda olupta türkçe karşılığı olmayan ingilizce kelimeleri id
     * leriyle birlikte döndüren fonksiyon.
     *
     * @return
     * @throws SQLException
     */
    public HashMap<Integer, String> getNullWords() throws SQLException {
        HashMap<Integer, String> words = new HashMap<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT id, eng FROM words WHERE tr IS NULL";

        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                words.put(rs.getInt("id"), rs.getString("eng"));
            }
            return words;
        } catch (Exception e) {
            e.printStackTrace();
            pstmt.close();
            rs.close();
        }
        return null;
    }

    /**
     * Türkçe karsılığı olmayıp türkçe karşılıkları yandex api tarafından
     * gönderilen kelimeleri veritabanında güncelleyen fonksiyon.
     *
     * @param words
     * @throws SQLException
     */
    public void uptadeTheWords(HashMap<Integer, String> words) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "UPDATE words SET tr = ? WHERE id = ?";
        connection.setAutoCommit(false);
        int counter = 0;
        try {
            pstmt = connection.prepareStatement(sql);
            for (Integer index : words.keySet()) {
                pstmt.setString(1, words.get(index));
                pstmt.setInt(2, index);
                pstmt.addBatch();
                if ((counter + 1) % 100 == 0) {
                    pstmt.executeBatch();
                }
            }
            pstmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            connection.commit();
            connection.setAutoCommit(true);
        }
    }

    /**
     * Gönderilen id yi words tablosundan silen fonksiyon.
     *
     * @param id
     * @throws SQLException
     */
    public void removeWordFromWords(int id) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM words WHERE id = ?";

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }

    /**
     * Gönderilen id yi fileWords tablosundan silen fonksiyon.
     *
     * @param id
     * @throws SQLException
     */
    public void removeWordFromfileWord(int id) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM fileWord WHERE wordID = ?";

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }

    /**
     * Gönderilen sayfa numalarına göre 6 tane sözlük ismi döndüren fonksiyon.
     *
     * @param page
     * @return
     * @throws SQLException
     */
    public ArrayList<String> nameOfFiles(int page) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT fileName FROM fileNames ORDER BY id DESC LIMIT ?,?";
        ArrayList<String> fileNames = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, (page - 1) * 6);
            pstmt.setInt(2, page * 6);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("fileName"));
                fileNames.add(rs.getString("fileName"));

            }
            return fileNames;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            rs.close();
            pstmt.close();
        }
    }

    /**
     * Gönderilen fileName parametresine göre o dosyada bulunan kelimelerin
     * türkçe karşılıklarını eng=>tr biçiminde hazırlayıp döndüren fonsiyon.
     *
     * @param fileName
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getWordsinFile(String fileName) throws SQLException {
        ArrayList<String> words = new ArrayList<>();
        int fileId = getFileNameId(fileName);
        if (fileId != -1) {
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String sql = "SELECT eng, tr FROM words,fileWord WHERE fileWord.fileID = ? and fileWord.wordID = words.id and words.tr IS NOT NULL ORDER BY eng";
            int sayac = 0;
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, fileId);
                rs = pstmt.executeQuery();
                while (rs.next()) {

                    words.add(rs.getString("eng") + "=>" + rs.getString("tr"));
                    sayac++;
                }
                return words;
            } catch (Exception e) {
                return null;
            } finally {
                pstmt.close();
                rs.close();
                System.out.println(sayac);
            }
        } else {
            return null;
        }
    }

    public void close() throws SQLException {
        if (!connection.isClosed()) {
            System.out.println("bağlantı kapatıldı");
            connection.close();
        }
    }

    /**
     * Maksimum sayfa sayısı için var olan tüm sözlük sayısının geri döndüren
     * fonksiyon.
     *
     * @return
     * @throws SQLException
     */
    public int getNumberOfFiles() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) AS COUNT FROM fileNames";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("COUNT");
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     * Gönderilen dictName parametresine göre gönderilen sözlüğün hem fileNames
     * hemde fileWord tablosundan silinmesini sağlayan fonksiyon.
     *
     * @param dictName
     * @throws SQLException
     */
    public void removeDict(String dictName) throws SQLException {
        int fileId = getFileNameId(dictName);
        deleteFileFromFileNames(fileId);
        deleteFileFromdWords(fileId);

    }

    private void deleteFileFromFileNames(int fileId) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM fileNames WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, fileId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }

    private void deleteFileFromdWords(int fileId) throws SQLException {
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM fileWord WHERE fileID = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, fileId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }
    }

}
