package com.ky.fitnesApp.service;

import com.ky.fitnesApp.dto.MenuServiceDto;

import java.util.List;

public interface MenuService {
    MenuServiceDto create(MenuServiceDto menuServiceDto);
    MenuServiceDto update(MenuServiceDto menuServiceDto);
    MenuServiceDto getById(Long id);
    List<MenuServiceDto> getMenus();
    String delete(Long id);
}
