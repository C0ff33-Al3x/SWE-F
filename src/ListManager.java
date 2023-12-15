public interface ListManager {
    void addObserver(ListUpdater obs);
    void removeObserver(ListUpdater obs);
    void notify(PrintedMedia pm);
}


//Subject