package com.example.capstoneapp.api;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {


    public static final String myapikey = "20b486e870414b6087e25487f9245f37";
    public  static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit retrofit;

    public static Retrofit getClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(getUnsafeOkHttpClient().build())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient(){
        //return null;
        try{
            final TrustManager[] trustAllCerts = new TrustManager[]{
             new X509TrustManager() {
                 @Override
                 public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                 }

                 @Override
                 public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                 }

                 @Override
                 public X509Certificate[] getAcceptedIssuers() {
                     return new X509Certificate[]{};
                 }
             }



            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory,(X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });

            return builder;

        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }


}
