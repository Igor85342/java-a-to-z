package ru.moskalets.inputOutput;

import java.io.File;
import java.io.FileFilter;

/**
 * Filter - exclude from list all files with the selected format.
 * @author Igor Moskalets.
 * @since 02.04.2017.
 */
public class Filter implements FileFilter {
    String[] ext;
    Filter(String ext) {
        this.ext = ext.split(",");
    }
    /**
     * The method compares the file format.
     * @param File pathname.
     * @return String.
     */
    private String getExtension(File pathname)
    {
        String filename = pathname.getPath();
        int i = filename.lastIndexOf('.');
        if ((i > 0) && (i < filename.length()-1)) {
            return filename.substring(i+1).toLowerCase();
        }
        return "";
    }
    /**
     * The method filters the file with a specific format.
     * @param File pathname.
     * @return boolean.
     */
    public boolean accept(File pathname)
    {
        if (!pathname.isFile())
            return true;
        String extension = getExtension(pathname);
        for (String e : ext) {
            if (e.equalsIgnoreCase(extension))
                return false;
        }
        return true;
    }
}
