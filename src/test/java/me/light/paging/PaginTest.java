package me.light.paging;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.light.config.RootConfig;
import me.light.mapper.BoardMapper;
import me.light.model.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class PaginTest {
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void dataInsert() {
		Board board = new Board();
		for (int i = 1; i <= 412; i++) {
			board.setTitle("제목 : 자바 페이징 처리" + i);
			board.setContent("내용 : 자바 페이징 처리" + i);
			board.setWriter("테스터"+i);
			mapper.insert(board);
		}
	}
}
