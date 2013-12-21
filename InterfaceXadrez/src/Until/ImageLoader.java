/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Until;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;


public class ImageLoader
{
    public static Image LoadImage(String file)
    {
        Image image = null;

        try
        {
            image = ImageIO.read(new File(file));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        return image;
    }
}