package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entites.Universite;
import tn.esprit.springproject.services.UniversiteServiceImp;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("universite")
public class UniversiteController {

    private final UniversiteServiceImp universiteServiceImp;

    @Operation(summary = "Create a new university", description = "Creates a new university.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "University created successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Universite.class))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "retrieve created university",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Universite.class))
            )
    })
    @PostMapping("/")
    public Universite addUniversite(@RequestBody Universite universite){
        return universiteServiceImp.addUniversite(universite);
    }

    @Operation(summary = "Update an existing university", description = "Updates an existing university by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "University updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Universite.class))
    )
    @PutMapping("{id}")
    public Universite updateUniversite(@PathVariable long id,@RequestBody Universite universite){
        return  universiteServiceImp.updateUniversite(id , universite);
    }

    @Operation(summary = "Get all Universities", description = "Retrieves a list of all universities.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the list of universities" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("all")
    public List<Universite> findAllUniversities(){
        return universiteServiceImp.getAllUniversite();
    }

    @Operation(summary = "Get university by ID", description = "Retrieve university by ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the university" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("{id}")
    public Universite findUniversiteById(@PathVariable long id){
        return universiteServiceImp.getUniversiteById(id);
    }

    @Operation(summary = "Delete a university", description = "Deletes a university by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "University deleted successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Universite.class))
    )
    @DeleteMapping("{id}")
    public void deleteUniversite(@PathVariable long id){
        universiteServiceImp.deleteUniversite(id);
    }

}
