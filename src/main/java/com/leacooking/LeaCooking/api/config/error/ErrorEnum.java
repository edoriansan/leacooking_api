package com.leacooking.LeaCooking.api.config.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorEnum implements Serializable {

    ///// Par defaut /////
    E400(BAD_REQUEST, "Merci de vérifier votre saisie."),
    E401(UNAUTHORIZED, "Impossible de vous identifier. %n%s"),
    E403(FORBIDDEN, "Vous ne pouvez pas réaliser cette action. %n%s"),
    E500(INTERNAL_SERVER_ERROR, "Une erreur inattendue s'est produite. %n%s"),
    E404(NOT_FOUND, "%s n'existe pas"),

    ;

    private final HttpStatus status;
    private final String description;

}
