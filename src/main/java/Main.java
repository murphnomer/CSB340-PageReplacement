import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PageGenerator pg = new PageGenerator();
        ReplacementAlgorithm repl;
        int[] refs;
        for (PageGenerator.Page page : pg.pages) {
            refs = page.getReferenceString();
            System.out.println(page.name + " = " + page.formatRefString());
            for (int i = 3; i < 8; i += 2) {
                repl = new FIFO(i);
                for (int p : refs) {
                    repl.insert(p);
                }
                System.out.println(page.name + " of type " + page.type + " had " + repl.pageFaultCount +
                        " page faults for algorithm " + repl.algorithmName + " with a frame size of " +
                        repl.pageFrameCount + ".");
                repl = new LRU(i);
                for (int p : refs) {
                    repl.insert(p);
                }
                System.out.println(page.name + " of type " + page.type + " had " + repl.pageFaultCount +
                        " page faults for algorithm " + repl.algorithmName + " with a frame size of " +
                        repl.pageFrameCount + ".");
                repl = new OPT(i);
                repl.setPageList(refs);
                for (int p : refs) {
                    repl.insert(p);
                }
                System.out.println(page.name + " of type " + page.type + " had " + repl.pageFaultCount +
                        " page faults for algorithm " + repl.algorithmName + " with a frame size of " +
                        repl.pageFrameCount + ".");
            }
        }
    }
}
