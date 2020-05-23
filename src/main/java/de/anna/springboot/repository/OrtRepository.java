package de.anna.springboot.repository;

import de.anna.springboot.model.entity.Ort;

import java.util.List;

public interface OrtRepository {

    List<Ort> findOrtByBundesland(String bundeslandName);
}
