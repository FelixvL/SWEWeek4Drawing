/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4drawingswe.domain;

import drawing.domain.Oval;
import drawing.domain.PaintedText;
import drawing.domain.Image;

import java.awt.Point;

import java.awt.Color;

/**
 *
 * @author DellLatFlex
 */
public interface IPaintable {
    void setColor(Color color);
    void paintOval(Oval oval);
    void paintLine(Point from, Point to, int weight);
    void paintText(PaintedText text);
    void paintImage(Image image);
    void clear();
}
