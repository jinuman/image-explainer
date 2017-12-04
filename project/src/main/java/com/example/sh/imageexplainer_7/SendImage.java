package com.example.sh.imageexplainer_7;

import android.os.Handler;
import android.os.Message;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SH on 2017-11-29.
 */



public class SendImage extends Thread{

    public Handler m_handler;
    String lineEnd = "\r\n";
    String twoHyphens = "--";
    String boundary = "*****";
    String urlString = "SERVER_URL";
    byte[] data;
    String fileName;


    SendImage(byte[] data, String fileName,Handler handler)
    {
        this.data = data;
        this.fileName = fileName;
        this.m_handler = handler;
    }

    public void run() {

        try{
            //선택한 파일의 절대 경로를 이용해서 파일 입력 스트림 객체를 얻어온다.
            //FileInputStream mFileInputStream = new FileInputStream(fileName);
            //파일을 업로드할 서버의 url 주소를이용해서 URL 객체 생성하기.
            URL connectUrl = new URL(urlString);
            //Connection 객체 얻어오기.
            HttpURLConnection conn = (HttpURLConnection)connectUrl.openConnection();
            conn.setDoInput(true);//입력할수 있도록
            conn.setDoOutput(true); //출력할수 있도록
            conn.setUseCaches(false);  //캐쉬 사용하지 않음
            //post 전송
            conn.setRequestMethod("POST");
            //파일 업로드 할수 있도록 설정하기.
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            //DataOutputStream 객체 생성하기.
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            //전송할 데이터의 시작임을 알린다.
            //dos.writeBytes(twoHyphens + boundary + lineEnd);
            //dos.writeBytes("Content-Disposition: form-data; name=\"upfile\";filename=\"" + fileName+"\"" + lineEnd);
            //dos.writeBytes(lineEnd);
            //한번에 읽어들일수있는 스트림의 크기를 얻어온다.
            //int bytesAvailable = mFileInputStream.available();
            //byte단위로 읽어오기 위하여 byte 배열 객체를 준비한다.

            byte[] buffer = new byte[1024];
            int bytesLength = data.length;
            int count = (data.length / 1024) + 1;

            for (int i = 0; i < count; i++)
            {
                int leng;
                if (bytesLength >= 1024)
                {
                    leng = 1024;
                    bytesLength -= 1024;
                }
                else
                {
                    leng = bytesLength;
                }
                System.arraycopy(data,i*1024,buffer,0,leng);
                dos.write(buffer, 0, leng);
                //출력한 데이터 밀어내기
                dos.flush();
            }

            //전송할 데이터의 끝임을 알린다.
            dos.writeBytes(lineEnd);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
            //flush() 타이밍??
            //dos.flush();
            dos.close();//스트림 닫아주기
            //mFileInputStream.close();//스트림 닫아주기.
            // get response
            int ch;
            //입력 스트림 객체를 얻어온다.
            InputStream is = conn.getInputStream();
            StringBuffer b =new StringBuffer();
            while( ( ch = is.read() ) != -1 ){
                b.append( (char)ch );
            }

            String s=b.toString();
            Message msg = m_handler.obtainMessage();
            msg.what = 1;

            String hi = new String(s);
            msg.obj = hi;

            m_handler.sendMessage(msg);

            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

}