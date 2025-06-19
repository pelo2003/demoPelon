package SpringbootAPI.SpringbootAPI.Service;

import SpringbootAPI.SpringbootAPI.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(id:1, name:"ida", age: 32, email:"ida@mail.com")
        User user2 = new User(id:2, name:"poe", age: 22, email:"poe@mail.com")
        User user3 = new User(id:3, name:"sue", age: 42, email:"sue@mail.com")
        User user4 = new User(id:4, name:"ian", age: 30, email:"ian@mail.com")
        User user5 = new User(id:5, name:"ivy", age: 62, email:"ivy@mail.com")

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

    }
    public Optional<User> getUser(Integer id){
        Optional optional = Optional.empty();
        for(User user: userList){
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }

        }
        return optional;
    }
}