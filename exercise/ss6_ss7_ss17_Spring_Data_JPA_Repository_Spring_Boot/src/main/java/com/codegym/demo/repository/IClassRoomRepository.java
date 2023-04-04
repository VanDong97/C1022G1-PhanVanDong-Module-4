package com.codegym.demo.repository;

import com.codegym.demo.model.ClassRoom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClassRoomRepository extends PagingAndSortingRepository<ClassRoom, Integer> {
}
