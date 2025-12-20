package com.project.Fridgy.controller;

import com.project.Fridgy.dto.IngredientRequestDTO;
import com.project.Fridgy.model.IngredientRequest;
import com.project.Fridgy.model.Recipe;
import com.project.Fridgy.model.User;
import com.project.Fridgy.service.IngredientRequestService;
import com.project.Fridgy.service.JwtService;
import com.project.Fridgy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredient-request")
public class IngredientRequestController {

    @Autowired
    private IngredientRequestService ingredientRequestService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public IngredientRequest create(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody IngredientRequestDTO dto) {

        String email = jwtService.extractEmailFromAuthHeader(authHeader);
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ingredientRequestService.createRequest(
                dto.getName(),
                dto.getSymbol(),
                user
        );
    }

    @GetMapping("/pending")
    public List<IngredientRequest> getPendingRequests() {
        return ingredientRequestService.getPendingRequests();
    }

    @PostMapping("/{id}/approve")
    public IngredientRequest approve(@PathVariable Long id, @RequestBody(required = false) String adminMessage) {
        return ingredientRequestService.acceptRequest(id, adminMessage);
    }

    @PostMapping("/{id}/reject")
    public IngredientRequest reject(@PathVariable Long id, @RequestBody(required = false) String adminMessage) {
        return ingredientRequestService.rejectRequest(id, adminMessage);
    }

    @GetMapping("/my")
    public ResponseEntity<List<IngredientRequest>> getMyRequests(
            @RequestHeader("Authorization") String authHeader) {

        String email = jwtService.extractEmailFromAuthHeader(authHeader);
        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<IngredientRequest> myRequests =
                ingredientRequestService.getRequestedByEmail(email);

        return ResponseEntity.ok(myRequests);
    }


    @GetMapping("/all")
    public List<IngredientRequest> getAllRequests(){
        return ingredientRequestService.getAllRequested();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ingredientRequestService.deleteRequest(id);
    }
}
