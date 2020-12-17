package movielibrary;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;

public class MovieLibrary extends javax.swing.JFrame implements Path {

    protected String userName, password, repeatPassword;
    ArrayList<Movie> dataList = new ArrayList();
    ReadFromFile readFromFile;
    BarChart chart;
    DefaultTableModel model;
    SignUpController sign;
    DeleteMovie deleteMovieClass;
    SaveInFile saveInFile;
    Movie movie;
    String nameMovie, categoryMovie;
    int yearMovie;
    double ratingMovie;

    public MovieLibrary() {
        initComponents();
        addBarChart();
        categoryMovie();

        saveInFile = new SaveInFile();
        deleteMovieClass = new DeleteMovie();
        model = (DefaultTableModel) table.getModel();
        String str = "Proszę o zalogowanie się bądź\n zarejestrowanie. Życzymy miłego dnia.";
        label3.setText("<html><p style=\"text-align:center;\"> " + str + "</p></html>");

        //--------  widoczność paneli
        //----  MAIN MENU  -----------------
        MenuWindow.setVisible(true);
        EmptyWindow.setVisible(true);
        SignupWindow.setVisible(false);
        LoginWindow.setVisible(false);

        //----  MENU LIBRARY  -----------------
        MenuLibraryWindow.setVisible(false);
        AddLibraryWindow.setVisible(false);
        ShowLibraryWindow.setVisible(false);
        DeleteLibraryWindow.setVisible(false);
        RankingLibraryWindow.setVisible(false);

        //-------  wyśrodkowanie tekstu w komórkach w tabeli  ---------------
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < 4; x++) {
            table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
        //---------  CENTER COMBOBOX  -------------------
        ((JLabel) id_yearMovie.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) id_categoryMovie.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) id_deleteElementMovie.getRenderer()).setHorizontalAlignment(JLabel.CENTER);

        //---------  SET MY METHOD PROMPT TEXT  -----------------
        setPromptTextField(id_user, "UŻYTKOWNIK");
        setPromptTextField(id_password, "HASŁO");
        setPromptTextField(id_userSign, "UŻYTKOWNIK");
        setPromptTextField(id_passwordSign, "HASŁO");
        setPromptTextField(id_repeatPasswordSign, "HASŁO");
        setPromptTextField(id_nameMovie, "NAZWA FILMU");

        //---------  SET TO CHANGE HOVER BUTTON  -----------------
        ChangeEffectButton thread = new ChangeEffectButton(id_login, id_signup, id_addMovie, id_showMovie, id_deleteMovie,
                id_rankingMovie);
        thread.start();

    }

    //---------  SET PROMPT TEXT  -----------------   
    private void setPromptTextField(JTextField textField, String promptText) {
        textField.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(promptText)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(promptText);
                }
            }
        }
        );
    }

    //---------  ADD CHART BAR TO PANEL   -----------------   
    void addBarChart() {
        SwingUtilities.invokeLater(() -> {
            chart = new BarChart();
            ChartPanel chartPanel = new ChartPanel(chart.createChart());

            //----- refresh jPanel ------------------
            BarChart.removeAll();

            //---------------------------------------
            BarChart.setLayout(new BorderLayout());
            BarChart.add(chartPanel, BorderLayout.CENTER);
        });
    }

    public void resetLabels() {
        errorLabelSignUp.setText("");
        errorLabel.setText("");
        id_informatonSuccessfulLabel.setText("");
        id_informatonLabelDel.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainWindow = new javax.swing.JPanel();
        leftWindow = new javax.swing.JPanel();
        MenuLibraryWindow = new javax.swing.JPanel();
        labellib = new javax.swing.JLabel();
        labelLib2 = new javax.swing.JLabel();
        id_showMovie = new javax.swing.JButton();
        id_addMovie = new javax.swing.JButton();
        id_deleteMovie = new javax.swing.JButton();
        id_rankingMovie = new javax.swing.JButton();
        MenuWindow = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        id_signup = new javax.swing.JButton();
        id_login = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        rightWindow = new javax.swing.JPanel();
        RankingLibraryWindow = new javax.swing.JPanel();
        labelLogowanie8 = new javax.swing.JLabel();
        separatorUnderLogin8 = new javax.swing.JSeparator();
        BarChart = new javax.swing.JPanel();
        DeleteLibraryWindow = new javax.swing.JPanel();
        labelLogowanie6 = new javax.swing.JLabel();
        separatorUnderLogin6 = new javax.swing.JSeparator();
        id_deleteElementMovie = new javax.swing.JComboBox<>();
        id_deleteButtonMovie = new javax.swing.JButton();
        id_informatonLabelDel = new javax.swing.JLabel();
        AddLibraryWindow = new javax.swing.JPanel();
        labelLogowanie7 = new javax.swing.JLabel();
        separatorUnderLogin7 = new javax.swing.JSeparator();
        VBox = new javax.swing.JPanel();
        id_nameMovie = new javax.swing.JTextField();
        id_yearMovie = new javax.swing.JComboBox<>();
        id_categoryMovie = new javax.swing.JComboBox<>();
        id_rateMovie = new javax.swing.JTextField();
        id_sliderReating = new javax.swing.JSlider();
        id_addMovieButton = new javax.swing.JButton();
        id_informatonSuccessfulLabel = new javax.swing.JLabel();
        ShowLibraryWindow = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        labelLogowanie3 = new javax.swing.JLabel();
        separatorUnderLogin3 = new javax.swing.JSeparator();
        EmptyWindow = new javax.swing.JPanel();
        LoginWindow = new javax.swing.JPanel();
        labelLogowanie = new javax.swing.JLabel();
        separatorUnderLogin = new javax.swing.JSeparator();
        id_password = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        id_showPasswordLogin = new javax.swing.JCheckBox();
        id_user = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        SignupWindow = new javax.swing.JPanel();
        separatorUnderLogin1 = new javax.swing.JSeparator();
        id_passwordSign = new javax.swing.JPasswordField();
        signupButton = new javax.swing.JButton();
        id_showPasswordSign = new javax.swing.JCheckBox();
        id_userSign = new javax.swing.JTextField();
        labelLogowanie1 = new javax.swing.JLabel();
        id_repeatPasswordSign = new javax.swing.JPasswordField();
        id_showRepeatPassword = new javax.swing.JCheckBox();
        errorLabelSignUp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteka filmów");

        MainWindow.setPreferredSize(new java.awt.Dimension(800, 500));
        MainWindow.setVerifyInputWhenFocusTarget(false);
        MainWindow.setLayout(new java.awt.GridBagLayout());

        leftWindow.setPreferredSize(new java.awt.Dimension(259, 500));
        leftWindow.setLayout(new java.awt.CardLayout());

        MenuLibraryWindow.setBackground(new java.awt.Color(54, 57, 75));

        labellib.setFont(new java.awt.Font("Dialog", 1, 23)); // NOI18N
        labellib.setForeground(new java.awt.Color(124, 109, 55));
        labellib.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labellib.setText("ŚWIAT FILMÓW");

        labelLib2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        labelLib2.setForeground(new java.awt.Color(217, 188, 74));
        labelLib2.setText("MOVIEWORLD");

        id_showMovie.setBackground(new java.awt.Color(102, 102, 102));
        id_showMovie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_showMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_showMovie.setText("LISTA FILMÓW");
        id_showMovie.setBorder(null);
        id_showMovie.setPreferredSize(new java.awt.Dimension(245, 63));
        id_showMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_showMovieActionPerformed(evt);
            }
        });

        id_addMovie.setBackground(new java.awt.Color(102, 102, 102));
        id_addMovie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_addMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_addMovie.setText("DODAWANIE FILMU");
        id_addMovie.setBorder(null);
        id_addMovie.setPreferredSize(new java.awt.Dimension(245, 63));
        id_addMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_addMovieActionPerformed(evt);
            }
        });

        id_deleteMovie.setBackground(new java.awt.Color(102, 102, 102));
        id_deleteMovie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_deleteMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_deleteMovie.setText("USUWANIE FILMU");
        id_deleteMovie.setBorder(null);
        id_deleteMovie.setPreferredSize(new java.awt.Dimension(245, 63));
        id_deleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_deleteMovieActionPerformed(evt);
            }
        });

        id_rankingMovie.setBackground(new java.awt.Color(102, 102, 102));
        id_rankingMovie.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_rankingMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_rankingMovie.setText("RANKING FILMÓW");
        id_rankingMovie.setBorder(null);
        id_rankingMovie.setPreferredSize(new java.awt.Dimension(245, 63));
        id_rankingMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_rankingMovieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLibraryWindowLayout = new javax.swing.GroupLayout(MenuLibraryWindow);
        MenuLibraryWindow.setLayout(MenuLibraryWindowLayout);
        MenuLibraryWindowLayout.setHorizontalGroup(
            MenuLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLibraryWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_showMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_addMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_deleteMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_rankingMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuLibraryWindowLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(labellib, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelLib2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLibraryWindowLayout.setVerticalGroup(
            MenuLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLibraryWindowLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labellib, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(labelLib2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(id_showMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_addMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_deleteMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_rankingMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        leftWindow.add(MenuLibraryWindow, "card3");

        MenuWindow.setBackground(new java.awt.Color(54, 57, 75));
        MenuWindow.setMinimumSize(new java.awt.Dimension(263, 500));
        MenuWindow.setPreferredSize(new java.awt.Dimension(263, 500));

        label1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        label1.setForeground(new java.awt.Color(124, 109, 55));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("Witam w świecie filmów");

        label3.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        label3.setForeground(new java.awt.Color(124, 109, 55));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        label2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        label2.setForeground(new java.awt.Color(217, 188, 74));
        label2.setText("MOVIEWORLD");

        id_signup.setBackground(new java.awt.Color(54, 57, 75));
        id_signup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_signup.setForeground(new java.awt.Color(255, 255, 255));
        id_signup.setText("ZAREJESTRUJ SIĘ");
        id_signup.setBorder(null);
        id_signup.setPreferredSize(new java.awt.Dimension(245, 63));
        id_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_signupActionPerformed(evt);
            }
        });

        id_login.setBackground(new java.awt.Color(54, 57, 75));
        id_login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_login.setForeground(new java.awt.Color(255, 255, 255));
        id_login.setText("ZALOGUJ SIĘ");
        id_login.setBorder(null);
        id_login.setBorderPainted(false);
        id_login.setPreferredSize(new java.awt.Dimension(245, 63));
        id_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuWindowLayout = new javax.swing.GroupLayout(MenuWindow);
        MenuWindow.setLayout(MenuWindowLayout);
        MenuWindowLayout.setHorizontalGroup(
            MenuWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuWindowLayout.createSequentialGroup()
                .addGroup(MenuWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuWindowLayout.createSequentialGroup()
                        .addGroup(MenuWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MenuWindowLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MenuWindowLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MenuWindowLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MenuWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MenuWindowLayout.createSequentialGroup()
                                .addGroup(MenuWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        MenuWindowLayout.setVerticalGroup(
            MenuWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuWindowLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(id_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        leftWindow.add(MenuWindow, "card2");

        MainWindow.add(leftWindow, new java.awt.GridBagConstraints());

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");
        jSeparator2.setPreferredSize(new java.awt.Dimension(8, 500));
        MainWindow.add(jSeparator2, new java.awt.GridBagConstraints());

        rightWindow.setPreferredSize(new java.awt.Dimension(533, 500));
        rightWindow.setLayout(new java.awt.CardLayout());

        RankingLibraryWindow.setBackground(new java.awt.Color(34, 57, 75));

        labelLogowanie8.setBackground(new java.awt.Color(255, 255, 255));
        labelLogowanie8.setFont(new java.awt.Font("Century Gothic", 1, 39)); // NOI18N
        labelLogowanie8.setForeground(new java.awt.Color(255, 255, 255));
        labelLogowanie8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogowanie8.setText("RANKING FILMÓW");
        labelLogowanie8.setPreferredSize(new java.awt.Dimension(321, 73));
        labelLogowanie8.setRequestFocusEnabled(false);

        separatorUnderLogin8.setForeground(new java.awt.Color(255, 255, 255));
        separatorUnderLogin8.setPreferredSize(new java.awt.Dimension(283, 10));

        javax.swing.GroupLayout BarChartLayout = new javax.swing.GroupLayout(BarChart);
        BarChart.setLayout(BarChartLayout);
        BarChartLayout.setHorizontalGroup(
            BarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BarChartLayout.setVerticalGroup(
            BarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RankingLibraryWindowLayout = new javax.swing.GroupLayout(RankingLibraryWindow);
        RankingLibraryWindow.setLayout(RankingLibraryWindowLayout);
        RankingLibraryWindowLayout.setHorizontalGroup(
            RankingLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separatorUnderLogin8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RankingLibraryWindowLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(labelLogowanie8, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(RankingLibraryWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        RankingLibraryWindowLayout.setVerticalGroup(
            RankingLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RankingLibraryWindowLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelLogowanie8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorUnderLogin8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        rightWindow.add(RankingLibraryWindow, "card8");

        DeleteLibraryWindow.setBackground(new java.awt.Color(34, 57, 75));

        labelLogowanie6.setBackground(new java.awt.Color(255, 255, 255));
        labelLogowanie6.setFont(new java.awt.Font("Century Gothic", 1, 39)); // NOI18N
        labelLogowanie6.setForeground(new java.awt.Color(255, 255, 255));
        labelLogowanie6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogowanie6.setText("USUWANIE FILMU");
        labelLogowanie6.setPreferredSize(new java.awt.Dimension(321, 73));
        labelLogowanie6.setRequestFocusEnabled(false);

        separatorUnderLogin6.setForeground(new java.awt.Color(255, 255, 255));
        separatorUnderLogin6.setPreferredSize(new java.awt.Dimension(283, 10));

        id_deleteElementMovie.setBackground(new java.awt.Color(34, 57, 75));
        id_deleteElementMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_deleteElementMovie.setMaximumRowCount(10);
        id_deleteElementMovie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FILM DO USUNIĘCIA" }));

        id_deleteButtonMovie.setBackground(new java.awt.Color(51, 128, 51));
        id_deleteButtonMovie.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        id_deleteButtonMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_deleteButtonMovie.setText("USUŃ FILM");
        id_deleteButtonMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_deleteButtonMovieActionPerformed(evt);
            }
        });

        id_informatonLabelDel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        id_informatonLabelDel.setForeground(new java.awt.Color(255, 102, 102));
        id_informatonLabelDel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout DeleteLibraryWindowLayout = new javax.swing.GroupLayout(DeleteLibraryWindow);
        DeleteLibraryWindow.setLayout(DeleteLibraryWindowLayout);
        DeleteLibraryWindowLayout.setHorizontalGroup(
            DeleteLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separatorUnderLogin6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DeleteLibraryWindowLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(labelLogowanie6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteLibraryWindowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DeleteLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteLibraryWindowLayout.createSequentialGroup()
                        .addComponent(id_deleteButtonMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteLibraryWindowLayout.createSequentialGroup()
                        .addGroup(DeleteLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id_informatonLabelDel, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_deleteElementMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))))
        );
        DeleteLibraryWindowLayout.setVerticalGroup(
            DeleteLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteLibraryWindowLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelLogowanie6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorUnderLogin6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_informatonLabelDel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_deleteElementMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(id_deleteButtonMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        rightWindow.add(DeleteLibraryWindow, "card7");

        AddLibraryWindow.setBackground(new java.awt.Color(34, 57, 75));

        labelLogowanie7.setBackground(new java.awt.Color(255, 255, 255));
        labelLogowanie7.setFont(new java.awt.Font("Century Gothic", 1, 39)); // NOI18N
        labelLogowanie7.setForeground(new java.awt.Color(255, 255, 255));
        labelLogowanie7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogowanie7.setText("DODAWANIE FILMU");
        labelLogowanie7.setPreferredSize(new java.awt.Dimension(321, 73));
        labelLogowanie7.setRequestFocusEnabled(false);

        separatorUnderLogin7.setForeground(new java.awt.Color(255, 255, 255));
        separatorUnderLogin7.setPreferredSize(new java.awt.Dimension(283, 10));

        VBox.setBackground(new java.awt.Color(34, 57, 75));
        VBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        VBox.setAlignmentY(10.0F);
        VBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        id_nameMovie.setBackground(new java.awt.Color(34, 57, 75));
        id_nameMovie.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        id_nameMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_nameMovie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_nameMovie.setText("NAZWA FILMU");
        id_nameMovie.setMinimumSize(new java.awt.Dimension(15, 45));
        id_nameMovie.setPreferredSize(new java.awt.Dimension(252, 45));

        id_yearMovie.setBackground(new java.awt.Color(34, 57, 75));
        id_yearMovie.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        id_yearMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_yearMovie.setMaximumRowCount(10);
        id_yearMovie.setPreferredSize(new java.awt.Dimension(252, 45));

        id_categoryMovie.setBackground(new java.awt.Color(34, 57, 75));
        id_categoryMovie.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        id_categoryMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_categoryMovie.setMaximumRowCount(10);
        id_categoryMovie.setPreferredSize(new java.awt.Dimension(252, 45));

        id_rateMovie.setEditable(false);
        id_rateMovie.setBackground(new java.awt.Color(34, 57, 75));
        id_rateMovie.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        id_rateMovie.setForeground(new java.awt.Color(255, 255, 255));
        id_rateMovie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_rateMovie.setText("5");
        id_rateMovie.setPreferredSize(new java.awt.Dimension(252, 45));

        id_sliderReating.setBackground(new java.awt.Color(34, 57, 75));
        id_sliderReating.setForeground(new java.awt.Color(255, 255, 255));
        id_sliderReating.setMajorTickSpacing(1);
        id_sliderReating.setMaximum(10);
        id_sliderReating.setMinorTickSpacing(1);
        id_sliderReating.setPaintLabels(true);
        id_sliderReating.setPaintTicks(true);
        id_sliderReating.setSnapToTicks(true);
        id_sliderReating.setValue(5);
        id_sliderReating.setPreferredSize(new java.awt.Dimension(252, 45));

        id_addMovieButton.setBackground(new java.awt.Color(51, 128, 51));
        id_addMovieButton.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        id_addMovieButton.setForeground(new java.awt.Color(255, 255, 255));
        id_addMovieButton.setText("DODAJ FILM");
        id_addMovieButton.setMaximumSize(new java.awt.Dimension(329, 32));
        id_addMovieButton.setPreferredSize(new java.awt.Dimension(252, 45));
        id_addMovieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_addMovieButtonActionPerformed(evt);
            }
        });

        id_informatonSuccessfulLabel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        id_informatonSuccessfulLabel.setForeground(new java.awt.Color(255, 102, 102));
        id_informatonSuccessfulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout VBoxLayout = new javax.swing.GroupLayout(VBox);
        VBox.setLayout(VBoxLayout);
        VBoxLayout.setHorizontalGroup(
            VBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VBoxLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(VBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_informatonSuccessfulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(id_yearMovie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_nameMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_categoryMovie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_rateMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_sliderReating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_addMovieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        VBoxLayout.setVerticalGroup(
            VBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VBoxLayout.createSequentialGroup()
                .addComponent(id_informatonSuccessfulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(id_nameMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_yearMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(id_categoryMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(id_rateMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(id_sliderReating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(id_addMovieButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddLibraryWindowLayout = new javax.swing.GroupLayout(AddLibraryWindow);
        AddLibraryWindow.setLayout(AddLibraryWindowLayout);
        AddLibraryWindowLayout.setHorizontalGroup(
            AddLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separatorUnderLogin7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AddLibraryWindowLayout.createSequentialGroup()
                .addGroup(AddLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddLibraryWindowLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(labelLogowanie7, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddLibraryWindowLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(VBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        AddLibraryWindowLayout.setVerticalGroup(
            AddLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddLibraryWindowLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelLogowanie7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorUnderLogin7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rightWindow.add(AddLibraryWindow, "card6");

        ShowLibraryWindow.setBackground(new java.awt.Color(34, 57, 75));

        table.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAZWA", "ROK", "GATUNEK", "OCENA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(140);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(50);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        labelLogowanie3.setBackground(new java.awt.Color(255, 255, 255));
        labelLogowanie3.setFont(new java.awt.Font("Century Gothic", 1, 39)); // NOI18N
        labelLogowanie3.setForeground(new java.awt.Color(255, 255, 255));
        labelLogowanie3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogowanie3.setText("GALERIA FILMÓW");
        labelLogowanie3.setPreferredSize(new java.awt.Dimension(321, 73));
        labelLogowanie3.setRequestFocusEnabled(false);

        separatorUnderLogin3.setForeground(new java.awt.Color(255, 255, 255));
        separatorUnderLogin3.setPreferredSize(new java.awt.Dimension(283, 10));

        javax.swing.GroupLayout ShowLibraryWindowLayout = new javax.swing.GroupLayout(ShowLibraryWindow);
        ShowLibraryWindow.setLayout(ShowLibraryWindowLayout);
        ShowLibraryWindowLayout.setHorizontalGroup(
            ShowLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separatorUnderLogin3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ShowLibraryWindowLayout.createSequentialGroup()
                .addGroup(ShowLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShowLibraryWindowLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ShowLibraryWindowLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(labelLogowanie3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        ShowLibraryWindowLayout.setVerticalGroup(
            ShowLibraryWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShowLibraryWindowLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelLogowanie3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorUnderLogin3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        rightWindow.add(ShowLibraryWindow, "card5");

        EmptyWindow.setBackground(new java.awt.Color(34, 57, 75));

        javax.swing.GroupLayout EmptyWindowLayout = new javax.swing.GroupLayout(EmptyWindow);
        EmptyWindow.setLayout(EmptyWindowLayout);
        EmptyWindowLayout.setHorizontalGroup(
            EmptyWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        EmptyWindowLayout.setVerticalGroup(
            EmptyWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        rightWindow.add(EmptyWindow, "card4");

        LoginWindow.setBackground(new java.awt.Color(34, 57, 75));

        labelLogowanie.setBackground(new java.awt.Color(255, 255, 255));
        labelLogowanie.setFont(new java.awt.Font("Century Gothic", 1, 39)); // NOI18N
        labelLogowanie.setForeground(new java.awt.Color(255, 255, 255));
        labelLogowanie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogowanie.setText("LOGOWANIE");
        labelLogowanie.setPreferredSize(new java.awt.Dimension(321, 73));
        labelLogowanie.setRequestFocusEnabled(false);

        separatorUnderLogin.setForeground(new java.awt.Color(255, 255, 255));
        separatorUnderLogin.setPreferredSize(new java.awt.Dimension(283, 10));

        id_password.setBackground(new java.awt.Color(34, 57, 75));
        id_password.setForeground(new java.awt.Color(255, 255, 255));
        id_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_password.setText("HASŁO");
        id_password.setToolTipText("");
        id_password.setActionCommand("<Not Set>");
        id_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        id_password.setOpaque(false);

        loginButton.setBackground(new java.awt.Color(51, 128, 51));
        loginButton.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("ZALOGUJ");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        id_showPasswordLogin.setBackground(new java.awt.Color(34, 57, 75));
        id_showPasswordLogin.setForeground(new java.awt.Color(255, 255, 255));
        id_showPasswordLogin.setText("Pokaż hasło");
        id_showPasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_showPasswordLoginActionPerformed(evt);
            }
        });

        id_user.setBackground(new java.awt.Color(34, 57, 75));
        id_user.setForeground(new java.awt.Color(255, 255, 255));
        id_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_user.setText("UŻYTKOWNIK");
        id_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        errorLabel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 102, 102));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LoginWindowLayout = new javax.swing.GroupLayout(LoginWindow);
        LoginWindow.setLayout(LoginWindowLayout);
        LoginWindowLayout.setHorizontalGroup(
            LoginWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginWindowLayout.createSequentialGroup()
                .addGroup(LoginWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginWindowLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(labelLogowanie, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginWindowLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(separatorUnderLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginWindowLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(LoginWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_user)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(id_password)
                            .addComponent(errorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_showPasswordLogin)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        LoginWindowLayout.setVerticalGroup(
            LoginWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginWindowLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(labelLogowanie, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(separatorUnderLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_user, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(LoginWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_password, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_showPasswordLogin))
                .addGap(25, 25, 25)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        rightWindow.add(LoginWindow, "card2");

        SignupWindow.setBackground(new java.awt.Color(34, 57, 75));

        separatorUnderLogin1.setForeground(new java.awt.Color(255, 255, 255));
        separatorUnderLogin1.setPreferredSize(new java.awt.Dimension(283, 10));

        id_passwordSign.setBackground(new java.awt.Color(34, 57, 75));
        id_passwordSign.setForeground(new java.awt.Color(255, 255, 255));
        id_passwordSign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_passwordSign.setText("HASŁO");
        id_passwordSign.setToolTipText("");
        id_passwordSign.setActionCommand("<Not Set>");
        id_passwordSign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        id_passwordSign.setOpaque(false);

        signupButton.setBackground(new java.awt.Color(51, 128, 51));
        signupButton.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        signupButton.setForeground(new java.awt.Color(255, 255, 255));
        signupButton.setText("ZAREJESTRUJ");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        id_showPasswordSign.setBackground(new java.awt.Color(34, 57, 75));
        id_showPasswordSign.setForeground(new java.awt.Color(255, 255, 255));
        id_showPasswordSign.setText("Pokaż hasło");
        id_showPasswordSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_showPasswordSignActionPerformed(evt);
            }
        });

        id_userSign.setBackground(new java.awt.Color(34, 57, 75));
        id_userSign.setForeground(new java.awt.Color(255, 255, 255));
        id_userSign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_userSign.setText("UŻYTKOWNIK");
        id_userSign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        labelLogowanie1.setBackground(new java.awt.Color(255, 255, 255));
        labelLogowanie1.setFont(new java.awt.Font("Century Gothic", 1, 39)); // NOI18N
        labelLogowanie1.setForeground(new java.awt.Color(255, 255, 255));
        labelLogowanie1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogowanie1.setText("ZAREJESTRUJ SIĘ");
        labelLogowanie1.setPreferredSize(new java.awt.Dimension(321, 73));
        labelLogowanie1.setRequestFocusEnabled(false);

        id_repeatPasswordSign.setBackground(new java.awt.Color(34, 57, 75));
        id_repeatPasswordSign.setForeground(new java.awt.Color(255, 255, 255));
        id_repeatPasswordSign.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_repeatPasswordSign.setText("HASŁO");
        id_repeatPasswordSign.setToolTipText("");
        id_repeatPasswordSign.setActionCommand("<Not Set>");
        id_repeatPasswordSign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        id_repeatPasswordSign.setOpaque(false);

        id_showRepeatPassword.setBackground(new java.awt.Color(34, 57, 75));
        id_showRepeatPassword.setForeground(new java.awt.Color(255, 255, 255));
        id_showRepeatPassword.setText("Pokaż hasło");
        id_showRepeatPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_showRepeatPasswordActionPerformed(evt);
            }
        });

        errorLabelSignUp.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        errorLabelSignUp.setForeground(new java.awt.Color(255, 102, 102));
        errorLabelSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout SignupWindowLayout = new javax.swing.GroupLayout(SignupWindow);
        SignupWindow.setLayout(SignupWindowLayout);
        SignupWindowLayout.setHorizontalGroup(
            SignupWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignupWindowLayout.createSequentialGroup()
                .addGroup(SignupWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SignupWindowLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(separatorUnderLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SignupWindowLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(labelLogowanie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SignupWindowLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(SignupWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorLabelSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(id_userSign)
                            .addComponent(signupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(id_passwordSign)
                            .addComponent(id_repeatPasswordSign))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SignupWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_showPasswordSign)
                            .addComponent(id_showRepeatPassword))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        SignupWindowLayout.setVerticalGroup(
            SignupWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignupWindowLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(labelLogowanie1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(separatorUnderLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_userSign, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(SignupWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_passwordSign, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_showPasswordSign))
                .addGap(25, 25, 25)
                .addGroup(SignupWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_repeatPasswordSign, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_showRepeatPassword))
                .addGap(25, 25, 25)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        rightWindow.add(SignupWindow, "card3");

        MainWindow.add(rightWindow, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_signupActionPerformed

        resetLabels();
        //----  MAIN MENU  -----------------
        SignupWindow.setVisible(true);
        EmptyWindow.setVisible(false);
        LoginWindow.setVisible(false);
    }//GEN-LAST:event_id_signupActionPerformed

    private void id_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_loginActionPerformed
        resetLabels();
        LoginWindow.setVisible(true);
        EmptyWindow.setVisible(false);
        SignupWindow.setVisible(false);

    }//GEN-LAST:event_id_loginActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        userName = id_user.getText();
        password = String.valueOf(id_password.getPassword());
        readFromFile = new ReadFromFile(userName, password, errorLabel);
        readFromFile.loadFromFile(Path.PATH_LOGS, true);

        //-------  if login is successful, a different window will appear  -----------------------------------
        if (readFromFile.successfulLogin) {
            //----  MAIN MENU  -----------------
            MenuWindow.setVisible(false);
            LoginWindow.setVisible(false);

            //----  MENU LIBRARY  -----------------
            MenuLibraryWindow.setVisible(true);
            ShowLibraryWindow.setVisible(true);
            AddLibraryWindow.setVisible(false);
            DeleteLibraryWindow.setVisible(false);
            RankingLibraryWindow.setVisible(false);
            addDataToTable();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void id_showPasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_showPasswordLoginActionPerformed
        if (id_showPasswordLogin.isSelected()) {
            id_password.setEchoChar((char) 0);
        } else {
            id_password.setEchoChar('*');
        }
    }//GEN-LAST:event_id_showPasswordLoginActionPerformed

    private void id_showPasswordSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_showPasswordSignActionPerformed
        if (id_showPasswordSign.isSelected()) {
            id_passwordSign.setEchoChar((char) 0);
        } else {
            id_passwordSign.setEchoChar('*');
        }
    }//GEN-LAST:event_id_showPasswordSignActionPerformed

    private void id_showRepeatPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_showRepeatPasswordActionPerformed
        if (id_showRepeatPassword.isSelected()) {
            id_repeatPasswordSign.setEchoChar((char) 0);
        } else {
            id_repeatPasswordSign.setEchoChar('*');
        }
    }//GEN-LAST:event_id_showRepeatPasswordActionPerformed

    private void id_showMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_showMovieActionPerformed
        //----  MENU LIBRARY  -----------------
        ShowLibraryWindow.setVisible(true);
        AddLibraryWindow.setVisible(false);
        DeleteLibraryWindow.setVisible(false);
        RankingLibraryWindow.setVisible(false);

        addDataToTable();
    }//GEN-LAST:event_id_showMovieActionPerformed

    private void addDataToTable() {
        model.getDataVector().removeAllElements();
        dataList.clear();
        readFromFile = new ReadFromFile(dataList);
        readFromFile.loadFromFile(Path.PATH_MOVIES, false);
        for (Movie tk : dataList) {
            Object data[] = {tk.getName(),
                tk.getYear(),
                tk.getCategory(),
                tk.getRate()
            };
            model.addRow(data);
        }
    }

    private void id_addMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_addMovieActionPerformed
        resetLabels();
        //----  MENU LIBRARY  -----------------
        ShowLibraryWindow.setVisible(false);
        AddLibraryWindow.setVisible(true);
        DeleteLibraryWindow.setVisible(false);
        RankingLibraryWindow.setVisible(false);
    }//GEN-LAST:event_id_addMovieActionPerformed

    private void id_deleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_deleteMovieActionPerformed
        resetLabels();
        //----  MENU LIBRARY  -----------------
        ShowLibraryWindow.setVisible(false);
        AddLibraryWindow.setVisible(false);
        DeleteLibraryWindow.setVisible(true);
        RankingLibraryWindow.setVisible(false);

        // ----------  usuwanie wszystkich elementów z Combobox
        id_deleteElementMovie.removeAllItems();

        // ----------  dodawanie elementów
        for (Movie tk : dataList) {
            String data = tk.getName() + ", "
                    + String.valueOf(tk.getYear()) + ", "
                    + tk.getCategory() + ", "
                    + String.valueOf(tk.getRate());

            id_deleteElementMovie.addItem(data);

        }

    }//GEN-LAST:event_id_deleteMovieActionPerformed

    private void id_rankingMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_rankingMovieActionPerformed
        //----  MENU LIBRARY  -----------------
        ShowLibraryWindow.setVisible(false);
        AddLibraryWindow.setVisible(false);
        DeleteLibraryWindow.setVisible(false);
        RankingLibraryWindow.setVisible(true);

        addBarChart();
    }//GEN-LAST:event_id_rankingMovieActionPerformed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        userName = id_userSign.getText();
        password = String.valueOf(id_passwordSign.getPassword());
        repeatPassword = String.valueOf(id_repeatPasswordSign.getPassword());

        sign = new SignUpController();
        sign.conditionLogin(userName, password, repeatPassword, errorLabelSignUp);
    }//GEN-LAST:event_signupButtonActionPerformed

    private void id_deleteButtonMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_deleteButtonMovieActionPerformed
        try {
            deleteMovieClass.deleteRecordInFile(id_deleteElementMovie.getSelectedItem().toString());
            String str = "Usunięcie filmu " + id_deleteElementMovie.getSelectedItem()
                    + " zakończyło się powodzeniem.";
            id_informatonLabelDel.setText("<html><p style=\"text-align:center;\"> " + str + "</p></html>");
        } catch (IOException ex) {
            String str = "Usunięcie filmu zakończyło się NIEPOWODZENIEM!";
            id_informatonLabelDel.setText("<html><p style=\"text-align:center;\"> " + str + "</p></html>");
        }
        addDataToTable();
    }//GEN-LAST:event_id_deleteButtonMovieActionPerformed

    private void id_addMovieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_addMovieButtonActionPerformed
        try {
            addMovie();
        } catch (ParseException ex) {
            Logger.getLogger(MovieLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_id_addMovieButtonActionPerformed

    //---------  ADD CATEGORY MOVIE TO COMBOBOX  -----------------   
    public void categoryMovie() {
        // Listen for changes in the text
        id_sliderReating.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                id_rateMovie.setText(String.valueOf(id_sliderReating.getValue()));
            }
        });

        id_categoryMovie.addItem(String.valueOf(MovieCategory.AKCJA));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.ANIMACJA));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.DRAMAT));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.HORROR));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.KOMEDIA));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.KRYMINALNY));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.PRZYGODOWY));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.ROMANTYCZNY));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.SCIENCE_FICTION));
        id_categoryMovie.addItem(String.valueOf(MovieCategory.THRILLER));

        for (int year = 2020; year >= 1980; year--) {
            id_yearMovie.addItem(String.valueOf(year));
        }
    }

    //---------  SAVE MOVIE IN FILE TXT  -----------------   
    public void addMovie() throws ParseException {
        nameMovie = id_nameMovie.getText();
        yearMovie = Integer.parseInt((String) id_yearMovie.getSelectedItem());
        categoryMovie = id_categoryMovie.getSelectedItem().toString();
        formatNumber();

        saveInFile.saveToFile(nameMovie, categoryMovie, Path.PATH_MOVIES,
                false, yearMovie, ratingMovie
        );
        movie = new Movie(nameMovie, yearMovie, categoryMovie, ratingMovie);

        id_informatonSuccessfulLabel.setText("Prawidłowo dodano film do biblioteki");
    }

    private void formatNumber() throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(String.valueOf(id_rateMovie.getText()));
        ratingMovie = number.doubleValue();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new MovieLibrary().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddLibraryWindow;
    private javax.swing.JPanel BarChart;
    private javax.swing.JPanel DeleteLibraryWindow;
    private javax.swing.JPanel EmptyWindow;
    private javax.swing.JPanel LoginWindow;
    private javax.swing.JPanel MainWindow;
    private javax.swing.JPanel MenuLibraryWindow;
    private javax.swing.JPanel MenuWindow;
    private javax.swing.JPanel RankingLibraryWindow;
    private javax.swing.JPanel ShowLibraryWindow;
    private javax.swing.JPanel SignupWindow;
    private javax.swing.JPanel VBox;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel errorLabelSignUp;
    private javax.swing.JButton id_addMovie;
    private javax.swing.JButton id_addMovieButton;
    private javax.swing.JComboBox<String> id_categoryMovie;
    private javax.swing.JButton id_deleteButtonMovie;
    private javax.swing.JComboBox<String> id_deleteElementMovie;
    private javax.swing.JButton id_deleteMovie;
    private javax.swing.JLabel id_informatonLabelDel;
    private javax.swing.JLabel id_informatonSuccessfulLabel;
    private javax.swing.JButton id_login;
    private javax.swing.JTextField id_nameMovie;
    private javax.swing.JPasswordField id_password;
    private javax.swing.JPasswordField id_passwordSign;
    private javax.swing.JButton id_rankingMovie;
    private javax.swing.JTextField id_rateMovie;
    private javax.swing.JPasswordField id_repeatPasswordSign;
    private javax.swing.JButton id_showMovie;
    private javax.swing.JCheckBox id_showPasswordLogin;
    private javax.swing.JCheckBox id_showPasswordSign;
    private javax.swing.JCheckBox id_showRepeatPassword;
    private javax.swing.JButton id_signup;
    private javax.swing.JSlider id_sliderReating;
    private javax.swing.JTextField id_user;
    private javax.swing.JTextField id_userSign;
    private javax.swing.JComboBox<String> id_yearMovie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel labelLib2;
    private javax.swing.JLabel labelLogowanie;
    private javax.swing.JLabel labelLogowanie1;
    private javax.swing.JLabel labelLogowanie3;
    private javax.swing.JLabel labelLogowanie6;
    private javax.swing.JLabel labelLogowanie7;
    private javax.swing.JLabel labelLogowanie8;
    private javax.swing.JLabel labellib;
    private javax.swing.JPanel leftWindow;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel rightWindow;
    private javax.swing.JSeparator separatorUnderLogin;
    private javax.swing.JSeparator separatorUnderLogin1;
    private javax.swing.JSeparator separatorUnderLogin3;
    private javax.swing.JSeparator separatorUnderLogin6;
    private javax.swing.JSeparator separatorUnderLogin7;
    private javax.swing.JSeparator separatorUnderLogin8;
    private javax.swing.JButton signupButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
