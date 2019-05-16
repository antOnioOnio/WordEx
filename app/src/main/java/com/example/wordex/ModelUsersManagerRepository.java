/*package com.example.wordex;
import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ModelUsersManagerRepository {

    private ModelUserDao mUserdAO;
    private LiveData<List<ModelUsers>> mAllusers;


    ModelUsersManagerRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mUserdAO = db.userDao();
        mAllusers = mUserdAO.getAll();

    }

    LiveData<List<ModelUsers>> getAllusers() {
        return mAllusers;
    }

    void insert(ModelUsers user) {new insertAsyncTask(mUserdAO).execute(user);}



    public boolean isLogin(String user){
        ModelUsers usuario = mUserdAO.findUserByUserName(user);

        if (usuario != null){
            return true;
        }else {
            return false;
        }

    }

    private static class insertAsyncTask extends AsyncTask<ModelUsers, Void, Void> {

        private ModelUserDao mAsyncDao;

        insertAsyncTask(ModelUserDao dao){
            mAsyncDao = dao;
        }

        @Override
        protected  Void doInBackground(final ModelUsers... params){
            mAsyncDao.insert(params[0]);
            return null;
        }

    }

}
*/