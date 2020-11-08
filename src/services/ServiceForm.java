package services;

import views.draw.DrawVisitor;
import models.Form;

import java.util.Arrays;
import java.util.List;
/**
 * Class qui gere toutes les opérations sur les formes
 */
public final class ServiceForm {
    /**
     * Constructeur
     */
    public ServiceForm() {}
    /**
     *
     * @param forms :
     */
    public void manageAcceleration(List<Form> forms) {

    }
    /**
     * Fonction qui gère les collision entre les formes
     * @param forms : la liste des formes
     * @return vrai s'il y a collision faut sinon
     */
    public boolean manageCrashFormForm(List<Form> forms) {
        return true;
    }

    public <GRAPHIC> void drawForm(DrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g, List<Form> forms) {
        try {
            for (Form f: forms) f.draw(drawVisitor, g);
        } catch (NullPointerException nullPointerException) {
            throw new NullPointerException("The list of forms should be initialized");
        }
    }

    public <GRAPHIC> void drawForm(DrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g, Form... forms) {
        this.drawForm(drawVisitor, g, Arrays.asList(forms));
    }
}
