package application.adapters.rest.dtos.responses;
public record LoginResponse(String token,String tokenType,long expiresInSeconds) {}
