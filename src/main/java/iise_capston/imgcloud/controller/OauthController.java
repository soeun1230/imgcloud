package iise_capston.imgcloud.controller;

import iise_capston.imgcloud.oauth.OauthServerType;
import iise_capston.imgcloud.service.OauthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000",methods = RequestMethod.GET)
public class OauthController {

    private final OauthService oauthService;
    private static final Logger logger = LoggerFactory.getLogger(OauthController.class);

    @SneakyThrows
    @PostMapping("/oauth/{oauthServerType}")
    ResponseEntity<Void> redirectAuthCodeRequestUrl(
            @PathVariable OauthServerType oauthServerType,
            HttpServletResponse response
            ){
        String redirectUrl = oauthService.getAuthCodeRequestUrl(oauthServerType);
        response.sendRedirect(redirectUrl);
        logger.info(redirectUrl);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/oauth/login/{oauthServerType}")
    ResponseEntity<Long> login(
            @PathVariable OauthServerType oauthServerType,
            @RequestParam("code") String code
    ){
        logger.info("Attempting to log in with code: {}", code);

        Long login = oauthService.login(oauthServerType, code);
        return ResponseEntity.ok(login);
    }
}
