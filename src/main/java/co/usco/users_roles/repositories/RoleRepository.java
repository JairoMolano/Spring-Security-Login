package co.usco.users_roles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.usco.users_roles.models.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long>{
    
}
