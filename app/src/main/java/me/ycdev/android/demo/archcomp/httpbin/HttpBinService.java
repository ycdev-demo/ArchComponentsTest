package me.ycdev.android.demo.archcomp.httpbin;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HttpBinService {
    @GET("/delay/{n}")
    String delay(@Path("n") int n);
}

