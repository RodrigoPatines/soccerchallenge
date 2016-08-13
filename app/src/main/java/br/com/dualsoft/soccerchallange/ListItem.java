package br.com.dualsoft.soccerchallange;

/**
 * Created by Rodrigo.Patines on 27/07/2016.
 */
public class ListItem {
    private Long id;
    private String key;
    private String description;

    public ListItem(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public ListItem(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
