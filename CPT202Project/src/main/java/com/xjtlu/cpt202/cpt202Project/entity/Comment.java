package com.xjtlu.cpt202.cpt202Project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment implements Serializable {

    private int Id;
    //the id of the blog that the comment belongs to
    private int blogId;

    private int authorId;

    private String userName;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime postTime;

    //replies
    private List<Comment> replyComments = new ArrayList<>();

    private int parentCommentId;

    public void setContent(String content) {
        if(content != null){
        if(content.trim().isEmpty()){
            this.content = null;
        }else{
            this.content = content;
        }
    }
    }


}
