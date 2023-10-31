package com.ddm.petfood.ui.pet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.databinding.FragmentPetBinding;

public class PetViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pet fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
