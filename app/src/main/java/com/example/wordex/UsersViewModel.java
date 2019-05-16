/*package com.example.wordex;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {
    private ModelUsersManagerRepository mRepository;

    private LiveData<List<ModelUsers>> usuarios;

    public UsersViewModel(Application application){
        super(application);
        mRepository = new ModelUsersManagerRepository(application);
        usuarios = mRepository.getAllusers();

    }

    LiveData<List<ModelUsers>> getUsuarios(){
        return usuarios;
    }

    public boolean isLogIn(String name){
        return mRepository.isLogin(name);
    }



}
*/