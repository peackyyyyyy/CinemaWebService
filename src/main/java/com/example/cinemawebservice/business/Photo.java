package com.example.cinemawebservice.business;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.datatransfer.Clipboard;
import java.util.List;
@Data
@Document(collection = "photos")
public class Photo {
    @Id
    private String id;
    private String title;
    private Binary image;

    public Photo(String title) {
    }


    public String getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary binary) {
    }

    public Photo(String id, String title, Binary image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image  +
                '}';
    }

}
