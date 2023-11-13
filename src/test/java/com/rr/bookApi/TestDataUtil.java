package com.rr.bookApi;

import com.rr.bookApi.domain.entities.AuthorEntity;
import com.rr.bookApi.domain.entities.BookEntity;

public final class TestDataUtil {

    private TestDataUtil(){}

//    public static Author createTestAuthor() {
//        return Author.builder().
//                id(1L)
//                .name("Teresa Rosa")
//                .age(60)
//                .build();
//    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder().
                id(2L)
                .name("Yuval Noah Harari")
                .age(47)
                .build();
    }


    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder().
                id(3L)
                .name("Noam Chomsky")
                .age(94)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder().
                id(4L)
                .name("Paulo Coelho")
                .age(76)
                .build();
    }

//    public static BookEntity createTestBook() {
//        return BookEntity.builder().
//                isbn("978-1-2345-6789-0")
//                .title("The Shadow in the Attic")
//                .authorId(1L)
//                .build();
//    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder().
                isbn("978-1-2345-6789-4")
                .title("Sapiens")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookB(AuthorEntity authorEntity) {
        return BookEntity.builder().
                isbn("978-1-2345-6789-7")
                .title("Who Rules the World?")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(AuthorEntity authorEntity) {
        return BookEntity.builder().
                isbn("978-1-2345-6789-2")
                .title("Zahir")
                .authorEntity(authorEntity)
                .build();
    }
}
