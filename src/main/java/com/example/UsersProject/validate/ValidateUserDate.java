package com.example.UsersProject.validate;

import com.example.UsersProject.DateFormat;
import com.example.UsersProject.entity.UserEntity;
import com.example.UsersProject.repository.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidateUserDate {

    private static final Integer OLD = 18;

    public static String validate(UserEntity entity, UsersRepository repository) {
        int compare = Integer.parseInt(DateFormat.getYear()) - Integer.parseInt(entity.getDataOfBirth().substring(0, 4));
        System.out.println(compare);
        if (compare >= OLD) {
            repository.save(entity);
        } else {
            return new RuntimeException("you are not 18 years old").getLocalizedMessage();
        }
        return "Thank you for registration";
    }

    public List<UserEntity> validateFromLess(UsersRepository repository, Integer old) {
        List<UserEntity> listFromLess = new ArrayList<>();
        for (UserEntity user : repository.findAll()) {
            int compare = Integer.parseInt(DateFormat.getYear()) - Integer.parseInt(user.getDataOfBirth().substring(0, 4));
            System.out.println(compare);
            if (compare <= old) {
                listFromLess.add(user);
            }
        }
        return listFromLess;
    }


    public static boolean validationMail(String email) {
        String reg = "[A-Za-z0-9+_.-]+@(.+)+(.com)$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
