package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entites.Chambre;
import tn.esprit.springproject.services.ChamberServiceImp;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("chamber")
public class ChambreController {

    private final ChamberServiceImp chamberServiceImp;

    @Operation(summary = "Get all chambers", description = "Retrieves a list of all chambers.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the list of chambers" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("all")
    public List<Chambre> getAllChamber(){
        return chamberServiceImp.findAllChambre();
    }

    @Operation(summary = "Get chamber by ID", description = "Retrieve chamber by ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the chamber" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("{idChamber}")
    public Chambre getChamberById(@PathVariable long idChamber){
        return chamberServiceImp.findChambre(idChamber);
    }

    @Operation(summary = "Create a new chamber", description = "Creates a new chamber.")
    @ApiResponse(
            responseCode = "201",
            description = "Chamber created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Chambre.class))
    )
    @PostMapping("/")
    public Chambre addChamber(@RequestBody Chambre chamber){
        return chamberServiceImp.addChambre(chamber);
    }

    @Operation(summary = "Update an existing chamber", description = "Updates an existing chamber by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Chamber updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Chambre.class))
    )
    @PutMapping("{idChamber}")
    public Chambre getChamberById(@PathVariable long idChamber, @RequestBody Chambre chamber){
        return chamberServiceImp.updateChambre(idChamber, chamber);
    }

    @Operation(summary = "Delete a chamber", description = "Deletes a chamber by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Chamber deleted successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Chambre.class))
    )
    @DeleteMapping("{idChamber}")
    public void deleteChamber(@PathVariable long idChamber){
        chamberServiceImp.deleteChambre(idChamber);
    }

    @Operation(summary = "Get chamber by Bloc ID", description = "Retrieve chamber by Bloc ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the bloc" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/getChambreByBloc/{blocId}")
    public Set<Chambre> findChambresByBlocIdBloc(@PathVariable("blocId") long id){
        return chamberServiceImp.getChambresByBloc(id);
    }
}
