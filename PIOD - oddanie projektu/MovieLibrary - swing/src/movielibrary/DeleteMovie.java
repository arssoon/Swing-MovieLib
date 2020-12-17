package movielibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteMovie {
    // -----    DELETE MOVIE    ------------------------------------------------------
    public void deleteRecordInFile(String lineToRemove) throws IOException {
        File oldFile = new File(Path.PATH_MOVIES);
        File newFile = new File(Path.PATH_MOVIESTEMP);

        BufferedReader reader = new BufferedReader(new FileReader(oldFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            //-------  Trim newline when comparing with lineToRemove  -----------------------------------
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.flush();
        writer.close();
        reader.close();

        //-------  delete old file and replace him newFile about new name file  -----------------------------------
        if (oldFile.exists()) {
            oldFile.delete();
        }
        newFile.renameTo(oldFile);
    }

}
