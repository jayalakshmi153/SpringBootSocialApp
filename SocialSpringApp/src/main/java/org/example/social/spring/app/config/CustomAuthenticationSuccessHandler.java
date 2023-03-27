package org.example.social.spring.app.config;

import example.social.spring.app.dto.UserDTO;
import example.social.spring.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		UserDTO userDTO = userService.getUserByEmail(authentication.getName());
		request.getSession().setAttribute("user", userDTO);

		response.sendRedirect(request.getContextPath() + "/user/profile");
	}

}
