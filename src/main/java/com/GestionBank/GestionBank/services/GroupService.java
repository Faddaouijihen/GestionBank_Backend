package com.GestionBank.GestionBank.services;



import com.GestionBank.GestionBank.dto.GroupDto;
import com.GestionBank.GestionBank.entities.UserGroupe;

import java.util.List;

public interface GroupService {
        UserGroupe create(GroupDto groupDto);
        UserGroupe getOne(long id);
        List<UserGroupe> findAll();
}
