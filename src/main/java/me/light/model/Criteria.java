package me.light.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	private int page; // 페이지 번호
	private int perPageNum;  // 한 페이지에 보여줄 게시글 수
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this.page=1; 
		this.perPageNum=10; 
	}

	public int getPageStart() { // #{pageStart}
		return (this.page-1)*this.perPageNum;
	}

	public void setPage(int page) {
		// 주소창에서 쿼리스트링으로 요청시 동작한다. 
		this.page = (this.page <= 0) ? 1 : page; 
	}
	
	public String[] getTypeCollection() { // #{typeCollection}
		return type!=null ? type.split("") : new String[] {};
	}
}
