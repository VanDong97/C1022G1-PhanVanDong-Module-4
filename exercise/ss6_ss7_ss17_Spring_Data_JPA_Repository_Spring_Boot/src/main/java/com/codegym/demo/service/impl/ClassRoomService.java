package com.codegym.demo.service.impl;

import com.codegym.demo.model.ClassRoom;
import com.codegym.demo.repository.IClassRoomRepository;
import com.codegym.demo.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {

    @Autowired
    private IClassRoomRepository iClassRoomRepository;

    @Override
    public List<ClassRoom> findAll() {
        return (List<ClassRoom>) iClassRoomRepository.findAll();
    }
}
