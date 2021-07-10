package mg.rmahatoky.carapi.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Pour hasher un texte
 *
 * @author Mahatoky
 */
public abstract class Sha256 {

    /**
     * @param text à hasher
     * @return le hash
     * @throws NoSuchAlgorithmException
     */
    public static String hash(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(text.getBytes());
        return bytesToHex(messageDigest.digest());
    }

    public static String bytesToHex(byte[] byteData) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * Pour tester le hashage
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            String hashPass = Sha256.hash("1234"); // 03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
            System.out.println("hash " + hashPass);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
