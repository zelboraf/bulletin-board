package pl.coderslab.bulletinBoard.security;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
