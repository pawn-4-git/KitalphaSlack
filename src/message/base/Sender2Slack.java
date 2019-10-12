/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Pawn
 */
public class Sender2Slack {
    final String  urlString="https://slack.com/api/chat.postMessage";
    
    /**
     * Slackにメッセージを送信する
     * @param token　必須
     * @param channel　指定しない場合はgeneralに通知します
     * @param text 必須
     * @param asUser　trueの場合はアプリを作成したslackbotで、指定しないもしくはfalseの場合はuserNameで指定した名前で通知します
     * @param userName asUserに指定しないもしくはfalseの場合に指定可能 指定しない場合はアプリ名で通知します
     * @return 
     */
    public boolean sendMessage(String token,String channel,String text,Boolean asUser,String userName){
        try {
            URL url = new URL(urlString);
            URLConnection uc = url.openConnection();
            uc.setDoOutput(true);//POST可能にする
 
            uc.setRequestProperty("User-Agent", "@IT java-tips URLConnection");// ヘッダを設定
            uc.setRequestProperty("Accept-Language", "ja");// ヘッダを設定
            OutputStream os = uc.getOutputStream();//POST用のOutputStreamを取得
        
            StringBuffer postStr = new StringBuffer();//POSTするデータ
            
            postStr.append("token=").append(token);
            postStr.append("&text=").append(text);
            if(channel!=null&&channel.length()!=0){
                postStr.append("&channel=").append(channel);
            }else{
                postStr.append("&channel=general");
            }
            if(asUser!=null&&asUser){
                postStr.append("&as_user=true");
            }else{
                postStr.append("&as_user=false");
                if(userName!=null&&userName.length()!=0){
                    postStr.append("&username=").append(userName);
                }
            
            }
            try (PrintStream ps = new PrintStream(os)) {
                ps.print(postStr);//データをPOSTする
            } //データをPOSTする
 
            InputStream is = uc.getInputStream();//POSTした結果を取得
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            reader.close();
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + urlString);
            return false;
        } catch (IOException e) {
            System.err.println("Can't connect to " + urlString);
            return false;
        }
        return true;
    }
}
