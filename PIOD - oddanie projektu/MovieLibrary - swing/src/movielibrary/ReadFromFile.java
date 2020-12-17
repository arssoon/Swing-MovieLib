package movielibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;

public class ReadFromFile  {
    public boolean successfulLogin;
    String name, password;
    JLabel label;
    ArrayList<Movie> dataList;
    protected JLabel errorLabel;

    public ReadFromFile(String name, String password, JLabel label) {
        this.name = name;
        this.password = password;
        this.label = label;
    }

    public ReadFromFile(ArrayList<Movie> dataList) {
        this.dataList = dataList;
    }

    public void loadFromFile(String file, boolean isPasswordFile) {
        File log = new File(file);
        BufferedReader br;

        if (log.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
                if (isPasswordFile) {
                    successfulLogin = conditionLogin(br);
                    br.close();
                } else {
                    loadDataFromFile(br, dataList);
                    br.close();
                }
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Plik nie istnieje.");
        }
    }

    public void loadDataFromFile(BufferedReader br, ArrayList<Movie> dataList) throws IOException {
        String line;
        //-------  WORDS IN A ROW SEPARATOR  -----------------------------------
        String FieldDelimiter = ", ";

        while ((line = br.readLine()) != null) {
            String[] fields = line.split(FieldDelimiter, -1);

            //-------  LINE SHOWS THE FIRST LINE BUT br.readLine THE NEXT   -----------------------------------
            Movie movie = new Movie(fields[0],
                    Integer.parseInt(fields[1]),
                    fields[2],
                    Double.parseDouble(fields[3])
            );
            //-------  ADDING DATA TO THE ROW   -----------------------------------
            dataList.add(movie);
        }
    }

    public boolean conditionLogin(BufferedReader br) throws IOException {
        String line;
        String FieldDelimiter = ", ";

        while ((line = br.readLine()) != null) {
            String[] fields = line.split(FieldDelimiter, -1);
            //-------  CHECK LOGIN AND PASSWORD   -----------------------------------
            if (name.equals(fields[0]) && password.equals(fields[1])) {
                label.setText("Logowanie powiodło się.");
                return true;
            } else {
                label.setText("Nazwa użytkownika bądź hasło jest nieprawidłowe!");
            }
        }
        return false;
    }

}
