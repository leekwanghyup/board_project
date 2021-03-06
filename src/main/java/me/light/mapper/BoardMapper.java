package me.light.mapper;

import java.util.List;

import me.light.model.Board;
import me.light.model.Criteria;

public interface BoardMapper {
	List<Board> getList(Criteria criteria);
	Board get(Long bno);
	void insert(Board board);
	int totalCount(Criteria criteria);
}
