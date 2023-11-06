package com.ddm.petfood.ui.meal;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.RacaoRepository;

import java.util.ArrayList;
import java.util.List;

public class MealViewModel extends ViewModel {

    private MutableLiveData<List<Racao>> meals;
    private RacaoRepository racaoRepository;

    private Context context;

    public MealViewModel() {
        this.meals = new MutableLiveData<List<Racao>>();
        this.meals.setValue(new ArrayList<>());
    }

    public void setContext(Context context){
        this.context = context;
        this.racaoRepository = new RacaoRepository(context);
    }

    public LiveData<List<Racao>> getMeals() {
        return meals;
    }

    public void addMeal(){
        Racao meal = new Racao("Meal massa ai", "Tem uns kg ai");

        List<Racao> mealList = this.meals.getValue();
        mealList.add(meal);
        this.meals.setValue(mealList);
    }
}