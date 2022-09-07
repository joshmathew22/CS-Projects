
/**
 * Write a description of class NegativeImageFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NegativeImageFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
             int red;        // changed to private Adam Heck and Stephen Preast    4/20/04        
    
            private int green;      //  "           "       "
    
            private int blue;       //  "           "       "

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {

                
                data[row][col].getRed();
                data[row][col].getGreen();
                data[row][col].getBlue();
                Pixel(255-red, 255-green, 255-blue);
            }
        }

        pi.setData(data);
    }
}
