package com.groundgurus.lastmodified;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileChangeLastModifiedTimeApp {
    private static final Logger log = Logger.getLogger(FileChangeLastModifiedTimeApp.class.getName());

    public static void main(String[] args) {
        String filePath = System.getProperty("user.home") + File.separator + "myfile.txt";
        File myFile = new File(filePath);

        // Create the file if it doesn't exists
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }

        // set to next two months
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 2);
        myFile.setLastModified(cal.getTimeInMillis());

        log.info("Last Modified (After): " + new Date(myFile.lastModified()));
    }
}
