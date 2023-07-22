package com.geekster.Hotel.Management.System.service;

import com.geekster.Hotel.Management.System.model.HotelRoom;
import com.geekster.Hotel.Management.System.model.Type;
import com.geekster.Hotel.Management.System.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    IRoomRepo roomRepo;

    public String addRoom(HotelRoom room) {
        roomRepo.save(room);
        return "room added successfully..";
    }

    public String addRooms(List<HotelRoom> rooms) {
        roomRepo.saveAll(rooms);
        return "all rooms added";
    }

    public Iterable<HotelRoom> getAllRooms() {
        return roomRepo.findAll();
    }

    public Optional<HotelRoom> getRoomById(Long roomId) {
        return roomRepo.findById(roomId);
    }

    public Iterable<HotelRoom> getRoomsByIds(List<Long> roomIds) {
        return roomRepo.findAllById(roomIds);
    }

    public String updateRoomById(Long roomId, Type type) {
        Optional<HotelRoom> myRoomOpt = roomRepo.findById(roomId);
        HotelRoom myRoom = null;
        if(myRoomOpt.isPresent()){
            myRoom = myRoomOpt.get();
        }else{
            return "id not found..";
        }

        myRoom.setRoomType(type);
        roomRepo.save(myRoom);
        return "room type updated..";
    }

    public boolean checkRoomExists(Long roomId) {
        return roomRepo.existsById(roomId);
    }

    public Long getTotalRooms() {
        return roomRepo.count();
    }

    public String deleteRoomById(Long roomId) {
        roomRepo.deleteById(roomId);
        return "room deleted..";
    }

    public List<HotelRoom> getRoomsByStatus(Boolean status) {
        return roomRepo.findByRoomStatus(status);
    }

    public List<HotelRoom> getRoomsByStatusAndType(Boolean status, Type type) {
        return roomRepo.findByRoomStatusAndRoomType(status,type);
    }

    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(Boolean status, Type type, Double lLimit, Double uLimit) {
        return roomRepo.findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(status,type,lLimit,uLimit);
    }

    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(Type roomType) {
        return roomRepo.findByRoomTypeOrderByRoomPriceDesc(roomType);
    }

    public List<HotelRoom> getBudgetedAcOrNonAC(Type roomType1, Type roomType2, Double lLimit, Double uLimit) {
        return roomRepo.findByRoomTypeAndRoomPriceBetweenOrRoomType(roomType1,lLimit, uLimit,roomType2);
    }
}
