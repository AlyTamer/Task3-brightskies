package com.aly.brightskies.task3.controllers;

import com.aly.brightskies.task3.dto.RoomDTO;
import com.aly.brightskies.task3.services.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@Tag(name = "Room Management", description = "Manage,Create, & retrieve room information")
public class RoomManagementController {
    private final RoomService roomService;
    @Autowired
    public RoomManagementController(RoomService roomService) {

        this.roomService = roomService;
    }

    @Operation(
        summary = "Get Rooms",
        description = "Retrieve a list of rooms. Optionally filter by type."
    )
    @GetMapping
    public List<RoomDTO> getRooms(@RequestParam(required = false) String type) {

        return roomService.getRooms(type);
    }

}
