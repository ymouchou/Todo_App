package org.ldv.todoapp.controller

import org.ldv.todoapp.model.repository.UtilisateurRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UtilisateursController(
    private val utilisateurRepository: UtilisateurRepository
) {
    @GetMapping("/admin/utilisateurs")
    fun voirUtilisateurs(model: Model): String {
        val listeUtilisateurs = utilisateurRepository.findAllAvecRole()
        model.addAttribute("listeUtilisateurs", listeUtilisateurs)
        return "admin/utilisateurs"
    }
}