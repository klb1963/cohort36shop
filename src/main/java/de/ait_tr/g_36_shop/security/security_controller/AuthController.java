package de.ait_tr.g_36_shop.security.security_controller;

import de.ait_tr.g_36_shop.domain.entity.User;
import de.ait_tr.g_36_shop.security.sec_dto.RefreshRequestDto;
import de.ait_tr.g_36_shop.security.sec_dto.TokenResponseDto;
import de.ait_tr.g_36_shop.security.security_service.AuthService;
import jakarta.security.auth.message.AuthException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    //endpoint для аутентификации пользователя
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody User user) throws AuthException {
        try {
            return service.login(user);
        } catch (AuthException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/refresh")
    public TokenResponseDto getNewAccessToken(@RequestBody RefreshRequestDto request){
        try {
            return service.getNewAccessToken(request.getRefreshToken());
        } catch (AuthException e) {
            throw new RuntimeException(e);
        }
    }

}
