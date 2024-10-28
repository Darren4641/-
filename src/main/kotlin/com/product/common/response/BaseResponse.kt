package com.product.common.response

import com.product.common.status.ResultCode

data class BaseResponse<T> (
    val resultCode : String = ResultCode.SUCCESS.code,
    val message : String = ResultCode.SUCCESS.message,
    val success : Boolean = true,
    val data : T? = null
)