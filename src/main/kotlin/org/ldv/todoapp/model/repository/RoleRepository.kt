package org.ldv.todoapp.model.repository
import org.ldv.todoapp.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
interface RoleRepository : JpaRepository<Role, Long> {
}