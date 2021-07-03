package mg.rmahatoky.carapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * API qui permet de:
 * - D'avoir une liste de voitures.
 * - Chaque utilisateur peut commenter une voiture.
 * - L'utilisateur non connecté peut voir la liste mais pas les commentaires.
 * - On ne doit pouvoir accéder aux commentaires seulement si on est connecté.
 *
 * @author Mahatoky
 */
@SpringBootApplication
public class CarApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApiApplication.class, args);
    }

}
