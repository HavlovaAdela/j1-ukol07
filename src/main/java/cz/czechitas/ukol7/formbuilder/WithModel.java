package cz.czechitas.ukol7.formbuilder;

import com.jgoodies.common.bean.Bean;

import java.awt.*;

/**
 * @author Filip Jirsák
 */
public interface WithModel<B> {
  FormBuilderWithContainer<Bean> container(Container container);
}
