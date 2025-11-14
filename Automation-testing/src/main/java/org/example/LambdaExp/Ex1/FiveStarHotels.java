package org.example.LambdaExp.Ex1;

public class FiveStarHotels implements FilterCondition{
    @Override
    public boolean test(Hotel hotel) {
        return hotel.getHotelType().equals(HotelType.FIVE_STAR);
    }
}
