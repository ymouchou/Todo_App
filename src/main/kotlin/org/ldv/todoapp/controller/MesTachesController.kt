package org.ldv.todoapp.controller

import jakarta.servlet.http.HttpSession
import org.ldv.todoapp.model.repository.TacheRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MesTachesController(
    private val tacheRepository: TacheRepository
) {
    @GetMapping("/mes-taches")
    fun mesTaches(model: Model, session: HttpSession): String {
        val utilisateurId = session.getAttribute("utilisateurId") as? Long
        val taches = if (utilisateurId != null) {
            tacheRepository.findByUtilisateur_IdUtilisateur(utilisateurId)
        } else {
            emptyList()
        }
        model.addAttribute("taches", taches)
        return "mes-taches"
    }
}