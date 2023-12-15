class Client
{
    PrintedMediaCollection collection;
 
    public Client(PrintedMediaCollection collection)
    {
        this.collection = collection;
    }
 
    public void printCatalogue()
    {
        Cursor Cursor = collection.createIterator();
        System.out.println("-------Catalogue------");
        while (Cursor.hasNext())
        {
            PrintedMedia n = (PrintedMedia)Cursor.next();
            System.out.println(n.getTitle() +" , "+ n.getAuthor() +" , "+ n.getGenre());
        }
    }

    public void printBooks() {
        Cursor cursor = collection.createIterator();
        System.out.println("-------Book Catalogue------");
        while (cursor.hasNext()) {
            PrintedMedia media = (PrintedMedia) cursor.next();
            if (media instanceof Book) {
                System.out.println(media.getTitle() + " , " + media.getAuthor() + " , " + media.getGenre());
            }
        }
    }

    public void printComics() {
        Cursor cursor = collection.createIterator();
        System.out.println("-------Comic Catalogue------");
        while (cursor.hasNext()) {
            PrintedMedia media = (PrintedMedia) cursor.next();
            if (media instanceof Comic) {
                System.out.println(media.getTitle() + " , " + media.getAuthor() + " , " + media.getGenre());
            }
        }
    }
}
 