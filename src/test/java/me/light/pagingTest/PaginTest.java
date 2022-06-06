package me.light.pagingTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.light.config.RootConfig;
import me.light.mapper.BoardMapper;
import me.light.model.Board;
import me.light.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class PaginTest {
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void test() {
		Criteria criteria = new Criteria();
		criteria.setType("T");
		criteria.setKeyword("자바");
		List<Board> list = mapper.getList(criteria);
		for(Board b : list) {
			System.out.println(b);
		}
	}
}
