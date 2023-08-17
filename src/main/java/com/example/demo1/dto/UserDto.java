package com.example.demo1.dto;

import com.example.demo1.models.AppUser;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;

    private String email;
    private String name;

    private List<ArticleDto> articles;

    public static UserDto from(AppUser entity){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
