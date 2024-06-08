package com.example.LearnKotlin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/Simple")
@RestController
public class AndroidController {

	private App app = new App("00000", 0);

    private List<App> apps = new ArrayList<>();

    @GetMapping
    public ResponseEntity<App> show() {
        System.out.println("-------> Client requested this method");
        return ResponseEntity.ok(app);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody App requestBody) {
        String id = requestBody.getId();
        int cnt = requestBody.getCnt();

        this.app.setId(id);
        this.app.setCnt(cnt);

        return ResponseEntity.ok(id);
    }

    @PostMapping("/app")
    public ResponseEntity<String> createApp(@RequestBody App app) {
        System.out.println(app);
        apps.add(app);
        return ResponseEntity.ok(app.getId());
    }

    @DeleteMapping("/app/{id}")
    public ResponseEntity<Boolean> deleteApp(@PathVariable String id) {
        boolean sts = apps.removeIf(el -> el.getId().equals(id));
        return new ResponseEntity<>(sts, HttpStatus.ACCEPTED);
    }

    @PutMapping("/app")
    public ResponseEntity<String> updateApp(@RequestBody App app) {
        int ind = apps.indexOf(app);
        System.out.println(app.toString());
        System.out.println("Index is " + ind);
        apps.set(ind, app);
        return new ResponseEntity<>(app.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/app")
    public ResponseEntity<List<App>> showApps() {
        return ResponseEntity.ok(apps);
    }
}
