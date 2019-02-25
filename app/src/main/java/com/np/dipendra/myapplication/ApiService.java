package com.np.dipendra.myapplication;

import com.np.dipendra.myapplication.modal.Announcements;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class ApiService {
    private static final String BASE_URL = "http://192.168.137.1/app/";

    public static RetrofitInterface getServiceClass() {
        return RetrofitApi.getRetrofit(BASE_URL)
                .create(RetrofitInterface.class);
    }

    public interface RetrofitInterface {
        @GET("select_user.php")
        public Call<List<Modal>> getUserName();

        @GET("fetch_announcement.php")
        public Call<List<Announcements>> getAnnouncements();
    }
}
