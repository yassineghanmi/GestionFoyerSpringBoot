package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entites.Foyer;
import tn.esprit.springproject.services.FoyerServicelmp;

import java.util.List;

@RestController
@RequestMapping("foyer")
public class FoyerController {
    @Autowired
    private FoyerServicelmp foyerServicelmp;

    @Operation(summary = "Create a new foyer", description = "Creates a new foyer.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Foyer created successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Foyer.class))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "retrieve created foyer",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Foyer.class))
            )
    })
    @PostMapping("/")
    public Foyer addFoyer(@RequestBody Foyer f){
       return foyerServicelmp.addFoyer(f);
    }

    @Operation(summary = "Update an existing foyer", description = "Updates an existing foyer by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Foyer updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Foyer.class))
    )
    @PutMapping("updatefoyer")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return  foyerServicelmp.updateFoyer(f);
    }

    @Operation(summary = "Get all Foyers", description = "Retrieves a list of all foyers.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the list of foyers" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/all")
    public List<Foyer> findAllFoyer(){
        return foyerServicelmp.findAllFoyer();
    }

    @Operation(summary = "Get foyer by ID", description = "Retrieve foyer by ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the foyer" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("{idF}")
    public  Foyer findFoyerById(@PathVariable long idF){
        return foyerServicelmp.findFoyer(idF);

    }

    @Operation(summary = "Delete a foyer", description = "Deletes a foyer by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Foyer deleted successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Foyer.class))
    )
    @DeleteMapping("{idF}")
    public void deleteFoyer(@PathVariable long idF){
        foyerServicelmp.deleteFoyer(idF);}

    @Operation(summary = "Get foyer by name", description = "Retrieve foyer by name.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the foyer" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("getbyname/{nameFoyer}")
    public Foyer getFoyerbyname(@PathVariable String nameFoyer){
        return foyerServicelmp.findFoyerByName(nameFoyer);
    }
}