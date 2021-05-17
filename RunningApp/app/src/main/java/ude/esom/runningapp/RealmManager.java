package ude.esom.runningapp;

import android.content.Context;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.Sort;

public class RealmManager<T extends RealmModel>  {
    private Realm realm;
    private static final String REALM_NAME = "Running App";

    public RealmManager() {}

    public void initialize(Context context)
    {
        Realm.init(context);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(REALM_NAME)
                .allowWritesOnUiThread(true)
                .allowQueriesOnUiThread(true)
                .build();
        realm = Realm.getInstance(config);
    }

    public void create(T entry)
    {
        realm.executeTransaction (transactionRealm -> {
            transactionRealm.insert(entry);
        });
    }

    public List<T> getEntries(Class<T> clazz)
    {
        return realm.where(clazz).findAll().sort("datePerformed", Sort.DESCENDING);
    }

    public T getEntry(String id, Class<T> clazz)
    {
        return realm.where(clazz).equalTo("id", id).findFirst();
    }

    public void update(T object)
    {
        realm.executeTransaction( transactionRealm -> {
            transactionRealm.copyToRealmOrUpdate(object);
        });
    }

    public void delete(String id, Class<T> clazz)
    {
        realm.executeTransaction( transactionRealm -> {
            T entry = transactionRealm.where(clazz).equalTo("id", id).findFirst();
            if(entry != null) ((RealmObject)entry).deleteFromRealm();
        });
    }
}

