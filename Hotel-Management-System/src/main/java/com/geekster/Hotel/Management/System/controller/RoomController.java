package com.geekster.Hotel.Management.System.controller;

import com.geekster.Hotel.Management.System.model.HotelRoom;
import com.geekster.Hotel.Management.System.model.Type;
import com.geekster.Hotel.Management.System.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    // ----------------------------------------------------------------------
    // add particular room
    @PostMapping("room")
    public String addRoom(@RequestBody HotelRoom room){
        return roomService.addRoom(room);
    }

    // add List of room
    @PostMapping("rooms")
    public String addRooms(@RequestBody List<HotelRoom> rooms){
        return roomService.addRooms(rooms);
    }

    // ---------------------------------------------------------------------

    // get all rooms
    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms(){
        return roomService.getAllRooms();
    }

    // get particular room by id
    @GetMapping("room/{roomId}")
    public Optional<HotelRoom> getRoomById(@PathVariable Long roomId){
        return roomService.getRoomById(roomId);
    }

    // get all rooms list by ids
    @GetMapping("rooms/list")
    public Iterable<HotelRoom> getRoomsByIds(@RequestBody List<Long> roomIds){
        return roomService.getRoomsByIds(roomIds);
    }

    // -------------------------------------------------------------------------

    // update room type on the basis of roomId
    @PutMapping("room/{roomId}/{type}")
    public String updateRoomById(@PathVariable Long roomId, @RequestBody Type type){
        return roomService.updateRoomById(roomId, type);
    }

    //check room is present or not in the database
    @GetMapping("room/{roomId}/exists")
    public boolean checkRoomExists(@PathVariable Long roomId){
        return roomService.checkRoomExists(roomId);
    }

    // count total no. of rooms present
    @GetMapping("rooms/count")
    public Long getTotalRooms(){
        return roomService.getTotalRooms();
    }

    // delete a room by id
    @DeleteMapping("room/{roomId}")
    public String deleteRoomById(@PathVariable Long roomId){
        return roomService.deleteRoomById(roomId);
    }

    // ------------------------------ CUSTOM FINDERS ------------------------------
    //find rooms by status
    @GetMapping("room/status/{status}")
    public List<HotelRoom> getRoomsByStatus(@PathVariable Boolean status){
        return roomService.getRoomsByStatus(status);
    }

    // find rooms by status and type
    @GetMapping("rooms/status/{status}/type/{type}")
    public List<HotelRoom> getRoomsByStatusAndType(@PathVariable Boolean status, @PathVariable Type type){
        return roomService.getRoomsByStatusAndType(status, type);
    }

    // find rooms by status , type and price
    @GetMapping("rooms/status/{status}/type/{type}/priceRange")
    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(@PathVariable Boolean status,@PathVariable Type type,@RequestParam Double lLimit, @RequestParam Double uLimit){
        return roomService.getRoomsByStatusAndTypeAndPrice(status,type,lLimit,uLimit);
    }

    // find rooms by type and price sortedDesc
    @GetMapping("rooms/type/{roomType}")
    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(@PathVariable Type roomType)
    {
        return roomService.getRoomsByTypeAndPriceSortedDesc(roomType);
    }

    // find total budget on the basis of type1 and type2
    @GetMapping("rooms/type1/{roomType1}/type2/{roomType2}")
    public List<HotelRoom> getBudgetedAcOrNonAC(@PathVariable Type roomType1,@PathVariable Type roomType2, @RequestParam Double lLimit,@RequestParam Double uLimit)
    {
        return roomService.getBudgetedAcOrNonAC( roomType1, roomType2, lLimit,uLimit);
    }
}
