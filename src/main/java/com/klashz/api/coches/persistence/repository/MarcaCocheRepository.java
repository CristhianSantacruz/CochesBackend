package com.klashz.api.coches.persistence.repository;

import com.klashz.api.coches.domain.pojo.MarcaCochePojo;
import com.klashz.api.coches.domain.repository.IMarcaCocheRepository;
import com.klashz.api.coches.persistence.mapper.IMarcaCocheMapper;
import com.klashz.api.coches.persistence.models.MarcaCocheEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MarcaCocheRepository implements IMarcaCocheRepository{

    private final IMarcaCocheJpaRespository iMarcaCocheJpaRespository;
    private final IMarcaCocheMapper iMarcaCocheMapper;

    public MarcaCocheRepository(IMarcaCocheJpaRespository iMarcaCocheJpaRespository, IMarcaCocheMapper iMarcaCocheMapper) {
        this.iMarcaCocheJpaRespository = iMarcaCocheJpaRespository;
        this.iMarcaCocheMapper = iMarcaCocheMapper;
    }


    @Override
    public Optional<MarcaCochePojo> findById(Long id) {
        return iMarcaCocheJpaRespository.findById(id)
                .map(iMarcaCocheMapper::toMarcaCochePojo);
    }

    @Override
    public List<MarcaCochePojo> getAll() {
        return iMarcaCocheMapper.toMarcaCochePojo
                (iMarcaCocheJpaRespository.findAll());
    }

    @Override
    public MarcaCochePojo save(MarcaCochePojo newmarcaCochePojo) {
        MarcaCocheEntity marcaCocheEntity = iMarcaCocheMapper.toMarcaCocheEntity(newmarcaCochePojo);
        return iMarcaCocheMapper.toMarcaCochePojo(iMarcaCocheJpaRespository.save(marcaCocheEntity));
    }

    @Override
    public void delete(Long id) {

        iMarcaCocheJpaRespository.deleteById(id);

    }
}
