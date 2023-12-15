public class Main {
    public static void main(String[] args) {

        // Singleton Tests
        ComicFactory cf = ComicFactory.getInstance();
        BookFactory bf = BookFactory.getInstance();

        ComicFactory cf2 = ComicFactory.getInstance();
        BookFactory bf2 = BookFactory.getInstance();

        System.out.println(cf2 == cf); // Should print "true"
        System.out.println(bf2 == bf); // Should print "true"

        // Observer Test
        ListA groupA = new ListA();
        ListB groupB = new ListB();

        cf.addObserver(groupA);
        bf.addObserver(groupB);

        PrintedMedia comic = cf.createMedia("Tomie", "Junji Ito", "Horror");
        PrintedMedia book = bf.createMedia("The secret History", "Donna Tartt", "Mystery");

        cf.removeObserver(groupA);
        bf.removeObserver(groupB);

        PrintedMedia comic2 = cf.createMedia("Soul Eater", "Atsushi Ohkubo", "Fantasy");
        PrintedMedia book2 = bf.createMedia("The bell Jar", "Sylvia Plath", "Novel");

        // Iterator Test
        PrintedMediaCollection nc = new PrintedMediaCollection();
        nc.addItem(comic);
        nc.addItem(book);
        nc.addItem(comic2);
        nc.addItem(book2);
        Client nb = new Client(nc);
        nb.printCatalogue();
        nb.printComics();
        nb.printBooks();

    }
}