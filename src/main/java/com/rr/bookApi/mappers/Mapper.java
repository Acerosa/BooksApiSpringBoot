package com.rr.bookApi.mappers;

public interface Mapper <A, B>{
    B mapTo(A a);
    A mapFrom(B a);
}
