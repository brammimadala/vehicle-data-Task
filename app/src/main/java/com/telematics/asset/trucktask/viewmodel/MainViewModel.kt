package com.telematics.asset.trucktask.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telematics.asset.trucktask.model.VehicleDataResponse
import com.telematics.asset.trucktask.model.VehicleName
import com.telematics.asset.trucktask.model.postdata.PostData
import com.telematics.asset.trucktask.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val vehicleDataResponse = MutableLiveData<VehicleDataResponse?>()

    fun callApi() {

        viewModelScope.launch {
            val data = repository.getVehicleDetails(PostData(11, 1007, "9889897789", 3476))

            try {
                if (data.isSuccessful) {
                    val vdr: VehicleDataResponse? = data.body()
                    if (vdr != null) {
                        vehicleDataResponse.value = vdr
                    }

                } else {
                    val error = data.errorBody().toString()
                }

            } catch (e: Exception) {
                Log.i("exception===>", "${e.message.toString()}")
            }
        }
    }


    fun getVehicleNameData(): List<VehicleName> {
        val nameList: ArrayList<VehicleName> = arrayListOf()
        nameList.add(VehicleName("Grand Vistara"))
        nameList.add(VehicleName("Brezza"))
        nameList.add(VehicleName("Dzire"))
        nameList.add(VehicleName("Alto"))
        nameList.add(VehicleName("Swift"))
        nameList.add(VehicleName("Fronx"))
        nameList.add(VehicleName("Wagon"))
        nameList.add(VehicleName("Baleno"))
        nameList.add(VehicleName("Presso"))
        nameList.add(VehicleName("Safari"))
        nameList.add(VehicleName("Indica"))
        nameList.add(VehicleName("Harrier"))
        nameList.add(VehicleName("Nexon"))
        nameList.add(VehicleName("Indigo"))
        nameList.add(VehicleName("Tigor"))
        return nameList
    }


}