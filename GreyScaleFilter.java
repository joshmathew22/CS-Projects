
/**
 * Write a description of class GreyScaleFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 
public class GreyScaleFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
      
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                
                
                int red = data[row][col].getRed();
                int green = data[row][col].getGreen();
                int blue = data[row][col].getBlue();
                int avg = (red+green+blue)/3;
                data[row][col].setRed(avg);
                data[row][col].setGreen(avg);
                data[row][col].setBlue(avg);
           
            }
        }

        pi.setData(data);
    }
}
