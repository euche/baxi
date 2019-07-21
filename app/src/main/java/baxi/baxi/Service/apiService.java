package baxi.baxi.Service;

import baxi.baxi.models.custResponse;
import baxi.baxi.models.loginResponse;
import baxi.baxi.models.loginuser;
import baxi.baxi.models.storeResponse;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface apiService {



    @POST("v1/auth/login")
    Call<loginResponse>authenticateUser(@Body loginuser user);



    @GET("/v1/store/{businessId}/{storeId}/getStoreItems")
    Single<storeResponse>getStoreitems(@Path("businessId") int businessId,@Path("storeId") int storeId ,@Header("Authorization")  String token);



   @GET("/v1/storecustomer/{businessId}/{storeId}")
   Call<custResponse>getCustomersList(@Path("businessId") int businessId, @Path("storeId") int storeId, @Header("Authorization")  String token,@Query("previousPage") int pageIndex);


}
