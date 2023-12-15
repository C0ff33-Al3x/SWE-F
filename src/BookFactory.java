import java.util.ArrayList;
import java.util.List;

public class BookFactory implements PrintedMediaFactory, ListManager {

    private List<ListUpdater> ListB = new ArrayList<>();

    private static BookFactory instance;

    private BookFactory() {
    }

    public static BookFactory getInstance() {
        if (instance == null) {
            instance = new BookFactory();
        }
        return instance;
    }

    public List<ListUpdater> getSubscribers() {
        return ListB;
    }

    @Override
    public PrintedMedia createMedia(String author, String title, String genre) {
        PrintedMedia book = new Book(author, title, genre);
        System.out
                .println("A new " + book.getGenre() + " volume is out: " + book.getTitle() + " by " + book.getAuthor());
        notify(book);
        return book;
    }

    @Override
    public void notify(PrintedMedia pm) {
        if (pm instanceof Book) {
            for (ListUpdater obs : ListB) {
                obs.update(pm);
            }
        }
    }

    @Override
    public void addObserver(ListUpdater obs) {
        ListB.add(obs);
    }

    @Override
    public void removeObserver(ListUpdater obs) {
        ListB.remove(obs);
    }

}
