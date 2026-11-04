package org.ldv.todoapp.controller
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
@Controller
class AccueilController {
    @GetMapping("/")
    fun accueil(): String {
        return "accueil"
    }
}