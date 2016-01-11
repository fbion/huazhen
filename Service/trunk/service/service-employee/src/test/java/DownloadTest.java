import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2015/5/29.
 */
public class DownloadTest {

    @Test
    public void downloadFileTest(){

        downloadFile("//192.168.1.232/home/shell/transaction/人事异动表14.xls","d:\\人事异动表14.xls");

    }

    public void downloadFile(String remoteFilePath, String localFilePath)
    {
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);
        try
        {
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection)urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1)
            {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bis.close();
                bos.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }




}
