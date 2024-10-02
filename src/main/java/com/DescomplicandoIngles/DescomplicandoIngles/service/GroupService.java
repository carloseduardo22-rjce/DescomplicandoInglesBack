package com.DescomplicandoIngles.DescomplicandoIngles.service;

import com.DescomplicandoIngles.DescomplicandoIngles.entities.GroupMessage.Group;
import com.DescomplicandoIngles.DescomplicandoIngles.repository.GroupRepository;
import com.DescomplicandoIngles.DescomplicandoIngles.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group findById (Integer id)  {
        return groupRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Group not found!"));
    }

}
