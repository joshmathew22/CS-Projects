/**
 * Defines a filter method to modify images
 * 
 * @author Richard Dunn
 * @version March 2, 2002
 */

public interface Filter
{
    /**
     * Modify the image according to your algorithm
     * 
     * @param  theImage The image to modify
     */
    void filter(PixelImage theImage);
}
