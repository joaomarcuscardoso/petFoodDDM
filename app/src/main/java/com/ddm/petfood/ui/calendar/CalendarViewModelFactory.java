package com.ddm.petfood.ui.calendar;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.repository.CalendarioRepository;
import com.ddm.petfood.ui.meal.MealViewModel;

public class CalendarViewModelFactory implements ViewModelProvider.Factory {

    private final CalendarioRepository calendarioRepository;

    public CalendarViewModelFactory(CalendarioRepository calendarioRepository){
        this.calendarioRepository = calendarioRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CalendarViewModel.class)) {
            return (T) new CalendarViewModel(calendarioRepository);
        }
        throw new IllegalArgumentException("Classe ViewModel desconhecida: " + modelClass.getName());
    }

}
