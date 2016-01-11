package com.hzframework.io;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by paul on 15-2-23.
 */
public class FileOperate {
    public static String[] getFiles(String path, String filter, boolean includeSubdirectories) {
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();

        ArrayList<String> files = new ArrayList<String>();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                if ((filter.contains("*") && array[i].getName().equals(filter)) ||
                        (filter.contains("*") && PathUtils.GetExtensionName(array[i].getName()).equals(PathUtils.GetExtensionName(filter))))
                    // take file path and name
                    files.add(array[i].getPath());
            } else if (includeSubdirectories && array[i].isDirectory()) {
                getFiles(array[i].getPath(), filter, includeSubdirectories);
            }
        }

        return (String[]) files.toArray();
    }

    public static boolean renameFile(String strSrcPath, String strDstPath) {
        String srcPath, dstPath;
        srcPath = strSrcPath.trim();
        dstPath = strDstPath.trim();
        if (srcPath.charAt(srcPath.length() - 1) == File.separatorChar)
            srcPath = srcPath.substring(0, srcPath.length() - 1);
        if (dstPath.charAt(dstPath.length() - 1) == File.separatorChar)
            dstPath = dstPath.substring(0, dstPath.length() - 1);

        if (srcPath.equals("") || dstPath.equals("") || srcPath.equals(dstPath)) {
            System.out.println("Path is error(FileOperate.renameFile())");
            return false;
        }
        File file1 = new File(srcPath);
        if (!file1.exists()) {
            System.out.println("Source Path is error(FileOperate.renameFile())");
            return false;
        }

        if (file1.isDirectory())   //dir
        {
            System.out.println("Source Path isn't file(FileOperate.renameFile())");
            return false;
        } else   //file
        {
            File file2 = new File(dstPath);
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    System.out.println(
                            "Destination Path is error(FileOperate.copyFile())");
                    return false;
                } else {
                    file2.delete();
                }
            } else {
                File file3 = file2.getParentFile();
                if ((file3 != null) && !file3.exists()) {
                    file3.mkdirs();
                }
            }
            return file1.renameTo(file2);
        }

    }//function renameFile end

    public static void copyFile(String strSrcPath, String strDstPath) {
        String srcPath, dstPath;
        srcPath = strSrcPath.trim();
        dstPath = strDstPath.trim();
        if (srcPath.charAt(srcPath.length() - 1) == File.separatorChar)
            srcPath = srcPath.substring(0, srcPath.length() - 1);
        if (dstPath.charAt(dstPath.length() - 1) == File.separatorChar)
            dstPath = dstPath.substring(0, dstPath.length() - 1);

        if (srcPath.equals("") || dstPath.equals("") || srcPath.equals(dstPath)) {
            System.out.println("Path is error(FileOperate.copyFile())");
            return;
        }
        File file1 = new File(srcPath);
        if (!file1.exists() || file1.isDirectory()) {
            System.out.println("Source Path is error(FileOperate.copyFile())");
            return;
        }
        File file2 = new File(dstPath);
        File file3 = file2.getParentFile();
        if ((file3 != null) && !file3.exists()) {

            file3.mkdirs();
        }
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcPath), 8192);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dstPath), 8192);
            byte[] btData = new byte[1024];
            int size;
            while ((size = in.read(btData)) != -1) {
                out.write(btData, 0, size);
            }
            out.flush();
            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//copyFile end

    public static void copyFiles(String strSrcDir, String strDstDir) {
        String srcDir, dstDir;
        srcDir = strSrcDir.trim();
        dstDir = strDstDir.trim();
        if (!srcDir.equals(File.separator))
            if (srcDir.charAt(srcDir.length() - 1) == File.separatorChar)
                srcDir = srcDir.substring(0, srcDir.length() - 1);
        if (!dstDir.equals(File.separator))
            if (dstDir.charAt(dstDir.length() - 1) == File.separatorChar)
                dstDir = dstDir.substring(0, dstDir.length() - 1);

        if (srcDir.equals("") || dstDir.equals("") || srcDir.equals(dstDir)) {
            System.out.println("Path is error(FileOperate.copyFiles())");
            return;
        }
        File file1 = new File(srcDir);
        if (!file1.isDirectory()) {
            System.out.println("Source Path is error(FileOperate.copyFiles())");
            return;
        }
        File file2 = new File(dstDir);
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                System.out.println("Destination Path is error(FileOperate.copyFiles())");
                return;
            }
        } else {
            file2.mkdirs();
        }

        String[] fileNames = file1.list();

        for (int i = 0; i < fileNames.length; i++) {
            File file = new File(file1, fileNames[i]);
            if (file.isDirectory()) {
                copyFiles(srcDir + File.separator + fileNames[i], dstDir + File.separator + fileNames[i]);
            } else {
                copyFile(srcDir + File.separator + fileNames[i], dstDir + File.separator + fileNames[i]);
            }
        }

    }//copyFiles end

    public static void moveFile(String strSrcPath, String strDstPath) {
        copyFile(strSrcPath, strDstPath);
        deleteFile(strSrcPath);
    }//moveFile end

    public static void moveFiles(String strSrcDir, String strDstDir) {
        copyFiles(strSrcDir, strDstDir);
        deleteFiles(strSrcDir, true);
    }//moveFiles end


    public static boolean deleteFile(String strPath) {
        File file = new File(strPath.trim());
        if (file.exists()) {
            System.out.println("delete file is unsuccessful(FileOperate.deleteFile())");
            return file.delete();
        } else {
            System.out.println("File or Dir isn't existent(FileOperate.deleteFile())");
            return false;
        }
    }//deleteFile end

    public static void deleteFiles(String strDir, boolean deleteDir) {
        String dir = strDir.trim();
        if (dir.charAt(dir.length() - 1) == File.separatorChar)
            dir = dir.substring(0, dir.length() - 1);
        if (dir.equals("")) {
            System.out.println("Path is error(FileOperate.deleteFiles())");
            return;
        }
        File file = new File(dir);
        if (!file.exists()) {
            System.out.println("file or dir isn't existent(FileOperate.deleteFiles())");
            return;
        }
        if (file.isDirectory()) {
            String[] fileNames = file.list();
            for (int i = 0; i < fileNames.length; i++) {
                File subFile = new File(file, fileNames[i]);
                if (subFile.isDirectory()) {
                    deleteFiles(dir + File.separator + fileNames[i], deleteDir);
                    if (deleteDir)
                        subFile.delete();
                } else {
                    subFile.delete();
                }
            }
            if (deleteDir)
                file.delete();
        } else {
            file.delete();
        }
    }//deleteFiles end
}
