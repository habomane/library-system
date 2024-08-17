package com.library.books.repositories;

import java.util.List;
import com.library.books.entities.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "graphic-novels", path = "graphicnovels")
public interface GraphicNovelRepository extends PagingAndSortingRepository<GraphicNovel, Long>, CrudRepository<GraphicNovel,Long> {

    List<GraphicNovel> findByName(@Param("name") String name);

}