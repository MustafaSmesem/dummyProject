package com.joumer.dummyproject.controller;

import com.joumer.dummyproject.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "Jwt bearer")
public class UserController {

    @GetMapping
    @Operation(
            tags = {"User endpoint"},
            summary = "get users by name",
            description = "this endpoint get all users that his name is equal to query param username",
            parameters = {
                @Parameter(name = "username", description = "The name of the user: string", example = "Mustafa")
            }
    )
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting user by name successfully",
                    content = @Content(
                            schema = @Schema(implementation = User.class),
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User with this name is not exist",
                    content = @Content(
                            schema = @Schema(implementation = String.class),
                            mediaType = "application/json"
                    )
            )
    })
    public List<User> getUserByName(@RequestParam String username) {
        return List.of(
                User.builder()
                .id(1001L)
                .name(username)
                .createdDate(LocalDateTime.now().minusDays(30))
                .build()
        );
    }

    @PostMapping
    @Operation(
            tags = {"User endpoint"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Its need user as a request body",
                    content = @Content(
                            schema = @Schema(implementation = User.class),
                            mediaType = "application/json"
                    )
            )
    )
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok("User " + user.getId() + " has been added successfully");
    }
}
