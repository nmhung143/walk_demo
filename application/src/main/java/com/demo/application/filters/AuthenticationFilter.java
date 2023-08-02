package com.demo.application.filters;

import com.demo.application.security.UserAuthentication;
import com.demo.application.security.UserRepoDetails;
import com.demo.application.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Slf4j
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;
    private final UserDetailsService userService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain chain) throws ServletException, IOException {
        try {
            getJwtFromRequest(request)
                    .flatMap(jwtUtils::validateTokenAndGetJws)
                    .ifPresent(jws -> {
                        var username = jws.getBody().getSubject();
                        // set user details on spring security context
                        var userDetails = (UserRepoDetails) userService.loadUserByUsername(username);

                        var userAuthentication = new UserAuthentication(userDetails.getUser());
                        userAuthentication.setAuthenticated(true);
                        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
                    });
        } catch (Exception e) {
            log.error("Cannot set user authentication", e);
        }

        chain.doFilter(request, response);
    }

    private Optional<String> getJwtFromRequest(HttpServletRequest request) {
        var tokenHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(tokenHeader) && tokenHeader.startsWith("Bearer ")) {
            return Optional.of(tokenHeader.replace("Bearer ", ""));
        }

        return Optional.ofNullable(request.getParameter("token"));
    }

}
