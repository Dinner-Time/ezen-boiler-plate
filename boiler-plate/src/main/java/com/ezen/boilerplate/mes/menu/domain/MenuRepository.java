package com.ezen.boilerplate.mes.menu.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, String> {
    public List<Menu> findByParentMenuIsNotNull();

    public List<Menu> findByParentMenuIsNull();
}
