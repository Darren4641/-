//package com.product.common.exception.handler
//
//
//
//import com.product.common.status.ResultCode
//import com.fasterxml.jackson.databind.JsonMappingException
//import com.fasterxml.jackson.databind.exc.InvalidFormatException
//import com.product.common.exception.CustomException
//import com.product.common.exception.dto.ExceptionMsg
//import com.product.common.exception.dto.FieldErrorDetail
//import org.springframework.http.HttpStatus
//import org.springframework.http.converter.HttpMessageNotReadableException
//import org.springframework.validation.FieldError
//import org.springframework.validation.ObjectError
//import org.springframework.web.bind.MethodArgumentNotValidException
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.bind.annotation.ResponseStatus
//import org.springframework.web.bind.annotation.RestControllerAdvice
//import org.springframework.web.context.request.WebRequest
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
//import org.springframework.web.reactive.function.server.ServerResponse
//import reactor.core.publisher.Mono
//import java.util.function.Consumer
//
//
//@RestControllerAdvice
//class ExceptionHandler (
//
//) {
//
//
//
//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun methodValidException (
//        ex : MethodArgumentNotValidException
//    ) : Mono<ServerResponse> {
//        val errors: MutableList<FieldErrorDetail> = ArrayList<FieldErrorDetail>()
//        println("PARAMS Exception")
//        ex.bindingResult.allErrors.forEach(Consumer { error : ObjectError ->
//            errors.add(
//                FieldErrorDetail(
//                    field = (error as FieldError).field,
//                    message = error.defaultMessage ?: "Invalid Params"
//                )
//            )
//        })
//
//        return ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(ExceptionMsg(
//            code = ResultCode.INVALID_PARAMETER.code,
//            message = ResultCode.INVALID_PARAMETER.message,
//            success = false,
//            errors = errors
//        ))
//    }
//
//
//    @ExceptionHandler(HttpMessageNotReadableException::class)
//    fun handleHttpMessageNotReadableException(
//        ex: HttpMessageNotReadableException,
//        request: WebRequest
//    ): Mono<ServerResponse> {
//        val rootCause = ex.cause
//
//        val errors : MutableList<FieldErrorDetail> = ArrayList<FieldErrorDetail>()
//        if (rootCause is InvalidFormatException) {
//            for (reference in rootCause.path) {
//                errors.add(
//                    FieldErrorDetail(
//                        field = reference.fieldName,
//                        message = "[" + reference.fieldName + "] 가 타입이 알맞지 않습니다."
//                    )
//                )
//            }
//        } else if (rootCause is JsonMappingException) {
//            for (reference in rootCause.path) {
//                errors.add(
//                    FieldErrorDetail(
//                        field = reference.fieldName,
//                        message = "[" + reference.fieldName + "] 가 누락되었습니다."
//                    )
//                )
//            }
//        } else {
//            errors.add(
//                FieldErrorDetail(
//                field = "",
//                message = rootCause?.message?:"에러 발생"
//            ))
//        }
//        return ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(ExceptionMsg(
//            code = ResultCode.INVALID_PARAMETER.code,
//            message = ResultCode.INVALID_PARAMETER.message,
//            success = false,
//            errors = errors
//        ))
//
//    }
//
//
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
//    @ResponseStatus(HttpStatus.OK)
//    fun handleTypeMismatch(ex: MethodArgumentTypeMismatchException): Mono<ServerResponse> {
//        return if (ex.requiredType?.isEnum == true) {
//            val enumValues = ex.requiredType!!.enumConstants?.joinToString(", ")
//            ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(ExceptionMsg(
//                code = ResultCode.INVALID_PARAMETER.code,
//                message = ResultCode.INVALID_PARAMETER.message,
//                success = false,
//                errors = listOf(FieldErrorDetail(
//                    field = ex.name,
//                    message = enumValues.toString()
//                ))
//            ))
//        } else {
//            ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(ExceptionMsg(
//                code = ResultCode.INVALID_PARAMETER.code,
//                message = ResultCode.INVALID_PARAMETER.message,
//                success = false,
//                errors = listOf(FieldErrorDetail(
//                    field = ex.name,
//                    message = "Invalid value for parameter '${ex.name}'"
//                ))
//            ))
//        }
//    }
//}