package com.product.common.exception

import com.product.common.status.ResultCode

open class CustomException(
    val resultCode: ResultCode
) : RuntimeException(resultCode.message)