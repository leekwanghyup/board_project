package me.light.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageMarker {
	private Criteria criteria;
	private int totalCount; 
	private int startPage; 
	private int endPage; 
	private int tempEndPage; 
	private boolean prev; 
	private boolean next;
	private int displayPageNum = 10; 
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount; 
		calcDate(); 
	}

	private void calcDate() {
		endPage = (int) Math.ceil(criteria.getPage() / (double)displayPageNum) * displayPageNum;
		startPage = endPage - displayPageNum + 1;
		tempEndPage = (int)(Math.ceil(totalCount / (double)criteria.getPerPageNum()) );
		if(endPage>tempEndPage) endPage = tempEndPage; 
		prev = startPage != 1;  
		next = this.endPage < tempEndPage; 
	}
}
