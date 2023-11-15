package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entites.Bloc;
import tn.esprit.springproject.entites.TypeChambre;
import tn.esprit.springproject.services.BlocServiceImp;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("bloc")
public class BlocController {

    @Autowired
    private BlocServiceImp blocServiceImp;

    @Operation(summary = "Get all blocs", description = "Retrieves a list of all blocs.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the list of blocs" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("all")
    public List<Bloc> getAllBloc(){
        return blocServiceImp.getAllBloc();
    }

    @Operation(summary = "Get bloc by ID", description = "Retrieve bloc by ID.")
    @ApiResponse(responseCode = "200",
            description = "Successfully retrieved the bloc" ,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("{idBloc}")
    public Bloc getBlocById(@PathVariable long idBloc){
        return blocServiceImp.getBlocById(idBloc);
    }

    @Operation(summary = "Create a new bloc", description = "Creates a new bloc.")
    @ApiResponse(
            responseCode = "201",
            description = "Bloc created successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Bloc.class))
    )
    @PostMapping("/")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return blocServiceImp.addBloc(bloc);
    }

    @Operation(summary = "Update an existing bloc", description = "Updates an existing bloc by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Bloc updated successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Bloc.class))
    )
    @PutMapping("update/{idBloc}")
    public Bloc getBlocById(@PathVariable long idBloc , @RequestBody Bloc bloc){
        return blocServiceImp.updateBloc(idBloc , bloc);
    }

    @Operation(summary = "Delete a bloc", description = "Deletes a bloc by ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Bloc deleted successfully",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Bloc.class))
    )
    @DeleteMapping("delete/{idBloc}")
    public void deleteBloc(@PathVariable long idBloc){
        blocServiceImp.deleteBloc(idBloc);
    }

    @Operation(summary = "Get a bloc by chamber type", description = "Get a bloc by chamber type.")
    @ApiResponse(
            responseCode = "200",
            description = "Successfully get Bloc",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Bloc.class))
    )
    @GetMapping("getbytypec/{typeC}")
    public Set<Bloc> findByChamberTypeC(@PathVariable TypeChambre typeC){
        return blocServiceImp.findByChamberTypeC(typeC);
    }

    @Operation(summary = "Get a bloc by chamber ID", description = "Get a bloc by chamber ID.")
    @ApiResponse(
            responseCode = "200",
            description = "Successfully get Bloc",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Bloc.class))
    )
    @GetMapping("findBlocByChambreId/{chambreId}")
    public Bloc findBlocByChambreId(@PathVariable long chambreId){
        return blocServiceImp.findBlocByChambreId(chambreId);
    }

}
