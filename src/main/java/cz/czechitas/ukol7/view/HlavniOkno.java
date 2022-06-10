package cz.czechitas.ukol7.view;

import com.jgoodies.common.bean.Bean;
import cz.czechitas.ukol7.controller.Barva;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static java.lang.String.valueOf;

public class HlavniOkno extends JFrame {
    private final PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Oblíbená barva - aplikace");
        this.controller = controller;
        this.init();
    }


    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new MigLayout("wrap 2"));
        setMinimumSize(new Dimension(400, 200));

        FormBuilderWithContainer<Bean> formBuilder = FormBuilder.create(controller.getModel())
                .container(this);

        formBuilder
                .label("&Přezdívka")
                .textField("prezdivka")
                .add();

        for (Barva prvniBarva : Barva.values()){
            formBuilder.radioButton(prvniBarva.getText(), "barva", prvniBarva)
                    .add("span");
        }

//Pozn.Toto je řešení bez bonusové úlohy-> tady je někde chyba - barva je null ve výpisu a tudíž i tlačítko uložit je pořád šedivé
//        formBuilder
//        .panel(panel->{
//            JRadioButton cervena= new JRadioButton(Barva.CERVENA.getText());
//            JRadioButton zluta= new JRadioButton(Barva.ZLUTA.getText());
//
//            ButtonGroup skupina= new ButtonGroup();
//            skupina.add(cervena);
//            skupina.add(zluta);
//            panel.add(cervena);
//            panel.add(zluta);
//            }
//    )
//        .add();


        formBuilder.panel(panel -> {
            JButton ulozitButton = new JButton(controller.getUlozitAction());

            getRootPane().setDefaultButton(ulozitButton);

            panel.add(ulozitButton);
        }).add("right, span");
        pack();

    }
}
