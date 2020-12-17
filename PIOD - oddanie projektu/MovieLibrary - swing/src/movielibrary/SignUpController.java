package movielibrary;

import javax.swing.JLabel;

public class SignUpController implements Path {
    JLabel label;
    String userName;
    String password;
    String repeatPassword;
    SaveInFile saveInFile;

    
    public SignUpController() {
        saveInFile = new SaveInFile();
    }

    
    protected void conditionLogin(String userName, String password, 
            String repeatPassword, JLabel label) {
        //-------  PASSWORD MUST HAVE MORE THAN 3 CHARACTERS  -----------------------------------
        if (password.length() > 3) {
            //-------  COMPARISON OF THE PASSWORD AND THE REPEAT PASSWORD  -----------------------------------
            if (password.equals(repeatPassword)) {
                //-------  REMOVE SPACE LIKE SIGNS  -----------------------------------
                if (!userName.trim().isEmpty() && !repeatPassword.trim().isEmpty()) {
                    label.setText("Prawidłowo zarejestrowany.");
                    saveInFile.saveToFile(userName, password, Path.PATH_LOGS,
                            true, 0, 0);
                } else {
                    label.setText("Puste pole!");
                }
            } else {
                label.setText("Hasła nie są zgodne.");
            }
        } else {
            label.setText("Hasło za krótkie min. 4 znaki!");
        }
    }
}
