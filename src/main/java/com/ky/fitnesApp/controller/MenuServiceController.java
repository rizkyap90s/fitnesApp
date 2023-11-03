package com.ky.fitnesApp.controller;


import com.ky.fitnesApp.dto.MenuServiceDto;
import com.ky.fitnesApp.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuServiceController {
    MenuService menuService;

    public MenuServiceController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/create")
    public ResponseEntity<MenuServiceDto> createMenu(@RequestBody MenuServiceDto menuServiceDto) {
        MenuServiceDto createdMenu = menuService.create(menuServiceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMenu);
    }

    @PostMapping("/update")
    public ResponseEntity<MenuServiceDto> updateMenu(@RequestBody MenuServiceDto menuServiceDto) {
        MenuServiceDto updatedMenu = menuService.update(menuServiceDto);
        if (updatedMenu != null) {
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuServiceDto> getMenuById(@PathVariable Long id) {
        MenuServiceDto menu = menuService.getById(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<MenuServiceDto>> getAllMenus() {
        List<MenuServiceDto> menus = menuService.getMenus();
        return ResponseEntity.ok(menus);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
        String result = menuService.delete(id);
        if ("Menu item deleted successfully".equals(result)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

