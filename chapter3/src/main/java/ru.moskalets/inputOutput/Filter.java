package ru.moskalets.inputOutput;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Пользователь on 30.03.2017.
 */
public class Filter implements FileFilter {
    String[] ext;

    Filter(String ext) {
        this.ext = ext.split(",");
    }
    private String getExtension(File pathname)
    {
        String filename = pathname.getPath();
        int i = filename.lastIndexOf('.');
        if ((i > 0) && (i < filename.length()-1)) {
            return filename.substring(i+1).toLowerCase();
        }
        return "";
    }
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
