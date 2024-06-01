package com.example.GestionLabo.serviceImplementation;
import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.exception.PasswordNotRelyException;
import com.example.GestionLabo.exception.UserWithEmailNotFoundException;
import com.example.GestionLabo.models.User;
import com.example.GestionLabo.models.enums.Role;
import com.example.GestionLabo.repository.UserRepo;
import com.example.GestionLabo.requestDto.LoginRequestDto;
import com.example.GestionLabo.requestDto.RegisterUserRequestDto;
import com.example.GestionLabo.requestDto.UserRequestDto;
import com.example.GestionLabo.responseDto.RegisterUserResponseDto;
import com.example.GestionLabo.responseDto.UserResponseDto;
import com.example.GestionLabo.serviceDeclaration.AuthServiceDec;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor

public class AuthServiceImp implements AuthServiceDec {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public UserResponseDto registerAdmin(UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        user.setRole(Role.ADMINISTRATEUR);
        User savedUser = userRepo.save(user);

        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @Override
    public UserResponseDto login(LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.getEmail();
        String suggestedPassword = loginRequestDto.getPassword();
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new UserWithEmailNotFoundException(email);
        } else {
            if (userOptional.get().getPassword().equals(suggestedPassword)) {
                return modelMapper.map(userOptional, UserResponseDto.class);

            } else {
                throw new PasswordNotRelyException(suggestedPassword);
            }
        }

    }

    @Override
    public RegisterUserResponseDto registerSimpleUser(RegisterUserRequestDto userRequestDto) {

        User user = modelMapper.map(userRequestDto, User.class);
        // generate passwod to the user : a faire apres :
        String password = generateRandomPassword(8);
        user.setPassword(password);
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, RegisterUserResponseDto.class);

    }

    private String generateRandomPassword(int length) {
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+";

        String allChars = upperChars + lowerChars + numbers + specialChars;

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }


    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> allusers = this.userRepo.findAll();
        return allusers.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).toList();
    }

    @Override
    public UserResponseDto getUserWithId(String id) {

        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new CustomNotFoundException("user", id);
        }
        return modelMapper.map(user, UserResponseDto.class);
    }
}
