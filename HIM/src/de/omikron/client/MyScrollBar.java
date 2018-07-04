package de.omikron.client;

import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class MyScrollBar {

  static class MyScrollbarUI extends MetalScrollBarUI {
    private Image imageThumb, imageTrack;
    public MyScrollbarUI() {
        try {
            imageThumb = ImageIO.read(new File("res/thumb.png"));
            imageTrack = ImageIO.read(new File("res/track.png"));
        } catch (IOException e){}
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {        
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor( Color.red );
        g.drawRect( 0, 0, thumbBounds.width - 2, thumbBounds.height - 1 );
        AffineTransform transform = AffineTransform.getScaleInstance((double)thumbBounds.width/imageThumb.getWidth(null),(double)thumbBounds.height/imageThumb.getHeight(null));
        ((Graphics2D)g).drawImage(imageThumb, transform, null);
        g.translate( -thumbBounds.x, -thumbBounds.y );
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {        
        g.translate(trackBounds.x, trackBounds.y);
        ((Graphics2D)g).drawImage(imageTrack,AffineTransform.getScaleInstance(1,(double)trackBounds.height/imageTrack.getHeight(null)),null);
        g.translate( -trackBounds.x, -trackBounds.y );
    }

  }
}