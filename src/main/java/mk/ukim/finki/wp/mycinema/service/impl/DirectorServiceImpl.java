package mk.ukim.finki.wp.mycinema.service.impl;

import mk.ukim.finki.wp.mycinema.model.Director;
import mk.ukim.finki.wp.mycinema.repository.DirectorRepository;
import mk.ukim.finki.wp.mycinema.service.DirectorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> findAll() {
        return this.directorRepository.findAll();
    }

    @Override
    public Optional<Director> findById(Long id) {
        return this.directorRepository.findById(id);
    }
}
