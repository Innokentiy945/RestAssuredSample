package Model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Model {
    @JsonProperty
    private String title;
    @JsonProperty
    private String description;

    @Override
    public String toString() {
        return "Model{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Model(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
