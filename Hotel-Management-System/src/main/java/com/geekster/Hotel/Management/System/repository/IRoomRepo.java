package com.geekster.Hotel.Management.System.repository;

import com.geekster.Hotel.Management.System.model.HotelRoom;
import com.geekster.Hotel.Management.System.model.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRoomRepo extends CrudRepository<HotelRoom,Long> {

    List<HotelRoom> findByRoomStatus(Boolean status);

    List<HotelRoom> findByRoomStatusAndRoomType(Boolean status, Type type);

    List<HotelRoom> findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(Boolean status, Type type, Double lLimit, Double uLimit);

    List<HotelRoom> findByRoomTypeOrderByRoomPriceDesc(Type roomType);

    List<HotelRoom> findByRoomTypeAndRoomPriceBetweenOrRoomType(Type roomType1, Double lLimit, Double uLimit, Type roomType2);
}
