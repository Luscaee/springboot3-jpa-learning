package org.example.course.resources;

import org.example.course.entities.User;
import org.example.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.sql.DataSource; // excluir com barra depois
import java.net.URI;
import java.sql.Connection; //
import java.sql.SQLException; //
import java.util.HashMap; //
import java.util.List;
import java.util.Map; //

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @Autowired
    private DataSource dataSource;

    @GetMapping("/debug-db-connection")
    public ResponseEntity<Map<String, String>> getDbConnectionDetails() {
        Map<String, String> details = new HashMap<>();
        try (Connection connection = dataSource.getConnection()) {
            String jdbcUrl = connection.getMetaData().getURL();
            String userName = connection.getMetaData().getUserName();
            details.put("DATABASE_URL", jdbcUrl);
            details.put("DATABASE_USER", userName);
            return ResponseEntity.ok(details);
        } catch (SQLException e) {
            details.put("error", e.getMessage());
            return ResponseEntity.status(500).body(details);
        }
    }
}
