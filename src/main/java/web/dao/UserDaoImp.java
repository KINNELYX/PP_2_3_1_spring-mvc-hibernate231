package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManger;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManger.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManger.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManger.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManger.remove(getUser(id));
    }
}
