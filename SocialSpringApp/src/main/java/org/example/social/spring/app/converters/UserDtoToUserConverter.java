package org.example.social.spring.app.converters;

import org.example.social.spring.app.dto.UserDTO;
import org.example.social.spring.app.constants.Gender;
import org.example.social.spring.app.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoToUserConverter implements Converter<UserDTO, User> {

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User convert(UserDTO userDTO) {
        User.UserBuilder builder = User.builder()
                                       .id(userDTO.getId())
                                       .email(userDTO.getEmail())
                                       .firstName(userDTO.getFirstName())
                                       .lastName(userDTO.getLastName())
                                       .phone(userDTO.getPhone())
                                       .sex(Gender.getGenderByName(userDTO.getSex()))
                                       .image(userDTO.getImage())
                                       .dob(userDTO.getDob());

        if (userDTO.getPassword() != null)
            builder.password(passwordEncoder.encode(userDTO.getPassword()));

        return builder.build();
    }
}
