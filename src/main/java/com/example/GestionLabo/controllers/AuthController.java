package com.example.GestionLabo.controllers;

import com.example.GestionLabo.requestDto.LoginRequestDto;
import com.example.GestionLabo.requestDto.RegisterUserRequestDto;
import com.example.GestionLabo.requestDto.UserRequestDto;
import com.example.GestionLabo.responseDto.RegisterUserResponseDto;
import com.example.GestionLabo.responseDto.UserResponseDto;
import com.example.GestionLabo.serviceImplementation.AuthServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@ControllerAdvice
public class AuthController {
    private final AuthServiceImp authService;

    @PostMapping("/login")


    public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        UserResponseDto res =  authService.login(loginRequestDto);
        return ResponseEntity.ok(res) ;
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<UserResponseDto> registerAdmin(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto myuser = authService.registerAdmin(userRequestDto);
        return ResponseEntity.ok(myuser);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserResponseDto> getUserWithId(@PathVariable String id) {
        UserResponseDto user = authService.getUserWithId(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> allusers = authService.getAllUsers();
        return ResponseEntity.ok(allusers);
    }

    @PostMapping("/RegisterSimpleUser")
    public ResponseEntity<RegisterUserResponseDto> registerSimpleUser(
            @RequestBody() RegisterUserRequestDto userRequestDto) {
        RegisterUserResponseDto user= authService.registerSimpleUser(userRequestDto);
        return ResponseEntity.ok(user);
    }



    @PostMapping("/loginUser")
    public ResponseEntity<UserResponseDto> loginAdmin(@RequestBody LoginRequestDto loginRequestDto) {
        UserResponseDto user = authService.login(loginRequestDto);
        return ResponseEntity.ok(user);
    }



}
