package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entites.Reservation;
import tn.esprit.springproject.services.ReservationServiceImp;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("reservation")
public class ReservationController {

    private final ReservationServiceImp reservationServiceImp;

    @Operation(summary = "Create a new reservation", description = "Creates a new reservation.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Reservation created successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Reservation.class))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "retrieve created reservation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Reservation.class))
            )
    })
    @PostMapping("/")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationServiceImp.addReservation(reservation);
    }

    @Operation(summary = "Update an existing reservation", description = "Updates an existing reservation by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Reservation updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Reservation.class))
    )
    @PutMapping("{id}")
    public Reservation updateReservation(@PathVariable String id,@RequestBody Reservation reservation){
        return  reservationServiceImp.updateReservation(id , reservation);
    }

    @Operation(summary = "Get all Reservations", description = "Retrieves a list of all Reservations.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the list of reservations" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("all")
    public List<Reservation> findAllReservation(){
        return reservationServiceImp.getAllReservation();
    }

    @Operation(summary = "Get reservation by ID", description = "Retrieve reservation by ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the reservation" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("{id}")
    public Reservation findReservationById(@PathVariable String id){
        return reservationServiceImp.getReservationById(id);
    }

    @Operation(summary = "Delete a reservation", description = "Deletes a reservation by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Reservation deleted successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Reservation.class))
    )
    @DeleteMapping("{id}")
    public void deleteReservation(@PathVariable String id){
        reservationServiceImp.deleteReservation(id);
    }

    @Operation(summary = "Get reservation by Student ID", description = "Retrieves a reservation by student ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the student" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/reservationByEtudiant/{idEtudiant}")
    public Set<Reservation> getReservationsByEtudiant(@PathVariable long idEtudiant){
        return reservationServiceImp.getReservationsByEtudiantID(idEtudiant);
    }

    @Operation(summary = "Get reservation by Student name", description = "Retrieves a reservation by student name.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the student" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/reservationByEtudiantNom/{nomEtudiant}")
    public Set<Reservation> getReservationByEtudiantNom(@PathVariable String nomEtudiant){
        return reservationServiceImp.getReservationsByEtudiantNom(nomEtudiant);
    }

    @Operation(summary = "Get reservation by Student name start with AB", description = "Retrieves a reservation by student name start with AB.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the student" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/rsvByStudentLikeAB")
    public List<Reservation> getResevationsByEtudiantLikeAB(){
        return reservationServiceImp.findRsvByStudentName();
    }

}
