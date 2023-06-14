import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OPT extends ReplacementAlgorithm { // OPT will extend ReplacementAlgorithm

    LinkedList<Integer> frames = new LinkedList<>();
    int currentIndex;

    public OPT(int pageFrameCount) {
        super(pageFrameCount);
        algorithmName = "OPT";
        currentIndex = 0;
    }

    public void insert(int pageNumber) {
        if (!frames.contains(pageNumber)) {
            pageFaultCount++;
            if (frames.size() >= pageFrameCount) {
                int longestf = frames.peek();
                int longesti = allPages.length;
                int thisi;
                for (Integer f : frames) {
                    thisi = 0;
                    for (int i = currentIndex; i < allPages.length; i++) {
                        if (f.equals(allPages[i])) {
                            thisi = i;
                            if (i > longesti) {
                                longestf = f;
                                longesti = i;
                            }
                        }
                        if (thisi == 0) {
                            longestf = f;
                            longesti = allPages.length;
                        }
                    }
                }
                frames.remove(Integer.valueOf(longestf));
            }
            frames.add(pageNumber);
        }
        currentIndex++;
    }


}
