//package com.web.e_note.repository;
//
//import com.web.e_note.entity.Role;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface RoleRepository extends JpaRepository<Role, Long> {
//    @Query("SELECT r FROM Role r WHERE r.roleName = :name")
//    Role findByName(@Param("roleName") String name);
//
//
//}
