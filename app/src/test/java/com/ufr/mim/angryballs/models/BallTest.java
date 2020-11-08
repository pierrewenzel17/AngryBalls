package com.ufr.mim.angryballs.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

final class BallTest {

    private List<IBall> _forms;

    @BeforeEach
    void setUp() {
        /*
        _forms = new ArrayList<>();
        _forms.add(new Ball(2, String.RED));
        _forms.add(new Ball(2, String.YELLOW));
        _forms.add(new Ball(2, String.GREEN));
        _forms.add(new Ball(2, String.BLUE));
        _forms.add(new Ball(2, String.WHITE));
        _forms.add(new Ball(2, String.BLACK));

         */
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toStringForms() {
        for (IBall f : _forms) {
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