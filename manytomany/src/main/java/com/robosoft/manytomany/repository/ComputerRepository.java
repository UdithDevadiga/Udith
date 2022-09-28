package com.robosoft.manytomany.repository;

import com.robosoft.manytomany.modal.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer,Integer> {
}
