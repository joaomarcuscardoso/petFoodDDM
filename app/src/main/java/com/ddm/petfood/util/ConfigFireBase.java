package com.ddm.petfood.util;

import com.google.firebase.auth.FirebaseAuth;

public class ConfigFireBase {

    private static FirebaseAuth auth;

    public static FirebaseAuth FireBaseAuth(){
        if (auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
