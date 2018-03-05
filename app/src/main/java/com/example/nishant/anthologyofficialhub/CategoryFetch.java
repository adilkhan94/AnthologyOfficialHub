package com.example.nishant.anthologyofficialhub;

/**
 * Created by Nishant on 3/5/2018.
 */

public class CategoryFetch {
String cba[];
    String AL_Type;
CategoryFetch(){

}

    CategoryFetch(String category){
     AL_Type =category;
    }

    public String getAL_Type() {
        return AL_Type;
    }


    public void setAL_Type(String AL_Type) {
        this.AL_Type = AL_Type;
    }
@Override
public String toString(){
    return AL_Type;
}
}
