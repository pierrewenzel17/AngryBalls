package models;

import models.enums.ColorForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormTest {

    private List<Form> _forms;

    @BeforeEach
    void setUp() {
        _forms = new ArrayList<>();
        _forms.add(new Ball(2, ColorForm.RED));
        _forms.add(new Ball(2, ColorForm.YELLOW));
        _forms.add(new Ball(2, ColorForm.GREEN));
        _forms.add(new Ball(2, ColorForm.BLUE));
        _forms.add(new Ball(2, ColorForm.WHITE));
        _forms.add(new Ball(2, ColorForm.BLACK));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toStringForms() {
        for (Form f : _forms) {
            System.out.println(f.toString());
            assertNotEquals("", f.toString());
        }
    }

    @Test
    void FormId() {
        for (int i = 0; i < _forms.size(); i++)
            for (int j = 0; j < _forms.size(); j++) {
                if (i == j) assertEquals(_forms.get(i).hashCode(), _forms.get(j).hashCode());
                else assertNotEquals(_forms.get(i).hashCode(), _forms.get(j).hashCode());
            }
    }
}