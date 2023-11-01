package br.com.erudio.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.model.Book;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.unittests.mapper.mocks.MockBook;


class BookServiceTest {
	
	
	MockBook input;
	
	@InjectMocks
	private BookService service;
	
	
	@Mock
	private BookRepository repository;
	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockBook();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Book> entity = input.mockListBook();
		
		when(repository.findAll())
			.thenReturn(entity);
		
		var result = service.findAll();
		
		assertNotNull(result);
		assertEquals(10, result.size());

		
		int number;
		BookVO bookOne = result.get(number = 1);
		assertNotNull(bookOne);
		assertNotNull(bookOne.getKey());
		assertNotNull(bookOne.getLinks());
		assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("title test number" + number, bookOne.getTitle());
		assertEquals("author test number" + number, bookOne.getAuthor());
		assertEquals(new Date(number), bookOne.getLaunchDate());
		assertEquals(number, bookOne.getPrice());
		
		
		BookVO bookFive = result.get(number = 5);
		assertNotNull(bookFive);
		assertNotNull(bookFive.getKey());
		assertNotNull(bookFive.getLinks());
		assertTrue(bookFive.toString().contains("links: [</api/book/v1/5>;rel=\"self\"]"));
		assertEquals("title test number" + number, bookFive.getTitle());
		assertEquals("author test number" + number, bookFive.getAuthor());
		assertEquals(new Date(number), bookFive.getLaunchDate());
		assertEquals(number, bookFive.getPrice());
		
		
		BookVO bookNine = result.get(number = 9);
		assertNotNull(bookNine);
		assertNotNull(bookNine.getKey());
		assertNotNull(bookNine.getLinks());
		assertTrue(bookNine.toString().contains("links: [</api/book/v1/9>;rel=\"self\"]"));
		assertEquals("title test number" + number, bookNine.getTitle());
		assertEquals("author test number" + number, bookNine.getAuthor());
		assertEquals(new Date(number), bookNine.getLaunchDate());
		assertEquals(number, bookNine.getPrice());
		
	}

	@Test
	void testFindById() {
		Book entity = input.mockBook(1);
		
		
		when(repository.findById(1L))
		 .thenReturn(Optional.of(entity));
		
		BookVO result = service.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("title test number1", result.getTitle());
		assertEquals("author test number1", result.getAuthor());
		assertEquals(new Date(1), result.getLaunchDate());
		assertEquals(1, result.getPrice());
	}

	@Test
	void testCreate() {
		
		Book persisted = input.mockBook(1);
		persisted.setId(1L);
		
		when(repository.save(Mockito.any()))
			.thenReturn(persisted);
		
		BookVO vo = input.mockBookVO(1);
		vo.setKey(1L);

		BookVO result = service.create(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("title test number1", result.getTitle());
		assertEquals("author test number1", result.getAuthor());
		assertEquals(new Date(1), result.getLaunchDate());
		assertEquals(1, result.getPrice());
		
	}

	@Test
	void testUpdate() {
		
		Book entity = input.mockBook(1);
		
		when(repository.findById(1L))
			.thenReturn(Optional.of(entity));
		
		Book updated = entity;
		
		when(repository.save(entity))
			.thenReturn(updated);
		
		BookVO vo = input.mockBookVO(1);
		
		BookVO result = service.update(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("title test number1", result.getTitle());
		assertEquals("author test number1", result.getAuthor());
		assertEquals(new Date(1), result.getLaunchDate());
		assertEquals(1, result.getPrice());
		
	}

	@Test
	void testDelete() {
		Book entity = input.mockBook(1);
		
		when(repository.findById(1L))
			.thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}

}
