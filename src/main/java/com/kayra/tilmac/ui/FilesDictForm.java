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
package com.kayra.tilmac.ui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author gurhan
 */
public class FilesDictForm extends javax.swing.JFrame {

    /**
     * Creates new form FilesDictForm
     */
    public FilesDictForm() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2 - this.getWidth() / 2);
        int y = (screenSize.height / 2 - this.getHeight() / 2);
        this.setLocation(x, y);
    }

    DefaultListModel<String> originalModel;

    public void setWords(ArrayList<String> words) {
        originalModel = new DefaultListModel<>();
        for (String word : words) {
            originalModel.addElement(word);
        }
        jList1.setModel(originalModel);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();
        jButtonExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(360, 490));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTextFieldSearch.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });
        jTextFieldSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldSearchCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldSearchInputMethodTextChanged(evt);
            }
        });
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jButtonDelete.setIcon(new ImageIcon(FilesDictForm.class.getResource("/icons/redo.png"))); // NOI18N
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonExport.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        jButtonExport.setText("Dışarı Aktar");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        String allWords = "";
        Object[] awords = originalModel.toArray();
        for (int i = 0; i < awords.length; i++) {
            if (i == 0) {
                allWords = awords[i].toString().substring(0, 1).toUpperCase() + "\n--------------------\n";
            }
            allWords += awords[i] + "\n";
            try {
                if (awords[i].toString().charAt(0) != awords[i + 1].toString().charAt(0)) {
                    allWords += "\n" + awords[i + 1].toString().substring(0, 1).toUpperCase() + "\n--------------------\n";
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("bitti");

            }
        }
        System.out.println(allWords);
        String s = this.getTitle();
        System.out.println(s.substring(0, s.lastIndexOf(".")) + ".sozluk");
        try {
            String fileName = this.getTitle();
            Document document = new Document();
            File file = new File(System.getProperty("user.home")+File.separator+"Export Dicts");
            if (!file.exists()) {
                file.mkdir();
            }
            String exportDictName = fileName.substring(0, fileName.lastIndexOf(".")) + ".sozluk.pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.home")+File.separator+"Export Dicts" + File.separator + exportDictName));
            document.open();
            BaseFont arialFont = BaseFont.createFont(System.getProperty("user.dir")+File.separator+"font" + File.separator + "arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(arialFont, 12, Font.NORMAL);

            Paragraph paraghraph = new Paragraph(new String(allWords.getBytes(), "UTF-8"), font);
            final float[][] COLUMNS = {
                {36, 36, 296, 806}, {299, 36, 559, 806}
            };
            ColumnText ct = new ColumnText(writer.getDirectContent());
            ct.addElement(paraghraph);
            ct.setAlignment(Element.ALIGN_JUSTIFIED);
            ct.setExtraParagraphSpace(6);
            ct.setLeading(0, 1.2f);
            ct.setFollowingIndent(27);
            int column = 0;
            int status = ColumnText.START_COLUMN;
            while (ColumnText.hasMoreText(status)) {
                ct.setSimpleColumn(
                        COLUMNS[column][0], COLUMNS[column][1],
                        COLUMNS[column][2], COLUMNS[column][3]);
                ct.setYLine(COLUMNS[column][3]);
                status = ct.go();
                column = Math.abs(column - 1);
                if (column == 0) {
                    document.newPage();
                }
            }

            ct.go();

            document.close();
            JOptionPane.showMessageDialog(this, System.getProperty("user.home") + File.separator + "Export Dicts" + file.separator + exportDictName + " başarıyla oluşturuldu.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jTextFieldSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldSearchInputMethodTextChanged

    }//GEN-LAST:event_jTextFieldSearchInputMethodTextChanged

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed

    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jTextFieldSearchCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldSearchCaretPositionChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldSearchCaretPositionChanged

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed


    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        String searchText = jTextFieldSearch.getText();

        if (searchText.length() > 0 && !searchText.equals("")) {
            DefaultListModel<String> tmpModel = new DefaultListModel<>();
            int n = searchText.length();
            for (int i = 0; i < originalModel.size(); i++) {
                String text = originalModel.get(i).substring(0, n);
                if (text.equals(searchText)) {
                    tmpModel.addElement(originalModel.get(i));
                }

            }
            jList1.setModel(tmpModel);
        } else {
            jList1.setModel(originalModel);
        }


    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        jTextFieldSearch.setText("");
        jList1.setModel(originalModel);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FilesDictForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilesDictForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilesDictForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilesDictForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilesDictForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}