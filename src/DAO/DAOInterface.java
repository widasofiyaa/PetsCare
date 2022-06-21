package DAO;

import java.util.List;
public interface DAOInterface<A>{
    
    public void insert(A object);
    public void update(A object);
    public void delete(Integer id);
    public List<A> get(String key);
    public List<A> getAll();

}

