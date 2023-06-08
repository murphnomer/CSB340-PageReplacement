import java.util.LinkedList;
import java.util.Queue;

public class FIFO extends ReplacementAlgorithm { // FIFO will extend ReplacementAlgorithm

    Queue<Integer> frames = new LinkedList<>();

    public FIFO(int pageFrameCount) {
        super(pageFrameCount);
        algorithmName = "FIFO";
    }

    public void insert(int pageNumber) {
        if (!frames.contains(pageNumber)) {
            pageFaultCount++;
            if (frames.size() >= pageFrameCount) {
                frames.remove();
            }
            frames.add(pageNumber);
        }
    }


}
