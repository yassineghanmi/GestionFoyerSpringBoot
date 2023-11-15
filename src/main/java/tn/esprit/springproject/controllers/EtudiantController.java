package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entites.Etudiant;
import tn.esprit.springproject.services.EtudiantServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class EtudiantController  {

    private EtudiantServiceImp etudiantServiceImp;

    @Operation(summary = "Create a new student", description = "Creates a new student.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Student created successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Etudiant.class))
            ),
            @ApiResponse(
                    responseCode = "200",
                    description = "retrieve created student",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Etudiant.class))
            )
    })
    @PostMapping("/")
    public Etudiant addEtudiant(@RequestBody Etudiant E){
        return etudiantServiceImp.addEtudiant(E);
    }

    @Operation(summary = "Update an existing student", description = "Updates an existing student by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Student updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Etudiant.class))
    )
    @PutMapping("{idE}")
    public Etudiant updateEtudiant(@PathVariable long idE,@RequestBody Etudiant E){
        return  etudiantServiceImp.updateEtudiant(idE,E);
    }

    @Operation(summary = "Get all Students", description = "Retrieves a list of all students.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the list of students" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("all")
    public List<Etudiant> findAllEtudiant(){
        return etudiantServiceImp.findAllEtudiant();
    }

    @Operation(summary = "Get student by ID", description = "Retrieve student by ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the student" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("{idE}")
    public  Etudiant findEtudiantById(@PathVariable long idE){
        return etudiantServiceImp.findEtudiant(idE);

    }

    @Operation(summary = "Delete a student", description = "Deletes a student by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Student deleted successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Etudiant.class))
    )
    @DeleteMapping("{idE}")
    public void deleteEtudiant(@PathVariable long idE){
        etudiantServiceImp.deleteEtudiant(idE);
    }
}
