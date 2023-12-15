import java.util.ArrayList;
import java.util.List;

public class ComicFactory implements PrintedMediaFactory, ListManager {

    private List<ListUpdater> ListA = new ArrayList<>();
    private static ComicFactory instance;

    private ComicFactory() {
    }

    public static ComicFactory getInstance() {
        if (instance == null) {
            instance = new ComicFactory();
        }
        return instance;
    }

    public List<ListUpdater> getSubscribers() {
        return ListA;
    }

    @Override
    public PrintedMedia createMedia(String author, String title, String genre) {
        PrintedMedia comic = new Comic(author, title, genre);
        System.out.println(
                "A new " + comic.getGenre() + " volume is out: " + comic.getTitle() + " by " + comic.getAuthor());
        notify(comic);
        return comic;
    }

    @Override
    public void notify(PrintedMedia pm) {
        if (pm instanceof Comic) {
            for (ListUpdater obs : ListA) {
                obs.update(pm);
            }
        }
    }

    @Override
    public void addObserver(ListUpdater obs) {
        ListA.add(obs);
    }

    @Override
    public void removeObserver(ListUpdater obs) {
        ListA.remove(obs);
    }

}
