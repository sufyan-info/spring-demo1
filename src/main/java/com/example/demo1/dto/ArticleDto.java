package com.example.demo1.dto;

import com.example.demo1.models.AppUser;
import com.example.demo1.models.UserArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class ArticleDto {

    private Long id;
    private Long ownerId;
    private String title;
    private String body;

    public UserArticle toEntity(){
        UserArticle entity = new UserArticle();
        entity.setId(id);
        entity.setOwner(new AppUser(ownerId));
        entity.setTitle(title);
        entity.setBody(body);
        return entity;
    }

    public static ArticleDto from(UserArticle entity){
        return ArticleDto.builder()
                .id(entity.getId())
                .ownerId(entity.getOwner().getId())
                .title(entity.getTitle())
                .body(entity.getBody())
                .build();
    }
}
