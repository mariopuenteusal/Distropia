package com.ipo.distropia.data;

import com.ipo.distropia.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 24/06/2018.
 */
public class Data {

    private List<User> users= new ArrayList<>();
    private static Data mData;

    private Data(){

    }

    public static Data getInstance(){

        if(mData==null){
            mData = new Data();
            mockData();

        }
        return mData;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public static void mockData(){
        mData.getUsers().add(new User("Usuario1","Depresión","Dani García","Activo"));
        mData.getUsers().add(new User("Usuario2","Anorexia","Dani García","Activo"));
        mData.getUsers().add(new User("Usuario3","Ansiedad","Dani García","Activo"));
    }

}
