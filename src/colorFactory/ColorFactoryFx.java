package colorFactory;

import javafx.scene.paint.Color;
import models.enums.ColorForm;
import java.util.HashMap;

public final class ColorFactoryFx extends ColorFactory<Color> {

    public ColorFactoryFx() {
        this._colorMap = new HashMap<>();
        for(ColorForm c : ColorForm.values()) this._colorMap.put(c,Color.valueOf(c.value));
    }

    @Override
    public Color MapColor(ColorForm colorForm) {
        return _colorMap.get(colorForm);
    }
}
