package com.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angular.model.Impiegato;

public interface ImpiegatoRepository extends JpaRepository<Impiegato, Long> {

}
