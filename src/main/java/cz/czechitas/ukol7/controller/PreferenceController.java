package cz.czechitas.ukol7.controller;

import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;
import cz.czechitas.ukol7.model.PreferenceBean;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class PreferenceController {
    private final PresentationModel <PreferenceBean> model;
    private Action ulozitAction;
    public PreferenceController() {
        model = new PresentationModel<>(new PreferenceBean());
        ulozitAction = ActionBuilder.create("&Uložit", this::handleUlozit);
        model.addBeanPropertyChangeListener(this::handlePropertyChange);
        vypoctiStavAkci();
    }

    private void handlePropertyChange(PropertyChangeEvent propertyChangeEvent) {
        vypoctiStavAkci();
    }

    public PresentationModel<PreferenceBean> getModel() {
        return model;
    }

    public Action getUlozitAction() {
        return ulozitAction;
    }

    private void vypoctiStavAkci() {

        if(model.getBean().getBarva()==null||model.getBean().getPrezdivka()==null){
            ulozitAction.setEnabled(false);
        }else{
            ulozitAction.setEnabled(true);
        }}



    public void handleUlozit() {
        PreferenceBean bean = this.model.getBean();
        System.out.println("Byla uložena tato data:");
        System.out.printf("Přezdívka: %s", bean.getPrezdivka()).println();
        System.out.printf("Oblíbená barva: %s", bean.getBarva().getText()).println();
    }

}
