package org.ldv.todoapp.controller

import org.ldv.todoapp.model.repository.TacheRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TachesController(
    private val tacheRepository: TacheRepository
) {
    @GetMapping("/admin/taches")
    fun voirTaches(model: Model): String {
        val listeTaches = tacheRepository.findAllAvecUtilisateur()
        model.addAttribute("listeTaches", listeTaches)
        return "admin/taches"
    }
}