package com.example.obspringsecurityjwtroles.service;

import com.example.obspringsecurityjwtroles.entities.Role;
import com.example.obspringsecurityjwtroles.entities.User;
import com.example.obspringsecurityjwtroles.dto.UserDto;
import com.example.obspringsecurityjwtroles.exception.EmailAlreadyExistsException;
import com.example.obspringsecurityjwtroles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    // que le pasen un username y devuelva un UserDetails para hacer la carga de los datos del usuario en el contexto de seguridad de Spring
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        //le pasa aqui un Username, Password y Authority
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) { //para trabajar con autoritys,  carga los roles
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }); // crea un conjunto de Autoritys o "ROLE_"
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add); // es otra manera de conseuir la lista de todos los usuarios
        return list;
    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    // DTO: clases para cargar datos desde fuera de la aplicacion y para enviar datos que estan dentro de la aplicacion hacia afuera, para pasar de JSON a java y de java a JSON
    // las respuestas o peticiones que vienen en JSON se guardan un UserDTo y luego con java podemos acceder
    // A la hora de guardar el usuario se puede verificar que el nombre no este ocupado, el email, contraseña segura. si se incumple puedo lanzar una excepcion
    public User save(UserDto user) {
        // extrae un objeto usuario a través de un  DTO Data Transfer Object,
        User nUser = user.getUserFromDto();

        //utilizamos el servicio para comprobar con un metodo existsByEmail que devuelve un boolean
        if(userRepository.existsByEmail(nUser.getEmail()))
            throw new EmailAlreadyExistsException("Email ocupado"); //si es verdadero lanza la excepcion

        nUser.setPassword(bcryptEncoder.encode(user.getPassword())); // se crifra codifica la contraseña

        // AUTORIZACION o ROL con Niveles de acceso
        // se asigna un rol de usuario por defecto a acualquier usuario que se registre en la plataforma
        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role); // con el metodo add se le asigna un rol "USER"

        //Tendria que desde un controlador especial que solo pueda ejecutar un administrador que pueda asignar roles admin
        if(nUser.getEmail().split("@")[1].equals("admin.edu")){ // si el email tiene "admin.edu"
            role = roleService.findByName("ADMIN"); // se le asigna el valor "ADMIN"
            roleSet.add(role);
        }


        // se guarda en BD
        nUser.setRoles(roleSet);
        return userRepository.save(nUser);
    }
}
