package movielibrary;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart implements Path {

    ArrayList<Movie> dataList = new ArrayList();
    ArrayList<String> dataString = new ArrayList();
    ReadFromFile readFromFile;
    String str;
    ArrayList<String> categoryMovieList;
    DefaultCategoryDataset dataset;

    public BarChart() {
        readFromFile = new ReadFromFile(dataList);
        readFromFile.loadFromFile(Path.PATH_MOVIES, false);
        dataset = new DefaultCategoryDataset();

        for (Movie tk : dataList) {
            String data = tk.getName() + ", "
                    + String.valueOf(tk.getYear()) + ", "
                    + tk.getCategory() + ", "
                    + String.valueOf(tk.getRate());

            dataString.add(data);
        }
    }

    public JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(null, null, null,
                createDataset(),
                PlotOrientation.HORIZONTAL,
                true, true, false);
        return barChart;
    }

    //-------  ASSIGN MOVIE TO THE CATEGORY  -----------------------------------
    private void addMovieToCategory(List<String> name, List<String> category, List<Double> rating) {
        for (int i = 0; i < name.size(); i++) {
            if (category.get(i).trim().equals(String.valueOf(MovieCategory.AKCJA))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(0), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.ANIMACJA))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(1), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.DRAMAT))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(2), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.HORROR))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(3), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.KOMEDIA))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(4), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.KRYMINALNY))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(5), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.PRZYGODOWY))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(6), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.ROMANTYCZNY))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(7), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.SCIENCE_FICTION))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(8), name.get(i));
            } else if (category.get(i).trim().equals(String.valueOf(MovieCategory.THRILLER))) {
                dataset.addValue(rating.get(i), categoryMovieList.get(9), name.get(i));
            }
        }
    }

    private CategoryDataset createDataset() {
        declareVariablesAxises();

        str = String.valueOf(dataString);

        List<String> name = new LinkedList<>();
        List<Integer> year = new LinkedList<>();
        List<String> category = new LinkedList<>();
        List<Double> rating = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",");

        while (tokenizer.hasMoreTokens()) {
            //-------  'REPLACE' METHOD TO REMOVE FROM START LINE SIGN '[' - WTIHOUT COMPILATION LEVEL ERROR  -----------------------------------
            name.add(tokenizer.nextToken().replace('[', ' '));

            //-------  'TRIM()' METHOD TO THE DELETE SPACE SIGN  - COMPILATION LEVEL ERROR -----------------------------------
            year.add(Integer.parseInt(tokenizer.nextToken().trim()));
            category.add(tokenizer.nextToken());

            //-------  'REPLACE' METHOD TO REMOVE ']' CHARACTER AT THE END - COMPILATION LEVEL ERROR -----------------------------------
            rating.add(Double.parseDouble(tokenizer.nextToken().replace(']', ' ')));
        }
        addMovieToCategory(name, category, rating);
        return dataset;
    }

    // -----    declaration of variables Axis X and Y   ------------------------------------------------------
    private void declareVariablesAxises() {
        //----  GATUNKI FILMÓW
        categoryMovieList = new ArrayList();

        // -----   LOOP WHICH WRITE CATEGORY OF MOVIES TO TABLE   ------------------------------------------------------
        for (MovieCategory movie : MovieCategory.values()) {
            categoryMovieList.add(String.valueOf(movie));
        }
    }

}
