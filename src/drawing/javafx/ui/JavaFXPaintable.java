/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.javafx.ui;

import drawing.domain.IPaintable;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author DellLatFlex
 */
public abstract class JavaFXPaintable implements IPaintable {
    private GraphicsContext gc;
}
