package com.ky.fitnesApp.service.impl;

import com.ky.fitnesApp.dto.MenuServiceDto;
import com.ky.fitnesApp.repository.MenuRepository;
import com.ky.fitnesApp.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    MenuRepository repository;

    public MenuServiceImpl(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public MenuServiceDto create(MenuServiceDto menuServiceDto) {
        return repository.save(menuServiceDto);
    }

    @Override
    public MenuServiceDto update(MenuServiceDto menuServiceDto) {
        return repository.save(menuServiceDto);
    }

    @Override
    public MenuServiceDto getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<MenuServiceDto> getMenus() {
        return repository.findAll();
    }

    @Override
    public String delete(Long id) {
        repository.deleteById(id);
        return "DELETED";
    }
}
