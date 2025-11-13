package org.example.LambdaExp;


@FunctionalInterface
public interface FilterCondition {

    public boolean test(Hotel hotel);

    default boolean hello(){
        return true;
    }
}
