public class Comic extends PrintedMedia {
    private String title;
    private String author;
    private String genre;

    public Comic(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getGenre() {
        return this.genre;
    }
}

//ConcreteProductA