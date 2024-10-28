package co.usco.users_roles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.usco.users_roles.models.PermissionModel;
import co.usco.users_roles.models.RoleModel;
import co.usco.users_roles.models.UserModel;
import co.usco.users_roles.repositories.RoleRepository;
import co.usco.users_roles.repositories.UserRepository;
import java.util.List;
import java.util.Set;

@Service
public class DataInitializerService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void initializeData() {
        
        // PERMISOS
        PermissionModel readPermission = PermissionModel.builder()
            .name("READ")
            .build();

        PermissionModel writePermission = PermissionModel.builder()
            .name("WRITE")
            .build();

            PermissionModel deletePermission = PermissionModel.builder()
            .name("DELETE")
            .build();

        PermissionModel adminPermission = PermissionModel.builder()
            .name("ADMIN")
            .build();

        // ROLES
        RoleModel roleUser = RoleModel.builder()
            .rolename("USER")
            .permissions(Set.of(readPermission, writePermission))
            .build();

        RoleModel roleAdmin = RoleModel.builder()
            .rolename("ADMIN")
            .permissions(Set.of(readPermission, writePermission, deletePermission, adminPermission))
            .build();

        roleRepository.saveAll(List.of(roleUser, roleAdmin));

        // USUARIOS
        UserModel userUsuario1 = UserModel.builder()
            .username("USER1")
            .password(passwordEncoder.encode("1234"))
            .roles(Set.of(roleUser))
            .build();

        UserModel userUsuario2 = UserModel.builder()
            .username("USER2")
            .password(passwordEncoder.encode("1234"))
            .roles(Set.of(roleUser))
            .build();

        UserModel userAdministrador = UserModel.builder()
            .username("ADMIN")
            .password(passwordEncoder.encode("1234"))
            .roles(Set.of(roleAdmin))
            .build();

        userRepository.saveAll(List.of(userUsuario1, userUsuario2, userAdministrador));
    }
}
