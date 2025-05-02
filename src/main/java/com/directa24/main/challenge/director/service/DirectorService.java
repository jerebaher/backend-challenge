package com.directa24.main.challenge.director.service;

import com.directa24.main.challenge.director.model.Director;

import java.util.List;

public interface DirectorService {

    List<Director> getDirectors(int threshold);
}
