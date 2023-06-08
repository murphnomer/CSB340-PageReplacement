import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PageGenerator
{
	Random random = new Random();

	class Page {
		int[] referenceString;
		String type;
		String name;

		Page(int[] refString, String name, String type) {
			this.referenceString = refString;
			this.name = name;
			this.type = type;
		}

		public int[] getReferenceString() {
			return referenceString;
		}
	}

	List<Page> pages;
	public int[] getReferenceString() {

		int[] rStr1 = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		//int[] fStr2 = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
		//int[] rStr3 = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
		return rStr1;
	}

	public int[] generateRandomRefString(int size) {
		return random.ints(size, 0, 10).toArray();
	}

	public PageGenerator() {
		pages = new ArrayList<>();
		pages.add(new Page(new int[] {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1}, "p1", "given"));
		pages.add(new Page(new int[] {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3}, "p2", "given"));
		pages.add(new Page(new int[] {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4}, "p3", "given"));
		for (int i = 1; i <= 3; i++) {
			pages.add(new Page(generateRandomRefString(5 + (5 * i)), "p" + (i * 3 + 1), "random"));
			pages.add(new Page(generateRandomRefString(5 + (5 * i)), "p" + (i * 3 + 2), "random"));
			pages.add(new Page(generateRandomRefString(5 + (5 * i)), "p" + (i * 3 + 3), "random"));
		}
	}
}
