package com.GestionBank.GestionBank.services;

import com.GestionBank.GestionBank.dto.GroupDto;
import com.GestionBank.GestionBank.entities.UserGroupe;
import com.GestionBank.GestionBank.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public UserGroupe create(GroupDto groupDto) {
        UserGroupe userGroup = new UserGroupe();
        userGroup.setNomGroup(groupDto.getNomGroup());
        return this.groupRepository.save(userGroup);  // Aucun conflit de type avec Catalina
    }

    @Override
    public UserGroupe getOne(long id) {
        return this.groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserGroupe> findAll() {
        return this.groupRepository.findAll();
    }
}
