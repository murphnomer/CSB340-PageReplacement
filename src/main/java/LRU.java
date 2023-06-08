import java.util.LinkedList;
import java.util.Queue;

public class LRU extends ReplacementAlgorithm { // LRU will extend ReplacementAlgorithm

    LinkedList<Integer> frames = new LinkedList<>();

    public LRU(int pageFrameCount) {
        super(pageFrameCount);
        algorithmName = "LRU";
    }

    public void insert(int pageNumber) {
        if (!frames.contains(pageNumber)) {
            pageFaultCount++;
            if (frames.size() >= pageFrameCount) {
                frames.remove();
            }
            frames.add(pageNumber);
        } else {
            frames.remove(Integer.valueOf(pageNumber));
            frames.add(pageNumber);
        }
    }


}
