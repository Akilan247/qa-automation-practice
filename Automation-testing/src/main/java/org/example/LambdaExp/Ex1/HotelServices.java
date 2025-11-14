package org.example.LambdaExp.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HotelServices {
    List<Hotel> hotels = new ArrayList<>();

    public HotelServices(){
        hotels.add(new Hotel(101,2000,HotelType.THREE_STAR));
        hotels.add(new Hotel(102,2000,HotelType.THREE_STAR));
        hotels.add(new Hotel(103,5000,HotelType.FIVE_STAR));
        hotels.add(new Hotel(107,2000,HotelType.THREE_STAR));
        hotels.add(new Hotel(109,5000,HotelType.FIVE_STAR));
    }

    public List<Hotel> filterHotels(Predicate<Hotel> filterCondition){
        List<Hotel> hotelsList = new ArrayList<>();

        for(Hotel hotel : hotels){
            if(filterCondition.test(hotel)){
                hotelsList.add(hotel);
            }
        }
        return hotelsList;
    }

}