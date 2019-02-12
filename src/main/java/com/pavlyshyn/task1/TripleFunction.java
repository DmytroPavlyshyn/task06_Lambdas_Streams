package com.pavlyshyn.task1;

public interface TripleFunction<S,U,V,R> {
    R apply(S s, U u, V v);
}
