
class PrintedMediaCollection implements Collection {
    static final int MAX_ITEMS = 100;
    int numberOfItems = 0;
    PrintedMedia[] catalogue;

    public PrintedMediaCollection() {
        catalogue = new PrintedMedia[MAX_ITEMS];

        // Add some Dummy Printed Medias
        Book book1 = new Book("Crime and Punishment", "Fedor Dostoevskij", "Novel");
        Comic comic1 = new Comic("RatMan", "Leo Ortolani", "Comedy");
        Comic comic2 = new Comic("SpiderMan", "Marvel", "Fiction");
        Book book2 = new Book("Dracula", "Bram Stoker", "Horror");
        addItem(book1);
        addItem(comic1);
        addItem(comic2);
        addItem(book2);
    }

    public int catalogueDim() {
        return numberOfItems;
    }

    public void addItem(PrintedMedia pm) {
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else {
            catalogue[numberOfItems] = pm;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Cursor createIterator() {
        return new PrintedMediaIterator(catalogue);
    }
}
