public abstract class ReplacementAlgorithm
{
	// the number of page faults
	protected int pageFaultCount;
	
	// the number of physical page frame
	protected int pageFrameCount;

	protected String algorithmName;

	protected int[] allPages;

	/**
	 * @param pageFrameCount - the number of physical page frames
	 */
	public ReplacementAlgorithm(int pageFrameCount) {
		if (pageFrameCount < 0)
			throw new IllegalArgumentException();
		
		this.pageFrameCount = pageFrameCount;
		pageFaultCount = 0;
	}

	public void setPageList(int[] allPages) {
		this.allPages = allPages;
	}

	/**
	 * @return - the number of page faults that occurred.
	 */
	public int getPageFaultCount() {
		return pageFaultCount;
	}
	
	/**
	 * @param pageNumber - the page number to be inserted
	 */
	public abstract void insert(int pageNumber); 
}
