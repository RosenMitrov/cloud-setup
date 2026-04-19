package demo.appservice.controllers;

import demo.appservice.services.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstanceController {

    private final InstanceService instanceService;

    @Autowired
    public InstanceController(InstanceService instanceService) {
        this.instanceService = instanceService;
    }

    @GetMapping("/instance")
    public ResponseEntity<String> instance() {
        return ResponseEntity.ok(instanceService.getPort());
    }

    @GetMapping("/value")
    public ResponseEntity<String> getValueProperty() {
        return ResponseEntity.ok(instanceService.getValueProperty());
    }
}