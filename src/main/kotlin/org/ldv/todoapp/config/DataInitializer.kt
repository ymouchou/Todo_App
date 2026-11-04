package org.ldv.todoapp.config

import org.ldv.todoapp.model.entity.Role
import org.ldv.todoapp.model.entity.Utilisateur
import org.ldv.todoapp.model.entity.Tache
import org.ldv.todoapp.model.repository.RoleRepository
import org.ldv.todoapp.model.repository.UtilisateurRepository
import org.ldv.todoapp.model.repository.TacheRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer(
    private val roleRepository: RoleRepository,
    private val utilisateurRepository: UtilisateurRepository,
    private val tacheRepository: TacheRepository
) : CommandLineRunner {

    override fun run(vararg args: String) {
        // Initialisation uniquement si les tables sont vides
        if (roleRepository.count() > 0 ||
            utilisateurRepository.count() > 0 ||
            tacheRepository.count() > 0) {
            println("Base de données déjà initialisée.")
            return
        }

        println("Initialisation des données TodoApp...")

        // 1. Création des rôles
        val roleUser = roleRepository.save(
            Role(nom = "ROLE_USER")
        )
        val roleAdmin = roleRepository.save(
            Role(nom = "ROLE_ADMIN")
        )

        // 2. Création des utilisateurs
        val alice = utilisateurRepository.save(
            Utilisateur(
                nom = "Martin",
                prenom = "Alice",
                email = "alice@example.com",
                role = roleUser
            )
        )

        val bob = utilisateurRepository.save(
            Utilisateur(
                nom = "Durand",
                prenom = "Bob",
                email = "bob@example.com",
                role = roleUser
            )
        )

        val claire = utilisateurRepository.save(
            Utilisateur(
                nom = "Bernard",
                prenom = "Claire",
                email = "claire@example.com",
                role = roleUser
            )
        )

        val admin = utilisateurRepository.save(
            Utilisateur(
                nom = "Admin",
                prenom = "TodoApp",
                email = "admin@example.com",
                role = roleAdmin
            )
        )

        // 3. Création des tâches
        val aujourdHui = LocalDate.now()
        val taches = listOf(
            // Tâches d'Alice
            Tache(
                titre = "Préparer le TP Spring Boot",
                description = "Rédiger le support de cours MVC.",
                dateEcheance = aujourdHui.plusDays(7),
                utilisateur = alice
            ),
            Tache(
                titre = "Installer IntelliJ IDEA",
                description = "Configurer l'environnement Kotlin.",
                dateEcheance = aujourdHui.minusDays(2),
                terminee = true,
                utilisateur = alice
            ),
            // Tâches de Bob
            Tache(
                titre = "Réviser les requêtes SQL",
                dateEcheance = aujourdHui.plusDays(3),
                utilisateur = bob
            ),
            Tache(
                titre = "Terminer le projet JDBC",
                description = "Finaliser les méthodes DAO.",
                dateEcheance = aujourdHui.minusDays(5),
                utilisateur = bob
            ),
            // Tâches de Claire
            Tache(
                titre = "Étudier les annotations JPA",
                dateEcheance = aujourdHui.plusDays(10),
                utilisateur = claire
            ),
            Tache(
                titre = "Lire la documentation Thymeleaf",
                terminee = true,
                utilisateur = claire
            ),
            // Tâches de l'admin
            Tache(
                titre = "Vérifier les comptes utilisateurs",
                dateEcheance = aujourdHui.plusDays(1),
                utilisateur = admin
            ),
            Tache(
                titre = "Contrôler les tâches enregistrées",
                utilisateur = admin
            )
        )

        tacheRepository.saveAll(taches)

        println("Initialisation terminée :")
        println("- 2 rôles")
        println("- 4 utilisateurs")
        println("- ${taches.size} tâches")
    }
}