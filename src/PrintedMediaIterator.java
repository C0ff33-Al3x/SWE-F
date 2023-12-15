class PrintedMediaIterator implements Cursor
{
    PrintedMedia[] catalogue;
    int pos = 0;

    public  PrintedMediaIterator (PrintedMedia[] catalogue)
    {
        this.catalogue = catalogue;
    }
 
    
    
    public PrintedMedia next()
    {
        PrintedMedia pm =  catalogue[pos];
        pos += 1;
        return pm;
    }
 
   
    public boolean hasNext()
    {
        if (pos >= catalogue.length ||
            catalogue[pos] == null)
            return false;
        else
            return true;
    }
}