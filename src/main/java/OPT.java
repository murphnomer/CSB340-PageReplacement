import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OPT extends ReplacementAlgorithm { // OPT will extend ReplacementAlgorithm

    LinkedList<Integer> frames = new LinkedList<>();
    int[] allPages;
    int currentIndex;

    public OPT(int pageFrameCount) {
        super(pageFrameCount);
        algorithmName = "OPT";
        currentIndex = 0;
    }

    public void setPageList(int[] allPages) {
        this.allPages = allPages;
    }

    public void insert(int pageNumber) {
        if (!frames.contains(pageNumber)) {
            pageFaultCount++;
            if (frames.size() >= pageFrameCount) {
                int longestf = allPages.length;
                int longesti = allPages.length;
                for (Integer f : frames) {
                    for (int i = currentIndex; i < allPages.length; i++) {
                        if (f.equals(allPages[i])) {
                            longesti = i;
                            longestf = f;
                        }
                    }
                }
                if (longestf < allPages.length) {
                    frames.remove(Integer.valueOf(longestf));
                } else {
                    frames.remove();
                }
            }
            frames.add(pageNumber);
        }
        currentIndex++;
    }


}
