package rasterdata;
 
/*
 * Represents a two dimensional grid with colors.
 */
public class Raster {
    int width();
    int height();

    void setColor(int r, int c, int color) ;
    //int getColor(int r, int c);

    Optional<Intager> getColor(int c, int r);
}
