package application.adapters.rest.controllers;
import application.domain.ports.in.LoginUseCase;
import application.adapters.rest.dtos.requests.LoginRequest;
import application.adapters.rest.dtos.responses.LoginResponse;
public final class AuthRestController {
    private final LoginUseCase loginUseCase;
    public AuthRestController(LoginUseCase loginUseCase){this.loginUseCase=loginUseCase;}
    public LoginResponse login(LoginRequest request){return new LoginResponse(loginUseCase.login(request.username(),request.password()),"Bearer",3600);}
}
