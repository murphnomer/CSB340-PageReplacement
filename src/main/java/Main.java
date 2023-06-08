import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PageGenerator pg = new PageGenerator();
        OPT repl;
        int[] refs;
        for (PageGenerator.Page page : pg.pages) {
            refs = page.getReferenceString();
            for (int i = 3; i < 8; i += 2) {
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
