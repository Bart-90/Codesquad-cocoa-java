package Day18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DrawingBoard extends JFrame{

   Panel guiPanel, paintPanel;
   JRadioButton penBtn, eraserBtn, circleBtn, squareBtn;
   JButton colorSelectBtn;

   int startX;
   int startY;
   int endX;
   int endY;

   Color selectedColor;

   Graphics graphics;
   Graphics2D g;

}
