
/**
 * Write a description of class GuassianBlurFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuassianBlurFilter implements Filter 
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] blur = pi.getData();
        for (int row = 1; row < data.length-1; row++) {
            for (int col = 1; col < data[row].length-1; col++) {
                int red = (data[row-1][col-1].getRed()) + (data[row-1][col].getRed() *2) + (data[row-1][col+1].getRed()) + 
                (data[row][col-1].getRed()*2) + (data[row][col].getRed()*4) + (data[row][col+1].getRed()*2) +
                (data[row+1][col-1].getRed()) + (data[row+1][col].getRed()*2) + (data[row+1][col+1].getRed()) ;
                int avgRed = red/16;
                blur[row][col].setRed(avgRed);
                
                int green = (data[row-1][col-1].getGreen()) + (data[row-1][col].getGreen() *2) + (data[row-1][col+1].getGreen()) + 
                (data[row][col-1].getGreen()*2) + (data[row][col].getGreen()*4) + (data[row][col+1].getGreen()*2) +
                (data[row+1][col-1].getGreen()) + (data[row+1][col].getGreen()*2) + (data[row+1][col+1].getGreen()) ;
                int avgGreen = green/16;
                blur[row][col].setGreen(avgGreen);
                
                int blue = (data[row-1][col-1].getBlue()) + (data[row-1][col].getBlue() *2) + (data[row-1][col+1].getBlue()) + 
                (data[row][col-1].getBlue()*2) + (data[row][col].getBlue()*4) + (data[row][col+1].getBlue()*2) +
                (data[row+1][col-1].getBlue()) + (data[row+1][col].getBlue()*2) + (data[row+1][col+1].getBlue()) ;
                int avgBlue = blue/16;
                blur[row][col].setBlue(avgBlue);
                
            }
        }

        pi.setData(blur);
    }
}