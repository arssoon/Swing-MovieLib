package movielibrary;

public class Movie {
    String nameMovie;
    int yearMovie;
    String categoryMovie;
    double rateMovie;
    
    public Movie(String nameMovie, Integer yearMovie, String categoryMovie, Double rateMovie) {
        this.nameMovie = nameMovie;
        this.yearMovie = yearMovie;
        this.categoryMovie = categoryMovie;
        this.rateMovie = rateMovie;
    }

    public String getName() {
        return nameMovie;
    }

    public void setName(String name) {
        this.nameMovie = name;
    }

    public int getYear() {
        return yearMovie;
    }

    public void setYear(int year) {
        this.yearMovie = year;
    }

    public String getCategory() {
        return categoryMovie;
    }

    public void setCategory(String category) {
        this.categoryMovie = category;
    }

    public double getRate() {
        return rateMovie;
    }

    public void setRate(double rate) {
        this.rateMovie = rate;
    }
}
