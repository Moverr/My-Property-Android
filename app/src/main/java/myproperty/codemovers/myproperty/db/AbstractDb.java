package myproperty.codemovers.myproperty.db;

/**
 * Created by Manny on 11/3/2017.
 */

abstract public  class AbstractDb<T>  {
    public  abstract  void insertRecord(Class<T> aClass);
    public abstract void updateRecord(Integer recordId, Class<T> tClass);
}
