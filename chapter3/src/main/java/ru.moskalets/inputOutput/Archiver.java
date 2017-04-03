package ru.moskalets.inputOutput;



import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Archiver - class archives the project at the specified path.
 * @author Igor Moskalets.
 * @since 02.04.2017.
 */
public class Archiver {
    private final String pathInput;
    private final String pathOutput;
    private final String filterFormat;
    public Archiver(String pathInput,String pathOutput, String filterFormat) {
        this.pathInput = pathInput;
        this.pathOutput = pathOutput;
        this.filterFormat = filterFormat;
    }
    /**
     * The main method of the archiver.
     * @return void.
     */
    public void zip() throws Exception {
        File inputDir = new File(this.pathInput);
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(this.pathOutput));
        try {
            moveToDirectory(zout, inputDir);
        }
            catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            zout.close();
        }
    }
    /**
     * Method iterates through a directory and adds each file in the archive.
     * @param ZipOutputStream zout.
     * @param File inputDir.
     * @return void.
     */
    public void moveToDirectory(ZipOutputStream zout, File inputDir) throws Exception{
        File[] files = inputDir.listFiles(new Filter(this.filterFormat));
        FileInputStream fis = null;
            for (File file : files) {
                if (file.isDirectory()) {
                    moveToDirectory(zout, file);
                } else {
                    try {
                        fis = new FileInputStream(new File(file.getAbsolutePath()));
                        String parent = file.getParent().substring(file.getParent().lastIndexOf("\\") + 1);
                        zout.putNextEntry(new ZipEntry(parent + "\\" + file.getName()));
                        byte[] buffer = new byte[4048];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            zout.write(buffer, 0, length);
                        }
                    }
                    catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    finally {
                        try {
                            if (fis != null) {
                                fis.close();
                            }
                            zout.closeEntry();
                        }
                        catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }

    }
}
