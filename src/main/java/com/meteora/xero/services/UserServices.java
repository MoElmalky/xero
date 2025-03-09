package com.meteora.xero.services;

import com.meteora.xero.api.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServices {

    private final List<UserModel> users;

    public UserServices(){
        users = new ArrayList<>();

        UserModel user1 = new UserModel(1,"Mohamed",20,"mohamed@email.com");
        UserModel user2 = new UserModel(2,"Ahmed",21,"ahmed@email.com");
        UserModel user3 = new UserModel(3,"Mahmoud",40,"mahmoud@email.com");
        UserModel user4 = new UserModel(4,"Malky",1000,"Malky@email.com");

        users.addAll(Arrays.asList(user1,user2,user3,user4));
    }

    public UserModel getUser(int id){
        for(UserModel user : users){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }

    public ArrayList<Integer> getCart(int userId){
        UserModel user = getUser(userId);
        return user.getCart();
    }

    public Boolean addToCart(int userId,int productId){
        UserModel user = getUser(userId);
        if(user != null){
            user.addToCard(productId);
            return true;
        } else {
            return false;
        }
    }
}
