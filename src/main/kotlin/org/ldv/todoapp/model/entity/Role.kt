package org.ldv.todoapp.model.entity
import jakarta.persistence.*
@Entity
@Table(name = "role")
open class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    open var idRole: Long? = null,
    @Column(name = "nom", nullable = false, unique = true, length = 50)
    open var nom: String = ""
)