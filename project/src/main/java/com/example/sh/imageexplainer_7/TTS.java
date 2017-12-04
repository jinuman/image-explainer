package com.example.sh.imageexplainer_7;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;


public class TTS extends Thread{

    Context context;
    String sentence;

    private MediaPlayer mp = new MediaPlayer();

    TTS(Context context, String sentence)
    {
        this.context = context;
        this.sentence = sentence;
    }
    public void run() {
        String clientId = "CLIENT_ID";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "CLIENT_SECRET";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(sentence, "UTF-8"); // 13자
            String apiURL = "https://openapi.naver.com/v1/voice/tts.bin";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "speaker=clara&speed=0&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];

                String tempname = Long.valueOf(new Date().getTime()).toString();
                File f = new File(context.getFilesDir(), tempname + ".mp3");
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
                playSong(context.getFilesDir()+ "/" +tempname + ".mp3");
                f.delete();
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void playSong(String songPath) {
        try {
            mp.reset(); // mp객체를 초기화합니다.
            mp.setDataSource(songPath);
            mp.prepare();
            mp.start();
            //Toast.makeText(this, "재생 : " + songPath, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            //Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}