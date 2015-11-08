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
package com.kayra.tilmac.docread;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.kayra.tilmac.db.DBManager;


/**
 *
 * @author gurhan
 */
public class DocRead {

    private File file;
    private String fileName;
    private int[][] filePages;
    private ArrayList<String> wordList = new ArrayList<>();

    public DocRead(File file) throws IOException {
        this.file = file;
        this.fileName = file.getName();
        if (getFileExtension(file).equals("pdf")) {
            PDFRead();
        } else {

        }
    }

    public DocRead(File file, int[][] filePages) throws IOException {
        this.file = file;
        this.filePages = filePages;

        if (getFileExtension(file).equals("pdf")) {
            PDFRead();
        } else {

        }
    }

    private void PDFRead() throws IOException {
        String fileName = file.getName();
        String filePath = file.getPath();
        try {
        PdfReader reader = new PdfReader(filePath);

        int startPage = 0;
        int lastPage = 0;

        try {
            String s = "";
            int length = filePages.length;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        startPage = filePages[i][j];
                    } else if (j == 1) {
                        lastPage = filePages[i][j];
                    }

                }
                if (startPage != -1 && lastPage != -1) {
                    s += "[" + startPage + "-" + lastPage + "]";
                    extractStringFromPDF(reader, startPage, lastPage);
                }
                if (filePages[i + 1][0] == 0) {
                    System.out.println("kırılma");
                    break;
                }
            }

            String name = this.file.getName();
            this.fileName = name.substring(0, name.lastIndexOf(".")) + "(" + s + ")" + name.substring(name.lastIndexOf("."));
        } catch (NullPointerException e) {
            startPage = 1;
            lastPage = reader.getNumberOfPages();
            extractStringFromPDF(reader, startPage, lastPage);
        }
        filePages = null;
        }catch(Exception e){
            System.out.println("hata pdf i okurken");
            e.printStackTrace();
        }

    }

    private void extractStringFromPDF(PdfReader reader, int startPage, int lastPage) throws IOException {
        if (startPage != -1 && lastPage != -1) {

            for (int pageNumber = startPage; pageNumber <= lastPage; pageNumber++) {
                String page = PdfTextExtractor.getTextFromPage(reader, pageNumber);
                page = page.toLowerCase();
                Pattern p = Pattern.compile("[\\w']+");
                Matcher m = p.matcher(page);

                while (m.find()) {

                    String word = page.substring(m.start(), m.end());
                    if (isContainNumericChar(word) == false) {
                        if (word.contains("'")) {
                            word = word.replace('\'', ' ').trim();

                        }
                        if (word.length() > 1 && wordList.contains(word) == false) {
                            wordList.add(word);

                        }
                    }

                }
            }
        }

    }

    public void addWordstoDB() throws SQLException {
        if (this.wordList != null && this.wordList.size() > 0) {
            System.out.println(file.getName());
            DBManager.connector.addWordstoDB(this.fileName, this.wordList);
        }
    }

    private static boolean isContainNumericChar(String s) {
        return s.matches(".*[0-9].*");
    }

    private String getFileExtension(File f) {
        String name = f.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            return name.substring(lastIndexOf + 1);
        }
        return null;
    }

}
