//
//import org.apache.tools.zip.UnixStat;
//import org.apache.tools.zip.Zip64Mode;
//import org.apache.tools.zip.ZipEntry;
//import org.apache.tools.zip.ZipOutputStream;
//
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.zip.CRC32;
//
//public class ZipUtil {
//
//
//    /**
//     * 文件压缩
//     *
//     * @param srcFile
//     * @param zipFile
//     * @throws Exception
//     */
//    public static void doCompress(String srcFile, String zipFile) throws Exception {
//        doCompress(new File(srcFile), new File(zipFile));
//    }
//
//    /**
//     * 文件压缩
//     *
//     * @param pathname
//     * @param out
//     * @throws IOException
//     */
//    public static void doCompress(String pathname, ZipOutputStream out) throws IOException {
//        doCompress(new File(pathname), out);
//    }
//
//    /**
//     * 对多个文件进行压缩
//     *
//     * @param destFile 目标文件
//     * @param files    源文件
//     * @throws IOException
//     */
//    public static void doCompress(File destFile, String[] files) throws IOException {
//        try (ZipOutputStream out = new ZipOutputStream(destFile)) {
//            for (String file : files) {
//                File f = new File(file);
//                if (!f.exists()) {
//
//                    continue;
//                }
//                doCompress(file, out);
//            }
//        }
//    }
//
//    /**
//     * 文件压缩
//     *
//     * @param srcFile  目录或者单个文件
//     * @param destFile 压缩后的ZIP文件
//     */
//    public static void doCompress(File srcFile, File destFile) throws Exception {
//        try (ZipOutputStream out = new ZipOutputStream(destFile)) {
//            if (srcFile.isDirectory()) {
//                File[] files = srcFile.listFiles();
//                if (files != null) {
//                    for (File file : files) {
//                        doCompress(file, out);
//                    }
//                }
//            } else {
//                doCompress(srcFile, out);
//            }
//        }
//    }
//
//
//    private static void doCompress(File file, ZipOutputStream out, String fileName) throws IOException {
//        if (file.exists()) {
//            try (FileInputStream fis = new FileInputStream(file)) {
//                byte[] buffer = new byte[1024];
//                ZipEntry ze = new ZipEntry(fileName);
//                out.putNextEntry(ze);
//                int len = 0;
//                // 读取文件的内容,打包到zip文件
//                while ((len = fis.read(buffer)) > 0) {
//                    out.write(buffer, 0, len);
//                }
//                out.flush();
//                out.closeEntry();
//            }
//        }
//    }
//
//
//    private static void doCompress(File file, ZipOutputStream out) throws IOException {
//        doCompress(file, out, file.getName());
//    }
//
//
//    public static void doCompressMulti(String[] files, ZipOutputStream out, String[] fileNames, String[] folders) throws IOException {
//        int counter = 0;
//        out.setEncoding("UTF-8");
//        out.setUseZip64(Zip64Mode.Always);
////        out.setMethod(ZipEntry.STORED);
//
//        if (folders != null && folders.length > 0) {
//            for (String folder : folders) {
//                ZipEntry ze = new ZipEntry(folder);
//    //            ze.setUnixMode(UnixStat.DEFAULT_DIR_PERM);
//                out.putNextEntry(ze);
//            }
//        }
//
//        for (String f : files) {
//            File file = new File(f);
//            if (file.exists()) {
//                try (FileInputStream fis = new FileInputStream(file)) {
//                    byte[] buffer = new byte[1024 * 4];
//                    String fileName = fileNames[counter++];
//                    ZipEntry ze = new ZipEntry(fileName);
//     //               ze.setUnixMode(UnixStat.DEFAULT_FILE_PERM);
////                    CRC32 crc32 = new CRC32();
////                    ze.setCrc(crc32.getValue());
//            //        logger.info(ze.getName()+" || " + ze.getUnixMode()+" || " + ze.getPlatform()+" || " + ze.getCrc()+" || " + ze.getMethod()+" || " + ze.getExternalAttributes());
//                    out.putNextEntry(ze);
//                    int len = 0;
//                    // 读取文件的内容,打包到zip文件
//                    while ((len = fis.read(buffer)) > 0) {
//                        out.write(buffer, 0, len);
//                    }
//                    out.flush();
//                    out.closeEntry();
//                }
//            }
//        }
//
//    }
//    public static void main(String[] args) throws IOException {
//        ArrayList<String> fileNames = new ArrayList<>();
//        ArrayList<String> fileObjs = new ArrayList<>();
//        String tempFileName = "C:\\Users\\JCX\\Desktop\\a.zip";
//
//        String filepath = "C:\\Users\\JCX\\Desktop\\中文1\\";
//        File file = new File(filepath);
//        String[] fileList = file.list();
//        String[] paramFileNames = new String[fileList.length];
//        String[] paramFileObjs = new String[fileList.length];
//        String[] paramFolders = new String[1];
//        paramFolders[0] = "中文\\";
//        try {
//            File tempFile = new File(tempFileName);
//            tempFile.createNewFile();
//
//            for (String str : fileList) {
//                fileNames.add(str);
//                fileObjs.add(filepath+str);
//            }
//            fileNames.toArray(paramFileNames);
//            for(int i = 0 ;i <paramFileNames.length;i++) {
//                paramFileNames[i] = "中文\\" + paramFileNames[i];
//            }
//            fileObjs.toArray(paramFileObjs);
//            try (ZipOutputStream out = new ZipOutputStream(tempFile)) {
//                ZipUtil.doCompressMulti(paramFileObjs, out, paramFileNames, paramFolders);
//            } catch (Exception e) {
//                throw e;
//            }
//        } catch (Exception e) {
//
//        }
//
//        File zipFile = new File(tempFileName);
//        String tempFileName2 = "C:\\Users\\JCX\\Desktop\\中文传输.zip";
//        FileOutputStream fileOutputStream = new FileOutputStream(tempFileName2);
//        byte[] buffer = new byte[1024*1024];
//        FileInputStream fileInputStream = new FileInputStream(zipFile);
//        int bytesRead = 0;
//        while((bytesRead = fileInputStream.read(buffer,0,1024*1024))!=-1) {
//            fileOutputStream.write(buffer,0,bytesRead);
//        }
//        fileInputStream.close();
//        fileOutputStream.close();
//
//    }
//
//
//}
