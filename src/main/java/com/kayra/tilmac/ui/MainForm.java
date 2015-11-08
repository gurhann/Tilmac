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

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.kayra.tilmac.db.DBManager;
import com.kayra.tilmac.translator.YandexTranslator;

/**
 *
 * @author gurhan
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        changeCurrentDirectory();
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2 - this.getWidth() / 2);
        int y = (screenSize.height / 2 - this.getHeight() / 2);
        this.setLocation(x, y);
    }
    private void changeCurrentDirectory(){
        if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("user.dir", "/usr/local/tilmac/");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelSozlukler = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButtonAddFile = new javax.swing.JButton();
        jButtonPreviousPage = new javax.swing.JButton();
        jButtonNextPage = new javax.swing.JButton();
        jLabelCurrentPage = new javax.swing.JLabel();
        jButtonRefresh = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemUpdate = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemHelp = new javax.swing.JMenuItem();
        jMenuItemAboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TİLMAÇ");
        setMinimumSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(226, 226, 226));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(235, 13, 63));
        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 15, 15));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(jPanel2);
        jLabel1.setText("TİLMAÇ Belgeye Özgü Sözlüğünüz");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSozlukler.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelSozlukler.setAutoscrolls(true);
        isButtonsMustEnable(1);

        javax.swing.GroupLayout jPanelSozluklerLayout = new javax.swing.GroupLayout(jPanelSozlukler);
        jPanelSozlukler.setLayout(jPanelSozluklerLayout);
        jPanelSozluklerLayout.setHorizontalGroup(
            jPanelSozluklerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        jPanelSozluklerLayout.setVerticalGroup(
            jPanelSozluklerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(234, 234, 234));

        jButtonAddFile.setBackground(new java.awt.Color(242, 241, 240));
        jButtonAddFile.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jButtonAddFile.setForeground(new java.awt.Color(61, 30, 30));
        jButtonAddFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/writing17.png"))); // NOI18N
        jButtonAddFile.setText("Belge Ekle");
        jButtonAddFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddFile.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        try{
            addDictPanels(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        jButtonAddFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAddFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAddFileMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAddFileMouseEntered(evt);
            }
        });
        jButtonAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFileActionPerformed(evt);
            }
        });
        buttonIsTransparent(jButtonAddFile, false);

        jButtonPreviousPage.setEnabled(false);
        jButtonPreviousPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow-l.png"))); // NOI18N
        jButtonPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousPageActionPerformed(evt);
            }
        });

        jButtonNextPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow-r.png"))); // NOI18N
        jButtonNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextPageActionPerformed(evt);
            }
        });

        jLabelCurrentPage.setText("1");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButtonAddFile, org.jdesktop.beansbinding.ELProperty.create("${font}"), jLabelCurrentPage, org.jdesktop.beansbinding.BeanProperty.create("font"));
        bindingGroup.addBinding(binding);

        jButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonPreviousPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNextPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabelCurrentPage))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAddFile)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButtonAddFile)
                .addGap(26, 26, 26)
                .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPreviousPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCurrentPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNextPage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanelSozlukler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSozlukler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu4.setText("Sözlük");

        jMenuItemUpdate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUpdate.setText("Güncelle");
        jMenuItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUpdateActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemUpdate);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemExit.setText("Çıkış");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemExit);

        jMenuBar2.add(jMenu4);

        jMenu1.setText("Hakkında");

        jMenuItemHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHelp.setText("Kullanım Klavuzu");
        jMenu1.add(jMenuItemHelp);

        jMenuItemAboutUs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAboutUs.setText("Hakkımızda");
        jMenuItemAboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutUsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAboutUs);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddFileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddFileMouseEntered
        // TODO add your handling code here:

        buttonIsTransparent(jButtonAddFile, true);
        jButtonAddFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open161.png")));
    }//GEN-LAST:event_jButtonAddFileMouseEntered

    private void jButtonAddFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddFileMouseExited
        buttonIsTransparent(jButtonAddFile, false);
        jButtonAddFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/writing17.png")));
    }//GEN-LAST:event_jButtonAddFileMouseExited
    public void addDict(int selection, File file) {

    }
    private void jButtonAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFileActionPerformed
        if (new YandexTranslator().isInternetReachable()) {
            String[] answersOfSelection = {"Evet online arama yapmak istiyorum", "Hayır daha sonra güncellensin"};
            int selection = JOptionPane.showOptionDialog(this, "İnternet bağlantınız mevcuz. Eğer online arama seçeneğini aktif ederseniz ekleme süresi uzayabilir fakat tüm sözcükler eklenir.", "Online arama aktif edilsin mi?", 0, JOptionPane.INFORMATION_MESSAGE, null, answersOfSelection, null);
            if (selection == 0) {
                DBManager.connector.setIsOnline(true);
            } else if (selection == 1) {
                DBManager.connector.setIsOnline(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "İnternet Bağlantısı Bulunamadı. Bazı sözcükler veri tabanına Türkçe karşılığı boş olarak eklenebilir. Lütfen daha sonra güncelleyin.");
            DBManager.connector.setIsOnline(false);
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Document Files", "doc", "docx", "odt"));
        fileChooser.showOpenDialog(this);

        File files[] = fileChooser.getSelectedFiles();
        String[] answersOfSelection = {"Evet Tüm Metni Eklemek İstiyorum", "Hayır Belirli Sayfaları Eklemek İstiyorum"};
        System.out.println(files.length);
        for (File file : files) {
            int selection = JOptionPane.showOptionDialog(this, file.getName() + " dosyasının tamamını mı eklemek istiyorsunuz ?", "Tüm Belge Mi ?", 0, JOptionPane.INFORMATION_MESSAGE, null, answersOfSelection, null);

            AddDictWorker mySwingWorker = new AddDictWorker();
            mySwingWorker.setFile(file);
            mySwingWorker.setSelection(selection);

            mySwingWorker.start();

            try {
                addDictPanels(1);
                isButtonsMustEnable(Integer.parseInt(jLabelCurrentPage.getText()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButtonAddFileActionPerformed

    private void jButtonNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextPageActionPerformed
        int currentPage = Integer.parseInt(jLabelCurrentPage.getText());
        currentPage++;
        isButtonsMustEnable(currentPage);
        jLabelCurrentPage.setText(String.valueOf(currentPage));
        try {
            addDictPanels(currentPage);
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNextPageActionPerformed

    private void jButtonPreviousPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousPageActionPerformed
        int currentPage = Integer.parseInt(jLabelCurrentPage.getText());
        currentPage--;
        isButtonsMustEnable(currentPage);
        jLabelCurrentPage.setText(String.valueOf(currentPage));
        try {
            addDictPanels(currentPage);
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPreviousPageActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        int page = Integer.parseInt(jLabelCurrentPage.getText());
        isButtonsMustEnable(page);
        try {
            addDictPanels(page);
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            DBManager.connector.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUpdateActionPerformed
        // TODO add your handling code here:
        String[] answersOfSelection = {"Evet", "Hayır"};
        int selection = JOptionPane.showOptionDialog(this, " Güncelleme İşlemini Başlatmak istediğinize eminmisiniz?", "Güncelle", 0, JOptionPane.INFORMATION_MESSAGE, null, answersOfSelection, null);

        if (selection == 0) {
            try {
                HashMap<Integer, String> nullWords = DBManager.connector.getNullWords();
                YandexTranslator translator = new YandexTranslator(nullWords);
                translator.start();
            } catch (SQLException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemUpdateActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        // TODO add your handling code here:
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemAboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutUsActionPerformed
        AboutForm form = new AboutForm();
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);

    }//GEN-LAST:event_jMenuItemAboutUsActionPerformed

    private void buttonIsTransparent(JButton button, boolean sart) {
        button.setOpaque(sart);
        button.setContentAreaFilled(sart);
        button.setContentAreaFilled(sart);
    }

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    private int getMaxPageNumber() throws SQLException {

        double fileNumber = (double) DBManager.connector.getNumberOfFiles();
        if (fileNumber == 0) {
            jButtonPreviousPage.setEnabled(false);
            jButtonNextPage.setEnabled(false);
        }
        return (int) Math.ceil(fileNumber / 6);
    }

    private void isButtonsMustEnable(int currentPage) {

        if (currentPage > 1) {
            jButtonPreviousPage.setEnabled(true);
        }
        try {
            if (currentPage == getMaxPageNumber()) {
                jButtonNextPage.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (currentPage == 1) {
            jButtonPreviousPage.setEnabled(false);
        }
        try {
            if (currentPage < getMaxPageNumber()) {
                jButtonNextPage.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addDictPanels(int page) throws SQLException {
        isButtonsMustEnable(page);
        ArrayList<String> fileNames = DBManager.connector.nameOfFiles(page);

        jPanelSozlukler.removeAll();
        if (fileNames.size() == 0) {
            jPanelSozlukler.repaint();
        }
        for (String fileName : fileNames) {
            final DictPanel panel = new DictPanel();
            panel.setTextJButtonDict(fileName);
            panel.jButtonDeleteDict.addActionListener(new ActionListener() {
                String fileName = panel.jButtonDictOpen.getText();

                @Override
                public void actionPerformed(ActionEvent ae) {
                    String[] answersOfSelection = {"Evet", "Hayır"};
                    int selection = JOptionPane.showOptionDialog(null, fileName + " sözlüğünü kaldırmak istediğinize emin misiniz ?", "Emin misiniz?", 0, JOptionPane.INFORMATION_MESSAGE, null, answersOfSelection, null);
                    if (selection == 0) {
                        try {

                            DBManager.connector.removeDict(fileName);
                            addDictPanels(Integer.parseInt(jLabelCurrentPage.getText()));
                        } catch (SQLException ex) {
                            Logger.getLogger(DictPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        return;
                    }
                }
            });

            jPanelSozlukler.setLayout(new GridLayout(2, 3));
            jPanelSozlukler.add(panel);
            jPanelSozlukler.repaint();
            validate();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddFile;
    private javax.swing.JButton jButtonNextPage;
    private javax.swing.JButton jButtonPreviousPage;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCurrentPage;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItemAboutUs;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemHelp;
    private javax.swing.JMenuItem jMenuItemUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelSozlukler;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
