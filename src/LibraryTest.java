import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {

    private BookFactory bf;
    private ComicFactory cf;
    private PrintedMediaCollection nc;

    @Before
    public void setUp() {
        cf = ComicFactory.getInstance();
        bf = BookFactory.getInstance();

        nc = new PrintedMediaCollection();
    }

    @Test
    public void SingletonTest() {

        ComicFactory cf2 = ComicFactory.getInstance();
        BookFactory bf2 = BookFactory.getInstance();

        boolean CF_result = false;
        if (cf == cf2) {
            CF_result = true;
        }
        assertEquals((boolean) true, (boolean) CF_result);

        boolean BF_result = false;
        if (bf == bf2) {
            BF_result = true;
        }
        assertEquals((boolean) true, (boolean) BF_result);
    }

    @Test
    public void ObserverTest() {

        ListA A = new ListA();
        ListA B = new ListA();
        ListA C = new ListA();
        ListA D = new ListA();

        cf.addObserver(A);
        cf.addObserver(B);
        cf.addObserver(C);
        cf.addObserver(D);

        ListB E = new ListB();
        ListB F = new ListB();
        ListB G = new ListB();

        bf.addObserver(E);
        bf.addObserver(F);
        bf.addObserver(G);

        List<ListUpdater> x = cf.getSubscribers();
        int sizeA = x.size();
        assertEquals((int) 4, (int) sizeA);

        List<ListUpdater> y = bf.getSubscribers();
        int sizeB = y.size();
        assertEquals((int) 3, (int) sizeB);

        cf.removeObserver(A);
        bf.removeObserver(E);

        x = cf.getSubscribers();
        sizeA = x.size();
        assertEquals((int) 3, (int) sizeA);

        y = bf.getSubscribers();
        sizeB = y.size();
        assertEquals((int) 2, (int) sizeB);

    }

    @Test
    public void IteratorTest() {
        int n = nc.catalogueDim();
        assertEquals((int) 4, (int) n);

        PrintedMedia A = cf.createMedia("aa", "aa", "aa");
        PrintedMedia B = bf.createMedia("bb", "bb", "bb");
        PrintedMedia C = cf.createMedia("cc", "cc", "cc");
        PrintedMedia D = bf.createMedia("dd", "dd", "dd");

        nc.addItem(A);
        nc.addItem(B);
        nc.addItem(C);
        nc.addItem(D);

        n = nc.catalogueDim();

        assertEquals((int) 8, (int) n);
    }

}
