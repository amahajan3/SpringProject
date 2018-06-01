package in.codertechnologies.batchSchedule.dto;

public class PaginationDetailsDTO {

	private long totalCount;
	private long pageSize;
	private boolean morePages;
	private long pageNo;
	private String searchTerm;
	
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public boolean isMorePages() {
		return morePages;
	}
	public void setMorePages(boolean morePages) {
		this.morePages = morePages;
	}
	public long getPageNo() {
		return pageNo;
	}
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
}
