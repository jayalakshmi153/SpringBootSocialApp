package org.example.social.spring.app.utils;

import example.social.spring.app.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.nio.file.Paths;

import static example.social.spring.app.constants.Constants.PROFILE_IMAGES;

public class ServerUtils {

    public static UserDTO getUserFromSession(HttpServletRequest request){
        return (UserDTO) request.getSession().getAttribute("user");
    }

    public static Path getProfileImagesPath() {
        return Paths.get(".").resolve(PROFILE_IMAGES);
    }
}
