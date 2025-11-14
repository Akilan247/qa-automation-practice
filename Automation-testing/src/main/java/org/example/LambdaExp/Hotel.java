package org.example.LambdaExp;

public class Hotel {
    private int id;
    private int price;
    private HotelType hotelType;

    public Hotel(int id,int price, HotelType hotelType){
        this.id = id;
        this.price = price;
        this.hotelType = hotelType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    @Override
    public String toString(){
        return "Hotel Id : " + id +
                " price per night :" + price +
                " Type : " + hotelType;
    }
}
