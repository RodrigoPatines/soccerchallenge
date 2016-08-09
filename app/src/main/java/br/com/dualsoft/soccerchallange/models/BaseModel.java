package br.com.dualsoft.soccerchallange.models;

/**
 * Created by Rodrigo.Patines on 06/08/2016.
 */
public class BaseModel {
    public Long id;
    public Integer active;

    public BaseModel(){
        this.active = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
