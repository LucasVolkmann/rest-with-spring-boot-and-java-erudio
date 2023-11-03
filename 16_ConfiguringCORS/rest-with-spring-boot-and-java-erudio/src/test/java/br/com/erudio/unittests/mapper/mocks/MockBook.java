package br.com.erudio.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.model.Book;

public class MockBook {
	
	public Book mockBook() {
		return mockBook(0);
	}
	
	public BookVO mockBookVO() {
		return mockBookVO(0);
	}
	
	public List<Book> mockListBook() {
		List<Book> bookList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			bookList.add(mockBook(i));
		}
		return bookList;
	}
	
	public List<BookVO> mockListBookVO() {
		List<BookVO> bookListVO = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			bookListVO.add(mockBookVO(i));
		}
		return bookListVO;
	}
	
	public Book mockBook(Integer number) {
		Book book = new Book();
		book.setId(number.longValue());
		book.setTitle("title test number" + number);
		book.setAuthor("author test number" + number);
		book.setLaunchDate(new Date(number));
		book.setPrice(number.doubleValue());
		return book;
	}
	
	public BookVO mockBookVO(Integer number) {
		BookVO bookVO = new BookVO();
		bookVO.setKey(number.longValue());
		bookVO.setTitle("title test number" + number);
		bookVO.setAuthor("author test number" + number);
		bookVO.setLaunchDate(new Date(number));
		bookVO.setPrice(number.doubleValue());
		return bookVO;
	}

}
