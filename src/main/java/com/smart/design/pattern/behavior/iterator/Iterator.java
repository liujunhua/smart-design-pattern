package com.smart.design.pattern.behavior.iterator;

/**
 *
 */
public interface Iterator {

    boolean hasNext();

    Object next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

}