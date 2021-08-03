package mg.rmahatoky.carapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
@EntityScan(basePackages = {"mg"})
@ComponentScan(basePackages = {"mg"})
@EnableJpaRepositories(basePackages = {"mg"})
public class CarApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApiApplication.class, args);
    }

}
