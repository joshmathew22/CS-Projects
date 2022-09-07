
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
  
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {

                
                int red = data[row][col].getRed();
                int green = data[row][col].getGreen();
                int blue = data[row][col].getBlue();
                data[row][col].setRed(255-red);
                data[row][col].setGreen(255- green);
                data[row][col].setBlue(255-blue);
           
            }
        }

        pi.setData(data);
    }
}
