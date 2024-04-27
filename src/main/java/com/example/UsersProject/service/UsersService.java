package com.example.UsersProject.service;

import com.example.UsersProject.entity.UserEntity;
import com.example.UsersProject.repository.UsersRepository;
import com.example.UsersProject.validate.ValidateUserDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ValidateUserDate validateUserDate;

    public String add(UserEntity entity) {
        return ValidateUserDate.validate(entity, usersRepository);
    }

    public List<UserEntity> getAll() {
        return usersRepository.findAll();
    }

    public  List<UserEntity> findByFromLess(Integer old){
    return validateUserDate.validateFromLess(usersRepository, old);
    }

    public UserEntity updateUserEmail(UserEntity userEntity, Integer idUser) {
        UserEntity entity = usersRepository.findById(idUser.longValue()).get();
        entity.setEmail(userEntity.getEmail());
        return usersRepository.saveAndFlush(entity);
    }

    public UserEntity updateUserEmailLastFirstName(
            UserEntity userEntity,
            Integer idUser) {
        UserEntity entity = usersRepository.findById(idUser.longValue()).get();
        entity.setEmail(userEntity.getEmail());
        entity.setLastName(userEntity.getLastName());
        entity.setFirstName(userEntity.getFirstName());
        return usersRepository.saveAndFlush(entity);
    }

    public UserEntity updateAll(
            UserEntity userEntity,
            Integer idUser) {
        UserEntity entity = usersRepository.findById(idUser.longValue()).get();
        entity.setEmail(userEntity.getEmail());
        entity.setLastName(userEntity.getLastName());
        entity.setFirstName(userEntity.getFirstName());
        entity.setDataOfBirth(userEntity.getDataOfBirth());
        return usersRepository.saveAndFlush(entity);
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id.longValue());
    }


    public List<UserEntity> findById(Integer id){
       return usersRepository.findById(id.longValue()).stream()
               .map(userEntity -> new UserEntity(userEntity.getEmail(), userEntity.getLastName(), userEntity.getFirstName(), userEntity.getDataOfBirth()))
               .collect(Collectors.toList());
    }
}
