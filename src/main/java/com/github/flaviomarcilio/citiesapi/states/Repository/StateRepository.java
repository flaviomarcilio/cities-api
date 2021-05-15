package com.github.flaviomarcilio.citiesapi.states.Repository;

import com.github.flaviomarcilio.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
