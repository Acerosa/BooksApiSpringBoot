package com.rr.bookApi.repositories;

import com.rr.bookApi.TestDataUtil;
import com.rr.bookApi.domain.entities.AuthorEntity;
import com.rr.bookApi.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryImplIntegrationTests {



    private  BookRepository underTest;
    @Autowired
    public BookEntityRepositoryImplIntegrationTests(BookRepository underTest) {

        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreateAndRecalled(){
        AuthorEntity authorEntity1 = TestDataUtil.createTestAuthorA();
        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity1);
        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }

    @Test
    public void testThatMultipleBooksCanBeCreateAndRecalled(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();

        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntityA);
        underTest.save(bookEntityA);

        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();

        BookEntity bookEntityB = TestDataUtil.createTestBookB(authorEntityB);
        underTest.save(bookEntityB);

        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorC();

        BookEntity bookEntityC = TestDataUtil.createTestBookC(authorEntityC);
        underTest.save(bookEntityC);

        Iterable<BookEntity> result = underTest.findAll();

        assertThat(result)
                .hasSize(3)
                .containsExactly(bookEntityA, bookEntityB, bookEntityC);
    }

    @Test
    public void testThatBookCanBeUpdated(){
    AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
    BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntity);
    underTest.save(bookEntityA);
    bookEntityA.setTitle("Updated Title");
    underTest.save(bookEntityA);
    Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(bookEntityA);
    }

    @Test
    public void testThatBookCanBeDeleted(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        BookEntity bookEntityA = TestDataUtil.createTestBookA(authorEntityA);
        underTest.save(bookEntityA);
        underTest.deleteById(bookEntityA.getIsbn());
        Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
        assertThat(result).isEmpty();
    }
}
