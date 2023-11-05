package com.telematics.asset.trucktask.repository

import com.telematics.asset.trucktask.api.ApiService
import com.telematics.asset.trucktask.model.VehicleDataResponse
import com.telematics.asset.trucktask.model.postdata.PostData
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getVehicleDetails(postData: PostData): Response<VehicleDataResponse> {
        return apiService.getVehicleData(postData)
    }


}