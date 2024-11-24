package com.example.exam2.Service;

import com.example.exam2.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users=new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean updateService(User user,String id){
        for (int i = 0; i <users.size() ; i++) {
            if(users.get(i).getID().equals(id)){
                users.set(i,user);
                return true;
            }

        }
        return false;
    }
    public boolean deleteService(String id){
        for (int i = 0; i <users.size() ; i++) {
            if(users.get(i).getID().equals(id)){
                users.remove(i);
                return true;
            }

        }
        return false;
    }

    public ArrayList<User> searchByBalance(int balance){
    ArrayList<User>balances=new ArrayList<>();
       for(User user1:users){
           if(user1.getBalance()>=balance){
               balances.add(user1);
               return balances;
           }

        }
       return null;
    }

    public ArrayList<User> searchByAge(int age){
        ArrayList<User>ages=new ArrayList<>();
        for(User user1:users){
            if(user1.getAge()>=age){
                ages.add(user1);
                return ages;
            }
        }
        return null;
    }




}
