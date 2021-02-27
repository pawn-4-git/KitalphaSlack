/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message.base;

import base.JsonConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import message.response.GetMessageResponse;

/**
 *
 * @author Pawn
 */
public class GetMessageFromSlack {
    final String  urlString="https://slack.com/api/conversations.history";
    
    /**
     * Slackにメッセージを送信する
     * @param token　必須
     * @param channel　指定しない場合はgeneralに通知します
     * @return 
     */
    public GetMessageResponse getMessage(String token,String channel){
        GetMessageResponse getMessageResponse=null;
        try {
            URL url = new URL(urlString);
            URLConnection uc = url.openConnection();
            uc.setDoOutput(true);//POST可能にする
 
            uc.setRequestProperty("User-Agent", "@IT java-tips URLConnection");// ヘッダを設定
            uc.setRequestProperty("Accept-Language", "ja");// ヘッダを設定
            OutputStream os = uc.getOutputStream();//POST用のOutputStreamを取得
        
            StringBuffer postStr = new StringBuffer();//POSTするデータ
            
            postStr.append("token=").append(token);
            postStr.append("&channel=").append(channel);
            
            try (PrintStream ps = new PrintStream(os)) {
                ps.print(postStr);//データをPOSTする
            } //データをPOSTする
 
            InputStream is = uc.getInputStream();//POSTした結果を取得
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String s;
            JsonConverter jsonConverter=new JsonConverter();
            
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
                getMessageResponse=(GetMessageResponse)jsonConverter.decode(s,GetMessageResponse.class);
            }
            reader.close();
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + urlString);
            return null;
        } catch (IOException e) {
            System.err.println("Can't connect to " + urlString);
            return null;
        }
        return getMessageResponse;
    }
}
