package org.example.LambdaExp;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        HotelServices hotelServices = new HotelServices();



        List<Hotel> threetarHotels = hotelServices.filterHotels(new Predicate() {

            @Override
            public boolean test(Object o) {
                return ((Hotel)o).getHotelType().equals(HotelType.THREE_STAR);
            }

//            @Override
//            public boolean test(Hotel hotel) {
//                return hotel.getHotelType().equals(HotelType.THREE_STAR);
//            }
        });


        List<Hotel> fivestarHotels = hotelServices
                .filterHotels((hotel) ->hotel.getHotelType()
                                                   .equals(HotelType.FIVE_STAR));

        fivestarHotels.forEach(System.out::println);
        threetarHotels.forEach(a-> System.out.println(a));
    }
}
