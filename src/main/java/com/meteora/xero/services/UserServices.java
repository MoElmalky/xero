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

        UserModel user1 = new UserModel(0,new UserModel.FullName("Mohamed","Ali","Elmalky"),
                new UserModel.BirthDate(2004,7,21),
                new UserModel.Address("Egypt","Sharqiyah","Abuhammad","Al-Hilmiya",7070),"elmalky@gmail.com");
        UserModel user2 = new UserModel(1,new UserModel.FullName("Mohamed","Wael","Khalifuh"),
                new UserModel.BirthDate(2004,2,2),
                new UserModel.Address("Egypt","Sharqiyah","Faquse","Kafr-Cows",8070),"wael@gmail.com");
        UserModel user3 = new UserModel(2,new UserModel.FullName("Mahmoud","Khalid","Khamis"),
                new UserModel.BirthDate(2004,5,13),
                new UserModel.Address("Egypt","Sharqiyah","10th","9th",1050),"7ooksh@gmail.com");
        UserModel user4 = new UserModel(3,new UserModel.FullName("Ahmed","Atef","Atea"),
                new UserModel.BirthDate(2004,1,1),
                new UserModel.Address("Egypt","Sharqiyah","Hihea","Hieaaa",5040),"aboatef@gmail.com");

        users.addAll(Arrays.asList(user1,user2,user3,user4));
    }

    public UserModel getUser(Integer id){
        for(UserModel user : users){
            if(id.equals(user.getId())){
                return user;
            }
        }
        return null;
    }

    public ArrayList<Integer> getUserCart(Integer userId){
        UserModel user = getUser(userId);
        return user.getUserCart();
    }

    public void addUser(UserDTO user){
        users.add(user.toUserModel(users.size()));
    }

    public Boolean addToCart(Integer userId,Integer productId){
        UserModel user = getUser(userId);
        if(user != null){
            user.addToCard(productId);
            return true;
        } else {
            return false;
        }
    }

    public record UserDTO(UserModel.FullName fullName, UserModel.BirthDate birthDate, String email, UserModel.Address address) {
        public UserModel toUserModel(Integer id) {
                return new UserModel(id, this.fullName, this.birthDate, this.address, this.email);
            }
        }
}
