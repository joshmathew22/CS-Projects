
/**
 * Write a description of class LaplacianFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LaplacianFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] lap = pi.getData();
        for (int row = 1; row < data.length-1; row++) {
            for (int col = 1; col < data[row].length-1; col++) {
                int red = (data[row-1][col-1].getRed()*-1) + (data[row-1][col].getRed() *-1) + (data[row-1][col+1].getRed()*-1) + 
                (data[row][col-1].getRed()*-1) + (data[row][col].getRed()*8) + (data[row][col+1].getRed()*-1) +
                (data[row+1][col-1].getRed()*-1) + (data[row+1][col].getRed()*-1) + (data[row+1][col+1].getRed()*-1) ;
                if(red<=255 && red>=0){
                    lap[row][col].setRed(red);
                }else if(red>255){
                    lap[row][col].setRed(255);
                }else if(red<0){
                    lap[row][col].setRed(0);
                }
                
                int green = (data[row-1][col-1].getGreen()*-1) + (data[row-1][col].getGreen()*-1) + (data[row-1][col+1].getGreen()*-1) + 
                (data[row][col-1].getGreen()*-1) + (data[row][col].getGreen()*8) + (data[row][col+1].getGreen()*-1) +
                (data[row+1][col-1].getGreen()*-1) + (data[row+1][col].getGreen()*-1) + (data[row+1][col+1].getGreen()*-1) ;
                if(green<=255 && green>=0){
                    lap[row][col].setGreen(green);
                }else if(green>255){
                    lap[row][col].setGreen(255);
                }else if(green<0){
                    lap[row][col].setGreen(0);
                }
                
                int blue = (data[row-1][col-1].getBlue()*-1) + (data[row-1][col].getBlue() *-1) + (data[row-1][col+1].getBlue()*-1) + 
                (data[row][col-1].getBlue()*-1) + (data[row][col].getBlue()*8) + (data[row][col+1].getBlue()*-1) +
                (data[row+1][col-1].getBlue()*-1) + (data[row+1][col].getBlue()*-1) + (data[row+1][col+1].getBlue()*-1) ;
                if(blue<=255 && blue>=0){
                    lap[row][col].setBlue(blue);
                }else if(blue>255){
                    lap[row][col].setBlue(255);
                }else if(blue<0){
                    lap[row][col].setBlue(0);
                }
            }
        }

        pi.setData(lap);
    }
}