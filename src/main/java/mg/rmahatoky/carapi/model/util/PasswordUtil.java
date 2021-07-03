package mg.rmahatoky.carapi.model.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Pour encoder les mots de passe
 * @author Mahatoky
 */
public abstract class PasswordUtil {

    //TODO: Dois utiliser autre que MD5
    public static String encrypt(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            // digest() finally determines to return the md5 hash value, returning a value of 8 as a string. Because the md5 hash value is a 16-bit hex value, it is actually an 8-bit character.
            // The BigInteger function converts an 8-bit string into a 16-bit hex value, represented by a string; gets a hash value in the form of a string
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
