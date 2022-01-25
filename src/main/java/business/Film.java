package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Film {
    @Id
    private final String id;
    private final String title;
    private final Integer duration;
    private final List<String> language;
    private final List<String> subtitles;
    private final String director;
    private final List<String> main_actor;
    private final String min_age;
    private final Date start;
    private final Date end;

    public Film(String id, String title, Integer duration, List<String> language, List<String> subtitles, String director, List<String> main_actor, String min_age, Date start, Date end){
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.language = language;
        this.subtitles = subtitles;
        this.director = director;
        this.main_actor = main_actor;
        this.min_age = min_age;
        this.start = start;
        this.end = end;

    }

    public Date getEnd() {
        return end;
    }

    public Date getStart() {
        return start;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getMin_age() {
        return min_age;
    }

    public List<String> getLanguage() {
        return language;
    }

    public List<String> getMain_actor() {
        return main_actor;
    }

    public List<String> getSubtitles() {
        return subtitles;
    }

    public String getDirector() {
        return director;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", language=" + language +
                ", subtitles=" + subtitles +
                ", director='" + director + '\'' +
                ", main_actor=" + main_actor +
                ", min_age=" + min_age +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
