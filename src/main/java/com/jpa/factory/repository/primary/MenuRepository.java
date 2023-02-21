package com.jpa.factory.repository.primary;

import com.jpa.factory.model.entity.primary.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MenuRepository extends JpaRepository<Menu, String> {

}
