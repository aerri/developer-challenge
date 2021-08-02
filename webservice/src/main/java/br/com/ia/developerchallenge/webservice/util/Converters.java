package br.com.ia.developerchallenge.webservice.util;

public class Converters {

    public static String BooleanToUserRole(Boolean isAdmin) {
        return isAdmin ? "ADMIN" : "USER";
    }

}
