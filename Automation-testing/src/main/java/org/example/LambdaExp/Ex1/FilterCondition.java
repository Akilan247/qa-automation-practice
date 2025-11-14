package org.example.LambdaExp.Ex1;


@FunctionalInterface
public interface FilterCondition {

    public boolean test(Hotel hotel);

    default boolean hello(){
        return true;
    }
}
