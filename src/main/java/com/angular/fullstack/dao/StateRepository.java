package com.angular.fullstack.dao;

import com.angular.fullstack.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface StateRepository extends JpaRepository<State,Integer> {
    List<State> findByCountryCode(@Param("code") String code);
}
