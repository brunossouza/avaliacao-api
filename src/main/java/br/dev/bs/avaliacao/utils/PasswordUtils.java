package br.dev.bs.avaliacao.utils;

//TODO: Implementar criptografia
public class PasswordUtils {

    public static String encrypt(String password) {
        return password;
    }

    public static boolean check(String password, String encryptedPassword) {
        return password.equals(encryptedPassword);
    }
}
