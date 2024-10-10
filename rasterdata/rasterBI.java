package rasterdata;

public class rasterBI implements Raster {
    private final BufferedImage image;
    
    public rasterBI(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public int width() {
        return image.getWidth();
    }
    @Override
    public int height() {
        //return this.height();
        return image.getHeight();
    }
    @Override
    public void setColor(int c,int r, int color) {
        //check bounderies
        //set pixel if address is valid,else do nothing
        if(c>=0 && c<width() && r>=0 && r<height()) {
            image.setColor(c, r, color);
        }
    }
    @Override
    public Optional<Intager> getColor(int c,int r) {
        //check bounderies
        //if adress is valid return Optional.of()
        //else return Optional.empty()
        if(c>=0 && c<width() && r>=0 && r<height()) {
            return Optional.of(image.getColor(c, r));
        }else {
            return Optional.empty();
        }
        
    }
}
