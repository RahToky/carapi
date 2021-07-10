# CarApi

**Api disponible**

- [x] L'application permet d'avoir une liste de voitures.
- [x] Chaque utilisateur peut commenter une voiture.
- [x] L'utilisateur non connecté peut voir la liste mais pas les commentaires.
- [x] On ne doit pouvoir accéder aux commentaires seulement si on est connecté.

**Base de donnée**

- [x] H2

**Securité**

- [x] SpringSecurity
- [x] BearerTokenInterceptor
- [x] JWT pour les tokens
- [x] SHA-256 pour le hashage

**Api Non Sécurisé**

```
/users 
/cars
/cars/{id}
```
*/users : pour voir les pseudo/pass afin de faciliter l'authentification*

**Api Sécurisé**

```
 /cars/{id}/comments
 ```

**Info User pour tester l'API**

```
Login: abnex
Pass : 03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
```