package cz.czechitas.ukol7.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;
import cz.czechitas.ukol7.controller.Barva;

import java.beans.PropertyChangeListener;

public class PreferenceBean implements ObservableBean {
    private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);
    private String prezdivka;
    private Barva barva;

    public Barva getBarva() {
        return barva;
    }
    public void setBarva(Barva barva) {
        Barva oldValue= this.barva;
        this.barva = barva;
        pcs.firePropertyChange("barva", oldValue, barva);

    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        this.prezdivka = prezdivka;
        String oldValue= this.prezdivka;
        pcs.firePropertyChange("přezdívka", oldValue, prezdivka);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
pcs.removePropertyChangeListener(listener);
    }
}
