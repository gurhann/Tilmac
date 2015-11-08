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

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import com.kayra.tilmac.docread.DocRead;

/**
 *
 * @author gurhan
 */
public class AddDictWorker implements Runnable {

    Thread t;
    private int selection;
    private File file;

    protected void doInBackground() throws Exception {
        if (selection == 0) {

            try {
                DocRead readFile = new DocRead(file);
                readFile.addWordstoDB();

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (selection == 1) {
            PageSection pageSection = new PageSection(null, true);
            pageSection.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            pageSection.setVisible(true);
            int[][] sectionOfPages = pageSection.getPageSection();

            try {

                DocRead readFile = new DocRead(file, sectionOfPages);
                readFile.addWordstoDB();
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @wbp.parser.entryPoint
     */
    @Override
    public void run() {
        try {
            doInBackground();
        } catch (Exception ex) {
            Logger.getLogger(AddDictWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @wbp.parser.entryPoint
     */
    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

}
