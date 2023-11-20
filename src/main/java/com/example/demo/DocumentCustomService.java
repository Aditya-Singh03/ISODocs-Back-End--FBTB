package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.data.repository.query.Param;

@Repository
public class DocumentCustomService implements DocumentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> findEntitiesWithCommonField() {
        String jpql = "SELECT e1, e2 FROM Entity1 e1 INNER JOIN Entity2 e2 ON e1.commonField = e2.commonField";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        return query.getResultList();
    }
}
